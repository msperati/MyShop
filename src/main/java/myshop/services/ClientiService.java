package myshop.services;

import myshop.dtos.ClienteDTO;
import myshop.entities.Cliente;
import myshop.entities.Ordine;
import myshop.repositories.ClientiRepository;
import myshop.repositories.OrdiniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientiService {

    @Autowired
    private ClientiRepository clientiRepository;

    @Autowired
    private OrdiniRepository ordiniRepository;

    public List<Cliente> getClienti() {
        //return clientiRepository.findAll();
        return clientiRepository.findAllOrdineAlfabetico();
    }

    public Cliente getClienteById(Long idCliente) {
        return clientiRepository.findById(idCliente).get();
    }

    public Cliente getClienteByEmail(String email) {
        return clientiRepository.findByEmail(email).get();
    }

    public List<Cliente> getClienteByNomeCognome(String nomecognome) {
        return clientiRepository.findByNomeCognome(nomecognome);
    }

//    public Cliente deleteCliente(Cliente cliente) {
//        clientiRepository.delete(cliente);
//        return cliente;
//    }

    public Cliente deleteCliente(Long idCliente) {
        Cliente cliente = clientiRepository.findById(idCliente).get();
        clientiRepository.delete(cliente);
        return cliente;
    }

    public Cliente saveCliente(Cliente cliente) {
        return clientiRepository.save(cliente);
    }

//    public ClienteDTO dettaglioCliente(Cliente cliente) {
//        ClienteDTO dto = new ClienteDTO();
//        dto.setCliente(cliente);
//        List<Ordine> ordiniCliente = ordiniRepository.findByClienteOrderByDataOrdineDesc(cliente);
//        dto.setOrdini(ordiniCliente);
//        return dto;
//    }

    public ClienteDTO dettaglioCliente(Long idCliente) {
        ClienteDTO dto = new ClienteDTO();
        Cliente cliente = clientiRepository.findById(idCliente).get();
        dto.setCliente(cliente);
        List<Ordine> ordiniCliente = ordiniRepository.findByClienteOrderByDataOrdineDesc(cliente);
        dto.setOrdini(ordiniCliente);
        return dto;
    }
}
