package myshop.repositories;

import myshop.entities.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ProdottiRepository extends JpaRepository<Prodotto, Long> {

    List<Prodotto> findAllByOnSale(Boolean onSale);

    @Transactional
    List<Prodotto> deleteByCategoria(String categoria);


    /**
     * queries per recuperare un po' di statistiche sulle performances di vendita del prodotto
     */
    @Query(value = "SELECT COUNT(*) FROM ENTITIES.ORDINE_PRODOTTO " +
            "WHERE ORDINE_PRODOTTO.ID_PRODOTTO =:idProdotto",
            nativeQuery = true)
    Long countOrdiniConProdotto(Long idProdotto);

    @Query(value = "SELECT COUNT(*) FROM ENTITIES.ORDINE_PRODOTTO " +
            "JOIN ENTITIES.ORDINE ON ORDINE.ID_ORDINE = ORDINE_PRODOTTO.ID_ORDINE " +
            "WHERE ORDINE_PRODOTTO.ID_PRODOTTO =:idProdotto " +
            "AND ORDINE.PAGATO = 1",
            nativeQuery = true)
    Long countOrdiniPagatiConProdotto(Long idProdotto);

    @Query(value = "SELECT SUM(QUANTITA) FROM ENTITIES.ORDINE_PRODOTTO " +
            "WHERE ORDINE_PRODOTTO.ID_PRODOTTO =:idProdotto",
            nativeQuery = true)
    Long countCopieOrdinateProdotto(Long idProdotto);

    @Query(value = "SELECT SUM(QUANTITA) FROM ENTITIES.ORDINE_PRODOTTO " +
            "JOIN ENTITIES.ORDINE ON ORDINE.ID_ORDINE = ORDINE_PRODOTTO.ID_ORDINE " +
            "WHERE ORDINE_PRODOTTO.ID_PRODOTTO =:idProdotto " +
            "AND ORDINE.PAGATO = 1",
            nativeQuery = true)
    Long countCopiePagateProdotto(Long idProdotto);

    @Query(value = "SELECT COUNT(*) FROM " +
            "(SELECT DISTINCT CLIENTE.ID_CLIENTE FROM ENTITIES.CLIENTE " +
            "JOIN ENTITIES.ORDINE ON ORDINE.ID_CLIENTE = CLIENTE.ID_CLIENTE " +
            "JOIN ENTITIES.ORDINE_PRODOTTO ON ORDINE_PRODOTTO.ID_ORDINE = ORDINE.ID_ORDINE " +
            "WHERE ORDINE_PRODOTTO.ID_PRODOTTO =:idProdotto) AS CLIENTI_DIVERSI",
            nativeQuery = true)
    Long countClientiOrdinantiProdotto(Long idProdotto);
}
