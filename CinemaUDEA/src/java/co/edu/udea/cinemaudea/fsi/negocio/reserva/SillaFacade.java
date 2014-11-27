/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.cinemaudea.fsi.negocio.reserva;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import co.edu.udea.cinemaudea.fsi.negocio.documentacion.AbstractFacade;
import co.edu.udea.cinemaudea.fsi.persistencia.entidades.Silla;

/**
 *
 * @author DiegoCalle
 */
@Stateless
public class SillaFacade extends AbstractFacade<Silla> {
    @PersistenceContext(unitName = "CinemaUDEAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SillaFacade() {
        super(Silla.class);
    }
    
}
