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
import SessionBean.KlantFacade;
import SessionBean.KoppelklantadresFacade;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author lucas
 */
@Named(value = "koppelKABean")
@Dependent
@Stateless
public class KoppelKABean {
    
    List<Klant> allKlant;
    List<Adres> allAdres;
    Integer selectedKlant;
    Integer selectedAdres;
    
    Map<String, Integer> klantList;
    Map<String, Integer> adresList;

    @Inject
    KlantFacade klantFacade;
    @Inject
    AdresFacade adresFacade;
    @Inject
    KoppelklantadresFacade koppelklantadresFacade;

    /**
     * Creates a new instance of KoppelKABean
     */
    public KoppelKABean() {
    }
    
    @PostConstruct
    private void init() {
        allKlant = klantFacade.findAll();
        allAdres = adresFacade.findAll();
        
        klantList  = new HashMap<>();
        adresList  = new HashMap<>();
        
        for (Klant e: allKlant){
            String klantVolNaam = e.getVoornaam()+" "+e.getTussenvoegsel()+" "+e.getAchternaam();
            klantList.put(klantVolNaam, e.getKlantId() ) ;
        }
        for (Adres e: allAdres){
            String adresVolNaam = e.getStraatnaam()+" "+e.getHuisnummer()+", "+e.getWoonplaats();
            adresList.put(adresVolNaam, e.getAdresId() ) ;
        }
    }
    
    public String create(){
        if (selectedKlant == null || selectedAdres == null){
            System.out.print("bullshitfail");
        }
        else{
            System.out.print("Klant Id: " +selectedKlant + ", Adres Id: " + selectedAdres );
        }
        Koppelklantadres koppelKA = new Koppelklantadres();
        koppelKA.setKlantId( klantFacade.find(selectedKlant) );
        koppelKA.setAdresId( adresFacade.find(selectedAdres) );
        koppelklantadresFacade.create(koppelKA);        
        return "/index";
    }
    
    
    
    
    
    
    
    //Getters en Setters
    public List<Klant> getAllKlant() {
        return allKlant;
    }

    public void setAllKlant(List<Klant> allKlant) {
        this.allKlant = allKlant;
    }

    public List<Adres> getAllAdres() {
        return allAdres;
    }

    public void setAllAdres(List<Adres> allAdres) {
        this.allAdres = allAdres;
    }

    public Integer getSelectedKlant() {
        return selectedKlant;
    }

    public void setSelectedKlant(Integer selectedKlant) {
        this.selectedKlant = selectedKlant;
    }

    public Integer getSelectedAdres() {
        return selectedAdres;
    }

    public void setSelectedAdres(Integer selectedAdres) {
        this.selectedAdres = selectedAdres;
    }
    
    public Map<String, Integer> getKlantList() {
        return klantList;
    }

    public void setKlantList(Map<String, Integer> klantList) {
        this.klantList = klantList;
    }

    public Map<String, Integer> getAdresList() {
        return adresList;
    }

    public void setAdresList(Map<String, Integer> adresList) {
        this.adresList = adresList;
    }
    
}
