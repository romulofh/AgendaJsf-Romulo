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
public class TelefoneCrudBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Telefone> list;
    private Telefone item = new Telefone();
    private Telefone beforeEditItem = null;
    private boolean edit;

    @PostConstruct
    public void init() {
        list = new ArrayList<Telefone>();
    }

    public void add() {
        item.setId(list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1);
        list.add(item);
        item = new Telefone();
    }

    public void resetAdd() {
    	item = new Telefone();
    }

    public void edit(Telefone item) {
    	beforeEditItem = item.clone();
        this.item = item;
        edit = true;
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Telefone();
        edit = false;
    }

    public void saveEdit() {
        this.item = new Telefone();
        edit = false;
    }

    public void delete(Telefone item) throws IOException {
        list.remove(item);
    }

    public List<Telefone> getList() {
        return list;
    }

    public Telefone getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }
	
}
