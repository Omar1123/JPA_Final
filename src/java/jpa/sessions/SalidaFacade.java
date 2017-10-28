/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Salida;

/**
 *
 * @author jake
 */
@Stateless
public class SalidaFacade extends AbstractFacade<Salida> {

    @PersistenceContext(unitName = "PersonalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SalidaFacade() {
        super(Salida.class);
    }
    
}
