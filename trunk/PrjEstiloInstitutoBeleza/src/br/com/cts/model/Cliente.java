package br.com.cts.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Cliente {
	private int idCliente;
	private String nomeCliente;
	private boolean sexoCliente;
	private String dataNascimentoCliente;
	private String logradouroCliente;
	private int numeroCliente;
	private String complementoCliente;
	private String bairroCliente;
	private String cidadeCliente;
	private String ufCliente;
	private String cepCliente;
	private String telefoneCliente;
	private String celular1Cliente;
	private String celular2Cliente;
	private String email1Cliente;
	private String email2Cliente;
	
	public Cliente(){
		
	}

	public Cliente(int idCliente, String nomeCliente, boolean sexoCliente, String dataNascimentoCliente, String logradouroCliente, int numeroCliente, String complementoCliente, String bairroCliente, String cidadeCliente, String ufCliente, String cepCliente, String telefoneCliente, String celular1Cliente, String celular2Cliente, String email1Cliente, String email2Cliente) {
		super();
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.sexoCliente = sexoCliente;
		this.dataNascimentoCliente = dataNascimentoCliente;
		this.logradouroCliente = logradouroCliente;
		this.numeroCliente = numeroCliente;
		this.complementoCliente = complementoCliente;
		this.bairroCliente = bairroCliente;
		this.cidadeCliente = cidadeCliente;
		this.ufCliente = ufCliente;
		this.cepCliente = cepCliente;
		this.telefoneCliente = telefoneCliente;
		this.celular1Cliente = celular1Cliente;
		this.celular2Cliente = celular2Cliente;
		this.email1Cliente = email1Cliente;
		this.email2Cliente = email2Cliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public boolean getSexoCliente() {
		return sexoCliente;
	}

	public void setSexoCliente(boolean sexoCliente) {
		this.sexoCliente = sexoCliente;
	}

	public String getDataNascimentoCliente() {
		return dataNascimentoCliente;
	}

	public boolean setDataNascimentoCliente(String dataNascimentoCliente) throws ParseException {
		if (isDate(dataNascimentoCliente)){
			this.dataNascimentoCliente = dataNascimentoCliente;
			return true;
		}
		else{
			return false;
		}
	}

	public String getLogradouroCliente() {
		return logradouroCliente;
	}

	public void setLogradouroCliente(String logradouroCliente) {
		this.logradouroCliente = logradouroCliente;
	}

	public int getNumeroCliente() {
		return numeroCliente;
	}

	public void setNumeroCliente(int numeroCliente) {
		this.numeroCliente = numeroCliente;
	}

	public String getComplementoCliente() {
		return complementoCliente;
	}

	public void setComplementoCliente(String complementoCliente) {
		this.complementoCliente = complementoCliente;
	}

	public String getBairroCliente() {
		return bairroCliente;
	}

	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}

	public String getCidadeCliente() {
		return cidadeCliente;
	}

	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}

	public String getUfCliente() {
		return ufCliente;
	}

	public void setUfCliente(String ufCliente) {
		this.ufCliente = ufCliente;
	}

	public String getCepCliente() {
		return cepCliente;
	}

	public void setCepCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getCelular1Cliente() {
		return celular1Cliente;
	}

	public void setCelular1Cliente(String celular1Cliente) {
		this.celular1Cliente = celular1Cliente;
	}

	public String getCelular2Cliente() {
		return celular2Cliente;
	}

	public void setCelular2Cliente(String celular2Cliente) {
		this.celular2Cliente = celular2Cliente;
	}

	public String getEmail1Cliente() {
		return email1Cliente;
	}

	public void setEmail1Cliente(String email1Cliente) {
		this.email1Cliente = email1Cliente;
	}

	public String getEmail2Cliente() {
		return email2Cliente;
	}

	public void setEmail2Cliente(String email2Cliente) {
		this.email2Cliente = email2Cliente;
	}
	
	public boolean isDate(String dataNascimentoCliente) throws ParseException {
		try{
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dateFormat.setLenient(false);
			dateFormat.parse(dataNascimentoCliente).toString();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
}