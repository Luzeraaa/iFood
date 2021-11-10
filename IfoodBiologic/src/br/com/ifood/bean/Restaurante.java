package br.com.ifood.bean;

import java.io.Serializable;

public class Restaurante implements Serializable {


	private static final long serialVersionUID = 1L;

	private int idRestaurante;
	
	private String nomeRestaurante;
	
	private float valorFrete;
	
	private int tempoEntrega;
	
	private float valorPedido;
	
	private String nomeResponsavel;
	
	private String emailResponsavel;
	
	private String cnpj;
	
	private String regiao;
	
	private Comida comida;


	
	



	public Restaurante() {
		super();
	}
	
	
	public Restaurante(int idRestaurante, String nomeRestaurante, float valorFrete, int tempoEntrega, float valorPedido,
			String nomeResponsavel, String emailResponsavel, String cnpj, String regiao) {
		super();
		this.idRestaurante = idRestaurante;
		this.nomeRestaurante = nomeRestaurante;
		this.valorFrete = valorFrete;
		this.tempoEntrega = tempoEntrega;
		this.valorPedido = valorPedido;
		this.nomeResponsavel = nomeResponsavel;
		this.emailResponsavel = emailResponsavel;
		this.cnpj = cnpj;
		this.regiao = regiao;
	}


	
	public String getRegiao() {
		return regiao;
	}


	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}


	public Comida getComida() {
		return comida;
	}

	public void setComida(Comida comida) {
		this.comida = comida;
	}

	public int getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public String getNomeRestaurante() {
		return nomeRestaurante;
	}

	public void setNomeRestaurante(String nomeRestaurante) {
		this.nomeRestaurante = nomeRestaurante;
	}

	public float getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(float valorFrete) {
		this.valorFrete = valorFrete;
	}

	public int getTempoEntrega() {
		return tempoEntrega;
	}

	public void setTempoEntrega(int tempoEntrega) {
		this.tempoEntrega = tempoEntrega;
	}

	public float getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(float valorPedido) {
		this.valorPedido = valorPedido;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getEmailResponsavel() {
		return emailResponsavel;
	}

	public void setEmailResponsavel(String emailResponsavel) {
		this.emailResponsavel = emailResponsavel;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
		
	
	
}
