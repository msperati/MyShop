package myshop.services;

import myshop.entities.Prodotto;
import myshop.repositories.ProdottiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottiService {

    @Autowired
    private ProdottiRepository prodottiRepository;

    public List<Prodotto> getProdotti() {
        return prodottiRepository.findAll();
    }

    public List<Prodotto> getProdottiOnSale() {
        return prodottiRepository.findAllByOnSale(true);
    }

    public Prodotto getProdotto(Long idProdotto) {
        return prodottiRepository.findById(idProdotto).get();
    }

    public Prodotto deleteProdottoById(Long idProdotto) {
        Prodotto prodotto = prodottiRepository.findById(idProdotto).get();
        prodottiRepository.delete(prodotto);
        return prodotto;
    }

    public Prodotto deleteProdotto(Prodotto prodotto) {
        prodottiRepository.delete(prodotto);
        return prodotto;
    }

    public List<Prodotto> deleteProdottoByCategoria(String categoria) {
        return prodottiRepository.deleteByCategoria(categoria);
    }

    public Prodotto saveProdotto(Prodotto prodotto) {
        return prodottiRepository.save(prodotto);
    }
}
