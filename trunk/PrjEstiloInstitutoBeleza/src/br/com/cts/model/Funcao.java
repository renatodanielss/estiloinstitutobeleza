package br.com.cts.model;

public class Funcao {
	private int id;
	private String nomeFuncao;
	
	public Funcao(){
		
	}
	
	public Funcao(int id, String nomeFuncao) {
		super();
		this.id = id;
		this.nomeFuncao = nomeFuncao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeFuncao() {
		return nomeFuncao;
	}

	public void setNomeFuncao(String nomeFuncao) {
		this.nomeFuncao = nomeFuncao;
	}
}