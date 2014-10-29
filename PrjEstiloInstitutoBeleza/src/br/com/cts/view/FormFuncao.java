package br.com.cts.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.com.cts.bll.FuncaoBLL;
import br.com.cts.model.Funcao;
import br.com.cts.number.IntegerObject;
import br.com.cts.util.Relatorio;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class FormFuncao extends JFrame{

	private JFrame frmFuncao;
	private JTextField txtFuncao;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenuItem mntmNovo;
	private JMenuItem mntmSalvar;
	private JMenu mnIr;
	private JPanel panel_1;
	private JLabel label;
	private JTextField txtId;
	private JMenuItem mntmCartoes;
	private JTextField txtComissao;
	private JTextField txtPesquisar;
	private JTextField txtPagina;
	private JTextField txtQtdPaginas;
	private JTable jTblFuncoes;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JComboBox<String> cbQtdPorPagina;
	private FuncaoBLL funcaoBll;
	private String message;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormFuncao window = new FormFuncao();
					window.frmFuncao.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public FormFuncao() throws NumberFormatException, Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private void initialize() throws NumberFormatException, Exception {
		frmFuncao = new JFrame();
		frmFuncao.setTitle("Fun\u00E7\u00F5es");
		frmFuncao.setBounds(100, 100, 1137, 498);
		frmFuncao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFuncao.getContentPane().setLayout(null);
		//setar tamanho mínimo do formnulário
		frmFuncao.setMinimumSize(frmFuncao.getSize());
		
		//instânciar bll
		funcaoBll = new FuncaoBLL();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Descri\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel.setBounds(12, 120, 530, 69);
		frmFuncao.getContentPane().add(panel);
		panel.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 2000, 21);
		frmFuncao.getContentPane().add(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		mntmNovo = new JMenuItem("Novo");
		
		//Listener
		mntmNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novo();
			}
		});
		mnArquivo.add(mntmNovo);
		
		mntmSalvar = new JMenuItem("Salvar");
		
		//Listener
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarAlterar();
			}
		});
		mnArquivo.add(mntmSalvar);
		
		JMenuItem mntmGerarRelatorio = new JMenuItem("Gerar Relat\u00F3rio");
		
		//Listener
		mntmGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarRelatorio();
			}
		});
		mnArquivo.add(mntmGerarRelatorio);
		
		mnIr = new JMenu("Ir");
		menuBar.add(mnIr);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		
		//Listener
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarFormCliente();
			}
		});
		
		mntmCartoes = new JMenuItem("Cart\u00F5es");
		
		//Listener
		mntmCartoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarFormCartao();
			}
		});
		mnIr.add(mntmCartoes);
		mnIr.add(mntmClientes);
		
		JMenuItem mntmPrestadoresDeServicos = new JMenuItem("Prestadores de Servi\u00E7os");
		
		//Listener
		mntmPrestadoresDeServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarFormPrestadorDeServico();
			}
		});
		mnIr.add(mntmPrestadoresDeServicos);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		
		//Listener
		mntmProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarFormProduto();
			}
		});
		mnIr.add(mntmProdutos);
		
		JLabel lblFuncao = new JLabel("Fun\u00E7\u00E3o:");
		lblFuncao.setBounds(15, 22, 46, 14);
		panel.add(lblFuncao);
		
		txtFuncao = new JTextField();
		txtFuncao.setBounds(15, 36, 414, 20);
		panel.add(txtFuncao);
		txtFuncao.setColumns(10);
		
		JLabel lblComisso = new JLabel("Comiss\u00E3o (%):");
		lblComisso.setBounds(439, 22, 81, 14);
		panel.add(lblComisso);
		
		txtComissao = new JTextField();
		
		//Listener
		txtComissao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtComissao.setText(txtComissao.getText().replaceAll("[^0-9.]", ""));
			}
		});
		txtComissao.setColumns(10);
		txtComissao.setBounds(439, 36, 81, 20);
		panel.add(txtComissao);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ID", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel_1.setBounds(12, 50, 530, 69);
		frmFuncao.getContentPane().add(panel_1);
		
		label = new JLabel("ID:");
		label.setBounds(15, 22, 37, 14);
		panel_1.add(label);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(15, 36, 355, 20);
		panel_1.add(txtId);
		
		JLabel label_1 = new JLabel("Pesquisar");
		label_1.setBounds(547, 50, 67, 14);
		frmFuncao.getContentPane().add(label_1);
		
		txtPesquisar = new JTextField();
		
		//Listener
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 10){
					try {
						if (IntegerObject.isInteger(txtPesquisar.getText())){
							popularJTablePorId(Integer.valueOf(txtPesquisar.getText()), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
							txtQtdPaginas.setText("1");
						}
						else{
							popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
							txtQtdPaginas.setText(String.valueOf(qtdPaginasJTable()));
							if (txtQtdPaginas.getText().equals("0"))
								txtPagina.setText("0");
						}
					} catch (Exception e1) {
						txtPagina.setText("0");
						txtQtdPaginas.setText("0");
						e1.printStackTrace();
					}
				}
			}
		});
		txtPesquisar.setColumns(10);
		txtPesquisar.setBounds(547, 67, 363, 20);
		frmFuncao.getContentPane().add(txtPesquisar);
		
		JLabel label_2 = new JLabel("P\u00E1gina");
		label_2.setBounds(913, 50, 67, 14);
		frmFuncao.getContentPane().add(label_2);
		
		txtPagina = new JTextField();
		
		//Listener
		txtPagina.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 10){
					try {
						if (Integer.valueOf(txtPagina.getText()) <= Integer.valueOf(txtQtdPaginas.getText())){
							if (Integer.valueOf(txtPagina.getText()) > 0){
								if (IntegerObject.isInteger(txtPesquisar.getText()))
									popularJTablePorId(Integer.valueOf(txtPesquisar.getText()), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtPagina.getText()));
								else
									popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtPagina.getText()));
								txtQtdPaginas.setText(String.valueOf(qtdPaginasJTable()));
							}
							else{
								if (IntegerObject.isInteger(txtPesquisar.getText()))
									popularJTablePorId(Integer.valueOf(txtPesquisar.getText()), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
								else
									popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
							}
						}
						else{
							if (IntegerObject.isInteger(txtPesquisar.getText()))
								popularJTablePorId(Integer.valueOf(txtPesquisar.getText()), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtQtdPaginas.getText()));
							else
								popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtQtdPaginas.getText()));
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				else
					txtPagina.setText(txtPagina.getText().replaceAll("[^0-9]", ""));
			}
		});
		txtPagina.setColumns(10);
		txtPagina.setBounds(913, 67, 85, 20);
		frmFuncao.getContentPane().add(txtPagina);
		
		JLabel label_3 = new JLabel("De");
		label_3.setBounds(1001, 50, 57, 14);
		frmFuncao.getContentPane().add(label_3);
		
		txtQtdPaginas = new JTextField();
		txtQtdPaginas.setEditable(false);
		txtQtdPaginas.setColumns(10);
		txtQtdPaginas.setBounds(1001, 67, 85, 20);
		frmFuncao.getContentPane().add(txtQtdPaginas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(545, 92, 541, 295);
		frmFuncao.getContentPane().add(scrollPane);
		
		jTblFuncoes = new JTable();
		jTblFuncoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(jTblFuncoes);
		jTblFuncoes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Função", "Comissão (%)"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, String.class
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
		jTblFuncoes.getColumnModel().getColumn(0).setPreferredWidth(100);
		jTblFuncoes.getColumnModel().getColumn(1).setPreferredWidth(320);
		jTblFuncoes.getColumnModel().getColumn(2).setPreferredWidth(118);
		
		//Listener - Definir comportamento de seleção de item no JTable
		jTblFuncoes.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
				Funcao funcao = new Funcao();
				try {
					if (jTblFuncoes.getSelectedRow() > -1){
						funcao = funcaoBll.procuraFuncaoPorId(Integer.valueOf(jTblFuncoes.getValueAt(jTblFuncoes.getSelectedRow(), 0).toString()));
						btnSalvar.setText("Alterar");
						mntmSalvar.setText("Alterar");
						preencherCampos(funcao);
					}
					else{
						btnSalvar.setText("Salvar");
						mntmSalvar.setText("Salvar");
						limparCampos();
					}
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	        }
	    });
		jTblFuncoes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//Instanciando DefaultTableCellRenderer para gerenciar JTable
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jTblFuncoes.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(JLabel.LEFT);
		
		btnNovo = new JButton("Novo");
		
		//Listener
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novo();
			}
		});
		btnNovo.setBounds(545, 387, 89, 23);
		frmFuncao.getContentPane().add(btnNovo);
		
		btnSalvar = new JButton("Salvar");
		
		//Listener
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarAlterar();
			}
		});
		btnSalvar.setBounds(633, 387, 89, 23);
		frmFuncao.getContentPane().add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		
		//Listener
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					excluir();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(721, 387, 89, 23);
		frmFuncao.getContentPane().add(btnExcluir);
		
		cbQtdPorPagina = new JComboBox<String>();
		
		//Listener
		cbQtdPorPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (IntegerObject.isInteger(txtPesquisar.getText())){
						popularJTablePorId(Integer.valueOf(txtPesquisar.getText()), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
						txtQtdPaginas.setText("1");
					}
					else{
						popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
						txtQtdPaginas.setText(String.valueOf(qtdPaginasJTable()));
						if (txtQtdPaginas.getText().equals("0"))
							txtPagina.setText("0");
					}
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		cbQtdPorPagina.setModel(new DefaultComboBoxModel<String>(new String[] {"10", "30", "50"}));
		cbQtdPorPagina.setBounds(812, 387, 55, 23);
		frmFuncao.getContentPane().add(cbQtdPorPagina);
		
		JButton btnFirst = new JButton("|<<");
		
		//Listener
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToFirst();
			}
		});
		btnFirst.setBounds(868, 387, 55, 23);
		frmFuncao.getContentPane().add(btnFirst);
		
		JButton btnPrevious = new JButton("<<");
		
		//Listener
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToPrevious();
			}
		});
		btnPrevious.setBounds(922, 387, 55, 23);
		frmFuncao.getContentPane().add(btnPrevious);
		
		JButton btnNext = new JButton(">>");
		
		//Listener
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToNext();
			}
		});
		btnNext.setBounds(976, 387, 55, 23);
		frmFuncao.getContentPane().add(btnNext);
		
		JButton btnLast = new JButton(">>|");
		
		//Listener
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToLast();
			}
		});
		btnLast.setBounds(1030, 387, 55, 23);
		frmFuncao.getContentPane().add(btnLast);
		
		//Popular JTable na inicialização do formulário, setar quantidade de páginas e página inicial
		popularJTableCompleto(Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
		txtQtdPaginas.setText(String.valueOf(qtdPaginasJTable()));
		if (Integer.valueOf(txtQtdPaginas.getText()) > 0)
			txtPagina.setText("1");
		else
			txtPagina.setText("0");
	}
	
	public JFrame getFrmFuncao() {
		return frmFuncao;
	}

	private void novo(){
		limparCampos();
		jTblFuncoes.clearSelection();
		btnSalvar.setText("Salvar");
		mntmSalvar.setText("Salvar");
	}
	
	private void salvarAlterar(){
		try {
			Funcao funcao = new Funcao();
			
			if (jTblFuncoes.getSelectedRow() > -1)
				funcao.setIdFuncao(Integer.valueOf(jTblFuncoes.getValueAt(jTblFuncoes.getSelectedRow(), 0).toString()));
			funcao.setNomeFuncao(txtFuncao.getText());
			funcao.setComissaoFuncao(Float.parseFloat(txtComissao.getText()));
			
			if (Integer.parseInt(txtPagina.getText()) == 0)
				txtPagina.setText("1");
			
			if (getQtdCamposIncorretos() < 1){
				if (btnSalvar.getText() == "Salvar"){
					funcaoBll.salvar(funcao);
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
					if (IntegerObject.isInteger(txtPesquisar.getText()))
						popularJTablePorId(Integer.valueOf(txtPesquisar.getText()), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtPagina.getText()));
					else
						popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtPagina.getText()));
					limparCampos();
				}
				else{
					int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja confirmar as alterações?","Alterar!", JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
						funcaoBll.alterar(funcao);
						JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
						if (IntegerObject.isInteger(txtPesquisar.getText()))
							popularJTablePorId(Integer.valueOf(txtPesquisar.getText()), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtPagina.getText()));
						else
							popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtPagina.getText()));
						limparCampos();
					}
				}
			}
			else{
				JOptionPane.showMessageDialog(null, this.message);
			}
			txtQtdPaginas.setText(String.valueOf(qtdPaginasJTable()));
		}catch (ParseException ex) {
			ex.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void excluir() throws NumberFormatException, Exception{
		if (jTblFuncoes.getSelectedRow() > -1){
			int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja realmente excluir?","Excluir!", JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION){
				Funcao funcao = funcaoBll.procuraFuncaoPorId(Integer.valueOf(jTblFuncoes.getValueAt(jTblFuncoes.getSelectedRow(), 0).toString()));
				funcaoBll.excluir(funcao);
				JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
				jTblFuncoes.clearSelection();
				if (IntegerObject.isInteger(txtPesquisar.getText()))
					popularJTablePorId(Integer.valueOf(txtPesquisar.getText()), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
				else
					popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
			}
		}
		txtQtdPaginas.setText(String.valueOf(qtdPaginasJTable()));
		if (Integer.parseInt(txtQtdPaginas.getText()) == 0)
			txtPagina.setText("0");
	}
	
	private int getQtdCamposIncorretos(){
		int contador = 0;
		this.message = "";
		if (!estaCampoTextoPreenchido(txtFuncao, " - Preencha o campo função!\n"))
			contador++;
		
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
	
	private void preencherCampos(Funcao funcao){
		txtId.setText(String.valueOf(funcao.getIdFuncao()));
		txtFuncao.setText(funcao.getNomeFuncao());
		txtComissao.setText(String.valueOf(funcao.getComissaoFuncao()));
	}
	
	private void chamarFormCartao(){
		try{
			FormCartao window = new FormCartao();
			window.getFrmCartoes().setVisible(true);
			frmFuncao.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void chamarFormCliente(){
		try{
			FormCliente window = new FormCliente();
			window.getFrmClientes().setVisible(true);
			frmFuncao.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void chamarFormPrestadorDeServico(){
		try{
			FormPrestadorDeServico window = new FormPrestadorDeServico();
			window.getFrmPrestadorDeServico().setVisible(true);
			frmFuncao.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void chamarFormProduto(){
		try{
			FormProduto window = new FormProduto();
			window.getFrmProdutos().setVisible(true);
			frmFuncao.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void popularJTableCompleto(int qtdPorPagina, int numeroDaPagina) throws Exception{
		DefaultTableModel modeloTable = (DefaultTableModel) jTblFuncoes.getModel();
		List<Funcao> funcoes = funcaoBll.procuraFuncao(qtdPorPagina, numeroDaPagina);
		
		for (Funcao f : funcoes) {
            modeloTable.addRow(new Object[] { f.getIdFuncao(), f.getNomeFuncao(), f.getComissaoFuncao() });
        }
	}
	
	private void popularJTablePorId(int id, int qtdPorPagina, int numeroDaPagina) throws Exception{
		DefaultTableModel modeloTable = (DefaultTableModel) jTblFuncoes.getModel();
		Funcao f = funcaoBll.procuraFuncaoPorId(id);
		
		modeloTable.setNumRows(0);
		modeloTable.addRow(new Object[] { f.getIdFuncao(), f.getIdFuncao(), f.getComissaoFuncao() });
		txtPagina.setText(String.valueOf(numeroDaPagina));
	}
	
	private void popularJTablePorNome(String nome, int qtdPorPagina, int numeroDaPagina) throws Exception{
		DefaultTableModel modeloTable = (DefaultTableModel) jTblFuncoes.getModel();
		List<Funcao> funcoes = funcaoBll.procuraFuncaoPorNome(nome, qtdPorPagina, numeroDaPagina);
		
		modeloTable.setNumRows(0);
		
		for (Funcao f : funcoes) {
            modeloTable.addRow(new Object[] { f.getIdFuncao(), f.getNomeFuncao(), f.getComissaoFuncao() });
        }
		
		txtPagina.setText(String.valueOf(numeroDaPagina));
	}
	
	private void limparCampos(){
		txtId.setText(null);
		txtFuncao.setText(null);
		txtComissao.setText(null);
		txtFuncao.requestFocus();
	}
	
	private int qtdPaginasJTable() throws Exception{
		int qtdRegistros = funcaoBll.recordCount(txtPesquisar.getText());
		int qtdPaginas = qtdRegistros / Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString());
		if (qtdRegistros % Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()) > 0)
			qtdPaginas++;
		return qtdPaginas;
	}
	
	private void goToFirst(){
		try {
			if (Integer.valueOf(txtPagina.getText()) > 1){
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
	
	private void chamarRelatorio(){
		Thread chamarRelatorioThread = new Thread(){
			public void run(){
				try{
					if (IntegerObject.isInteger(txtPesquisar.getText()))
						Relatorio.chamarRelatorio(Integer.valueOf(txtPesquisar.getText()), "id", "tbl_funcao", "reports/funcaoreport.jrxml");
					else
						Relatorio.chamarRelatorio(txtPesquisar.getText(), "nomefuncao", "tbl_funcao", "reports/funcaoreport.jrxml");
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		};
		chamarRelatorioThread.start();
	}
}