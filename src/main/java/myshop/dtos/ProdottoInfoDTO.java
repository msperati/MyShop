package myshop.dtos;

import lombok.Data;
import myshop.entities.Prodotto;

@Data
public class ProdottoInfoDTO {

    private Prodotto prodotto;
    private Long ordiniAssociati;
    private Long ordiniAssociatiPagati;
    private Long copieOrdinate;
    private Long copieOrdinatePagate;
    private Long clientiOrdinanti;
}
