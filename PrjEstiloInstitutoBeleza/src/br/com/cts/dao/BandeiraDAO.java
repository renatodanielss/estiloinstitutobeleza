package br.com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.cts.model.Bandeira;
import br.com.cts.util.ConnectionFactory;

public class BandeiraDAO {
	private Connection conn;
	
	public BandeiraDAO(){
		open();
	}
	
	public void salvar(Bandeira bandeira) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		if (bandeira == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "INSERT INTO tbl_bandeira values (?)";
			if (this.conn.isClosed())
				open();
			conn = this.conn;
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SQL);
			ps.setString(1, bandeira.getNomeBandeira());
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
	
	public void Alterar(Bandeira bandeira, String novoNome) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		if (bandeira == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "UPDATE tbl_bandeira SET nome = ? WHERE nome = ?";
			if (this.conn.isClosed())
				open();
			conn = this.conn;
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SQL);
			ps.setString(1, novoNome);
			ps.setString(2, bandeira.getNomeBandeira());
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
	
	public void Excluir(Bandeira bandeira) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		if (bandeira == null)
			throw new Exception("O valor passado não pode ser nulo!");
		try{
			String SQL = "DELETE FROM tbl_bandeira WHERE nome = ?";
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SQL);
			ps.setString(1, bandeira.getNomeBandeira());
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
	
	public Bandeira procuraBandeiraPorId(String id) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		ResultSet rs = null;
		try{
			String SQL = "SELECT * FROM tbl_bandeira WHERE nome = ?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			Bandeira bandeira = null;
			if (rs.next()){
				bandeira = new Bandeira();
				bandeira.setNomeBandeira(rs.getString(1));
			}
			
			return bandeira;
		}catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados "+sqle.getMessage());
		}finally{
			if (!conn.isClosed())
				conn.close();
		}
	}
	
	public List<Bandeira> procuraBandeira(int qtdPorPagina, int numeroDaPagina) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		ResultSet rs = null;
		try{
			String SQL = "SELECT * FROM tbl_bandeira order by nome limit " + qtdPorPagina + " offset " + (numeroDaPagina-1)*qtdPorPagina;
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			
			List<Bandeira> bandeiras = new ArrayList<Bandeira>();
			while (rs.next()){
				Bandeira bandeira1 = new Bandeira();
				bandeira1.setNomeBandeira(rs.getString(1));
				bandeiras.add(bandeira1);
				bandeira1 = null;
			}
			return bandeiras;
		}catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados "+sqle.getMessage());
		}finally{
			if (!conn.isClosed())
				conn.close();
		}
	}
	
	public List<Bandeira> procuraBandeiraPorNome(String nome, int qtdPorPagina, int numeroDaPagina) throws Exception{
		PreparedStatement ps = null;
		if (this.conn.isClosed())
			open();
		Connection conn = this.conn;
		ResultSet rs = null;
		try{
			String SQL = "SELECT * FROM tbl_bandeira WHERE lower(nome) LIKE lower(?) order by nome limit ? offset ?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, "%" + nome + "%");
			ps.setInt(2, qtdPorPagina);
			ps.setInt(3, (numeroDaPagina-1)*qtdPorPagina);
			rs = ps.executeQuery();
			
			List<Bandeira> bandeiras = new ArrayList<Bandeira>();
			while (rs.next()){
				Bandeira bandeira1 = new Bandeira();
				bandeira1.setNomeBandeira(rs.getString(1));
				bandeiras.add(bandeira1);
				bandeira1 = null;
			}
			return bandeiras;
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
			String SQL = "select count(*) from tbl_bandeira";
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
			String SQL = "SELECT count(*) FROM tbl_bandeira WHERE lower(nome) LIKE lower(?)";
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