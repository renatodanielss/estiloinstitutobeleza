package br.com.cts.model;

public class Funcao {
	private int idFuncao;
	private String nomeFuncao;
	
	public Funcao(){
		
	}
	
	public Funcao(int idFuncao, String nomeFuncao) {
		super();
		this.idFuncao = idFuncao;
		this.nomeFuncao = nomeFuncao;
	}

	public int getIdFuncao() {
		return idFuncao;
	}

	public void setIdFuncao(int idFuncao) {
		this.idFuncao = idFuncao;
	}

	public String getNomeFuncao() {
		return nomeFuncao;
	}

	public void setNomeFuncao(String nomeFuncao) {
		this.nomeFuncao = nomeFuncao;
	}
}