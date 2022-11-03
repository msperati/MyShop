package myshop.controllers;

import myshop.dtos.ClienteDTO;
import myshop.entities.Cliente;
import myshop.services.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/clienti")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientiController {

    @Autowired
    private ClientiService clientiService;

    @GetMapping(path = "/findAll")
    public @ResponseBody List<Cliente> getProdotti() {
        return clientiService.getClienti();
    }

    @GetMapping(path = "/get/{idCliente}")
    public @ResponseBody Cliente getClienteById(@PathVariable Long idCliente) {
        return clientiService.getClienteById(idCliente);
    }

    @GetMapping(path = "/getByEmail/{email}")
    public @ResponseBody Cliente getClienteByEmail(@PathVariable String email) {
        return clientiService.getClienteByEmail(email);
    }

    @GetMapping(path = "/getByNomeCognome/{nomecognome}")
    public @ResponseBody List<Cliente> getClienteByNomeCognome(@PathVariable String nomecognome) {
        return clientiService.getClienteByNomeCognome(nomecognome);
    }

    @GetMapping(path = "/dettaglio/{idCliente}")
    public @ResponseBody ClienteDTO dettaglioCliente(@PathVariable Long idCliente) {
        return clientiService.dettaglioCliente(idCliente);
    }

//    @GetMapping(path = "/dettaglio")
//    public @ResponseBody ClienteDTO dettaglioCliente(@RequestBody Cliente cliente) {
//        return clientiService.dettaglioCliente(cliente);
//    }

    @PostMapping(path = "/create")
    public @ResponseBody Cliente createCliente(@RequestBody Cliente cliente) {
        return clientiService.saveCliente(cliente);
    }

    @PutMapping(path = "/update")
    public @ResponseBody Cliente updateCliente(@RequestBody Cliente cliente) {
        return clientiService.saveCliente(cliente);
    }

//    @DeleteMapping(path = "/delete")
//    public @ResponseBody Cliente deleteCliente(@RequestBody Cliente cliente) {
//        return clientiService.deleteCliente(cliente);
//    }

    @DeleteMapping(path = "/delete/{idCliente}")
    public @ResponseBody Cliente deleteCliente(@PathVariable Long idCliente) {
        return clientiService.deleteCliente(idCliente);
    }

}
