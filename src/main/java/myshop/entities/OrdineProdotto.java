package myshop.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ordine_prodotto")
public class OrdineProdotto {

    @EmbeddedId
    OP_PK pk;
    @Column(name = "quantita")
    private Long quantita;
    @Column(name = "prezzo")
    private Long prezzo;

    @Embeddable
    @Data
    public static class OP_PK implements Serializable {
        
        @ManyToOne(cascade = CascadeType.MERGE)
        @JoinColumn(name = "id_ordine")
        private Ordine ordine;

        @ManyToOne(cascade = CascadeType.MERGE)
        @JoinColumn(name = "id_prodotto")
        private Prodotto prodotto;
    }
}
