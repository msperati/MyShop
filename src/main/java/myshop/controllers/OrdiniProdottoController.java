package myshop.controllers;

import myshop.entities.Ordine;
import myshop.entities.OrdineProdotto;
import myshop.services.OrdiniProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ordiniprodotto")
public class OrdiniProdottoController {

    @Autowired
    private OrdiniProdottoService ordiniProdottoService;

    @GetMapping(path = "/findAllByOrdine")
    public @ResponseBody List<OrdineProdotto> getOrdiniProdottoByOrdine(@RequestBody Ordine ordine) {
        return ordiniProdottoService.getOrdiniProdottoByOrdine(ordine);
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody OrdineProdotto deleteOrdineProdotto(@RequestBody OrdineProdotto op) {
        return ordiniProdottoService.deleteOrdineProdotto(op);
    }

    @PostMapping(path = "/create")
    public @ResponseBody Ordine createOrdineProdotto(@RequestBody OrdineProdotto op) {
        return ordiniProdottoService.createOrdineProdotto(op);
    }

    @PutMapping(path = "/update")
    public @ResponseBody Ordine updateOrdineProdotto(@RequestBody OrdineProdotto op) {
        return ordiniProdottoService.updateOrdineProdotto(op);
    }

    // INUTILE
    @GetMapping(path = "/findAll")
    public @ResponseBody List<OrdineProdotto> getOrdiniProdotto() {
        return ordiniProdottoService.getOrdiniProdotto();
    }

    // PROBABILMENTE INUTILE
    @DeleteMapping(path = "/deleteByPk")
    public @ResponseBody OrdineProdotto deleteOrdineProdottoByPK(@RequestBody OrdineProdotto.Pk pk) {
        return ordiniProdottoService.deleteOrdineProdottoByPk(pk);
    }
}
