package myshop.services;

import myshop.entities.Ordine;
import myshop.entities.OrdineProdotto;
import myshop.entities.Prodotto;
import myshop.repositories.OrdiniProdottoRepository;
import myshop.repositories.OrdiniRepository;
import myshop.repositories.ProdottiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrdiniProdottoService {

    @Autowired
    OrdiniProdottoRepository ordiniProdottoRepository;

    @Autowired
    OrdiniRepository ordiniRepository;

    @Autowired
    ProdottiRepository prodottiRepository;

    public List<OrdineProdotto> getOrdiniProdottoByOrdine(Ordine ordine) {
        return ordiniProdottoRepository.findAllByPkOrdine(ordine);
    }

    public OrdineProdotto deleteOrdineProdotto(OrdineProdotto op) {
        ordiniProdottoRepository.delete(op);

        /** SE CANCELLIAMO UN ORDINE DI PRODOTTO DOBBIAMO ANCHE AGGIORNARE L'IMPORTO DELL'ORDINE */
        Ordine ordine = ordiniRepository.findById(op.getPk().getOrdine().getId()).get();
        ordine.setImportoTotale(ordine.getImportoTotale() - (op.getPrezzo() * op.getQuantita()));
        ordiniRepository.save(ordine);

        /** SE CANCELLIAMO UN ORDINE DI PRODOTTO DOBBIAMO ANCHE RISTOCCARE IL PRODOTTO */
        Prodotto prodotto = prodottiRepository.findById(op.getPk().getProdotto().getId()).get();
        prodotto.setDisponibilita(prodotto.getDisponibilita() + op.getQuantita());
        prodottiRepository.save(prodotto);

        return op;
    }

    @Transactional
    public Ordine createOrdineProdotto(OrdineProdotto op) {
        ordiniProdottoRepository.save(op);

        /** SE CREIAMO UN ORDINE DI PRODOTTO DOBBIAMO ANCHE AUMENTARE L'IMPORTO DELL'ORDINE */
        Ordine ordine = ordiniRepository.findById(op.getPk().getOrdine().getId()).get();
        ordine.setImportoTotale(ordine.getImportoTotale() + (op.getPrezzo() * op.getQuantita()));
        ordiniRepository.save(ordine);

        /** SE CREIAMO UN ORDINE DI PRODOTTO DOBBIAMO ANCHE DIMINUIRE LA DISPONIBILITA DEL PRODOTTO */
        Prodotto prodotto = prodottiRepository.findById(op.getPk().getProdotto().getId()).get();
        prodotto.setDisponibilita(prodotto.getDisponibilita() - op.getQuantita());
        prodottiRepository.save(prodotto);

        return ordine;
    }

    @Transactional
    public Ordine updateOrdineProdotto(OrdineProdotto op) {

        OrdineProdotto opOriginale = ordiniProdottoRepository.findById(op.getPk()).get();
        Long quantitaOriginale = opOriginale.getQuantita();
        ordiniProdottoRepository.save(op);

        /** SE AGGIORNIAMO UN ORDINE DI PRODOTTO DOBBIAMO ANCHE AGGIORNARE L'IMPORTO DELL'ORDINE */
        Ordine ordine = ordiniRepository.findById(op.getPk().getOrdine().getId()).get();
        ordine.setImportoTotale(ordine.getImportoTotale() - ((quantitaOriginale - op.getQuantita()) * op.getPrezzo()));
        ordiniRepository.save(ordine);

        /** SE AGGIORNIAMO UN ORDINE DI PRODOTTO DOBBIAMO ANCHE AGGIORNARE LA DISPONIBILITA DEL PRODOTTO */
        Prodotto prodotto = prodottiRepository.findById(op.getPk().getProdotto().getId()).get();
        prodotto.setDisponibilita(prodotto.getDisponibilita() + (quantitaOriginale - op.getQuantita()));
        prodottiRepository.save(prodotto);

        return ordine;
    }

    // INUTILE
    public List<OrdineProdotto> getOrdiniProdotto() {
        return ordiniProdottoRepository.findAll();
    }

    // PROBABILMENTE INUTILE
    public OrdineProdotto deleteOrdineProdottoByPk(OrdineProdotto.OP_PK pk) {
        OrdineProdotto op = ordiniProdottoRepository.findById(pk).get();
        ordiniProdottoRepository.delete(op);

        /** SE CANCELLIAMO UN ORDINE DI PRODOTTO DOBBIAMO ANCHE AGGIORNARE L'IMPORTO DELL'ORDINE */
        Ordine ordine = ordiniRepository.findById(pk.getOrdine().getId()).get();
        ordine.setImportoTotale(ordine.getImportoTotale() - (op.getPrezzo() * op.getQuantita()));
        ordiniRepository.save(ordine);

        /** SE CANCELLIAMO UN ORDINE DI PRODOTTO DOBBIAMO ANCHE RISTOCCARE IL PRODOTTO */
        Prodotto prodotto = prodottiRepository.findById(pk.getProdotto().getId()).get();
        prodotto.setDisponibilita(prodotto.getDisponibilita() + op.getQuantita());
        prodottiRepository.save(prodotto);

        return op;
    }
}
