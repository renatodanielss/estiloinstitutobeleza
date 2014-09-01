package br.com.cts.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FormCartao extends JFrame{

	private JFrame frmCartoes;
	private JTextField txtNomeCartao;
	private JTextField txtBandeira;
	private JTextField txtDesconto;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenuItem mntmNovo;
	private JMenuItem mntmSalvar;
	private JMenu mnIr;
	private JMenuItem mntmFuncoes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCartao window = new FormCartao();
					window.frmCartoes.setVisible(true);
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
		frmCartoes = new JFrame();
		frmCartoes.setTitle("Cart\u00F5es");
		frmCartoes.setBounds(100, 100, 631, 255);
		frmCartoes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCartoes.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Descri\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel.setBounds(11, 46, 530, 121);
		frmCartoes.getContentPane().add(panel);
		panel.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 2000, 21);
		frmCartoes.getContentPane().add(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		mntmNovo = new JMenuItem("Novo");
		mntmNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novo();
			}
		});
		mnArquivo.add(mntmNovo);
		
		mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarAlterar();
			}
		});
		mnArquivo.add(mntmSalvar);
		
		JMenuItem mntmGerarRelatorio = new JMenuItem("Gerar Relat\u00F3rio");
		mnArquivo.add(mntmGerarRelatorio);
		
		mnIr = new JMenu("Ir");
		menuBar.add(mnIr);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarFormCliente();
			}
		});
		mnIr.add(mntmClientes);
		
		JMenuItem mntmPrestadoresDeServicos = new JMenuItem("Prestadores de Servi\u00E7os");
		mntmPrestadoresDeServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarFormPrestadorDeServico();
			}
		});
		
		mntmFuncoes = new JMenuItem("Fun\u00E7\u00F5es");
		mntmFuncoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarFormFuncao();
			}
		});
		mnIr.add(mntmFuncoes);
		mnIr.add(mntmPrestadoresDeServicos);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mntmProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarFormProduto();
			}
		});
		mnIr.add(mntmProdutos);
		
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

	public JFrame getFrmCartoes() {
		return frmCartoes;
	}
	
	private void novo(){
		
	}
	
	private void salvarAlterar(){
		
	}
	
	private void chamarFormCliente(){
		try{
			FormCliente window = new FormCliente();
			window.getFrmClientes().setVisible(true);
			frmCartoes.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void chamarFormFuncao(){
		try{
			FormFuncao window = new FormFuncao();
			window.getFrmFuncao().setVisible(true);
			frmCartoes.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void chamarFormPrestadorDeServico(){
		try{
			FormPrestadorDeServico window = new FormPrestadorDeServico();
			window.getFrmPrestadorDeServico().setVisible(true);
			frmCartoes.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void chamarFormProduto(){
		try{
			FormProduto window = new FormProduto();
			window.getFrmProdutos().setVisible(true);
			frmCartoes.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}