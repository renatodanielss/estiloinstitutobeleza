package br.com.cts.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.List;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import br.com.cts.bll.ClienteBLL;
import br.com.cts.model.Cliente;
import br.com.cts.util.Calendario;

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
	private String message;
	private JPanel panel_1;
	private JTable jTblClientes;
	private JTextField txtPesquisar;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnExcluir;

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
	 * @throws Exception 
	 */
	public FormCliente() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	@SuppressWarnings("serial")
	private void initialize() throws Exception {
		frmClientes = new JFrame();
		frmClientes.setTitle("Clientes");
		frmClientes.setBounds(100, 100, 1251, 520);
		frmClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClientes.setMinimumSize(frmClientes.getSize());
		
		txtNome = new JTextField();
		txtNome.setBounds(22, 96, 355, 20);
		txtNome.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(783, 398, 86, 23);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					salvar();
					popularJTablePorNome(txtPesquisar.getText());
					limparCampos();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		frmClientes.getContentPane().setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1235, 21);
		frmClientes.getContentPane().add(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		mntmNovo = new JMenuItem("Novo");
		mntmNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novo();
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
		txtDataNascimento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					if (!txtDataNascimento.getText().equals("__/__/____")){
						if (!Calendario.isDate(txtDataNascimento.getText())){
							txtDataNascimento.setText(null);
							JOptionPane.showMessageDialog(null, "Data de inv�lida!");
						}
					}
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		txtDataNascimento.setBounds(490, 96, 165, 20);
		txtDataNascimento.setFocusLostBehavior(0);
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
		txtNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if ((e.getKeyChar() < '0' || e.getKeyChar() > '9') && e.getKeyChar() != 8)
					txtNumero.setText(txtNumero.getText().replaceAll("[^0-9]", ""));
			}
		});
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
		txtCep.setFocusLostBehavior(0);
		frmClientes.getContentPane().add(txtCep);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(22, 270, 62, 14);
		frmClientes.getContentPane().add(lblTelefone);
		
		MaskFormatter mfTelefone = new MaskFormatter("(##) ####-####");
		mfTelefone.setPlaceholderCharacter('_');
		txtTelefone = new JFormattedTextField(mfTelefone);
		txtTelefone.setBounds(22, 285, 223, 20);
		txtTelefone.setFocusLostBehavior(0);
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
		mfCelular.setPlaceholderCharacter('_');
		txtCelular1 = new JFormattedTextField(mfCelular);
		txtCelular1.setBounds(257, 285, 201, 20);
		txtCelular1.setFocusLostBehavior(0);
		frmClientes.getContentPane().add(txtCelular1);
		
		lblCelular_1 = new JLabel("Celular 2:");
		lblCelular_1.setBounds(468, 270, 62, 14);
		frmClientes.getContentPane().add(lblCelular_1);
		
		MaskFormatter mfCelular2 = new MaskFormatter("(##) 9####-####");
		mfCelular2.setPlaceholderCharacter('_');
		txtCelular2 = new JFormattedTextField(mfCelular2);
		txtCelular2.setBounds(468, 285, 187, 20);
		txtCelular2.setFocusLostBehavior(0);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(684, 92, 541, 295);
		frmClientes.getContentPane().add(scrollPane);
		
		jTblClientes = new JTable();
		jTblClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(jTblClientes);
		jTblClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Data de Nascimento"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		jTblClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	ClienteBLL clienteBll = new ClienteBLL();
				Cliente cliente = new Cliente();
				try {
					if (jTblClientes.getSelectedRow() > -1){
						cliente = clienteBll.procuraClientePorId(Integer.valueOf(jTblClientes.getValueAt(jTblClientes.getSelectedRow(), 0).toString()));
						btnSalvar.setText("Alterar");
					}
					else{
						btnSalvar.setText("Salvar");
					}
					
					preencherCampos(cliente);
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	        }
	    });
		
		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(761, 67, 464, 20);
		txtPesquisar.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				warn();
			}
			public void removeUpdate(DocumentEvent e) {
				warn();
			}
			
			public void insertUpdate(DocumentEvent e) {
				warn();
			}
			
			public void warn() {
				try {
					popularJTablePorNome(txtPesquisar.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		frmClientes.getContentPane().add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setBounds(684, 70, 67, 14);
		frmClientes.getContentPane().add(lblPesquisar);
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novo();
			}
		});
		btnNovo.setBounds(684, 398, 89, 23);
		frmClientes.getContentPane().add(btnNovo);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(879, 398, 89, 23);
		frmClientes.getContentPane().add(btnExcluir);
		frmClientes.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtNome, cbSexo, txtDataNascimento, txtLogradouro, txtNumero, txtComplemento, txtBairro, txtCidade, cbUf, txtCep, txtTelefone, txtCelular1, txtCelular2, txtEmail1, txtEmail2, txtPesquisar, jTblClientes, btnNovo, btnSalvar, btnExcluir}));
		jTblClientes.getColumnModel().getColumn(1).setPreferredWidth(255);
		jTblClientes.getColumnModel().getColumn(2).setPreferredWidth(134);

		popularJTableCompleto();
	}
	
	private void novo(){
		limparCampos();
		btnSalvar.setText("Salvar");
	}
	
	private void salvar(){
		try {
			Cliente cliente = new Cliente();
			
			cliente.setNomeCliente(txtNome.getText());
			cliente.setSexoCliente(cbSexo.getSelectedIndex());
			cliente.setDataNascimentoCliente(txtDataNascimento.getText());
			cliente.setLogradouroCliente(txtLogradouro.getText());
			if (txtNumero.getText().length() > 0)
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
			if (getQtdCamposIncorretos() < 1){
				clienteBll.salvar(cliente);
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			}
			else{
				JOptionPane.showMessageDialog(null, this.message);
			}
		}catch (ParseException ex) {
			ex.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void alterar(){
		
	}
	
	private int getQtdCamposIncorretos(){
		int contador = 0;
		this.message = "";
		if (!estaCampoTextoPreenchido(txtNome, " - Preencha o campo nome!\n"))
			contador++;
		if (!estaCampoComboBoxPreenchido(cbSexo, " - Preencha o campo sexo!\n"))
			contador++;
		
		if (txtDataNascimento.getText().equals("__/__/____")){
			setErrorTextField(txtDataNascimento);
			this.message += " - Preencha o campo data de nascimento!\n";
			contador++;
		}
		else
			setCorrectTextField(txtDataNascimento);
		
		if (!estaCampoTextoPreenchido(txtLogradouro, " - Preencha o campo logradouro!\n"))
			contador++;
		if (!estaCampoTextoPreenchido(txtNumero, " - Preencha o campo n�mero!\n"))
			contador++;
		if (!estaCampoTextoPreenchido(txtBairro, " - Preencha o campo bairro!\n"))
			contador++;
		if (!estaCampoTextoPreenchido(txtCidade, " - Preencha o campo cidade!\n"))
			contador++;
		if (!estaCampoComboBoxPreenchido(cbUf, " - Preencha o campo UF!\n"))
			contador++;

		if (txtCep.getText().equals("_____-___")){
			setErrorTextField(txtCep);
			this.message += " - Preencha o campo data de CEP!\n";
			contador++;
		}
		else
			setCorrectTextField(txtCep);
		
		if (txtTelefone.getText().equals("(__) ____-____")){
			setErrorTextField(txtTelefone);
			this.message += " - Preencha o campo telefone!\n";
			contador++;
		}
		else
			setCorrectTextField(txtTelefone);
		
		return contador;
	}
	
	private boolean estaCampoTextoPreenchido(JTextField jTextField, String errorMessage){
		if (jTextField.getText().equals("")){
			setErrorTextField(jTextField);
			this.message += errorMessage;
			return false;
		}
		else{
			setCorrectTextField(jTextField);
			return true;
		}
	}
	
	private void setErrorTextField(JTextField jTextField){
		Color errorColor = new Color(255, 102, 102);
		jTextField.setBackground(errorColor);
		jTextField.setForeground(Color.WHITE);
	}
	
	private void setCorrectTextField(JTextField jTextField){
		jTextField.setBackground(Color.WHITE);
		jTextField.setForeground(Color.BLACK);
	}
	
	private boolean estaCampoComboBoxPreenchido(@SuppressWarnings("rawtypes") JComboBox jComboBox, String errorMessage){
		if (jComboBox.getSelectedIndex() < 1){
			setErrorComboField(jComboBox);
			this.message += errorMessage;
			return false;
		}
		else{
			setCorrectComboField(jComboBox);
			return true;
		}
	}
	
	private void setErrorComboField(@SuppressWarnings("rawtypes") JComboBox jComboBox){
		Color errorColor = new Color(255, 102, 102);
		jComboBox.setBackground(errorColor);
		jComboBox.setForeground(Color.WHITE);
	}
	
	private void setCorrectComboField(@SuppressWarnings("rawtypes") JComboBox jComboBox){
		jComboBox.setBackground(Color.WHITE);
		jComboBox.setForeground(Color.BLACK);
	}
	
	private void preencherCampos(Cliente cliente){
		txtNome.setText(cliente.getNomeCliente());
		cbSexo.setSelectedIndex(cliente.getSexoCliente());
		txtDataNascimento.setText(cliente.getDataNascimentoCliente());
		txtLogradouro.setText(cliente.getLogradouroCliente());
		txtNumero.setText(String.valueOf(cliente.getNumeroCliente()));
		txtComplemento.setText(cliente.getComplementoCliente());
		txtBairro.setText(cliente.getBairroCliente());
		txtCidade.setText(cliente.getCidadeCliente());
		cbUf.setSelectedIndex(cliente.getUfCliente());
		txtCep.setText(cliente.getCepCliente());
		txtTelefone.setText(cliente.getTelefoneCliente());
		txtCelular1.setText(null);
		txtCelular1.setText(cliente.getCelular1Cliente());
		txtCelular2.setText(null);
		txtCelular2.setText(cliente.getCelular2Cliente());
		txtEmail1.setText(cliente.getEmail1Cliente());
		txtEmail2.setText(cliente.getEmail2Cliente());
	}
	
	private void popularJTableCompleto() throws Exception{
		DefaultTableModel modeloTable = (DefaultTableModel) jTblClientes.getModel();
		ClienteBLL clienteBll = new ClienteBLL();
		List<Cliente> clientes = clienteBll.procuraCliente();
		
		for (Cliente c : clientes) {
			String strSexo = null;
			if (c.getSexoCliente() == 1)
				strSexo = "Masculino";
			else if (c.getSexoCliente() == 2)
				strSexo = "Feminino";
			
            modeloTable.addRow(new Object[] { c.getIdCliente(),
                    c.getNomeCliente(), strSexo });
        }
	}
	
	private void popularJTablePorNome(String nome) throws Exception{
		DefaultTableModel modeloTable = (DefaultTableModel) jTblClientes.getModel();
		ClienteBLL clienteBll = new ClienteBLL();
		List<Cliente> clientes = clienteBll.procuraClientePorNome(nome);
		
		int rowCount = modeloTable.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			modeloTable.removeRow(0);
		}
		
		for (Cliente c : clientes) {
			String strSexo = null;
			if (c.getSexoCliente() == 1)
				strSexo = "Masculino";
			else if (c.getSexoCliente() == 2)
				strSexo = "Feminino";
			
            modeloTable.addRow(new Object[] { c.getIdCliente(),
                    c.getNomeCliente(), strSexo });
        }
	}
	
	private void limparCampos(){
		txtNome.setText(null);
		cbSexo.setSelectedIndex(0);
		txtDataNascimento.setText(null);
		txtLogradouro.setText(null);
		txtNumero.setText(null);
		txtComplemento.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		cbUf.setSelectedIndex(0);
		txtCep.setText(null);
		txtTelefone.setText(null);
		txtCelular1.setText(null);
		txtCelular2.setText(null);
		txtEmail1.setText(null);
		txtEmail2.setText(null);
		txtNome.requestFocus();
	}
}