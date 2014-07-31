package br.com.cts.model;

public class Funcionario {
	private int id;
	private String nome;
	private int sexo;
	private String dataNascimento;
	private String logradouro;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private int uf;
	private String cep;
	private String telefone;
	private String celular1;
	private String celular2;
	private String email1;
	private String email2;
	private Funcao[] funcao;
	
	public Funcionario(){
		
	}
	
	public Funcionario(int id, String nome, int sexo, String dataNascimento, String logradouro, int numero, String complemento, String bairro, String cidade, int uf, String cep, String telefone, String celular1, String celular2, String email1, String email2, Funcao[] funcao) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.telefone = telefone;
		this.celular1 = celular1;
		this.celular2 = celular2;
		this.email1 = email1;
		this.email2 = email2;
		this.funcao = funcao;
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
	
	public int getSexo() {
		return sexo;
	}
	
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public int getUf() {
		return uf;
	}
	
	public void setUf(int uf) {
		this.uf = uf;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCelular1() {
		return celular1;
	}
	
	public void setCelular1(String celular1) {
		this.celular1 = celular1;
	}
	
	public String getCelular2() {
		return celular2;
	}
	
	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}
	
	public String getEmail1() {
		return email1;
	}
	
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	
	public String getEmail2() {
		return email2;
	}
	
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	
	public Funcao[] getFuncao() {
		return funcao;
	}
	
	public void setFuncao(Funcao[] funcao) {
		this.funcao = funcao;
	}
}