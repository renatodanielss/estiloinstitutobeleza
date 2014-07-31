package br.com.cts.model;

public class Produto {
	private int id;
	private String nome;
	private String codigoBarras;
	private Double valor;
	private Double valorPraVenda;
	private String tipoUnidade;
	private int qtdEstoque;

	public Produto(){
		
	}
	
	public Produto(int id, String nome, String codigoBarras, Double valor, Double valorPraVenda, String tipoUnidade, int qtdEstoque) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigoBarras = codigoBarras;
		this.valor = valor;
		this.valorPraVenda = valorPraVenda;
		this.tipoUnidade = tipoUnidade;
		this.qtdEstoque = qtdEstoque;
	}

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

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public void calcQuantEstoque(){

	}

	public void calcQuantVendida(){

	}

	public void calcLucro(){

	}
}