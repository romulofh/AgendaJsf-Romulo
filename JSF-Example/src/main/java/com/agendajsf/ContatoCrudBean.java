package com.agendajsf;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ContatoCrudBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Contato> list;
    private Contato item = new Contato();
    private Contato beforeEditItem = null;
    private boolean edit;
    

    @PostConstruct
    public void init() {
        list = new ArrayList<Contato>();
        item.setTelefone(new Telefone());
    }

    public void add() {
        item.setId(list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1);
        list.add(item);
        item = new Contato();
        item.setTelefone(new Telefone());
    }

    public void resetAdd() {
    	item = new Contato();
    }

    public void edit(Contato item) {
    	beforeEditItem = item.clone();
        this.item = item;
        edit = true;
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Contato();
        edit = false;
    }

    public void saveEdit() {
        this.item = new Contato();
        edit = false;
    }

    public void delete(Contato item) throws IOException {
        list.remove(item);
    }

    public List<Contato> getList() {
        return list;
    }

    public Contato getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }

}