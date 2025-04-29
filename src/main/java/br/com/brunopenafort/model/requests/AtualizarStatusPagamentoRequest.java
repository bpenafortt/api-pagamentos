package br.com.brunopenafort.model.requests;

import br.com.brunopenafort.model.enums.StatusPagamento;

public class AtualizarStatusPagamentoRequest {

    private StatusPagamento novoStatus;

    public StatusPagamento getNovoStatus() {
        return novoStatus;
    }

    public void setNovoStatus(StatusPagamento novoStatus) {
        this.novoStatus = novoStatus;
    }
}
