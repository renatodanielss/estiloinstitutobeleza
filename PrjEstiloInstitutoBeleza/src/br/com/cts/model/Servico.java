package br.com.cts.model;

import java.util.Date;

public class Servico {
	private int id;
	private Date dataHora;
	private String statusServico;
	private Double valor;
	private Double comissao;
	private Cliente cliente;
	private Funcionario funcionario;
	private Cartao[] cartao;

	public Servico(){
	}
	
	public Servico(int id, Date dataHora, String statusServico, Double valor, Double comissao, Cliente cliente, Funcionario funcionario, Cartao[] cartao){
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.statusServico = statusServico;
		this.valor = valor;
		this.comissao = comissao;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.cartao = cartao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getStatusServico() {
		return statusServico;
	}

	public void setStatusServico(String statusServico) {
		this.statusServico = statusServico;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cartao[] getCartao() {
		return cartao;
	}

	public void setCartao(Cartao[] cartao) {
		this.cartao = cartao;
	}

	public void calcComissao() {

	}

	public void gerarRelatorio() {

	}
}