package myshop.dtos;

import lombok.Data;
import myshop.entities.Cliente;
import myshop.entities.Ordine;

import java.util.List;

@Data
public class ClienteDTO {

    private Cliente cliente;
    private List<Ordine> ordini;

//    public static ClienteDTO clienteToDTO(Cliente cliente) {
//        ClienteDTO dto = new ClienteDTO();
//        dto.setId(cliente.getId());
//        dto.setNome(cliente.getNome());
//        dto.setCognome(cliente.getCognome());
//        dto.setIndirizzo(cliente.getIndirizzo());
//        dto.setEmail(cliente.getEmail());
//        dto.setTel(cliente.getTel());
//        dto.setPiva(cliente.getPiva());
//        dto.setOrdini(new LinkedList<>());
//        return dto;
//    }
//
//    public Cliente convert() {
//        Cliente cliente = new Cliente();
//        cliente.setId(this.id);
//        cliente.setNome(this.nome);
//        cliente.setCognome(this.cognome);
//        cliente.setIndirizzo(this.indirizzo);
//        cliente.setEmail(this.email);
//        cliente.setTel(this.tel);
//        cliente.setPiva(this.piva);
//        return cliente;
//    }
}
