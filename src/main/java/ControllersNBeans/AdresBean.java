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
    Klant thisKlant;


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
    
    
    //getters and Setters
    public Adres getThisAdres() {
        return thisAdres;
    }

    public void setThisAdres(Adres thisAdres) {
        this.thisAdres = thisAdres;
    }
    
    public List<Adres> getListOfAdressen() {
        return listOfAdressen;
    }

    public void setListOfAdressen(List<Adres> listOfAdressen) {
        this.listOfAdressen = listOfAdressen;
    }
    
    public Klant getThisKlant() {
        return thisKlant;
    }

    public void setThisKlant(Klant thisKlant) {
        this.thisKlant = thisKlant;
    }
    
    
    //???
    @PostConstruct
    private void init() {
        setListOfAdressen(adresFacade.findAll());
    }
    
    // Crud Acties
    public String create(){
        thisAdres = new Adres();
        return "viewAdresEdit";
    }
    
    public void remove(Adres adres){
        adresFacade.remove(adres);
    }
    
    public String updateThis(Adres adres){
        thisAdres = adres;
        return "viewAdresEdit";
    }
    
    public String update(){
        adresFacade.edit(thisAdres);
        return "viewAdresEdit";
    }
    
    public void selectThis(Adres adres){
        thisAdres = adres;
    }
}
