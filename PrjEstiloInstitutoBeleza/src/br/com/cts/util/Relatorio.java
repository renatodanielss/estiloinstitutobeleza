package br.com.cts.util;

import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {
	
	public static void chamarRelatorio(String arquivoRelatorio){
		try {
			JasperPrint relat = gerar(arquivoRelatorio);
			JasperViewer.viewReport(relat, false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JasperPrint gerar(String arquivoRelatorio){
		JasperPrint rel = null;
		try {    
			Connection con = ConnectionFactory.getConnection();
			HashMap map = new HashMap();
			String arquivoJasper = arquivoRelatorio;
			rel = JasperFillManager.fillReport(arquivoJasper, map, con);
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		return rel;
	}
}