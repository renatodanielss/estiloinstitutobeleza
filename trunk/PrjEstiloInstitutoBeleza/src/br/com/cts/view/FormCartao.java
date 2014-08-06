package br.com.cts.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormCartao {

	private JFrame frmCartes;
	private JTextField txtNomeCartao;
	private JTextField txtBandeira;
	private JTextField txtDesconto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCartao window = new FormCartao();
					window.frmCartes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormCartao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCartes = new JFrame();
		frmCartes.setTitle("Cart\u00F5es");
		frmCartes.setBounds(100, 100, 631, 255);
		frmCartes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCartes.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Descri\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel.setBounds(11, 46, 530, 121);
		frmCartes.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(15, 22, 46, 14);
		panel.add(lblNome);
		
		txtNomeCartao = new JTextField();
		txtNomeCartao.setBounds(14, 36, 495, 20);
		panel.add(txtNomeCartao);
		txtNomeCartao.setColumns(10);
		
		JLabel lblBandeira = new JLabel("Bandeira:");
		lblBandeira.setBounds(15, 61, 46, 14);
		panel.add(lblBandeira);
		
		txtBandeira = new JTextField();
		txtBandeira.setBounds(15, 77, 369, 20);
		panel.add(txtBandeira);
		txtBandeira.setColumns(10);
		
		txtDesconto = new JTextField();
		txtDesconto.setBounds(394, 77, 115, 20);
		panel.add(txtDesconto);
		txtDesconto.setColumns(10);
		
		JLabel lblDesconto = new JLabel("Desconto:");
		lblDesconto.setBounds(395, 61, 72, 14);
		panel.add(lblDesconto);
	}
}
