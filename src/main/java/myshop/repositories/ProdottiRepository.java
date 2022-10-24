package myshop.repositories;

import myshop.entities.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ProdottiRepository extends JpaRepository<Prodotto, Long> {

    List<Prodotto> findAllByOnSale(Boolean onSale);

    @Transactional
    List<Prodotto> deleteByCategoria(String categoria);
}
