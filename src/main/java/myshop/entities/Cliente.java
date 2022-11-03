package myshop.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String tel;
    
    @Column(name = "p_iva")
    private String piva;
}
