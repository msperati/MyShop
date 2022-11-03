package myshop.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ordine_prodotto")
public class OrdineProdotto {

    @EmbeddedId
    Pk pk;
    @Column(name = "quantita")
    private Long quantita;
    @Column(name = "prezzo")
    private Long prezzo;

    @Override
    public String toString() {
        return quantita + "X " + pk.prodotto.getDescrizione() + " = " + quantita * prezzo;
    }

    @Embeddable
    @Data
    public static class Pk implements Serializable {

        @ManyToOne(cascade = CascadeType.MERGE)
        @JoinColumn(name = "id_ordine")
        private Ordine ordine;

        @ManyToOne(cascade = CascadeType.MERGE)
        @JoinColumn(name = "id_prodotto")
        private Prodotto prodotto;
    }
}
