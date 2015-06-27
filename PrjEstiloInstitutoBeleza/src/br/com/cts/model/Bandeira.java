package br.com.cts.model;

public class Bandeira {
	private String nomeBandeira;
	
	public Bandeira(){	
	}
	
	public Bandeira(String nomeBandeira) {
		super();
		this.nomeBandeira = nomeBandeira;
	}

	public String getNomeBandeira() {
		return nomeBandeira;
	}
	
	public void setNomeBandeira(String nomeBandeira) {
		this.nomeBandeira = nomeBandeira;
	}
}
