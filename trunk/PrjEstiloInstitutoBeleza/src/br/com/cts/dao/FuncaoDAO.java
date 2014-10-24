package br.com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cts.model.Funcao;
import br.com.cts.util.ConnectionFactory;

public class FuncaoDAO {
	private Connection conn;
	
	public FuncaoDAO(){
		open();
	}
	
	public void salvar(Funcao funcao) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		if (funcao == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "INSERT INTO tbl_funcao values (default,?,?)";
			if (this.conn.isClosed())
				open();
			conn = this.conn;
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SQL);
			ps.setString(1, funcao.getNomeFuncao());
			ps.setFloat(2, funcao.getComissaoFuncao());
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
	
	public void Alterar(Funcao funcao) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		if (funcao == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "UPDATE tbl_funcao SET nomeFuncao = ?, comissao = ? WHERE id = ?";
			if (this.conn.isClosed())
				open();
			conn = this.conn;
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SQL);
			ps.setString(1, funcao.getNomeFuncao());
			ps.setFloat(2, funcao.getComissaoFuncao());
			ps.setInt(3, funcao.getIdFuncao());
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
	
	public void Excluir(Funcao funcao) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		if (funcao == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "DELETE FROM tbl_funcao WHERE id = ?";
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, funcao.getIdFuncao());
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
	
	public Funcao procuraFuncaoPorId(int id) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		ResultSet rs = null;
		try{
			String SQL = "SELECT * FROM tbl_funcao WHERE id = ?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			Funcao funcao = null;
			if (rs.next()){
				funcao = new Funcao();
				funcao.setIdFuncao(rs.getInt(1));
				funcao.setNomeFuncao(rs.getString(2));
				funcao.setComissaoFuncao(rs.getFloat(3));
			}
			
			return funcao;
		}catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados "+sqle.getMessage());
		}finally{
			if (!conn.isClosed())
				conn.close();
		}
	}
	
	public List<Funcao> procuraFuncao(int qtdPorPagina, int numeroDaPagina) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		ResultSet rs = null;
		try{
			String SQL = "SELECT * FROM tbl_funcao order by id limit " + qtdPorPagina + " offset " + (numeroDaPagina-1)*qtdPorPagina;
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			
			List<Funcao> funcoes = new ArrayList<Funcao>();
			while (rs.next()){
				Funcao funcao1 = new Funcao();
				funcao1.setIdFuncao(rs.getInt(1));
				funcao1.setNomeFuncao(rs.getString(2));
				funcao1.setComissaoFuncao(rs.getFloat(3));
				funcoes.add(funcao1);
				funcao1 = null;
			}
			return funcoes;
		}catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados "+sqle.getMessage());
		}finally{
			if (!conn.isClosed())
				conn.close();
		}
	}
	
	public List<Funcao> procuraFuncaoPorNome(String nome, int qtdPorPagina, int numeroDaPagina) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		ResultSet rs = null;
		try{
			String SQL = "SELECT * FROM tbl_funcao WHERE lower(nomeFuncao) LIKE lower(?) order by id limit ? offset ?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, "%" + nome + "%");
			ps.setInt(2, qtdPorPagina);
			ps.setInt(3, (numeroDaPagina-1)*qtdPorPagina);
			rs = ps.executeQuery();
			
			List<Funcao> funcoes = new ArrayList<Funcao>();
			while (rs.next()){
				Funcao funcao1 = new Funcao();
				funcao1.setIdFuncao(rs.getInt(1));
				funcao1.setNomeFuncao(rs.getString(2));
				funcao1.setComissaoFuncao(rs.getFloat(3));
				funcoes.add(funcao1);
				funcao1 = null;
			}
			return funcoes;
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
			String SQL = "select count(*) from tbl_funcao";
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
			String SQL = "SELECT count(*) FROM tbl_funcao WHERE lower(nomeFuncao) LIKE lower(?)";
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