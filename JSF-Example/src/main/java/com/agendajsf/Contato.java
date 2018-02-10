package com.agendajsf;

import java.io.Serializable;
//import java.util.List;

public class Contato implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String cpf;
	private String email;
	private Telefone telefone;

	public Contato() {}
	public Contato(Long id, String name, String cpf, String email, Telefone telefone) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Telefone getTelefone() {
		return telefone;
	}
	
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	
	@Override
	public Contato clone() {
		return new Contato(id, name, cpf, email, telefone
				);
	}

	public void restore(Contato contato) {
		this.id = contato.getId();
		this.name = contato.getName();
		this.cpf = contato.getCpf();
		this.email = contato.getEmail();
	}
	
	public void addTelefone(String ddd, String numero) {
		this.telefone = new Telefone(ddd, numero);
	}
	
}
