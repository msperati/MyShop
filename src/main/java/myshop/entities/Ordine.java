package myshop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ordine")
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ordine")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "data_ordine")
    private Date dataOrdine;

    @Column(name = "importo")
    private Long importoTotale;

    @Column(name = "indirizzo_spedizione")
    private String indirizzoSpedizione;

    @Column(name = "pagato")
    private Boolean pagato;

    @Column(name = "spedito")
    private Boolean spedito;

//    @JoinTable(name = "entities.ordine_prodotto")
//    @OneToMany
//    //(fetch = FetchType.LAZY, mappedBy = "ordine")
//    private List<OrdineProdotto> ordiniProdotto;
}
