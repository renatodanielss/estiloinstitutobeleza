package br.com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cts.model.Produto;
import br.com.cts.util.ConnectionFactory;

public class ProdutoDAO {
	private Connection conn;
	
	public ProdutoDAO(){
		open();
	}
	
	public void salvar(Produto produto) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		if (produto == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "INSERT INTO tbl_produto values (default,?,?,?,?,?)";
			if (this.conn.isClosed())
				open();
			conn = this.conn;
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SQL);
			ps.setString(1, produto.getNomeProduto());
			ps.setFloat(2, produto.getValorProduto());
			ps.setFloat(3, produto.getValorPraVendaProduto());
			ps.setString(4, produto.getTipoUnidadeProduto());
			ps.setInt(5, produto.getQtdEstoqueProduto());
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
	
	public void Alterar(Produto produto) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		if (produto == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "UPDATE tbl_produto SET nome = ?, valorProduto = ?, valorPraVendaProduto = ?, tipoUnidade = ?, qtdEstoque = ? WHERE id = ?";
			if (this.conn.isClosed())
				open();
			conn = this.conn;
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SQL);
			ps.setString(1, produto.getNomeProduto());
			ps.setFloat(2, produto.getValorProduto());
			ps.setFloat(3, produto.getValorPraVendaProduto());
			ps.setString(4, produto.getTipoUnidadeProduto());
			ps.setInt(5, produto.getQtdEstoqueProduto());
			ps.setInt(6, produto.getIdProduto());
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
	
	public void Excluir(Produto produto) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		if (produto == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "DELETE FROM tbl_produto WHERE id = ?";
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, produto.getIdProduto());
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
	
	public Produto procuraProdutoPorId(int id) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		ResultSet rs = null;
		try{
			String SQL = "SELECT * FROM tbl_produto WHERE id = ?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			Produto produto = null;
			if (rs.next()){
				produto = new Produto();
				produto.setIdProduto(rs.getInt(1));
				produto.setNomeProduto(rs.getString(2));
				produto.setValorProduto(rs.getFloat(3));
				produto.setValorPraVendaProduto(rs.getFloat(4));
				produto.setTipoUnidadeProduto(rs.getString(5));
				produto.setQtdEstoqueProduto(rs.getInt(6));
			}
			
			return produto;
		}catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados "+sqle.getMessage());
		}finally{
			if (!conn.isClosed())
				conn.close();
		}
	}
	
	public List<Produto> procuraProdutos(int qtdPorPagina, int numeroDaPagina) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		ResultSet rs = null;
		try{
			String SQL = "SELECT * FROM tbl_produto order by id limit " + qtdPorPagina + " offset " + (numeroDaPagina-1)*qtdPorPagina;
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			
			List<Produto> produtos = new ArrayList<Produto>();
			while (rs.next()){
				Produto produto1 = new Produto();
				produto1.setIdProduto(rs.getInt(1));
				produto1.setNomeProduto(rs.getString(2));
				produto1.setValorProduto(rs.getFloat(3));
				produto1.setValorPraVendaProduto(rs.getFloat(4));
				produto1.setTipoUnidadeProduto(rs.getString(5));
				produto1.setQtdEstoqueProduto(rs.getInt(6));
				produtos.add(produto1);
				produto1 = null;
			}
			return produtos;
		}catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados "+sqle.getMessage());
		}finally{
			if (!conn.isClosed())
				conn.close();
		}
	}
	
	public List<Produto> procuraProdutoPorNome(String nome, int qtdPorPagina, int numeroDaPagina) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		ResultSet rs = null;
		try{
			String SQL = "SELECT * FROM tbl_produto WHERE lower(nome) LIKE lower(?) order by id limit ? offset ?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, "%" + nome + "%");
			ps.setInt(2, qtdPorPagina);
			ps.setInt(3, (numeroDaPagina-1)*qtdPorPagina);
			rs = ps.executeQuery();
			
			List<Produto> produtos = new ArrayList<Produto>();
			while (rs.next()){
				Produto produto1 = new Produto();
				produto1.setIdProduto(rs.getInt(1));
				produto1.setNomeProduto(rs.getString(2));
				produto1.setValorProduto(rs.getFloat(3));
				produto1.setValorPraVendaProduto(rs.getFloat(4));
				produto1.setTipoUnidadeProduto(rs.getString(5));
				produto1.setQtdEstoqueProduto(rs.getInt(6));
				produtos.add(produto1);
				produto1 = null;
			}
			return produtos;
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
			String SQL = "select count(*) from tbl_produto";
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
			String SQL = "SELECT count(*) FROM tbl_produto WHERE lower(nome) LIKE lower(?)";
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