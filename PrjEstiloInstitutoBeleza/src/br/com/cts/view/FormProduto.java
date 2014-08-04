package br.com.cts.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormProduto {

	private JFrame frmProdutos;
	private JTextField txtNomeProduto;
	private JLabel lblNome;
	private JLabel lblCodigoBarras;
	private JTextField txtCodigoBarras;
	private JTextField txtTipoUnidade;
	private JLabel lblTipoUnidade;
	private JLabel lblValor;
	private JTextField txtValor;
	private JTextField txtValorVenda;
	private JLabel lblValorVenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProduto window = new FormProduto();
					window.frmProdutos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProdutos = new JFrame();
		frmProdutos.setTitle("Produtos");
		frmProdutos.setBounds(100, 100, 634, 273);
		frmProdutos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProdutos.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Descri\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel.setBounds(10, 38, 530, 148);
		frmProdutos.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setBounds(10, 38, 285, 20);
		panel.add(txtNomeProduto);
		txtNomeProduto.setColumns(10);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(11, 24, 46, 14);
		panel.add(lblNome);
		
		lblCodigoBarras = new JLabel("C\u00F3digo de Barras:");
		lblCodigoBarras.setBounds(11, 60, 119, 14);
		panel.add(lblCodigoBarras);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setBounds(10, 75, 499, 20);
		panel.add(txtCodigoBarras);
		txtCodigoBarras.setColumns(10);
		
		txtTipoUnidade = new JTextField();
		txtTipoUnidade.setBounds(305, 38, 204, 20);
		panel.add(txtTipoUnidade);
		txtTipoUnidade.setColumns(10);
		
		lblTipoUnidade = new JLabel("Tipo de Unidade: ");
		lblTipoUnidade.setBounds(305, 24, 101, 14);
		panel.add(lblTipoUnidade);
		
		lblValor = new JLabel("Valor:");
		lblValor.setBounds(11, 99, 46, 14);
		panel.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(10, 113, 252, 20);
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		txtValorVenda = new JTextField();
		txtValorVenda.setBounds(272, 113, 237, 20);
		panel.add(txtValorVenda);
		txtValorVenda.setColumns(10);
		
		lblValorVenda = new JLabel("Valor de Venda:");
		lblValorVenda.setBounds(273, 99, 95, 14);
		panel.add(lblValorVenda);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(22, 195, 89, 23);
		frmProdutos.getContentPane().add(btnNewButton);
	}
}
