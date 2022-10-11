/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.LocalDAO;
import br.edu.ifsul.dao.MobDAO;
import br.edu.ifsul.modelo.Local;
import br.edu.ifsul.modelo.Mob;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Izolante
 */
@Named(value = "controleMob")
@ViewScoped
public class ControleMob implements Serializable{
    
    @EJB
    private MobDAO<Mob> dao;
    private Mob objeto;
    @EJB
    private LocalDAO<Local> daoLocal;
    
    

    public ControleMob(){
        
    }
     public String listar() {
        return "/privado/mob/listar?faces-redirect=true";
    }
    
    public void novo() {
        objeto = new Mob();
    }
    
    public void alterar(Object id) {
        
        try {
            objeto = dao.getObjectByID(id);
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void excluir(Object id) {
        
        try {
            objeto = dao.getObjectByID(id);
            dao.remover(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar(){
        try {
            if(objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao salvar objeto: " + Util.getMensagemErro(e));
        }
    }
    /**
     * @return the dao
     */
    public MobDAO<Mob> getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(MobDAO<Mob> dao) {
        this.dao = dao;
    }

    /**
     * @return the objeto
     */
    public Mob getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(Mob objeto) {
        this.objeto = objeto;
    }

    /**
     * @return the daoLocal
     */
    public LocalDAO<Local> getDaoLocal() {
        return daoLocal;
    }

    /**
     * @param daoLocal the daoLocal to set
     */
    public void setDaoLocal(LocalDAO<Local> daoLocal) {
        this.daoLocal = daoLocal;
    }
    
    
    
}
