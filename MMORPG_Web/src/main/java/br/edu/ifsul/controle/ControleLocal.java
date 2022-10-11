/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.LocalDAO;
import br.edu.ifsul.dao.LocalDAO;
import br.edu.ifsul.modelo.Local;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Izolante
 */
@Named(value = "controleLocal")
@ViewScoped
public class ControleLocal implements Serializable{
    
    @EJB
    private LocalDAO<Local> dao;
    private Local objeto;

    public ControleLocal(){
        
    }
     public String listar() {
        return "/privado/local/listar?faces-redirect=true";
    }
    
    public void novo() {
        objeto = new Local();
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
    public LocalDAO<Local> getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(LocalDAO<Local> dao) {
        this.dao = dao;
    }

    /**
     * @return the objeto
     */
    public Local getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(Local objeto) {
        this.objeto = objeto;
    }
    
    
    
}
