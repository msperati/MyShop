package myshop.controllers;

import myshop.entities.Ordine;
import myshop.entities.OrdineProdotto;
import myshop.services.OrdiniProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/myshop")
public class OrdiniProdottoController {

    @Autowired
    private OrdiniProdottoService ordiniProdottoService;

    @GetMapping(path = "/ordine_op")
    public @ResponseBody List<OrdineProdotto> getOrdiniProdottoByOrdine(@RequestBody Ordine ordine) {
        return ordiniProdottoService.getOrdiniProdottoByOrdine(ordine);
    }

    @PutMapping(path = "/ordine_op")
    public @ResponseBody Ordine updateOrdineProdotto(@RequestBody OrdineProdotto op) {
        return ordiniProdottoService.updateOrdineProdotto(op);
    }

    @PostMapping(path = "/ordine_op")
    public @ResponseBody Ordine createOrdineProdotto(@RequestBody OrdineProdotto op) {
        return ordiniProdottoService.createOrdineProdotto(op);
    }

    @DeleteMapping(path = "/ordine_op")
    public @ResponseBody OrdineProdotto deleteOrdineProdotto(@RequestBody OrdineProdotto op) {
        return ordiniProdottoService.deleteOrdineProdotto(op);
    }

    // INUTILE
    @GetMapping(path = "/ordini_prod")
    public @ResponseBody List<OrdineProdotto> getOrdiniProdotto() {
        return ordiniProdottoService.getOrdiniProdotto();
    }

    // PROBABILMENTE INUTILE
    @DeleteMapping(path = "/ordine_op_by_pk")
    public @ResponseBody OrdineProdotto deleteOrdineProdottoByPK(@RequestBody OrdineProdotto.OP_PK pk) {
        return ordiniProdottoService.deleteOrdineProdottoByPk(pk);
    }
}
