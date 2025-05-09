package br.com.brunopenafort.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.brunopenafort.model.Pagamento;
import br.com.brunopenafort.model.enums.StatusPagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

	@Query(value = "SELECT p FROM Pagamento p WHERE "
			+ "(:codigoDebito IS NULL OR p.codigoDebito = :codigoDebito)"
			+ "AND (:cpfCnpjPagador IS NULL OR p.cpfCnpjPagador = :cpfCnpjPagador)"
			+ "AND (:statusPagamento IS NULL OR p.statusPagamento = :statusPagamento)")
	List<Pagamento> buscarPagamentos(@Param("codigoDebito") Long codigoDebito,@Param("cpfCnpjPagador") String cpfCnpjPagador,@Param("statusPagamento") StatusPagamento statusPagamento);
}
