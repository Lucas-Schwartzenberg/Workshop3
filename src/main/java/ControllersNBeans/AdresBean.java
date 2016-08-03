/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllersNBeans;

import Entity.Adres;
import Entity.Klant;
import Entity.Koppelklantadres;
import SessionBean.AdresFacade;
import SessionBean.KoppelklantadresFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author lucas
 */
@Named(value = "adresBean")
@Dependent
@Stateless
public class AdresBean {

    @Inject
    AdresFacade adresFacade;
    
    @Inject
    KoppelklantadresFacade koppelklantadresFacade;
    
    Adres thisAdres;
    List<Adres> listOfAdressen;

    /**
     * Creates a new instance of AdresBean
     */
    public AdresBean() {
    }
    
    public List<Adres> findAll(){
        return adresFacade.findAll();
    }
    
    public Adres find(Integer adres_id){
        return adresFacade.find(adres_id);
    }
    
    public List<Adres> findAdressenByKlant(Klant klant){
        List<Koppelklantadres> listOfAdresKoppels = koppelklantadresFacade.findByIdKlant( klant.getKlantId() );
        listOfAdressen.clear();
        for (Koppelklantadres kop: listOfAdresKoppels){
            listOfAdressen.add( kop.getAdresId() );
        }
        return listOfAdressen;
    }
    
    public List<Adres> getListOfAdressen() {
        return listOfAdressen;
    }

    public void setListOfAdressen(List<Adres> listOfAdressen) {
        this.listOfAdressen = listOfAdressen;
    }
    
    @PostConstruct
    private void init() {
        setListOfAdressen(adresFacade.findAll());
    }
}
