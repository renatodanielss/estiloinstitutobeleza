package br.com.cts.model;

public class Produtos {
	private int id;
	private String nome;
	private String codigoBarras;
	private Double valor;
	private Double valorPraVenda;
	private String tipoUnidade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorPraVenda() {
		return valorPraVenda;
	}

	public void setValorPraVenda(Double valorPraVenda) {
		this.valorPraVenda = valorPraVenda;
	}

	public String getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade(String tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}

	public void calcQuantEstoque() {

	}

	public void calcQuantVendida() {

	}

	public void calcLucro() {

	}
}