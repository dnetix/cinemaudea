/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistencia.entidades.Cartelera;

/**
 *
 * @author DiegoCalle
 */
@Stateless
public class CarteleraFacade extends AbstractFacade<Cartelera> {
    @PersistenceContext(unitName = "CinemaUDEAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarteleraFacade() {
        super(Cartelera.class);
    }
    
}
