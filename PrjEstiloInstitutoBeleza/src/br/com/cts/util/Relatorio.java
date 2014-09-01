package br.com.cts.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void chamarRelatorio(String valor, String campo, String tabela, String jrxml) throws Exception{
		JasperReport relatorio = null;  
		JasperDesign desenho;  
		  
		try {  
		    desenho = JRXmlLoader.load(jrxml);  
		    relatorio = JasperCompileManager.compileReport( desenho );  
		  
		} catch (JRException e2) {  
		    e2.printStackTrace();  
		}  
		  
		  
		ResultSet rs = null;  
		try {  
	        Connection con = ConnectionFactory.getConnection();
	        Statement stm = con.createStatement();  
	        String query = "select * from " + tabela + " where lower(" + campo + ") like lower('%" + valor + "%') order by id";
	        rs = stm.executeQuery( query );
		} catch (SQLException e1) {  
		    e1.printStackTrace();  
		}  
		  
		JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );  
		  
		Map parametros = new HashMap();  
		JasperPrint impressao = null;  
		  
		try {  
		    impressao = JasperFillManager.fillReport(relatorio , parametros, jrRS);  
		} catch (JRException e1) {  
		    e1.printStackTrace();  
		}  
		  
		JasperViewer viewer = new JasperViewer( impressao , false );
		viewer.setVisible(true);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void chamarRelatorio(int valor, String campo, String tabela, String jrxml) throws Exception{
		JasperReport relatorio = null;  
		JasperDesign desenho;  
		  
		try {  
		    desenho = JRXmlLoader.load(jrxml);  
		    relatorio = JasperCompileManager.compileReport( desenho );  
		  
		} catch (JRException e2) {  
		    e2.printStackTrace();  
		}  
		  
		  
		ResultSet rs = null;  
		try {  
	        Connection con = ConnectionFactory.getConnection();
	        Statement stm = con.createStatement();  
	        String query = "select * from " + tabela + " where " + campo + " = " + valor + " order by id";
	        rs = stm.executeQuery( query );  
		} catch (SQLException e1) {  
		    e1.printStackTrace();  
		}  
		  
		JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );  
		  
		Map parametros = new HashMap();  
		JasperPrint impressao = null;  
		  
		try {  
		    impressao = JasperFillManager.fillReport(relatorio , parametros, jrRS);  
		} catch (JRException e1) {  
		    e1.printStackTrace();  
		}  
		  
		JasperViewer viewer = new JasperViewer( impressao , false );
		viewer.setVisible(true);
	}
}