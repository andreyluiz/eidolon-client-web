package br.com.andrey.pessoa;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pessoa {

	public static final String RESOURCE_NAME = "pessoas";
	
	@XmlElement private Integer id;
	@XmlElement private String nome;
	
	public Pessoa() {
		
	}
	
	public Pessoa(Integer id) {
		this.id = id;
	}
	
	public Pessoa(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
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

}
