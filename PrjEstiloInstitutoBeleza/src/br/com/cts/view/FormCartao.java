package br.com.cts.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

import br.com.cts.bll.BandeiraBLL;
import br.com.cts.bll.CartaoBLL;
import br.com.cts.model.Bandeira;
import br.com.cts.model.Cartao;
import br.com.cts.number.IntegerObject;
import br.com.cts.util.Relatorio;

@SuppressWarnings("serial")
public class FormCartao extends JFrame{

	private JFrame frmCartoes;
	private static FormCartao instancia;
	private JTextField txtNome;
	private JComboBox<String> cbBandeira;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenuItem mntmNovo;
	private JMenuItem mntmSalvar;
	private JMenu mnIr;
	private JPanel panel_1;
	private JLabel label;
	private JTextField txtId;
	private JMenuItem mntmFuncoes;
	private JTextField txtPesquisar;
	private JTextField txtPagina;
	private JTextField txtQtdPaginas;
	private JTable jTblCartoes;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JComboBox<String> cbQtdPorPagina;
	private CartaoBLL cartaoBll;
	private String message;
	private JLabel lblDesconto;
	private JTextField txtPorcentagemDesconto;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					instancia = new FormCartao();
					instancia.frmCartoes.setVisible(true);
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
	public FormCartao() throws NumberFormatException, Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private void initialize() throws NumberFormatException, Exception {
		frmCartoes = new JFrame();
		frmCartoes.setTitle("Cart\u00F5es");
		frmCartoes.setBounds(100, 100, 1137, 498);
		frmCartoes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCartoes.getContentPane().setLayout(null);
		//setar tamanho mínimo do formnulário
		frmCartoes.setMinimumSize(frmCartoes.getSize());
		
		//instânciar bll
		cartaoBll = new CartaoBLL();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Descri\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel.setBounds(12, 120, 530, 108);
		frmCartoes.getContentPane().add(panel);
		panel.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 2000, 21);
		frmCartoes.getContentPane().add(menuBar);
		
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
		mnIr.add(mntmClientes);
		
		JMenuItem mntmPrestadoresDeServicos = new JMenuItem("Prestadores de Servi\u00E7os");
		
