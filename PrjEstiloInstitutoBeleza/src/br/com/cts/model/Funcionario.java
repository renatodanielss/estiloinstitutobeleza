package br.com.cts.model;

public class Funcionario {
	private int idFuncionario;
	private String nomeFuncionario;
	private int sexoFuncionario;
	private String dataNascimentoFuncionario;
	private String logradouroFuncionario;
	private int numeroFuncionario;
	private String complementoFuncionario;
	private String bairroFuncionario;
	private String cidadeFuncionario;
	private int ufFuncionario;
	private String cepFuncionario;
	private String telefoneFuncionario;
	private String celular1Funcionario;
	private String celular2Funcionario;
	private String email1Funcionario;
	private String email2Funcionario;
	private Funcao[] funcao;
	private Funcionario funcionario;
	
	public Funcionario(){
	}
	
	public Funcionario(int idFuncionario, String nomeFuncionario, int sexoFuncionario, String dataNascimentoFuncionario, String logradouroFuncionario, int numeroFuncionario, String complementoFuncionario, String bairroFuncionario, String cidadeFuncionario, int ufFuncionario, String cepFuncionario, String telefoneFuncionario, String celular1Funcionario, String celular2Funcionario, String email1Funcionario, String email2Funcionario, Funcao[] funcao, Funcionario funcionario) {
		super();
		this.idFuncionario = idFuncionario;
		this.nomeFuncionario = nomeFuncionario;
		this.sexoFuncionario = sexoFuncionario;
		this.dataNascimentoFuncionario = dataNascimentoFuncionario;
		this.logradouroFuncionario = logradouroFuncionario;
		this.numeroFuncionario = numeroFuncionario;
		this.complementoFuncionario = complementoFuncionario;
		this.bairroFuncionario = bairroFuncionario;
		this.cidadeFuncionario = cidadeFuncionario;
		this.ufFuncionario = ufFuncionario;
		this.cepFuncionario = cepFuncionario;
		this.telefoneFuncionario = telefoneFuncionario;
		this.celular1Funcionario = celular1Funcionario;
		this.celular2Funcionario = celular2Funcionario;
		this.email1Funcionario = email1Funcionario;
		this.email2Funcionario = email2Funcionario;
		this.funcao = funcao;
		this.funcionario = funcionario;
	}
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
	public int getSexoFuncionario() {
		return sexoFuncionario;
	}
	
	public void setSexoFuncionario(int sexoFuncionario) {
		this.sexoFuncionario = sexoFuncionario;
	}
	
	public String getDataNascimentoFuncionario() {
		return dataNascimentoFuncionario;
	}
	
	public void setDataNascimentoFuncionario(String dataNascimentoFuncionario) {
		this.dataNascimentoFuncionario = dataNascimentoFuncionario;
	}
	
	public String getLogradouroFuncionario() {
		return logradouroFuncionario;
	}
	
	public void setLogradouroFuncionario(String logradouroFuncionario) {
		this.logradouroFuncionario = logradouroFuncionario;
	}
	
	public int getNumeroFuncionario() {
		return numeroFuncionario;
	}
	
	public void setNumeroFuncionario(int numeroFuncionario) {
		this.numeroFuncionario = numeroFuncionario;
	}
	
	public String getComplementoFuncionario() {
		return complementoFuncionario;
	}
	
	public void setComplementoFuncionario(String complementoFuncionario) {
		this.complementoFuncionario = complementoFuncionario;
	}
	
	public String getBairroFuncionario() {
		return bairroFuncionario;
	}
	
	public void setBairroFuncionario(String bairroFuncionario) {
		this.bairroFuncionario = bairroFuncionario;
	}
	
	public String getCidadeFuncionario() {
		return cidadeFuncionario;
	}
	
	public void setCidadeFuncionario(String cidadeFuncionario) {
		this.cidadeFuncionario = cidadeFuncionario;
	}
	
	public int getUfFuncionario() {
		return ufFuncionario;
	}
	
	public void setUfFuncionario(int ufFuncionario) {
		this.ufFuncionario = ufFuncionario;
	}
	
	public String getCepFuncionario() {
		return cepFuncionario;
	}
	
	public void setCepFuncionario(String cepFuncionario) {
		this.cepFuncionario = cepFuncionario;
	}
	
	public String getTelefoneFuncionario() {
		return telefoneFuncionario;
	}
	
	public void setTelefoneFuncionario(String telefoneFuncionario) {
		this.telefoneFuncionario = telefoneFuncionario;
	}
	
	public String getCelular1Funcionario() {
		return celular1Funcionario;
	}
	
	public void setCelular1Funcionario(String celular1Funcionario) {
		this.celular1Funcionario = celular1Funcionario;
	}
	
	public String getCelular2Funcionario() {
		return celular2Funcionario;
	}
	
	public void setCelular2Funcionario(String celular2Funcionario) {
		this.celular2Funcionario = celular2Funcionario;
	}
	
	public String getEmail1Funcionario() {
		return email1Funcionario;
	}
	
	public void setEmail1Funcionario(String email1Funcionario) {
		this.email1Funcionario = email1Funcionario;
	}
	
	public String getEmail2() {
		return email2Funcionario;
	}
	
	public void setEmail2Funcionario(String email2Funcionario) {
		this.email2Funcionario = email2Funcionario;
	}
	
	public Funcao[] getFuncao() {
		return funcao;
	}
	
	public void setFuncao(Funcao[] funcao) {
		this.funcao = funcao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}