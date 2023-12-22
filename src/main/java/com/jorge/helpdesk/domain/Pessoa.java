package com.jorge.helpdesk.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.annotations.Collate;

import com.jorge.helpdesk.domain.enums.Perfil;

public abstract class Pessoa {
protected Integer id;

protected String nome;
protected String cpf;
protected String email;
protected String senha;
protected Set<Integer> perfis = new HashSet<>();
protected LocalDate datacriacao = LocalDate.now();// método LocalDate.now() pega a data do sistema
public Pessoa() { // construtor da super class
	super();
	addPerfil(Perfil.CLIENTE); // cliente criado passa a ter o perfil de cliente
}
public Pessoa(Integer id, String nome, String cpf, String email, String senha) { // construtor com parametros da super classe
	super();
	this.id = id;
	this.nome = nome;
	this.cpf = cpf;
	this.email = email;
	this.senha = senha;
	addPerfil(Perfil.CLIENTE); // cliente criado passa a ter o perfil de cliente
}
@Override
public int hashCode() {
	return Objects.hash(cpf, id);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Pessoa other = (Pessoa) obj;
	return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
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
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}
public Set<Perfil> getPerfis() {
	return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
}
public void addPerfil(Perfil perfil) {
	this.perfis.add(perfil.getCodigo());
}
public LocalDate getDatacriacao() {
	return datacriacao;
}
public void setDatacriacao(LocalDate datacriacao) {
	this.datacriacao = datacriacao;
}
}
