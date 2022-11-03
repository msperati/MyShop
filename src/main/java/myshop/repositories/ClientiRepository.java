package myshop.repositories;

import myshop.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientiRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT * FROM ENTITIES.CLIENTE " +
            "ORDER BY (CONCAT (CLIENTE.NOME,' ',CLIENTE.COGNOME))",
            nativeQuery = true)
    List<Cliente> findAllOrdineAlfabetico();

    Optional<Cliente> findByEmail(String email);

    @Query(value = "SELECT * FROM ENTITIES.CLIENTE WHERE " +
            "(CONCAT (CLIENTE.NOME,' ',CLIENTE.COGNOME) =:nomecognome)",
            nativeQuery = true)
    List<Cliente> findByNomeCognome(String nomecognome);
}
