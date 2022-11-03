package myshop.dtos;

import lombok.Data;
import myshop.entities.Cliente;
import myshop.entities.Ordine;

import java.util.List;

@Data
public class ClienteDTO {

    private Cliente cliente;
    private List<Ordine> ordini;
    
}
