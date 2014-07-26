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
	
	public ClienteDAO() throws Exception{
		try{
			this.conn = ConnectionFactory.getConnection();
		}catch(Exception e){
			throw new Exception("Erro: \n"+e.getMessage());
		}
	}
	
	public void salvar(Cliente cliente) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		if (cliente == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "INSERT INTO tbl_cliente values (default,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, cliente.getNomeCliente());
			ps.setString(2, cliente.getDataNascimentoCliente());
			ps.setString(3, cliente.getLogradouroCliente());
			ps.setInt(4, cliente.getNumeroCliente());
			ps.setString(5, cliente.getComplementoCliente());
			ps.setString(6, cliente.getBairroCliente());
			ps.setString(7, cliente.getCidadeCliente());
			ps.setString(8, cliente.getUfCliente());
			ps.setString(9, cliente.getCepCliente());
			ps.setString(10, cliente.getTelefoneCliente());
			ps.setString(11, cliente.getCelular1Cliente());
			ps.setString(12, cliente.getCelular2Cliente());
			ps.setString(13, cliente.getEmail1Cliente());
			ps.setString(14, cliente.getEmail2Cliente());
			ps.executeUpdate();
		}catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados "+sqle.getMessage());
		}finally{
			conn.close();
		}
	}
	
	public void Alterar(Cliente cliente) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		if (cliente == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "UPDATE tbl_cliente SET nome = ?, dataNascimento = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, uf = ?, cep = ?, telefone = ?, celular1 = ?, celular2 = ?, email1 = ?, email2 = ?"+" WHERE id = ?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, cliente.getNomeCliente());
			ps.setString(2, cliente.getDataNascimentoCliente());
			ps.setString(3, cliente.getLogradouroCliente());
			ps.setInt(4, cliente.getNumeroCliente());
			ps.setString(5, cliente.getComplementoCliente());
			ps.setString(6, cliente.getBairroCliente());
			ps.setString(7, cliente.getCidadeCliente());
			ps.setString(8, cliente.getUfCliente());
			ps.setString(9, cliente.getCepCliente());
			ps.setString(10, cliente.getTelefoneCliente());
			ps.setString(11, cliente.getCelular1Cliente());
			ps.setString(12, cliente.getCelular2Cliente());
			ps.setString(13, cliente.getEmail1Cliente());
			ps.setString(14, cliente.getEmail2Cliente());
			ps.executeUpdate();
		}catch(SQLException sqle){
			throw new Exception("Erro ao atualizar dados "+sqle.getMessage());
		}finally{
			conn.close();
		}
	}
	
	public void Excluir(Cliente cliente) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		if (cliente == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "DELETE FROM tbl_cliente WHERE id = ?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, cliente.getIdCliente());
			ps.executeUpdate();
		}catch(SQLException sqle){
			throw new Exception("Erro ao excluir dados "+sqle.getMessage());
		}finally{
			conn.close();
		}
	}
	
	public Cliente procuraClientePorId(int id) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			Connection conn = this.conn;
			String SQL = "SELECT * FROM tbl_cliente WHERE id = ?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			Cliente cliente = null;
			if (rs.next()){
				cliente = new Cliente();
				cliente.setIdCliente(rs.getInt(1));
				cliente.setNomeCliente(rs.getString(2));
				cliente.setDataNascimentoCliente(rs.getString(3));
				cliente.setLogradouroCliente(rs.getString(4));
				cliente.setNumeroCliente(rs.getInt(5));
				cliente.setComplementoCliente(rs.getString(6));
				cliente.setBairroCliente(rs.getString(7));
				cliente.setCidadeCliente(rs.getString(8));
				cliente.setUfCliente(rs.getString(9));
				cliente.setCepCliente(rs.getString(10));
				cliente.setTelefoneCliente(rs.getString(11));
				cliente.setCelular1Cliente(rs.getString(12));
				cliente.setCelular2Cliente(rs.getString(13));
				cliente.setEmail1Cliente(rs.getString(14));
				cliente.setEmail2Cliente(rs.getString(15));
			}
			return cliente;
		}catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados "+sqle.getMessage());
		}finally{
			conn.close();
		}
	}
	
	public List<Cliente> procuraClientePorNome(String nome) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			Connection conn = this.conn;
			String SQL = "SELECT * FROM tbl_cliente WHERE NOME LIKE %?%";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, nome);
			rs = ps.executeQuery();
			
			ArrayList<Cliente> clientes = new ArrayList<Cliente>();
			while (rs.next()){
				Cliente cliente1 = new Cliente();
				cliente1.setIdCliente(rs.getInt(1));
				cliente1.setNomeCliente(rs.getString(2));
				cliente1.setDataNascimentoCliente(rs.getString(3));
				cliente1.setLogradouroCliente(rs.getString(4));
				cliente1.setNumeroCliente(rs.getInt(5));
				cliente1.setComplementoCliente(rs.getString(6));
				cliente1.setBairroCliente(rs.getString(7));
				cliente1.setCidadeCliente(rs.getString(8));
				cliente1.setUfCliente(rs.getString(9));
				cliente1.setCepCliente(rs.getString(10));
				cliente1.setTelefoneCliente(rs.getString(11));
				cliente1.setCelular1Cliente(rs.getString(12));
				cliente1.setCelular2Cliente(rs.getString(13));
				cliente1.setEmail1Cliente(rs.getString(14));
				cliente1.setEmail2Cliente(rs.getString(15));
				clientes.add(cliente1);
				cliente1 = null;
			}
			return clientes;
		}catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados "+sqle.getMessage());
		}finally{
			conn.close();
		}
	}
}