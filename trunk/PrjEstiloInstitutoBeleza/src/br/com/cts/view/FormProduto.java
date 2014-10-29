package br.com.cts.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.List;

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

import br.com.cts.bll.ProdutoBLL;
import br.com.cts.model.Produto;
import br.com.cts.number.IntegerObject;
import br.com.cts.util.Relatorio;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class FormProduto extends JFrame{

	private JFrame frmProdutos;
	private JTextField txtNomeProduto;
	private JLabel lblNome;
	private JLabel lblCodigoBarras;
	private JTextField txtQtdEstoque;
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
	private JTable jTblProdutos;
	private JTextField txtId;
	private JTextField txtPesquisar;
	private JTextField txtPagina;
	private JTextField txtQtdPaginas;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JComboBox<String> cbQtdPorPagina;
	private ProdutoBLL produtoBll;
	private String message;

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
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public FormProduto() throws NumberFormatException, Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private void initialize() throws NumberFormatException, Exception {
		frmProdutos = new JFrame();
		frmProdutos.setTitle("Produtos");
		frmProdutos.setBounds(100, 100, 1121, 531);
		frmProdutos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProdutos.getContentPane().setLayout(null);
		//setar tamanho mínimo do formnulário
		frmProdutos.setMinimumSize(frmProdutos.getSize());
		
		//instânciar bll
		produtoBll = new ProdutoBLL();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Descri\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel.setBounds(12, 123, 530, 148);
		frmProdutos.getContentPane().add(panel);
		panel.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 2000, 21);
		frmProdutos.getContentPane().add(menuBar);
		
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
		
		lblCodigoBarras = new JLabel("Quantidade (Estoque):");
		lblCodigoBarras.setBounds(11, 60, 143, 14);
		panel.add(lblCodigoBarras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(545, 92, 539, 295);
		frmProdutos.getContentPane().add(scrollPane);
		
		jTblProdutos = new JTable();
		jTblProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(jTblProdutos);
		jTblProdutos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Produto", "Valor", "Valor para Venda", "Tipo de Unidade", "Quantidade (Estoque)"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jTblProdutos.getColumnModel().getColumn(0).setPreferredWidth(71);
		jTblProdutos.getColumnModel().getColumn(1).setPreferredWidth(172);
		jTblProdutos.getColumnModel().getColumn(2).setPreferredWidth(90);
		jTblProdutos.getColumnModel().getColumn(3).setPreferredWidth(94);
		jTblProdutos.getColumnModel().getColumn(5).setPreferredWidth(118);
		
		//Listener - Definir comportamento de seleção de item no JTable
		jTblProdutos.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
				Produto produto = new Produto();
				try {
					if (jTblProdutos.getSelectedRow() > -1){
						produto = produtoBll.procuraProdutoPorId(Integer.valueOf(jTblProdutos.getValueAt(jTblProdutos.getSelectedRow(), 0).toString()));
						btnSalvar.setText("Alterar");
						mntmSalvar.setText("Alterar");
						preencherCampos(produto);
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
		jTblProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//Instanciando DefaultTableCellRenderer para gerenciar JTable
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jTblProdutos.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(JLabel.LEFT);
		
		txtQtdEstoque = new JTextField();
		txtQtdEstoque.setBounds(10, 75, 499, 20);
		panel.add(txtQtdEstoque);
		txtQtdEstoque.setColumns(10);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ID", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel_1.setBounds(12, 50, 530, 69);
		frmProdutos.getContentPane().add(panel_1);
		
		JLabel label = new JLabel("ID:");
		label.setBounds(15, 22, 37, 14);
		panel_1.add(label);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(15, 36, 355, 20);
		panel_1.add(txtId);
		
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
		txtPesquisar.setBounds(545, 67, 363, 20);
		frmProdutos.getContentPane().add(txtPesquisar);
		
		JLabel label_1 = new JLabel("Pesquisar");
		label_1.setBounds(545, 50, 67, 14);
		frmProdutos.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("P\u00E1gina");
		label_2.setBounds(911, 50, 67, 14);
		frmProdutos.getContentPane().add(label_2);
		
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
		txtPagina.setBounds(911, 67, 85, 20);
		frmProdutos.getContentPane().add(txtPagina);
		
		JLabel label_3 = new JLabel("De");
		label_3.setBounds(999, 50, 57, 14);
		frmProdutos.getContentPane().add(label_3);
		
		txtQtdPaginas = new JTextField();
		txtQtdPaginas.setText("0");
		txtQtdPaginas.setEditable(false);
		txtQtdPaginas.setColumns(10);
		txtQtdPaginas.setBounds(999, 67, 85, 20);
		frmProdutos.getContentPane().add(txtQtdPaginas);
		
		btnNovo = new JButton("Novo");
		//Listener
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novo();
			}
		});
		btnNovo.setBounds(544, 387, 89, 23);
		frmProdutos.getContentPane().add(btnNovo);
		
		btnSalvar = new JButton("Salvar");
		//Listener
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarAlterar();
			}
		});
		btnSalvar.setBounds(632, 387, 89, 23);
		frmProdutos.getContentPane().add(btnSalvar);
		
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
		btnExcluir.setBounds(720, 387, 89, 23);
		frmProdutos.getContentPane().add(btnExcluir);
		
		cbQtdPorPagina = new JComboBox<String>();
		cbQtdPorPagina.setModel(new DefaultComboBoxModel<String>(new String[] {"10", "30", "50"}));
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
		cbQtdPorPagina.setBounds(811, 387, 55, 23);
		frmProdutos.getContentPane().add(cbQtdPorPagina);
		
		JButton btnFirst = new JButton("|<<");
		//Listener
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToFirst();
			}
		});
		btnFirst.setBounds(867, 387, 55, 23);
		frmProdutos.getContentPane().add(btnFirst);
		
		JButton btnPrevious = new JButton("<<");
		//Listener
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToPrevious();
			}
		});
		btnPrevious.setBounds(921, 387, 55, 23);
		frmProdutos.getContentPane().add(btnPrevious);
		
		JButton btnNext = new JButton(">>");
		//Listener
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToNext();
			}
		});
		btnNext.setBounds(975, 387, 55, 23);
		frmProdutos.getContentPane().add(btnNext);
		
		JButton btnLast = new JButton(">>|");
		//Listener
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToLast();
			}
		});
		btnLast.setBounds(1029, 387, 55, 23);
		frmProdutos.getContentPane().add(btnLast);
		
		//Popular JTable na inicialização do formulário, setar quantidade de páginas e página inicial
		popularJTableCompleto(Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
		txtQtdPaginas.setText(String.valueOf(qtdPaginasJTable()));
		if (Integer.valueOf(txtQtdPaginas.getText()) > 0)
			txtPagina.setText("1");
		else
			txtPagina.setText("0");
	}

	public JFrame getFrmProdutos() {
		return frmProdutos;
	}
	
	private void novo(){
		limparCampos();
		jTblProdutos.clearSelection();
		btnSalvar.setText("Salvar");
		mntmSalvar.setText("Salvar");
	}
	
	private void salvarAlterar(){
		try {
			Produto produto = new Produto();
			
			if (jTblProdutos.getSelectedRow() > -1)
				produto.setIdProduto(Integer.valueOf(jTblProdutos.getValueAt(jTblProdutos.getSelectedRow(), 0).toString()));
			produto.setNomeProduto(txtNomeProduto.getText());
			produto.setValorProduto(Float.parseFloat(txtValor.getText()));
			produto.setValorPraVendaProduto(Float.parseFloat(txtValorVenda.getText()));
			produto.setTipoUnidadeProduto(txtTipoUnidade.getText());
			produto.setQtdEstoqueProduto(Integer.parseInt(txtQtdEstoque.getText()));
			
			if (Integer.parseInt(txtPagina.getText()) == 0)
				txtPagina.setText("1");
			
			if (getQtdCamposIncorretos() < 1){
				if (btnSalvar.getText() == "Salvar"){
					produtoBll.salvar(produto);
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
						produtoBll.alterar(produto);
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
		if (jTblProdutos.getSelectedRow() > -1){
			int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja realmente excluir?","Excluir!", JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION){
				Produto produto = produtoBll.procuraProdutoPorId(Integer.valueOf(jTblProdutos.getValueAt(jTblProdutos.getSelectedRow(), 0).toString()));
				produtoBll.excluir(produto);
				JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
				jTblProdutos.clearSelection();
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
		if (!estaCampoTextoPreenchido(txtNomeProduto, " - Preencha o campo nome!\n"))
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
	
	private void preencherCampos(Produto produto){
		txtId.setText(String.valueOf(produto.getIdProduto()));
		txtNomeProduto.setText(produto.getNomeProduto());
		txtValor.setText(String.valueOf(produto.getValorProduto()));
		txtValorVenda.setText(String.valueOf(produto.getValorPraVendaProduto()));
		txtTipoUnidade.setText(produto.getTipoUnidadeProduto());
		txtQtdEstoque.setText(String.valueOf(produto.getQtdEstoqueProduto()));
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
	
	private void popularJTableCompleto(int qtdPorPagina, int numeroDaPagina) throws Exception{
		DefaultTableModel modeloTable = (DefaultTableModel) jTblProdutos.getModel();
		List<Produto> produtos = produtoBll.procuraProduto(qtdPorPagina, numeroDaPagina);
		
		for (Produto p : produtos) {
            modeloTable.addRow(new Object[] { p.getIdProduto(), p.getNomeProduto(), p.getValorProduto(), p.getValorPraVendaProduto(), p.getTipoUnidadeProduto(), p.getQtdEstoqueProduto() });
        }
	}
	
	private void popularJTablePorId(int id, int qtdPorPagina, int numeroDaPagina) throws Exception{
		DefaultTableModel modeloTable = (DefaultTableModel) jTblProdutos.getModel();
		Produto p = produtoBll.procuraProdutoPorId(id);
		
		modeloTable.setNumRows(0);
		modeloTable.addRow(new Object[] { p.getIdProduto(), p.getNomeProduto(), p.getValorProduto(), p.getValorPraVendaProduto(), p.getTipoUnidadeProduto(), p.getQtdEstoqueProduto() });
		txtPagina.setText(String.valueOf(numeroDaPagina));
	}
	
	private void popularJTablePorNome(String nome, int qtdPorPagina, int numeroDaPagina) throws Exception{
		DefaultTableModel modeloTable = (DefaultTableModel) jTblProdutos.getModel();
		List<Produto> produtos = produtoBll.procuraProdutoPorNome(nome, qtdPorPagina, numeroDaPagina);
		
		modeloTable.setNumRows(0);
		
		for (Produto p : produtos) {
			modeloTable.addRow(new Object[] { p.getIdProduto(), p.getNomeProduto(), p.getValorProduto(), p.getValorPraVendaProduto(), p.getTipoUnidadeProduto(), p.getQtdEstoqueProduto() });
        }
		
		txtPagina.setText(String.valueOf(numeroDaPagina));
	}
	
	private void limparCampos(){
		txtId.setText(null);
		txtNomeProduto.setText(null);
		txtValor.setText(null);
		txtValorVenda.setText(null);
		txtTipoUnidade.setText(null);
		txtQtdEstoque.setText(null);
		txtNomeProduto.requestFocus();
	}
	
	private int qtdPaginasJTable() throws Exception{
		int qtdRegistros = produtoBll.recordCount(txtPesquisar.getText());
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
						Relatorio.chamarRelatorio(Integer.valueOf(txtPesquisar.getText()), "id", "tbl_produto", "reports/produtoreport.jrxml");
					else
						Relatorio.chamarRelatorio(txtPesquisar.getText(), "nome", "tbl_produto", "reports/produtoreport.jrxml");
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		};
		chamarRelatorioThread.start();
	}
}