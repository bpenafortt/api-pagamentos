package br.com.brunopenafort.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.brunopenafort.model.Pagamento;
import br.com.brunopenafort.model.enums.StatusPagamento;
import br.com.brunopenafort.model.requests.AtualizarStatusPagamentoRequest;
import br.com.brunopenafort.service.impl.PagamentoServiceImpl;


@RestController
@RequestMapping(value = "/api/v1/pagamentos")
public class PagamentoController {
	
	@Autowired
	private PagamentoServiceImpl servicePagamento;
	
	@GetMapping
	public List<Pagamento> getPagamentos(
			@RequestParam(required = false, name = "codigoDebito") Long codigoDebito, 
			@RequestParam(required = false, name = "cpfCnpjPagador") String cpfCnpjPagador, 
			@RequestParam(required = false, name = "statusPagamento") StatusPagamento statusPagamento) 
	{
		return servicePagamento.listarPagamentos(codigoDebito, cpfCnpjPagador, statusPagamento);
	}
	
	@PostMapping
	public Pagamento fazerPagamento(@RequestBody Pagamento pagamento) {
		return servicePagamento.gravarPagamento(pagamento);
	}
	
	@PutMapping("/{id}/status")
	public Pagamento atualizarStatus(@PathVariable("id") Long idPagamento, @RequestBody AtualizarStatusPagamentoRequest statusPagamentoRequest) {
		try {
			return servicePagamento.atualizarStatusPagamento(idPagamento, statusPagamentoRequest.getNovoStatus());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public void deletePagamento(@PathVariable("id") Long idPagamento) throws Exception {
		servicePagamento.removerPagamento(idPagamento);
	}
}
