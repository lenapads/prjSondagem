package com.example.lenoca.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
	private String first_name;
	private String last_name;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_projeto_funcionario", joinColumns = @JoinColumn(name = "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "projeto_id"))
	private List<Projeto> projeto;
	
	public Funcionario() {
		
	}

	public Funcionario(Long id, String first_name, String last_name, List<Projeto> projeto) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.projeto = projeto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public List<Projeto> getProjeto() {
		return projeto;
	}

	public void setProjeto(List<Projeto> projeto) {
		this.projeto = projeto;
	}

}