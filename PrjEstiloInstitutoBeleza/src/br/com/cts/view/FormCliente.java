package br.com.cts.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.com.cts.bll.ClienteBLL;
import br.com.cts.model.Cliente;

public class FormCliente {
	private JFrame frmClientes;
	private JTextField txtNome;
	private JComboBox<String> cbSexo;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenuItem mntmNovo;
	private JFormattedTextField txtDataNascimento;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JLabel lblBairro;
	private JTextField txtBairro;
	private JLabel lblCidade;
	private JTextField txtCidade;
	private JLabel lblUf;
	private JFormattedTextField txtCep;
	private JComboBox<String> cbUf;
	private JLabel lblCep;
	private JLabel lblTelefone;
	private JFormattedTextField txtTelefone;
	private JPanel pnlDadosPessoais;
	private JPanel panel;
	private JLabel lblCelular;
	private JFormattedTextField txtCelular1;
	private JLabel lblCelular_1;
	private JFormattedTextField txtCelular2;
	private JLabel lblEmail;
	private JTextField txtEmail1;
	private JLabel lblEmail_1;
	private JTextField txtEmail2;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCliente window = new FormCliente();
					window.frmClientes.setVisible(true);
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
	public FormCliente() throws ParseException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		frmClientes = new JFrame();
		frmClientes.setTitle("Clientes");
		frmClientes.setBounds(100, 100, 1032, 439);
		frmClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtNome = new JTextField();
		txtNome.setBounds(22, 96, 355, 20);
		txtNome.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(22, 366, 86, 23);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		frmClientes.getContentPane().setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1016, 21);
		frmClientes.getContentPane().add(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		mntmNovo = new JMenuItem("Novo");
		mntmNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnArquivo.add(mntmNovo);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		mnArquivo.add(mntmSalvar);
		frmClientes.getContentPane().add(txtNome);
		frmClientes.getContentPane().add(btnSalvar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(22, 82, 37, 14);
		frmClientes.getContentPane().add(lblNome);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(490, 82, 120, 14);
		frmClientes.getContentPane().add(lblDataDeNascimento);
		
		MaskFormatter mfDataNascimento = new MaskFormatter("##/##/####");
		mfDataNascimento.setPlaceholderCharacter('_');
		txtDataNascimento = new JFormattedTextField(mfDataNascimento);
		txtDataNascimento.setBounds(490, 96, 165, 20);
		frmClientes.getContentPane().add(txtDataNascimento);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(389, 82, 37, 14);
		frmClientes.getContentPane().add(lblSexo);
		
		cbSexo = new JComboBox<String>();
		cbSexo.setBackground(Color.WHITE);
		cbSexo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Masculino", "Feminino"}));
		cbSexo.setBounds(387, 96, 94, 20);
		frmClientes.getContentPane().add(cbSexo);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(22, 153, 71, 14);
		frmClientes.getContentPane().add(lblLogradouro);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(22, 170, 355, 20);
		frmClientes.getContentPane().add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setBounds(389, 153, 46, 14);
		frmClientes.getContentPane().add(lblNmero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(389, 170, 86, 20);
		frmClientes.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(486, 153, 86, 14);
		frmClientes.getContentPane().add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(486, 170, 169, 20);
		frmClientes.getContentPane().add(txtComplemento);
		txtComplemento.setColumns(10);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(22, 193, 46, 14);
		frmClientes.getContentPane().add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(22, 209, 221, 20);
		frmClientes.getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(253, 193, 46, 14);
		frmClientes.getContentPane().add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(253, 209, 146, 20);
		frmClientes.getContentPane().add(txtCidade);
		txtCidade.setColumns(10);
		
		lblUf = new JLabel("UF:");
		lblUf.setBounds(409, 193, 34, 14);
		frmClientes.getContentPane().add(lblUf);
		
		cbUf = new JComboBox<String>();
		cbUf.setBackground(Color.WHITE);
		cbUf.setModel(new DefaultComboBoxModel<String>(new String[] {"", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
		cbUf.setBounds(409, 209, 97, 20);
		frmClientes.getContentPane().add(cbUf);
		
		lblCep = new JLabel("CEP:");
		lblCep.setBounds(516, 193, 46, 14);
		frmClientes.getContentPane().add(lblCep);
		
		MaskFormatter mfCep = new MaskFormatter("#####-###");
		mfCep.setPlaceholderCharacter('_');
		txtCep = new JFormattedTextField(mfCep);
		txtCep.setBounds(516, 209, 139, 20);
		frmClientes.getContentPane().add(txtCep);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(22, 270, 62, 14);
		frmClientes.getContentPane().add(lblTelefone);
		
		MaskFormatter mfTelefone = new MaskFormatter("(##) ####-####");
		mfTelefone.setPlaceholderCharacter('_');
		txtTelefone = new JFormattedTextField(mfTelefone);
		txtTelefone.setBounds(22, 285, 223, 20);
		frmClientes.getContentPane().add(txtTelefone);
		
		pnlDadosPessoais = new JPanel();
		pnlDadosPessoais.setForeground(Color.WHITE);
		pnlDadosPessoais.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados Pessoais", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 100, 0)));
		pnlDadosPessoais.setBounds(10, 60, 664, 69);
		frmClientes.getContentPane().add(pnlDadosPessoais);
		
		panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Endere\u00E7o", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel.setBounds(10, 132, 664, 113);
		frmClientes.getContentPane().add(panel);
		
		lblCelular = new JLabel("Celular 1:");
		lblCelular.setBounds(257, 270, 62, 14);
		frmClientes.getContentPane().add(lblCelular);
		
		MaskFormatter mfCelular = new MaskFormatter("(##) 9####-####");
		mfTelefone.setPlaceholderCharacter('_');
		txtCelular1 = new JFormattedTextField(mfCelular);
		txtCelular1.setBounds(257, 285, 201, 20);
		frmClientes.getContentPane().add(txtCelular1);
		
		lblCelular_1 = new JLabel("Celular 2:");
		lblCelular_1.setBounds(468, 270, 62, 14);
		frmClientes.getContentPane().add(lblCelular_1);
		
		txtCelular2 = new JFormattedTextField(mfCelular);
		txtCelular2.setBounds(468, 285, 187, 20);
		frmClientes.getContentPane().add(txtCelular2);
		
		lblEmail = new JLabel("E-mail 1:");
		lblEmail.setBounds(22, 310, 55, 14);
		frmClientes.getContentPane().add(lblEmail);
		
		txtEmail1 = new JTextField();
		txtEmail1.setBounds(22, 326, 312, 20);
		frmClientes.getContentPane().add(txtEmail1);
		txtEmail1.setColumns(10);
		
		lblEmail_1 = new JLabel("E-mail 2:");
		lblEmail_1.setBounds(343, 310, 56, 14);
		frmClientes.getContentPane().add(lblEmail_1);
		
		txtEmail2 = new JTextField();
		txtEmail2.setColumns(10);
		txtEmail2.setBounds(343, 326, 312, 20);
		frmClientes.getContentPane().add(txtEmail2);
		
		panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contato", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel_1.setBounds(10, 249, 664, 108);
		frmClientes.getContentPane().add(panel_1);
	}
	
	private void salvar(){
		try {
			int erro = 0;
			Cliente cliente = new Cliente();
			
			cliente.setNomeCliente(txtNome.getText());
			cliente.setSexoCliente(cbSexo.getSelectedIndex());
			if (!cliente.setDataNascimentoCliente(txtDataNascimento.getText()))
				erro++;
			cliente.setLogradouroCliente(txtLogradouro.getText());
			cliente.setNumeroCliente(Integer.parseInt(txtNumero.getText()));
			cliente.setComplementoCliente(txtComplemento.getText());
			cliente.setBairroCliente(txtBairro.getText());
			cliente.setCidadeCliente(txtCidade.getText());
			cliente.setUfCliente(cbUf.getSelectedIndex());
			cliente.setCepCliente(txtCep.getText());
			cliente.setTelefoneCliente(txtTelefone.getText());
			cliente.setCelular1Cliente(txtCelular1.getText());
			cliente.setCelular2Cliente(txtCelular2.getText());
			cliente.setEmail1Cliente(txtEmail1.getText());
			cliente.setEmail2Cliente(txtEmail2.getText());
		
			ClienteBLL clienteBll = new ClienteBLL();
			if (erro == 0){
				clienteBll.salvar(cliente);
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			}
		}catch (ParseException ex) {
			ex.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}