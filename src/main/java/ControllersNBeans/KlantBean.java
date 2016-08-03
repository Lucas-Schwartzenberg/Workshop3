/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllersNBeans;

import Entity.Klant;
import SessionBean.KlantFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author lucas
 */
@Named(value = "klantBean")
@Dependent
@Stateless
public class KlantBean {
    
    @Inject
    KlantFacade klantFacade;
    
    Klant thisKlant;
    

    /**
     * Creates a new instance of KlantBean
     */
    public KlantBean() {
    }
    
    public List<Klant> findAll(){
        return klantFacade.findAll();
    }
    
    public void remove(Klant klant){
        klantFacade.remove(klant);
    }
    
    
    public String selectKlant(Klant klant){
        thisKlant = klant;        
        return "viewKlantEdit";
    }

    public KlantFacade getKlantFacade() {
        return klantFacade;
    }

    public void setKlantFacade(KlantFacade klantFacade) {
        this.klantFacade = klantFacade;
    }

    public Klant getThisKlant() {
        return thisKlant;
    }

    public void setThisKlant(Klant thisKlant) {
        this.thisKlant = thisKlant;
    }
    
    
}
