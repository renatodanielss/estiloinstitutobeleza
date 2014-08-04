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
		frmFuncionrio.setBounds(100, 100, 763, 419);
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
		
		JComboBox cbFuncao = new JComboBox();
		cbFuncao.setBackground(Color.WHITE);
		cbFuncao.setBounds(332, 74, 307, 20);
		panel.add(cbFuncao);
		
		JLabel lblFuncao = new JLabel("Fun\u00E7\u00E3o:");
		lblFuncao.setBounds(333, 59, 46, 14);
		panel.add(lblFuncao);
		
		MaskFormatter mfDataNascimento = new MaskFormatter("##/##/####");
		mfDataNascimento.setPlaceholderCharacter('_');
		JFormattedTextField txtDataNascimento = new JFormattedTextField(mfDataNascimento);
		txtDataNascimento.setBounds(154, 74, 168, 20);
		panel.add(txtDataNascimento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Masculino", "Feminino"}));
		comboBox.setBounds(16, 73, 128, 20);
		panel.add(comboBox);
		
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
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(372, 72, 93, 20);
		panel_1.add(comboBox_1);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(374, 58, 46, 14);
		panel_1.add(lblUf);
		
		MaskFormatter mfCep = new MaskFormatter("#####-###");
		mfCep.setPlaceholderCharacter('_');
		JFormattedTextField txtCep = new JFormattedTextField(mfCep);
		txtCep.setBounds(475, 72, 165, 20);
		panel_1.add(txtCep);
		
		JLabel lblCep = new JLabel("CEP: ");
		lblCep.setBounds(477, 57, 46, 14);
		panel_1.add(lblCep);
	}
}
