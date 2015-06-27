package br.com.cts.model;

public class Venda {
	private int id;
	private Double valorTotal;
	private Produto[] produto;
	
	public Venda(){
	}
	
	public Venda(int id, Double valorTotal, Produto[] produto) {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
		this.produto = produto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Produto[] getProduto() {
		return produto;
	}

	public void setProduto(Produto[] produto) {
		this.produto = produto;
	}
}