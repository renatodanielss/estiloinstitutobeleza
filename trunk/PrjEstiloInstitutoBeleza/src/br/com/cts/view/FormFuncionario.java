package br.com.cts.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public class FormFuncionario {

	private JFrame frmFuncionrio;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormFuncionario window = new FormFuncionario();
					window.frmFuncionrio.setVisible(true);
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
	public FormFuncionario() throws ParseException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		frmFuncionrio = new JFrame();
		frmFuncionrio.setTitle("Funcion\u00E1rio");
		frmFuncionrio.setBounds(100, 100, 763, 473);
		frmFuncionrio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFuncionrio.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel.setBounds(10, 43, 660, 106);
		frmFuncionrio.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(16, 22, 46, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(14, 36, 625, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(16, 59, 46, 14);
		panel.add(lblSexo);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(155, 59, 155, 14);
		panel.add(lblDataDeNascimento);
		
		JComboBox<String> cbFuncao = new JComboBox<String>();
		cbFuncao.setBackground(Color.WHITE);
		cbFuncao.setBounds(332, 74, 307, 20);
		panel.add(cbFuncao);
		
		JLabel lblFuncao = new JLabel("Fun\u00E7\u00E3o:");
		lblFuncao.setBounds(333, 59, 46, 14);
		panel.add(lblFuncao);
		
		MaskFormatter mfDataNascimento = new MaskFormatter("##/##/####");
		mfDataNascimento.setPlaceholderCharacter('_');
		txtDataNascimento = new JFormattedTextField(mfDataNascimento);
		txtDataNascimento.setBounds(154, 74, 168, 20);
		panel.add(txtDataNascimento);
		
		JComboBox<String> cbSexo = new JComboBox<String>();
		cbSexo.setBackground(Color.WHITE);
		cbSexo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Masculino", "Feminino"}));
		cbSexo.setBounds(15, 73, 128, 20);
		panel.add(cbSexo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel_1.setBounds(10, 160, 661, 106);
		frmFuncionrio.getContentPane().add(panel_1);
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
		lblUf.setBounds(374, 58, 46, 14);
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
		panel_2.setBounds(11, 277, 660, 111);
		frmFuncionrio.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(15, 19, 64, 14);
		panel_2.add(lblTelefone);
		
		MaskFormatter mfTelefone = new MaskFormatter("(##) ####-####");
		mfTelefone.setPlaceholderCharacter('_');
		JFormattedTextField txtTelefone = new JFormattedTextField(mfTelefone);
		txtTelefone.setBounds(16, 34, 209, 20);
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
		lblEmail1.setBounds(16, 58, 63, 14);
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
	}
}
