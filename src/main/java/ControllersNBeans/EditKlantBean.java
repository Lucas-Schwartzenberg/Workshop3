/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllersNBeans;

import Entity.Klant;
import SessionBean.KlantFacade;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

/**
 *
 * @author lucas
 */
@Named(value = "editKlantBean")
@Dependent
@Stateless
public class EditKlantBean {
    
    @Inject
    KlantFacade klantFacade;
        
    Klant thisKlant;

    /**
     * Creates a new instance of EditKlantBean
     */
    public EditKlantBean() {
    }
    
    public String startEdit(Klant klant){
        thisKlant = klant;
        return "viewKlantEdit";
    }
    
    public String newKlant(){
        thisKlant = new Klant();
        thisKlant.setVoornaam("Anoniem");
        thisKlant.setAchternaam("Anoniem");
        thisKlant.setEmail("Anoniem");
        return "viewKlantEdit";
    }
    
    //DAO acties
    public String updateThisKlant(){
        klantFacade.edit(thisKlant);
        return "viewKlantLijst";
    }
    
    
    
    //getters en setters
    public Klant getThisKlant() {
        return thisKlant;
    }

    public void setThisKlant(Klant thisKlant) {
        this.thisKlant = thisKlant;
    }
    
    


}
