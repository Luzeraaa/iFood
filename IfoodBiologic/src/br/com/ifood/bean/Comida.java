package br.com.ifood.bean;

import java.io.Serializable;

public class Comida implements Serializable {
	

	private static final long serialVersionUID = 1L;

	private int idComida;
	
	private String descricaoComida;
	
	public Comida() {
		super();
	}

	
	
	public Comida(int idComida, String descricaoComida) {
		super();
		this.idComida = idComida;
		this.descricaoComida = descricaoComida;
	}



	public int getIdComida() {
		return idComida;
	}

	public void setIdComida(int idComida) {
		this.idComida = idComida;
	}

	public String getDescricaoComida() {
		return descricaoComida;
	}

	public void setDescricaoComida(String descricaoComida) {
		this.descricaoComida = descricaoComida;
	}
	
	
	
}
