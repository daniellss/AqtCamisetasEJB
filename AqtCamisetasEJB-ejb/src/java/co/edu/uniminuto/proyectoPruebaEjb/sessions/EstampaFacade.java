/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.proyectoPruebaEjb.sessions;

import co.edu.uniminuto.proyectoPruebaEjb.entities.Estampa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */
@Stateless
public class EstampaFacade extends AbstractFacade<Estampa> {
    @PersistenceContext(unitName = "AqtCamisetasEJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstampaFacade() {
        super(Estampa.class);
    }
    
}
