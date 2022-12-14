package myshop.repositories;

import myshop.entities.Ordine;
import myshop.entities.OrdineProdotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdiniProdottoRepository extends JpaRepository<OrdineProdotto, OrdineProdotto.Pk> {
    List<OrdineProdotto> findAllByPkOrdine(Ordine ordine);
}
