/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.proyectoPruebaEjb.sessions;

import co.edu.uniminuto.proyectoPruebaEjb.entities.Carro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */
@Stateless
public class CarroFacade extends AbstractFacade<Carro> {
    @PersistenceContext(unitName = "AqtCamisetasEJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarroFacade() {
        super(Carro.class);
    }
    
}
