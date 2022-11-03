package myshop.controllers;

import myshop.dtos.OrdineDTO;
import myshop.entities.Cliente;
import myshop.entities.Ordine;
import myshop.services.OrdiniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ordini")
@CrossOrigin(origins = "http://localhost:4200")
public class OrdiniController {

    @Autowired
    private OrdiniService ordiniService;

    @GetMapping(path = "/findAll")
    public @ResponseBody List<Ordine> getOrdini() {
        return ordiniService.getOrdini();
    }

    @GetMapping(path = "/findAllByCliente")
    public @ResponseBody List<Ordine> getOrdiniByCliente(@RequestBody Cliente cliente) {
        return ordiniService.getOrdiniByCliente(cliente);
    }

    @GetMapping(path = "/findAllByCliente/{idCliente}")
    public @ResponseBody List<Ordine> getOrdiniByCliente(@PathVariable Long idCliente) {
        return ordiniService.getOrdiniByCliente(idCliente);
    }

    @GetMapping(path = "/get/{idOrdine}")
    public @ResponseBody Ordine getOrdine(@PathVariable Long idOrdine) {
        return ordiniService.getOrdine(idOrdine);
    }

    @GetMapping(path = "/dettaglio/{idOrdine}")
    public @ResponseBody OrdineDTO dettaglioOrdine(@PathVariable Long idOrdine) {
        return ordiniService.dettaglioOrdine(idOrdine);
    }

//    @GetMapping(path = "/dettaglio")
//    public @ResponseBody OrdineDTO dettaglioOrdine(@RequestBody Ordine ordine) {
//        return ordiniService.dettaglioOrdine(ordine);
//    }

    @DeleteMapping(path = "/delete/{idOrdine}")
    public @ResponseBody OrdineDTO deleteOrdine(@PathVariable Long idOrdine) {
        return ordiniService.deleteOrdine(idOrdine);
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody OrdineDTO deleteOrdine(@RequestBody Ordine ordine) {
        return ordiniService.deleteOrdine(ordine);
    }

    @PostMapping(path = "/create")
    public @ResponseBody Ordine createOrdine(@RequestBody OrdineDTO ordine) {
        return ordiniService.saveOrdine(ordine);
    }

    @PutMapping(path = "/update")
    public @ResponseBody Ordine updateOrdine(@RequestBody OrdineDTO ordine) {
        return ordiniService.saveOrdine(ordine);
    }
}
