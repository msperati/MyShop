package myshop.services;

import com.sun.istack.NotNull;
import myshop.dtos.OrdineDTO;
import myshop.entities.Cliente;
import myshop.entities.Ordine;
import myshop.entities.OrdineProdotto;
import myshop.entities.Prodotto;
import myshop.repositories.ClientiRepository;
import myshop.repositories.OrdiniProdottoRepository;
import myshop.repositories.OrdiniRepository;
import myshop.repositories.ProdottiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrdiniService {

    @Autowired
    private OrdiniRepository ordiniRepository;

    @Autowired
    private OrdiniProdottoRepository opRepository;

    @Autowired
    private ProdottiRepository prodottiRepository;

    @Autowired
    private ClientiRepository clientiRepository;

    public List<Ordine> getOrdini() {
        return ordiniRepository.findAllByOrderByDataOrdineDesc();
    }

    public List<Ordine> getOrdiniByCliente(Cliente cliente) {
        return ordiniRepository.findByClienteOrderByDataOrdineDesc(cliente);
    }

    public List<Ordine> getOrdiniByCliente(Long idCliente) {
        Cliente cliente = clientiRepository.findById(idCliente).get();
        return ordiniRepository.findByClienteOrderByDataOrdineDesc(cliente);
    }

    public Ordine getOrdine(Long idOrdine) {
        return ordiniRepository.findById(idOrdine).get();
    }

    /**
     * La cancellazione di un'ordine porterà anche alla relativa cancellazione degli ordini prodotto
     * associati, e al riaumento delle quantità in stock dei prodotti ad esso associati
     */
    @Transactional
    public OrdineDTO deleteOrdine(Long idOrdine) {
        Ordine ordine = ordiniRepository.findById(idOrdine).get();
        List<OrdineProdotto> ordiniProdotto = opRepository.findAllByPkOrdine(ordine);
        for (OrdineProdotto op : ordiniProdotto) {
            /** SE CANCELLIAMO UN ORDINE DI PRODOTTO DOBBIAMO ANCHE RISTOCCARE IL PRODOTTO */
            Prodotto prodotto = op.getPk().getProdotto();
            prodotto.setDisponibilita(prodotto.getDisponibilita() + op.getQuantita());
            prodottiRepository.save(prodotto);
        }
        ordiniRepository.delete(ordine);
        OrdineDTO dto = new OrdineDTO();
        dto.setOrdine(ordine);
        dto.setOrdiniProdotto(ordiniProdotto);
        return dto;
    }

    /**
     * La cancellazione di un'ordine porterà anche alla relativa cancellazione degli ordini prodotto
     * associati, e al riaumento delle quantità in stock dei prodotti ad esso associati
     */
    @Transactional
    public OrdineDTO deleteOrdine(Ordine ordine) {
        List<OrdineProdotto> ordiniProdotto = opRepository.findAllByPkOrdine(ordine);
        for (OrdineProdotto op : ordiniProdotto) {
            /** SE CANCELLIAMO UN ORDINE DI PRODOTTO DOBBIAMO ANCHE RISTOCCARE IL PRODOTTO */
            Prodotto prodotto = op.getPk().getProdotto();
            prodotto.setDisponibilita(prodotto.getDisponibilita() + op.getQuantita());
            prodottiRepository.save(prodotto);
        }
        ordiniRepository.delete(ordine);
        OrdineDTO dto = new OrdineDTO();
        dto.setOrdine(ordine);
        dto.setOrdiniProdotto(ordiniProdotto);
        return dto;
    }

    @Transactional
    public Ordine saveOrdine(@NotNull OrdineDTO dto) {
        Ordine ordine = dto.getOrdine();
        ordine = ordiniRepository.save(ordine);
        for (OrdineProdotto op : dto.getOrdiniProdotto()) {
            op.getPk().setOrdine(ordine);
            opRepository.save(op);
            Prodotto prodotto = op.getPk().getProdotto();
            /** La disponibilità del prodotto è stata già decrementata lato FE, dobbiamo solo persisterla */
            prodottiRepository.save(prodotto);
        }
        return ordine;
    }

//    public OrdineDTO dettaglioOrdine(Ordine ordine) {
//        OrdineDTO dto = new OrdineDTO();
//        dto.setOrdine(ordine);
//        dto.setOrdiniProdotto(opRepository.findAllByPkOrdine(ordine));
//        return dto;
//    }

    public OrdineDTO dettaglioOrdine(Long idOrdine) {
        OrdineDTO dto = new OrdineDTO();
        Ordine ordine = ordiniRepository.findById(idOrdine).get();
        dto.setOrdine(ordine);
        List<OrdineProdotto> ordiniProdotto = opRepository.findAllByPkOrdine(ordine);
        dto.setOrdiniProdotto(ordiniProdotto);
        return dto;
    }
}
