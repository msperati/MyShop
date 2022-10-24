package myshop.controllers;

import myshop.entities.Cliente;
import myshop.entities.Ordine;
import myshop.services.OrdiniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/myshop")
public class OrdiniController {

    @Autowired
    private OrdiniService ordiniService;

    @GetMapping(path = "/ordini")
    public @ResponseBody List<Ordine> getOrdini() {
        return ordiniService.getOrdini();
    }

    @GetMapping(path = "/ordiniByCliente")
    public @ResponseBody List<Ordine> getOrdiniByCliente(@RequestBody Cliente cliente) {
        return ordiniService.getOrdiniByCliente(cliente);
    }

    @GetMapping(path = "/ordine{id}")
    public @ResponseBody Ordine getOrdine(@RequestParam Long idOrdine) {
        return ordiniService.getOrdine(idOrdine);
    }

    @DeleteMapping(path = "/ordine{id}")
    public @ResponseBody Ordine deleteOrdine(@RequestParam Long idOrdine) {
        return ordiniService.deleteOrdineById(idOrdine);
    }

    @DeleteMapping(path = "/ordine")
    public @ResponseBody Ordine deleteOrdine(@RequestBody Ordine ordine) {
        return ordiniService.deleteOrdine(ordine);
    }

    @PostMapping(path = "/ordine")
    public @ResponseBody Ordine createOrdine(@RequestBody Ordine ordine) {
        return ordiniService.saveOrdine(ordine);
    }

    @PutMapping(path = "/ordine")
    public @ResponseBody Ordine updateOrdine(@RequestBody Ordine ordine) {
        return ordiniService.saveOrdine(ordine);
    }
}
