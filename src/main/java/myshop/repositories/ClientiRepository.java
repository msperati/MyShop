package myshop.repositories;

import myshop.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientiRepository extends JpaRepository<Cliente, Long> {

}
