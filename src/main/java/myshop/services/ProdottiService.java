package myshop.services;

import myshop.dtos.ProdottoInfoDTO;
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

    public ProdottoInfoDTO dettaglio(Long idProdotto) {
        ProdottoInfoDTO dto = new ProdottoInfoDTO();
        dto.setProdotto(prodottiRepository.findById(idProdotto).get());
        dto.setCopieOrdinate(prodottiRepository.countCopieOrdinateProdotto(idProdotto));
        dto.setCopieOrdinatePagate(prodottiRepository.countCopiePagateProdotto(idProdotto));
        dto.setOrdiniAssociati(prodottiRepository.countOrdiniConProdotto(idProdotto));
        dto.setOrdiniAssociatiPagati(prodottiRepository.countOrdiniPagatiConProdotto(idProdotto));
        dto.setClientiOrdinanti(prodottiRepository.countClientiOrdinantiProdotto(idProdotto));
        return dto;
    }

    public Prodotto deleteProdottoById(Long idProdotto) {
        Prodotto prodotto = prodottiRepository.findById(idProdotto).get();
        prodottiRepository.delete(prodotto);
        return prodotto;
    }

//    public Prodotto deleteProdotto(Prodotto prodotto) {
//        prodottiRepository.delete(prodotto);
//        return prodotto;
//    }

    public List<Prodotto> deleteProdottoByCategoria(String categoria) {
        return prodottiRepository.deleteByCategoria(categoria);
    }

    public Prodotto saveProdotto(Prodotto prodotto) {
        return prodottiRepository.save(prodotto);
    }
}
