package myshop.services;

import myshop.entities.Cliente;
import myshop.repositories.ClientiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientiService {

    @Autowired
    private ClientiRepository clientiRepository;

    public List<Cliente> getClienti() {
        return clientiRepository.findAll();
    }

    public Cliente getCliente(Long idCliente) {
        return clientiRepository.findById(idCliente).get();
    }

    public Cliente deleteClienteById(Long idCliente) {
        Cliente cliente = clientiRepository.findById(idCliente).get();
        clientiRepository.delete(cliente);
        return cliente;
    }

    public Cliente deleteCliente(Cliente cliente) {
        clientiRepository.delete(cliente);
        return cliente;
    }

    public Cliente saveCliente(Cliente cliente) {
        return clientiRepository.save(cliente);
    }
}
