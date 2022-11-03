package myshop.controllers;

import myshop.dtos.ProdottoInfoDTO;
import myshop.entities.Prodotto;
import myshop.services.ProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/prodotti")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdottiController {

    @Autowired
    private ProdottiService prodottiService;

    @GetMapping(path = "/findAll")
    public @ResponseBody List<Prodotto> getProdotti() {
        return prodottiService.getProdotti();
    }

    @GetMapping(path = "/findAllByOnSale")
    public @ResponseBody List<Prodotto> getProdottiOnSale() {
        return prodottiService.getProdottiOnSale();
    }

    @GetMapping(path = "/get/{idProdotto}")
    public @ResponseBody Prodotto getProdotto(@PathVariable Long idProdotto) {
        return prodottiService.getProdotto(idProdotto);
    }

    @GetMapping(path = "/dettaglio/{idProdotto}")
    public @ResponseBody ProdottoInfoDTO getProdottoInfoDTO(@PathVariable Long idProdotto) {
        return prodottiService.dettaglio(idProdotto);
    }

    @PostMapping(path = "/create")
    public @ResponseBody Prodotto createProdotto(@RequestBody Prodotto prodotto) {
        return prodottiService.saveProdotto(prodotto);
    }

    @PutMapping(path = "/update")
    public @ResponseBody Prodotto updateProdotto(@RequestBody Prodotto prodotto) {
        return prodottiService.saveProdotto(prodotto);
    }

//    @DeleteMapping(path = "/delete")
//    public @ResponseBody Prodotto deleteProdotto(@RequestBody Prodotto prodotto) {
//        return prodottiService.deleteProdotto(prodotto);
//    }

    @DeleteMapping(path = "/delete/{idProdotto}")
    public @ResponseBody Prodotto deleteProdotto(@PathVariable Long idProdotto) {
        return prodottiService.deleteProdottoById(idProdotto);
    }

    @DeleteMapping(path = "/deleteByCategoria/{categoria}")
    public @ResponseBody List<Prodotto> deleteProdotto(@PathVariable String categoria) {
        return prodottiService.deleteProdottoByCategoria(categoria);
    }

}
