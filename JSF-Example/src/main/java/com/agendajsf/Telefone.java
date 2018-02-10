package com.agendajsf;

import java.io.Serializable;

public class Telefone implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	public String ddd;
	public String numero;
	
	public Telefone() {
		
	}
	public Telefone(String ddd, String numero) {
		//this.id = id;
		this.ddd = ddd;
		this.numero = numero;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Telefone clone() {
		return new Telefone(ddd, numero);
	}
	
	public void restore(Telefone telefone){
		this.id = telefone.getId();
		this.ddd = telefone.getDdd();
		this.numero = telefone.getNumero();
	}

}
