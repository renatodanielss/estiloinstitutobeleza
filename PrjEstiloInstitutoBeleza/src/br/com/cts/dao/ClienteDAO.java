package br.com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cts.model.Cliente;
import br.com.cts.util.ConnectionFactory;

public class ClienteDAO {
	private Connection conn;
	
	public ClienteDAO(){
		open();
	}
	
	public void salvar(Cliente cliente) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		if (cliente == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "INSERT INTO tbl_cliente values (default,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			if (this.conn.isClosed())
				open();
			conn = this.conn;
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SQL);
			ps.setString(1, cliente.getNomeCliente());
			ps.setInt(2, cliente.getSexoCliente());
			ps.setString(3, cliente.getDataNascimentoCliente());
			ps.setString(4, cliente.getLogradouroCliente());
			ps.setInt(5, cliente.getNumeroCliente());
			ps.setString(6, cliente.getComplementoCliente());
			ps.setString(7, cliente.getBairroCliente());
			ps.setString(8, cliente.getCidadeCliente());
			ps.setInt(9, cliente.getUfCliente());
			ps.setString(10, cliente.getCepCliente());
			ps.setString(11, cliente.getTelefoneCliente());
			ps.setString(12, cliente.getCelular1Cliente());
			ps.setString(13, cliente.getCelular2Cliente());
			ps.setString(14, cliente.getEmail1Cliente());
			ps.setString(15, cliente.getEmail2Cliente());
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException sqle){
			conn.rollback();
			throw new Exception("Erro ao inserir dados "+sqle.getMessage());
		}finally{
			if (!conn.isClosed())
				conn.close();
		}
	}
	
	public void Alterar(Cliente cliente) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		if (cliente == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "UPDATE tbl_cliente SET nome = ?, sexo = ?, dataNascimento = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, uf = ?, cep = ?, telefone = ?, celular1 = ?, celular2 = ?, email1 = ?, email2 = ?"+" WHERE id = ?";
			if (this.conn.isClosed())
				open();
			conn = this.conn;
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SQL);
			ps.setString(1, cliente.getNomeCliente());
			ps.setInt(2, cliente.getSexoCliente());
			ps.setString(3, cliente.getDataNascimentoCliente());
			ps.setString(4, cliente.getLogradouroCliente());
			ps.setInt(5, cliente.getNumeroCliente());
			ps.setString(6, cliente.getComplementoCliente());
			ps.setString(7, cliente.getBairroCliente());
			ps.setString(8, cliente.getCidadeCliente());
			ps.setInt(9, cliente.getUfCliente());
			ps.setString(10, cliente.getCepCliente());
			ps.setString(11, cliente.getTelefoneCliente());
			ps.setString(12, cliente.getCelular1Cliente());
			ps.setString(13, cliente.getCelular2Cliente());
			ps.setString(14, cliente.getEmail1Cliente());
			ps.setString(15, cliente.getEmail2Cliente());
			ps.setInt(16, cliente.getIdCliente());
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException sqle){
			conn.rollback();
			throw new Exception("Erro ao atualizar dados "+sqle.getMessage());
		}finally{
			if (!conn.isClosed())
				conn.close();
		}
	}
	
	public void Excluir(Cliente cliente) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		if (cliente == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "DELETE FROM tbl_cliente WHERE id = ?";
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, cliente.getIdCliente());
			ps.executeUpdate();
			conn.commit();
		}catch(SQLException sqle){
			conn.rollback();
			throw new Exception("Erro ao excluir dados "+sqle.getMessage());
		}finally{
			if (!conn.isClosed())
				conn.close();
		}
	}
	
	public Cliente procuraClientePorId(int id) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		ResultSet rs = null;
		try{
			String SQL = "SELECT * FROM tbl_cliente WHERE id = ?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			Cliente cliente = null;
			if (rs.next()){
				cliente = new Cliente();
				cliente.setIdCliente(rs.getInt(1));
				cliente.setNomeCliente(rs.getString(2));
				cliente.setSexoCliente(rs.getInt(3));
				cliente.setDataNascimentoCliente(rs.getString(4));
				cliente.setLogradouroCliente(rs.getString(5));
				cliente.setNumeroCliente(rs.getInt(6));
				cliente.setComplementoCliente(rs.getString(7));
				cliente.setBairroCliente(rs.getString(8));
				cliente.setCidadeCliente(rs.getString(9));
				cliente.setUfCliente(rs.getInt(10));
				cliente.setCepCliente(rs.getString(11));
				cliente.setTelefoneCliente(rs.getString(12));
				cliente.setCelular1Cliente(rs.getString(13));
				cliente.setCelular2Cliente(rs.getString(14));
				cliente.setEmail1Cliente(rs.getString(15));
				cliente.setEmail2Cliente(rs.getString(16));
			}
			
			return cliente;
		}catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados "+sqle.getMessage());
		}finally{
			if (!conn.isClosed())
				conn.close();
		}
	}
	
	public List<Cliente> procuraCliente(int qtdPorPagina, int numeroDaPagina) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		ResultSet rs = null;
		try{
			String SQL = "SELECT * FROM tbl_cliente order by id limit " + qtdPorPagina + " offset " + (numeroDaPagina-1)*qtdPorPagina;
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			
			List<Cliente> clientes = new ArrayList<Cliente>();
			while (rs.next()){
				Cliente cliente1 = new Cliente();
				cliente1.setIdCliente(rs.getInt(1));
				cliente1.setNomeCliente(rs.getString(2));
				cliente1.setSexoCliente(rs.getInt(3));
				cliente1.setDataNascimentoCliente(rs.getString(4));
				cliente1.setLogradouroCliente(rs.getString(5));
				cliente1.setNumeroCliente(rs.getInt(6));
				cliente1.setComplementoCliente(rs.getString(7));
				cliente1.setBairroCliente(rs.getString(8));
				cliente1.setCidadeCliente(rs.getString(9));
				cliente1.setUfCliente(rs.getInt(10));
				cliente1.setCepCliente(rs.getString(11));
				cliente1.setTelefoneCliente(rs.getString(12));
				cliente1.setCelular1Cliente(rs.getString(13));
				cliente1.setCelular2Cliente(rs.getString(14));
				cliente1.setEmail1Cliente(rs.getString(15));
				cliente1.setEmail2Cliente(rs.getString(16));
				clientes.add(cliente1);
				cliente1 = null;
			}
			return clientes;
		}catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados "+sqle.getMessage());
		}finally{
			if (!conn.isClosed())
				conn.close();
		}
	}
	
	public List<Cliente> procuraClientePorNome(String nome, int qtdPorPagina, int numeroDaPagina) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		ResultSet rs = null;
		try{
			String SQL = "SELECT * FROM tbl_cliente WHERE lower(nome) LIKE lower(?) order by id limit ? offset ?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, "%" + nome + "%");
			ps.setInt(2, qtdPorPagina);
			ps.setInt(3, (numeroDaPagina-1)*qtdPorPagina);
			rs = ps.executeQuery();
			
			List<Cliente> clientes = new ArrayList<Cliente>();
			while (rs.next()){
				Cliente cliente1 = new Cliente();
				cliente1.setIdCliente(rs.getInt(1));
				cliente1.setNomeCliente(rs.getString(2));
				cliente1.setSexoCliente(rs.getInt(3));
				cliente1.setDataNascimentoCliente(rs.getString(4));
				cliente1.setLogradouroCliente(rs.getString(5));
				cliente1.setNumeroCliente(rs.getInt(6));
				cliente1.setComplementoCliente(rs.getString(7));
				cliente1.setBairroCliente(rs.getString(8));
				cliente1.setCidadeCliente(rs.getString(9));
				cliente1.setUfCliente(rs.getInt(10));
				cliente1.setCepCliente(rs.getString(11));
				cliente1.setTelefoneCliente(rs.getString(12));
				cliente1.setCelular1Cliente(rs.getString(13));
				cliente1.setCelular2Cliente(rs.getString(14));
				cliente1.setEmail1Cliente(rs.getString(15));
				cliente1.setEmail2Cliente(rs.getString(16));
				clientes.add(cliente1);
				cliente1 = null;
			}
			return clientes;
		}catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados "+sqle.getMessage());
		}finally{
			if (!conn.isClosed())
				conn.close();
		}
	}
	
	private void open(){
		try{
			this.conn = ConnectionFactory.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int recordCount() throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		ResultSet rs = null;
		try{
			String SQL = "select count(*) from tbl_cliente";
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			
			int rowCount = 0;
			if (rs.next())
				rowCount = rs.getInt(1);
			
			return rowCount;
		}catch(SQLException sqle){
			throw new Exception("Erro ao efetuar consulta "+sqle.getMessage());
		}finally{
			if (!conn.isClosed())
				conn.close();
		}
	}
	
	public int recordCount(String nome) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		ResultSet rs = null;
		try{
			String SQL = "SELECT count(*) FROM tbl_cliente WHERE lower(nome) LIKE lower(?)";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, "%" + nome + "%");
			rs = ps.executeQuery();
			
			int rowCount = 0;
			if (rs.next())
				rowCount = rs.getInt(1);
			
			return rowCount;
		}catch(SQLException sqle){
			throw new Exception("Erro ao efetuar consulta "+sqle.getMessage());
		}finally{
			if (!conn.isClosed())
				conn.close();
		}
	}
}