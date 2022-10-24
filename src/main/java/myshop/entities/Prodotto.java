package myshop.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "prodotto")
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_prodotto")
    private Long id;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "disponibilita")
    private Long disponibilita;

    @Column(name = "prezzo")
    private Long prezzo;

    @Column(name = "on_sale")
    private Boolean onSale;
}
