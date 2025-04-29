package br.com.brunopenafort.service;

import java.util.List;

import br.com.brunopenafort.model.Pagamento;
import br.com.brunopenafort.model.enums.StatusPagamento;

public interface PagamentoService {

	List<Pagamento> listarPagamentos(Long codigoDebito, String cpfCnpjPagador, StatusPagamento statusPagamento);
	Pagamento gravarPagamento(Pagamento pagamento);
	Pagamento atualizarStatusPagamento(Long idPagamento, StatusPagamento novoStatusPagamento) throws Exception ;
	void removerPagamento(Long idPagamento) throws Exception;

}
