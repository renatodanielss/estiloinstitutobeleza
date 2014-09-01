package br.com.cts.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class FormProduto extends JFrame{

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
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 2000, 21);
		frmProdutos.getContentPane().add(menuBar);
		
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
		
		JMenuItem mntmCartoes = new JMenuItem("Cart\u00F5es");
		mntmCartoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarFormCartao();
			}
		});
		mnIr.add(mntmCartoes);
		
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

	public JFrame getFrmProdutos() {
		return frmProdutos;
	}
	
	private void novo(){
		
	}
	
	private void salvarAlterar(){
		
	}
	
	private void chamarFormCartao(){
		try{
			FormCartao window = new FormCartao();
			window.getFrmCartoes().setVisible(true);
			frmProdutos.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void chamarFormCliente(){
		try{
			FormCliente window = new FormCliente();
			window.getFrmClientes().setVisible(true);
			frmProdutos.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void chamarFormFuncao(){
		try{
			FormFuncao window = new FormFuncao();
			window.getFrmFuncao().setVisible(true);
			frmProdutos.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void chamarFormPrestadorDeServico(){
		try{
			FormPrestadorDeServico window = new FormPrestadorDeServico();
			window.getFrmPrestadorDeServico().setVisible(true);
			frmProdutos.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}