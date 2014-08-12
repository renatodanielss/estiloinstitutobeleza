package br.com.cts.model;

public class Produto {
	private int idProduto;
	private String nomeProduto;
	private String codigoBarrasProduto;
	private Double valorProduto;
	private Double valorPraVendaProduto;
	private String tipoUnidadeProduto;
	private int qtdEstoqueProduto;

	public Produto(){
		
	}
	
	public Produto(int idProduto, String nomeProduto, String codigoBarrasProduto, Double valorProduto, Double valorPraVendaProduto, String tipoUnidadeProduto, int qtdEstoqueProduto) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.codigoBarrasProduto = codigoBarrasProduto;
		this.valorProduto = valorProduto;
		this.valorPraVendaProduto = valorPraVendaProduto;
		this.tipoUnidadeProduto = tipoUnidadeProduto;
		this.qtdEstoqueProduto = qtdEstoqueProduto;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getCodigoBarrasProduto() {
		return codigoBarrasProduto;
	}

	public void setCodigoBarrasProduto(String codigoBarrasProduto) {
		this.codigoBarrasProduto = codigoBarrasProduto;
	}

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Double getValorPraVendaProduto() {
		return valorPraVendaProduto;
	}

	public void setValorPraVendaProduto(Double valorPraVendaProduto) {
		this.valorPraVendaProduto = valorPraVendaProduto;
	}

	public String getTipoUnidadeProduto() {
		return tipoUnidadeProduto;
	}

	public void setTipoUnidadeProduto(String tipoUnidadeProduto) {
		this.tipoUnidadeProduto = tipoUnidadeProduto;
	}

	public int getQtdEstoqueProduto() {
		return qtdEstoqueProduto;
	}

	public void setQtdEstoqueProduto(int qtdEstoqueProduto) {
		this.qtdEstoqueProduto = qtdEstoqueProduto;
	}

	
}