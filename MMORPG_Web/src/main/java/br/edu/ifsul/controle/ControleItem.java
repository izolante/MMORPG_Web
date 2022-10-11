/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ItemDAO;
import br.edu.ifsul.dao.ItemDAO;
import br.edu.ifsul.modelo.Item;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Izolante
 */
@Named(value = "controleItem")
@ViewScoped
public class ControleItem implements Serializable{
    
    @EJB
    private ItemDAO<Item> dao;
    private Item objeto;

    public ControleItem(){
        
    }
     public String listar() {
        return "/privado/item/listar?faces-redirect=true";
    }
    
    public void novo() {
        objeto = new Item();
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
    public ItemDAO<Item> getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(ItemDAO<Item> dao) {
        this.dao = dao;
    }

    /**
     * @return the objeto
     */
    public Item getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(Item objeto) {
        this.objeto = objeto;
    }
    
    
    
}
