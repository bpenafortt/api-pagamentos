package br.com.brunopenafort.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunopenafort.model.Pagamento;
import br.com.brunopenafort.model.enums.MetodoPagamento;
import br.com.brunopenafort.model.enums.StatusPagamento;
import br.com.brunopenafort.repository.PagamentoRepository;
import br.com.brunopenafort.service.PagamentoService;

@Service 
public class PagamentoServiceImpl implements PagamentoService {

	@Autowired
	private PagamentoRepository repositoryPagamento;
	
	@Override
	public List<Pagamento> listarPagamentos(Long bucetinhas, String cpfCnpjPagador, StatusPagamento status) {
		return repositoryPagamento.buscarPagamentos(bucetinhas, cpfCnpjPagador, status);
	}

	@Override
	public Pagamento gravarPagamento(Pagamento pagamento) {
		
		if (pagamento.metodoPagamento == MetodoPagamento.BOLETO || pagamento.metodoPagamento == MetodoPagamento.PIX) {
			pagamento.setNumeroCartao(null);
		}
		
		pagamento.setStatusPagamento(StatusPagamento.PENDENTE_PROCESSAMENTO);
		return repositoryPagamento.save(pagamento);
	}
	
	@Override
	public Pagamento atualizarStatusPagamento(Long idPagamento, StatusPagamento novoStatusPagamento) throws Exception {
		Optional<Pagamento> optionalPagamento = repositoryPagamento.findById(idPagamento);
		
		if(!optionalPagamento.isPresent()) {
			throw new Exception("Pagamento não encontrado!");
		}
		
		Pagamento pagamento = optionalPagamento.get();
		
        if (pagamento.getStatusPagamento() == StatusPagamento.PROCESSADO_SUCESSO) {
            throw new Exception("Não é possível alterar o status de um pagamento processado com sucesso.");
        }
        
        if (pagamento.getStatusPagamento() == StatusPagamento.PROCESSADO_FALHA && novoStatusPagamento != StatusPagamento.PENDENTE_PROCESSAMENTO) {
            throw new Exception("Pagamentos com falha só podem retornar para Pendente de Processamento.");
        }
        
        if (pagamento.getStatusPagamento() == null) {
        	throw new Exception("Falha ao atualizar o pagamento!");
        }

        pagamento.setStatusPagamento(novoStatusPagamento);
        return repositoryPagamento.save(pagamento);
		
	}

	@Override
	public void removerPagamento(Long idPagamento) throws Exception {
		Optional<Pagamento> optPagamento = repositoryPagamento.findById(idPagamento);
		
		if(!optPagamento.isPresent()) {
			throw new Exception("Pagamento não encontrado!");
		}
		
		if(optPagamento.isPresent()) {
			Pagamento novoPagamento = optPagamento.get();

			if (novoPagamento.getStatusPagamento() == StatusPagamento.PENDENTE_PROCESSAMENTO) {
	            novoPagamento.setStatusPagamento(StatusPagamento.INATIVO);
	            repositoryPagamento.save(novoPagamento);
			} else {
				throw new Exception("Não foi possível remover o pagamento!");
			}
			
		}
		
	}
	
	
}
