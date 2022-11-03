package myshop.dtos;

import lombok.Data;
import myshop.entities.Ordine;
import myshop.entities.OrdineProdotto;

import java.util.List;

@Data
public class OrdineDTO {

    private Ordine ordine;
    private List<OrdineProdotto> ordiniProdotto;

}
