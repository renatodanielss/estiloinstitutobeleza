package br.com.cts.model;

public class Funcao {
	private int idFuncao;
	private String nomeFuncao;
	private float comissaoFuncao;
	
	public Funcao(){
	}
	
	public Funcao(int idFuncao, String nomeFuncao, float comissaoFuncao) {
		super();
		this.idFuncao = idFuncao;
		this.nomeFuncao = nomeFuncao;
		this.comissaoFuncao = comissaoFuncao;
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

	public float getComissaoFuncao() {
		return comissaoFuncao;
	}

	public void setComissaoFuncao(float comissaoFuncao) {
		this.comissaoFuncao = comissaoFuncao;
	}
}