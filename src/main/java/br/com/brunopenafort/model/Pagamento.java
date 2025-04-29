package br.com.brunopenafort.model;

import br.com.brunopenafort.model.enums.MetodoPagamento;
import br.com.brunopenafort.model.enums.StatusPagamento;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Pagamento")
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idPagamento;
	
	public Long codigoDebito;
	
	public String cpfCnpjPagador;
	
	@Enumerated(EnumType.STRING)
	public MetodoPagamento metodoPagamento;
	
	public Long numeroCartao;
	
	public Double valorPagamento;
	
	@Enumerated(EnumType.STRING)
	public StatusPagamento statusPagamento;

	public Long getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Long idPagamento) {
		this.idPagamento = idPagamento;
	}

	public Long getCodigoDebito() {
		return codigoDebito;
	}

	public void setCodigoDebito(Long codigoDebito) {
		this.codigoDebito = codigoDebito;
	}

	public String getCpfCnpjPagador() {
		return cpfCnpjPagador;
	}

	public void setCpfCnpjPagador(String cpfCnpjPagador) {
		this.cpfCnpjPagador = cpfCnpjPagador;
	}

	public MetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPAgamento(MetodoPagamento metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public Long getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(Long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public Double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	} 
	
	
}
