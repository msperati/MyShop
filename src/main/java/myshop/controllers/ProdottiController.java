package myshop.controllers;

import myshop.entities.Prodotto;
import myshop.services.ProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/myshop")
public class ProdottiController {

    @Autowired
    private ProdottiService prodottiService;

    @GetMapping(path = "/prodotti")
    public @ResponseBody List<Prodotto> getProdotti() {
        return prodottiService.getProdotti();
    }

    @GetMapping(path = "/prodotti_onsale")
    public @ResponseBody List<Prodotto> getProdottiOnSale() {
        return prodottiService.getProdottiOnSale();
    }

    @GetMapping(path = "/prodotto{id}")
    public @ResponseBody Prodotto getProdotto(@RequestParam Long idProdotto) {
        return prodottiService.getProdotto(idProdotto);
    }

    @DeleteMapping(path = "/prodotto{id}")
    public @ResponseBody Prodotto deleteProdotto(@RequestParam Long idProdotto) {
        return prodottiService.deleteProdottoById(idProdotto);
    }

    @DeleteMapping(path = "/prodotto")
    public @ResponseBody Prodotto deleteProdotto(@RequestBody Prodotto prodotto) {
        return prodottiService.deleteProdotto(prodotto);
    }

    @DeleteMapping(path = "/prodottoByCategoria{categoria}")
    public @ResponseBody List<Prodotto> deleteProdotto(@RequestParam String categoria) {
        return prodottiService.deleteProdottoByCategoria(categoria);
    }

    @PutMapping(path = "/prodotto")
    public @ResponseBody Prodotto updateProdotto(@RequestBody Prodotto prodotto) {
        return prodottiService.saveProdotto(prodotto);
    }

    @PostMapping(path = "/prodotto")
    public @ResponseBody Prodotto createProdotto(@RequestBody Prodotto prodotto) {
        return prodottiService.saveProdotto(prodotto);
    }

//    @PostMapping(path = "/createProdotto")
//    public @ResponseBody Prodotto createProdotto(
//            @RequestParam String categoria,
//            @RequestParam String descrizione,
//            @RequestParam Long prezzo,
//            @RequestParam Long disponibilita) {
//        Prodotto prodotto = new Prodotto();
//        prodotto.setCategoria(categoria);
//        prodotto.setDescrizione(descrizione);
//        prodotto.setPrezzo(prezzo);
//        prodotto.setDisponibilita(disponibilita);
//        return prodottiRepository.save(prodotto);
//    }

}