		//Listener
		mntmPrestadoresDeServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarFormPrestadorDeServico();
			}
		});
		
		mntmFuncoes = new JMenuItem("Fun\u00E7\u00F5es");
		
		//Listener
		mntmFuncoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarFormFuncao();
			}
		});
		mnIr.add(mntmFuncoes);
		mnIr.add(mntmPrestadoresDeServicos);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		
		//Listener
		mntmProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarFormProduto();
			}
		});
		mnIr.add(mntmProdutos);
		
		JLabel lblFuncao = new JLabel("Cart\u00E3o:");
		lblFuncao.setBounds(15, 22, 66, 14);
		panel.add(lblFuncao);
		
		txtNome = new JTextField();
		txtNome.setBounds(15, 36, 505, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblBandeira = new JLabel("Bandeira:");
		lblBandeira.setBounds(15, 60, 66, 14);
		panel.add(lblBandeira);
		
		cbBandeira = new JComboBox<String>();
		cbBandeira.setBounds(15, 74, 245, 20);
		panel.add(cbBandeira);
		
		JButton btnAdicionarBandeira = new JButton("Adicionar");
		btnAdicionarBandeira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarAdicionarBandeira();
			}
		});
		btnAdicionarBandeira.setBounds(260, 74, 89, 20);
		panel.add(btnAdicionarBandeira);
		
		lblDesconto = new JLabel("Desconto (%):");
		lblDesconto.setBounds(350, 60, 89, 14);
		panel.add(lblDesconto);
		
		txtPorcentagemDesconto = new JTextField();
		txtPorcentagemDesconto.setColumns(10);
		txtPorcentagemDesconto.setBounds(350, 74, 170, 21);
		panel.add(txtPorcentagemDesconto);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ID", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel_1.setBounds(12, 50, 530, 69);
		frmCartoes.getContentPane().add(panel_1);
		
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
		frmCartoes.getContentPane().add(label_1);
		
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
		frmCartoes.getContentPane().add(txtPesquisar);
		
		JLabel label_2 = new JLabel("P\u00E1gina");
		label_2.setBounds(913, 50, 67, 14);
		frmCartoes.getContentPane().add(label_2);
		
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
		frmCartoes.getContentPane().add(txtPagina);
		
		JLabel label_3 = new JLabel("De");
		label_3.setBounds(1001, 50, 57, 14);
		frmCartoes.getContentPane().add(label_3);
		
		txtQtdPaginas = new JTextField();
		txtQtdPaginas.setEditable(false);
		txtQtdPaginas.setColumns(10);
		txtQtdPaginas.setBounds(1001, 67, 85, 20);
		frmCartoes.getContentPane().add(txtQtdPaginas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(545, 92, 541, 295);
		frmCartoes.getContentPane().add(scrollPane);
		
		jTblCartoes = new JTable();
		jTblCartoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(jTblCartoes);
		jTblCartoes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Cart\u00E3o", "Bandeira", "Desconto (%)"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jTblCartoes.getColumnModel().getColumn(1).setPreferredWidth(223);
		jTblCartoes.getColumnModel().getColumn(2).setPreferredWidth(131);
		jTblCartoes.getColumnModel().getColumn(3).setPreferredWidth(108);
		
		//Listener - Definir comportamento de seleção de item no JTable
		jTblCartoes.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
				Cartao cartao = new Cartao();
				try {
					if (jTblCartoes.getSelectedRow() > -1){
						cartao = cartaoBll.procuraCartaoPorId(Integer.valueOf(jTblCartoes.getValueAt(jTblCartoes.getSelectedRow(), 0).toString()));
						btnSalvar.setText("Alterar");
						mntmSalvar.setText("Alterar");
						preencherCampos(cartao);
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
		jTblCartoes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//Instanciando DefaultTableCellRenderer para gerenciar JTable
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jTblCartoes.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(JLabel.LEFT);
		
		btnNovo = new JButton("Novo");
		
		//Listener
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novo();
			}
		});
		btnNovo.setBounds(545, 387, 89, 23);
		frmCartoes.getContentPane().add(btnNovo);
		
		btnSalvar = new JButton("Salvar");
		
		//Listener
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarAlterar();
			}
		});
		btnSalvar.setBounds(633, 387, 89, 23);
		frmCartoes.getContentPane().add(btnSalvar);
		
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
		frmCartoes.getContentPane().add(btnExcluir);
		
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
		frmCartoes.getContentPane().add(cbQtdPorPagina);
		
		JButton btnFirst = new JButton("|<<");
		
		//Listener
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToFirst();
			}
		});
		btnFirst.setBounds(868, 387, 55, 23);
		frmCartoes.getContentPane().add(btnFirst);
		
		JButton btnPrevious = new JButton("<<");
		
		//Listener
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToPrevious();
			}
		});
		btnPrevious.setBounds(922, 387, 55, 23);
		frmCartoes.getContentPane().add(btnPrevious);
		
		JButton btnNext = new JButton(">>");
		
		//Listener
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToNext();
			}
		});
		btnNext.setBounds(976, 387, 55, 23);
		frmCartoes.getContentPane().add(btnNext);
		
		JButton btnLast = new JButton(">>|");
		
		//Listener
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToLast();
			}
		});
		btnLast.setBounds(1030, 387, 55, 23);
		frmCartoes.getContentPane().add(btnLast);
		
		popularCbBandeira();
		
		//Popular JTable na inicialização do formulário, setar quantidade de páginas e página inicial
		popularJTableCompleto(Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
		txtQtdPaginas.setText(String.valueOf(qtdPaginasJTable()));
		if (Integer.valueOf(txtQtdPaginas.getText()) > 0)
			txtPagina.setText("1");
		else
			txtPagina.setText("0");
	}
	
	public JFrame getFrmCartoes() {
		return frmCartoes;
	}

	private void novo(){
		limparCampos();
		jTblCartoes.clearSelection();
		btnSalvar.setText("Salvar");
		mntmSalvar.setText("Salvar");
	}
	
	private void salvarAlterar(){
		try {
			Cartao cartao = new Cartao();
			
			if (jTblCartoes.getSelectedRow() > -1)
				cartao.setIdCartao(Integer.valueOf(jTblCartoes.getValueAt(jTblCartoes.getSelectedRow(), 0).toString()));
			cartao.setNomeCartao(txtNome.getText());
			cartao.setBandeiraCartao(cbBandeira.getSelectedItem().toString());
			cartao.setPocentagemDescontoCartao(Float.valueOf(txtPorcentagemDesconto.getText()));
			
			if (Integer.parseInt(txtPagina.getText()) == 0)
				txtPagina.setText("1");
			
			if (getQtdCamposIncorretos() < 1){
				if (btnSalvar.getText() == "Salvar"){
					cartaoBll.salvar(cartao);
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
						cartaoBll.alterar(cartao);
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
		if (jTblCartoes.getSelectedRow() > -1){
			int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja realmente excluir?","Excluir!", JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION){
				Cartao cartao = cartaoBll.procuraCartaoPorId(Integer.valueOf(jTblCartoes.getValueAt(jTblCartoes.getSelectedRow(), 0).toString()));
				cartaoBll.excluir(cartao);
				JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
				jTblCartoes.clearSelection();
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
		if (!estaCampoTextoPreenchido(txtNome, " - Preencha o campo função!\n"))
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
	
	private void preencherCampos(Cartao cartao){
		txtId.setText(String.valueOf(cartao.getIdCartao()));
		txtNome.setText(cartao.getNomeCartao());
		cbBandeira.setSelectedItem(cartao.getBandeiraCartao());
		txtPorcentagemDesconto.setText(String.valueOf(cartao.getPocentagemDescontoCartao()));
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
	
	private void chamarAdicionarBandeira(){
		try{
			FormBandeira window = new FormBandeira();
			window.setTitle("Alterar");
			window.getFrmBandeira().setTitle("Bandeiras - Alterar");
			window.getFrmBandeira().setVisible(true);
			frmCartoes.setEnabled(false);
		}catch(Exception e){
			e.printStackTrace();
		}
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
	
	private void popularJTableCompleto(int qtdPorPagina, int numeroDaPagina) throws Exception{
		DefaultTableModel modeloTable = (DefaultTableModel) jTblCartoes.getModel();
		List<Cartao> cartoes = cartaoBll.procuraCartao(qtdPorPagina, numeroDaPagina);
		
		for (Cartao cartao : cartoes) {
            modeloTable.addRow(new Object[] { cartao.getIdCartao(), cartao.getNomeCartao(), cartao.getBandeiraCartao(), cartao.getPocentagemDescontoCartao() });
        }
	}
	
	private void popularJTablePorId(int id, int qtdPorPagina, int numeroDaPagina) throws Exception{
		DefaultTableModel modeloTable = (DefaultTableModel) jTblCartoes.getModel();
		Cartao cartao = cartaoBll.procuraCartaoPorId(id);
		
		modeloTable.setNumRows(0);
		modeloTable.addRow(new Object[] { cartao.getIdCartao(), cartao.getNomeCartao(), cartao.getBandeiraCartao(), cartao.getPocentagemDescontoCartao() });
		txtPagina.setText(String.valueOf(numeroDaPagina));
	}
	
	private void popularJTablePorNome(String nome, int qtdPorPagina, int numeroDaPagina) throws Exception{
		DefaultTableModel modeloTable = (DefaultTableModel) jTblCartoes.getModel();
		List<Cartao> cartoes = cartaoBll.procuraCartaoPorNome(nome, qtdPorPagina, numeroDaPagina);
		
		modeloTable.setNumRows(0);
		
		for (Cartao cartao : cartoes) {
            modeloTable.addRow(new Object[] { cartao.getIdCartao(), cartao.getNomeCartao(), cartao.getBandeiraCartao(), cartao.getPocentagemDescontoCartao() });
        }
		
		txtPagina.setText(String.valueOf(numeroDaPagina));
	}
	
	private void limparCampos(){
		txtId.setText(null);
		txtNome.setText(null);
		cbBandeira.setSelectedIndex(-1);
		txtPorcentagemDesconto.setText(null);
		txtNome.requestFocus();
	}
	
	private int qtdPaginasJTable() throws Exception{
		int qtdRegistros = cartaoBll.recordCount(txtPesquisar.getText());
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
						Relatorio.chamarRelatorio(Integer.valueOf(txtPesquisar.getText()), "id", "tbl_cartao", "reports/cartaoreport.jrxml");
					else
						Relatorio.chamarRelatorio(txtPesquisar.getText(), "nomecartao", "tbl_cartao", "reports/cartaoreport.jrxml");
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		};
		chamarRelatorioThread.start();
	}
	
	public static synchronized FormCartao getInstance() throws NumberFormatException, Exception{
		if (instancia == null)
			instancia = new FormCartao();
		return instancia;
	}
	
	public void popularCbBandeira() throws Exception{
		cbBandeira.removeAllItems();
		cbBandeira.addItem("");
		BandeiraBLL bandeiraBll = new BandeiraBLL();
		List<Bandeira> bandeiras = bandeiraBll.procuraBandeiraPorNome("", bandeiraBll.recordCount(), 1);
		
		for(Bandeira bandeira : bandeiras)
			cbBandeira.addItem(bandeira.getNomeBandeira());
	}
}