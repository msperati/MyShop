package myshop.services;

import myshop.entities.Cliente;
import myshop.entities.Ordine;
import myshop.repositories.OrdiniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdiniService {

    @Autowired
    private OrdiniRepository ordiniRepository;

    public List<Ordine> getOrdini() {
        return ordiniRepository.findAll();
    }

    public List<Ordine> getOrdiniByCliente(Cliente cliente) {
        return ordiniRepository.findByCliente(cliente);
    }

    public Ordine getOrdine(Long idOrdine) {
        return ordiniRepository.findById(idOrdine).get();
    }

    public Ordine deleteOrdineById(Long idOrdine) {
        Ordine ordine = ordiniRepository.findById(idOrdine).get();
        ordiniRepository.delete(ordine);
        return ordine;
    }

    public Ordine deleteOrdine(Ordine ordine) {
        ordiniRepository.delete(ordine);
        /** La cancellazione di un'ordine porterà anche alla relativa cancellazione degli ordini prodotto
         associati, e al riaumento delle quantità in stock dei prodotti ad esso associati */
        return ordine;
    }

    public Ordine saveOrdine(Ordine ordine) {
        return ordiniRepository.save(ordine);
    }
}
