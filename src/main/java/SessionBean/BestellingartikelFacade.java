/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.Bestellingartikel;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lucas
 */
@Stateless
public class BestellingartikelFacade extends AbstractFacade<Bestellingartikel> {

    @PersistenceContext(unitName = "mine_Workshop7_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BestellingartikelFacade() {
        super(Bestellingartikel.class);
    }
    
}
