/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Mob;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Izolante
 */
@Stateful
public class MobDAO<TIPO> extends DAOGenerico<Mob> implements Serializable{
    
    public MobDAO(){
        super();
        classePersistente = Mob.class;
//ordens
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        listaOrdem.add(new Ordem("local.nome", "Local", "like"));
        ordemAtual = listaOrdem.get(1);
        
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
    
}
