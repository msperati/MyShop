package myshop.repositories;

import myshop.entities.Cliente;
import myshop.entities.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdiniRepository extends JpaRepository<Ordine, Long> {

    List<Ordine> findAllByOrderByDataOrdineDesc();

    List<Ordine> findByClienteOrderByDataOrdineDesc(Cliente cliente);
}
