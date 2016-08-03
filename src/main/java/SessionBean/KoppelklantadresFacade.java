/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.Koppelklantadres;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author lucas
 */
@Stateless
public class KoppelklantadresFacade extends AbstractFacade<Koppelklantadres> {

    @PersistenceContext(unitName = "mine_Workshop7_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KoppelklantadresFacade() {
        super(Koppelklantadres.class);
    }
    
    public List<Koppelklantadres> findByIdKlant(Integer idKlant){
        Query query = em.createNamedQuery("Koppelklantadres.findByKlantId", Koppelklantadres.class);
        query.setParameter("klantId", idKlant);
        return query.getResultList();
    }
    
    public List<Koppelklantadres> findByIdAdres(Integer idAdres){
        Query query = em.createNamedQuery("Koppelklantadres.findByAdresId", Koppelklantadres.class);
        query.setParameter("adresId", idAdres);
        return query.getResultList();
    }
    
}
