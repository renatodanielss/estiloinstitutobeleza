package br.com.cts.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class FormPrestadorDeServico extends JFrame {

	private JFrame frmPrestadorDeServico;
	private JTextField txtNome;
	private JFormattedTextField txtDataNascimento;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JFormattedTextField txtCep;
	private JTextField txtEmail1;
	private JTextField txtEmail2;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenuItem mntmNovo;
	private JMenuItem mntmSalvar;
	private JMenu mnIr;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPrestadorDeServico window = new FormPrestadorDeServico();
					window.frmPrestadorDeServico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ParseException 
	 */
	public FormPrestadorDeServico() throws ParseException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		frmPrestadorDeServico = new JFrame();
		frmPrestadorDeServico.setTitle("Prestadores de Servi\u00E7os");
		frmPrestadorDeServico.setBounds(100, 100, 763, 542);
		frmPrestadorDeServico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrestadorDeServico.getContentPane().setLayout(null);
		frmPrestadorDeServico.setMinimumSize(frmPrestadorDeServico.getSize());
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel.setBounds(12, 120, 660, 106);
		frmPrestadorDeServico.getContentPane().add(panel);
		panel.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 2000, 21);
		frmPrestadorDeServico.getContentPane().add(menuBar);
		
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
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mntmProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarFormProduto();
			}
		});
		
		JMenuItem mntmFuncoes = new JMenuItem("Fun\u00E7\u00F5es");
		mntmFuncoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarFormFuncao();
			}
		});
		mnIr.add(mntmFuncoes);
		mnIr.add(mntmProdutos);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(15, 22, 46, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(15, 36, 625, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(15, 59, 46, 14);
		panel.add(lblSexo);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(155, 59, 155, 14);
		panel.add(lblDataDeNascimento);
		
		JComboBox<String> cbFuncao = new JComboBox<String>();
		cbFuncao.setBackground(Color.WHITE);
		cbFuncao.setBounds(332, 73, 307, 20);
		panel.add(cbFuncao);
		
		JLabel lblFuncao = new JLabel("Fun\u00E7\u00E3o:");
		lblFuncao.setBounds(333, 59, 46, 14);
		panel.add(lblFuncao);
		
		MaskFormatter mfDataNascimento = new MaskFormatter("##/##/####");
		mfDataNascimento.setPlaceholderCharacter('_');
		txtDataNascimento = new JFormattedTextField(mfDataNascimento);
		txtDataNascimento.setBounds(154, 73, 168, 20);
		panel.add(txtDataNascimento);
		
		JComboBox<String> cbSexo = new JComboBox<String>();
		cbSexo.setBackground(Color.WHITE);
		cbSexo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Masculino", "Feminino"}));
		cbSexo.setBounds(15, 73, 128, 20);
		panel.add(cbSexo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel_1.setBounds(12, 229, 661, 106);
		frmPrestadorDeServico.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(15, 19, 72, 14);
		panel_1.add(lblLogradouro);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(15, 33, 310, 20);
		panel_1.add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(335, 33, 86, 20);
		panel_1.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(336, 19, 59, 14);
		panel_1.add(lblNmero);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(433, 33, 207, 20);
		panel_1.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(434, 19, 130, 14);
		panel_1.add(lblComplemento);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(15, 57, 46, 14);
		panel_1.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(15, 72, 207, 20);
		panel_1.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(232, 72, 130, 20);
		panel_1.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(233, 57, 59, 14);
		panel_1.add(lblCidade);
		
		JComboBox<String> cbUf = new JComboBox<String>();
		cbUf.setBackground(Color.WHITE);
		cbUf.setBounds(372, 72, 93, 20);
		panel_1.add(cbUf);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(374, 57, 46, 14);
		panel_1.add(lblUf);
		
		MaskFormatter mfCep = new MaskFormatter("#####-###");
		mfCep.setPlaceholderCharacter('_');
		txtCep = new JFormattedTextField(mfCep);
		txtCep.setBounds(475, 72, 165, 20);
		panel_1.add(txtCep);
		
		JLabel lblCep = new JLabel("CEP: ");
		lblCep.setBounds(477, 57, 46, 14);
		panel_1.add(lblCep);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Contato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel_2.setBounds(12, 338, 660, 111);
		frmPrestadorDeServico.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(15, 19, 64, 14);
		panel_2.add(lblTelefone);
		
		MaskFormatter mfTelefone = new MaskFormatter("(##) ####-####");
		mfTelefone.setPlaceholderCharacter('_');
		JFormattedTextField txtTelefone = new JFormattedTextField(mfTelefone);
		txtTelefone.setBounds(15, 34, 209, 20);
		panel_2.add(txtTelefone);
		
		MaskFormatter mfCelular1 = new MaskFormatter("(##) 9####-####");
		mfCelular1.setPlaceholderCharacter('_');
		JFormattedTextField txtCelular1 = new JFormattedTextField(mfCelular1);
		txtCelular1.setBounds(236, 34, 193, 20);
		panel_2.add(txtCelular1);
		
		JLabel lblCelular1 = new JLabel("Celular 1:");
		lblCelular1.setBounds(236, 19, 58, 14);
		panel_2.add(lblCelular1);
		
		MaskFormatter mfCelular2 = new MaskFormatter("(##) 9####-####");
		mfCelular2.setPlaceholderCharacter('_');
		JFormattedTextField txtCelular2 = new JFormattedTextField(mfCelular2);
		txtCelular2.setBounds(439, 34, 200, 20);
		panel_2.add(txtCelular2);
		
		JLabel lblCelular2 = new JLabel("Celular 2:");
		lblCelular2.setBounds(439, 19, 64, 11);
		panel_2.add(lblCelular2);
		
		JLabel lblEmail1 = new JLabel("E-mail 1:");
		lblEmail1.setBounds(15, 58, 63, 14);
		panel_2.add(lblEmail1);
		
		txtEmail1 = new JTextField();
		txtEmail1.setBounds(15, 73, 301, 20);
		panel_2.add(txtEmail1);
		txtEmail1.setColumns(10);
		
		txtEmail2 = new JTextField();
		txtEmail2.setBounds(326, 73, 313, 20);
		panel_2.add(txtEmail2);
		txtEmail2.setColumns(10);
		
		JLabel lblEmail2 = new JLabel("E-mail 2:");
		lblEmail2.setBounds(326, 58, 64, 14);
		panel_2.add(lblEmail2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setForeground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ID", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel_3.setBounds(12, 50, 664, 69);
		frmPrestadorDeServico.getContentPane().add(panel_3);
		
		JLabel label = new JLabel("ID:");
		label.setBounds(15, 22, 37, 14);
		panel_3.add(label);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(15, 36, 355, 20);
		panel_3.add(txtId);
	}

	public JFrame getFrmPrestadorDeServico() {
		return frmPrestadorDeServico;
	}

	private void novo(){
		
	}
	
	private void salvarAlterar(){
		
	}
	
	private void chamarFormCartao(){
		try{
			FormCartao window = new FormCartao();
			window.getFrmCartoes().setVisible(true);
			frmPrestadorDeServico.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void chamarFormCliente(){
		try{
			FormCliente window = new FormCliente();
			window.getFrmClientes().setVisible(true);
			frmPrestadorDeServico.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void chamarFormFuncao(){
		try{
			FormFuncao window = new FormFuncao();
			window.getFrmFuncao().setVisible(true);
			frmPrestadorDeServico.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void chamarFormProduto(){
		try{
			FormProduto window = new FormProduto();
			window.getFrmProdutos().setVisible(true);
			frmPrestadorDeServico.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}