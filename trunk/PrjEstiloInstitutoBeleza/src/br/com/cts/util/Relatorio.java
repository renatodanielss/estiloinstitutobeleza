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
	
	/*@SuppressWarnings("rawtypes")
	public static void chamarRelatorio(String arquivoRelatorio, List listaDeDados){
		try {
			JasperPrint relat = gerar(arquivoRelatorio, listaDeDados);
			JasperViewer.viewReport(relat, false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JasperPrint gerar(String arquivoRelatorio, List listaDeDados){
		JasperPrint rel = null;
		try {
			JRBeanCollectionDataSource listaDeSubDados = new JRBeanCollectionDataSource(listaDeDados);
			Connection con = ConnectionFactory.getConnection();
			HashMap map = new HashMap();
			map.put("nomeParam", listaDeSubDados);
			String arquivoJasper = arquivoRelatorio;
			rel = JasperFillManager.fillReport(arquivoJasper, map, con);
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		return rel;
	}*/
	
	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public static void chamarRelatorio(String nome) throws Exception{
		JasperReport relatorio = null;  
		JasperDesign desenho;  
		  
		try {  
		    desenho = JRXmlLoader.load("reports/clientereport.jrxml");  
		    relatorio = JasperCompileManager.compileReport( desenho );  
		  
		} catch (JRException e2) {  
		    e2.printStackTrace();  
		}  
		  
		  
		ResultSet rs = null;  
		try {  
		        Connection con = ConnectionFactory.getConnection();
		        Statement stm = con.createStatement();  
		        String query = "select * from tbl_cliente where lower(nome) like lower('%" + nome + "%')"; //depois passo o numero certo  
		        rs = stm.executeQuery( query );  
		} catch (SQLException e1) {  
		    e1.printStackTrace();  
		}  
		  
		JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );  
		  
		Map parametros = new HashMap();  
		//parametros.put("nota", new Double(10));  
		JasperPrint impressao = null;  
		  
		try {  
		    impressao = JasperFillManager.fillReport(relatorio , parametros, jrRS);  
		} catch (JRException e1) {  
		    e1.printStackTrace();  
		}  
		  
		JasperViewer viewer = new JasperViewer( impressao , true );  
		viewer.viewReport(impressao);
	}
}