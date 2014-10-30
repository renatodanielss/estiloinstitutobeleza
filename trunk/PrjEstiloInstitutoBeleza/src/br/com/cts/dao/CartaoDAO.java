package br.com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.cts.model.Cartao;
import br.com.cts.util.ConnectionFactory;

public class CartaoDAO {
	private Connection conn;
	
	public CartaoDAO(){
		open();
	}
	
	public void salvar(Cartao cartao) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		if (cartao == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "INSERT INTO tbl_cartao values (default,?,?,?)";
			if (this.conn.isClosed())
				open();
			conn = this.conn;
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SQL);
			ps.setString(1, cartao.getNomeCartao());
			ps.setString(2, cartao.getBandeiraCartao());
			ps.setFloat(3, cartao.getPocentagemDescontoCartao());
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
	
	public void Alterar(Cartao cartao) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		if (cartao == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "UPDATE tbl_cartao SET nome = ?, bandeira = ?, porcentagemDesconto = ? WHERE id = ?";
			if (this.conn.isClosed())
				open();
			conn = this.conn;
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SQL);
			ps.setString(1, cartao.getNomeCartao());
			ps.setString(2, cartao.getBandeiraCartao());
			ps.setFloat(3, cartao.getPocentagemDescontoCartao());
			ps.setInt(4, cartao.getIdCartao());
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
	
	public void Excluir(Cartao cartao) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		if (cartao == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "DELETE FROM tbl_cartao WHERE id = ?";
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, cartao.getIdCartao());
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
	
	public Cartao procuraCartaoPorId(int id) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		ResultSet rs = null;
		try{
			String SQL = "SELECT * FROM tbl_cartao WHERE id = ?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			Cartao cartao = null;
			if (rs.next()){
				cartao = new Cartao();
				cartao.setIdCartao(rs.getInt(1));
				cartao.setNomeCartao(rs.getString(2));
				cartao.setBandeiraCartao(rs.getString(3));
				cartao.setPocentagemDescontoCartao(rs.getFloat(4));
			}
			
			return cartao;
		}catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados "+sqle.getMessage());
		}finally{
			if (!conn.isClosed())
				conn.close();
		}
	}
	
	public List<Cartao> procuraCartao(int qtdPorPagina, int numeroDaPagina) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		ResultSet rs = null;
		try{
			String SQL = "SELECT * FROM tbl_cartao order by id limit " + qtdPorPagina + " offset " + (numeroDaPagina-1)*qtdPorPagina;
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			
			List<Cartao> cartoes = new ArrayList<Cartao>();
			while (rs.next()){
				Cartao cartao1 = new Cartao();
				cartao1.setIdCartao(rs.getInt(1));
				cartao1.setNomeCartao(rs.getString(2));
				cartao1.setBandeiraCartao(rs.getString(3));
				cartao1.setPocentagemDescontoCartao(rs.getFloat(4));
				cartoes.add(cartao1);
				cartao1 = null;
			}
			return cartoes;
		}catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados "+sqle.getMessage());
		}finally{
			if (!conn.isClosed())
				conn.close();
		}
	}
	
	public List<Cartao> procuraCartaoPorNome(String nome, int qtdPorPagina, int numeroDaPagina) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		ResultSet rs = null;
		try{
			String SQL = "SELECT * FROM tbl_cartao WHERE lower(nome) LIKE lower(?) order by id limit ? offset ?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, "%" + nome + "%");
			ps.setInt(2, qtdPorPagina);
			ps.setInt(3, (numeroDaPagina-1)*qtdPorPagina);
			rs = ps.executeQuery();
			
			List<Cartao> cartoes = new ArrayList<Cartao>();
			while (rs.next()){
				Cartao cartao1 = new Cartao();
				cartao1.setIdCartao(rs.getInt(1));
				cartao1.setNomeCartao(rs.getString(2));
				cartao1.setBandeiraCartao(rs.getString(3));
				cartao1.setPocentagemDescontoCartao(rs.getFloat(4));
				cartoes.add(cartao1);
				cartao1 = null;
			}
			return cartoes;
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
			String SQL = "select count(*) from tbl_cartao";
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
			String SQL = "SELECT count(*) FROM tbl_cartao WHERE lower(nome) LIKE lower(?)";
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