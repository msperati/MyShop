package myshop.controllers;

import myshop.entities.Cliente;
import myshop.services.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/myshop")
public class ClientiController {

    @Autowired
    private ClientiService clientiService;

    @GetMapping(path = "/clienti")
    public @ResponseBody List<Cliente> getProdotti() {
        return clientiService.getClienti();
    }

    @GetMapping(path = "/cliente{id}")
    public @ResponseBody Cliente getCliente(@RequestParam Long idCliente) {
        return clientiService.getCliente(idCliente);
    }

    @DeleteMapping(path = "/cliente{id}")
    public @ResponseBody Cliente deleteCliente(@RequestParam Long idCliente) {
        return clientiService.deleteClienteById(idCliente);
    }

    @DeleteMapping(path = "/cliente")
    public @ResponseBody Cliente deleteCliente(@RequestBody Cliente cliente) {
        return clientiService.deleteCliente(cliente);
    }

    @PostMapping(path = "/cliente")
    public @ResponseBody Cliente createCliente(@RequestBody Cliente cliente) {
        return clientiService.saveCliente(cliente);
    }

    @PutMapping(path = "/cliente")
    public @ResponseBody Cliente updateCliente(@RequestBody Cliente cliente) {
        return clientiService.saveCliente(cliente);
    }

}
