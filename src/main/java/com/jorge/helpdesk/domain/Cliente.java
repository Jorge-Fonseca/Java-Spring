package com.jorge.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa { // classe cliente é uma instancia da classe pessoa, tem todos os atributos da classe pessoa
	private List<Chamado> chamados = new ArrayList<>();
	public Cliente() { // método construtor sem parametro
		super();
	}

	public Cliente(Integer id, String nome, String cpf, String email, String senha) { // método construtor com parametro
		super(id, nome, cpf, email, senha);
	}
	
	
	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	



}
