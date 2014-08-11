package br.com.cts.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.cts.bll.ClienteBLL;
import br.com.cts.model.Cliente;
import br.com.cts.util.Calendario;
import br.com.cts.util.FocusTraversalOnArray;
import br.com.cts.util.Relatorio;

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
	private JComboBox<String> cbQtdPorPagina;
	private JTextField txtPagina;
	private JLabel lblDe;
	private JTextField txtQtdPaginas;
	private ClienteBLL clienteBll;

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
		
		clienteBll = new ClienteBLL();
		
		txtNome = new JTextField();
		txtNome.setBounds(22, 96, 355, 20);
		txtNome.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(772, 387, 89, 23);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					salvarAlterar();
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
				salvarAlterar();
			}
		});
		mnArquivo.add(mntmSalvar);
		
		JMenuItem mntmGerarRelatorio = new JMenuItem("Gerar Relat\u00F3rio");
		mntmGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Relatorio.chamarRelatorio(txtPesquisar.getText());
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		mnArquivo.add(mntmGerarRelatorio);
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
							JOptionPane.showMessageDialog(null, "Data de inválida!");
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
		
		ImageIcon icon = new ImageIcon("images/estiloicone.png");
		Image img = icon.getImage();
		frmClientes.setIconImage(img);
		
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
		jTblClientes.getColumnModel().getColumn(1).setPreferredWidth(255);
		jTblClientes.getColumnModel().getColumn(2).setPreferredWidth(134);
		
		jTblClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
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
		
		cbQtdPorPagina = new JComboBox<String>();
		cbQtdPorPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
					txtQtdPaginas.setText(String.valueOf(qtdPaginasJTable()));
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		cbQtdPorPagina.setModel(new DefaultComboBoxModel<String>(new String[] {"10", "30", "50"}));
		cbQtdPorPagina.setBounds(951, 387, 55, 23);
		frmClientes.getContentPane().add(cbQtdPorPagina);
		
		txtPesquisar = new JTextField();
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 10){
					try {
						popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
						txtQtdPaginas.setText(String.valueOf(qtdPaginasJTable()));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		txtPesquisar.setBounds(686, 67, 363, 20);
		
		frmClientes.getContentPane().add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setBounds(686, 50, 67, 14);
		frmClientes.getContentPane().add(lblPesquisar);
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novo();
			}
		});
		btnNovo.setBounds(684, 387, 89, 23);
		frmClientes.getContentPane().add(btnNovo);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					excluir();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(860, 387, 89, 23);
		frmClientes.getContentPane().add(btnExcluir);
		
		JButton btnFirst = new JButton("|<<");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToFirst();
			}
		});
		btnFirst.setBounds(1007, 387, 55, 23);
		frmClientes.getContentPane().add(btnFirst);
		
		JButton btnPrevious = new JButton("<<");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToPrevious();
			}
		});
		btnPrevious.setBounds(1061, 387, 55, 23);
		frmClientes.getContentPane().add(btnPrevious);
		
		JButton btnNext = new JButton(">>");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToNext();
			}
		});
		btnNext.setBounds(1115, 387, 55, 23);
		frmClientes.getContentPane().add(btnNext);
		
		JButton btnLast = new JButton(">>|");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToLast();
			}
		});
		btnLast.setBounds(1169, 387, 55, 23);
		frmClientes.getContentPane().add(btnLast);
		
		txtPagina = new JTextField();
		txtPagina.setBounds(1052, 67, 85, 20);
		frmClientes.getContentPane().add(txtPagina);
		txtPagina.setColumns(10);
		
		JLabel lblPgina = new JLabel("P\u00E1gina");
		lblPgina.setBounds(1052, 50, 67, 14);
		frmClientes.getContentPane().add(lblPgina);
		
		lblDe = new JLabel("De");
		lblDe.setBounds(1140, 50, 57, 14);
		frmClientes.getContentPane().add(lblDe);
		
		txtQtdPaginas = new JTextField();
		txtQtdPaginas.setEditable(false);
		txtQtdPaginas.setColumns(10);
		txtQtdPaginas.setBounds(1140, 67, 85, 20);
		frmClientes.getContentPane().add(txtQtdPaginas);
		frmClientes.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtNome, cbSexo, txtDataNascimento, txtLogradouro, txtNumero, txtComplemento, txtBairro, txtCidade, cbUf, txtCep, txtTelefone, txtCelular1, txtCelular2, txtEmail1, txtEmail2, txtPesquisar, jTblClientes, btnNovo, btnSalvar, btnExcluir}));

		popularJTableCompleto(Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
		
		txtPagina.setText("1");
		txtQtdPaginas.setText(String.valueOf(qtdPaginasJTable()));
	}
	
	private void novo(){
		limparCampos();
		jTblClientes.clearSelection();
		btnSalvar.setText("Salvar");
	}
	
	private void salvarAlterar(){
		try {
			Cliente cliente = new Cliente();
			
			if (jTblClientes.getSelectedRow() > -1)
				cliente.setIdCliente(Integer.valueOf(jTblClientes.getValueAt(jTblClientes.getSelectedRow(), 0).toString()));
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

			if (getQtdCamposIncorretos() < 1){
				if (btnSalvar.getText() == "Salvar"){
					clienteBll.salvar(cliente);
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
					popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtPagina.getText()));
					limparCampos();
				}
				else{
					int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja confirmar as alteraçções?","Alterar!", JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
						clienteBll.alterar(cliente);
						JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
						popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtPagina.getText()));
						limparCampos();
					}
				}
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
	
	private void excluir() throws NumberFormatException, Exception{
		if (jTblClientes.getSelectedRow() > -1){
			int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja realmente excluir?","Excluir!", JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION){
				Cliente cliente = clienteBll.procuraClientePorId(Integer.valueOf(jTblClientes.getValueAt(jTblClientes.getSelectedRow(), 0).toString()));
				clienteBll.excluir(cliente);
				JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
				jTblClientes.clearSelection();
				popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
			}
		}
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
		if (!estaCampoTextoPreenchido(txtNumero, " - Preencha o campo número!\n"))
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
	
	private void popularJTableCompleto(int qtdPorPagina, int numeroDaPagina) throws Exception{
		DefaultTableModel modeloTable = (DefaultTableModel) jTblClientes.getModel();
		List<Cliente> clientes = clienteBll.procuraCliente(qtdPorPagina, numeroDaPagina);
		
		for (Cliente c : clientes) {
            modeloTable.addRow(new Object[] { c.getIdCliente(), c.getNomeCliente(), c.getDataNascimentoCliente() });
        }
		
		txtPagina.setText(String.valueOf(numeroDaPagina));
	}
	
	//Aqui
	private void popularJTablePorNome(String nome, int qtdPorPagina, int numeroDaPagina) throws Exception{
		DefaultTableModel modeloTable = (DefaultTableModel) jTblClientes.getModel();
		List<Cliente> clientes = clienteBll.procuraClientePorNome(nome, qtdPorPagina, numeroDaPagina);
		
		modeloTable.setNumRows(0);
		
		for (Cliente c : clientes) {
            modeloTable.addRow(new Object[] { c.getIdCliente(), c.getNomeCliente(), c.getDataNascimentoCliente() });
        }
		
		txtPagina.setText(String.valueOf(numeroDaPagina));
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
	
	//Aqui
	private int qtdPaginasJTable() throws Exception{
		int qtdRegistros = clienteBll.recordCount(txtPesquisar.getText());
		int qtdPaginas = qtdRegistros / Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString());
		if (qtdRegistros % Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()) > 0)
			qtdPaginas++;
		return qtdPaginas;
	}
	
	private void goToFirst(){
		try {
			if (!txtPagina.getText().equals("1")){
				popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void goToPrevious(){
		try {
			if (Integer.valueOf(txtPagina.getText()) > 1){
				popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtPagina.getText())-1);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void goToNext(){
		try {
			if (Integer.valueOf(txtPagina.getText()) < Integer.valueOf(txtQtdPaginas.getText())){
				popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtPagina.getText())+1);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void goToLast(){
		try {
			if (!txtPagina.getText().equals(txtQtdPaginas.getText())){
				popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtQtdPaginas.getText()));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}