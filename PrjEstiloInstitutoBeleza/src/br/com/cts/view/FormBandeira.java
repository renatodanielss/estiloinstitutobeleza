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
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.com.cts.bll.BandeiraBLL;
import br.com.cts.model.Bandeira;
import br.com.cts.number.IntegerObject;
import br.com.cts.util.Relatorio;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class FormBandeira extends JFrame{

	private JFrame frmBandeira;
	private JTextField txtNome;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenuItem mntmNovo;
	private JMenuItem mntmSalvar;
	private JMenu mnIr;
	private JMenuItem mntmCartoes;
	private JTextField txtPesquisar;
	private JTextField txtPagina;
	private JTextField txtQtdPaginas;
	private JTable jTblBandeiras;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JComboBox<String> cbQtdPorPagina;
	private BandeiraBLL bandeiraBll;
	private String message;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBandeira window = new FormBandeira();
					window.frmBandeira.setVisible(true);
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
	public FormBandeira() throws NumberFormatException, Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private void initialize() throws NumberFormatException, Exception {
		frmBandeira = new JFrame();
		frmBandeira.setTitle("Bandeiras");
		frmBandeira.setBounds(100, 100, 1137, 498);
		frmBandeira.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmBandeira.getContentPane().setLayout(null);
		//setar tamanho mínimo do formnulário
		frmBandeira.setMinimumSize(frmBandeira.getSize());
		
		//instânciar bll
		bandeiraBll = new BandeiraBLL();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Descri\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel.setBounds(12, 50, 530, 69);
		frmBandeira.getContentPane().add(panel);
		panel.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 2000, 21);
		frmBandeira.getContentPane().add(menuBar);
		
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
				try {
					salvarAlterar();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
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
		
		JLabel lblFuncao = new JLabel("Bandeira:");
		lblFuncao.setBounds(15, 22, 66, 14);
		panel.add(lblFuncao);
		
		txtNome = new JTextField();
		txtNome.setBounds(15, 36, 505, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel label_1 = new JLabel("Pesquisar");
		label_1.setBounds(547, 50, 67, 14);
		frmBandeira.getContentPane().add(label_1);
		
		txtPesquisar = new JTextField();
		
		//Listener
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 10){
					try {
						if (IntegerObject.isInteger(txtPesquisar.getText())){
							popularJTablePorId(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
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
		frmBandeira.getContentPane().add(txtPesquisar);
		
		JLabel label_2 = new JLabel("P\u00E1gina");
		label_2.setBounds(913, 50, 67, 14);
		frmBandeira.getContentPane().add(label_2);
		
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
									popularJTablePorId(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtPagina.getText()));
								else
									popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtPagina.getText()));
								txtQtdPaginas.setText(String.valueOf(qtdPaginasJTable()));
							}
							else{
								if (IntegerObject.isInteger(txtPesquisar.getText()))
									popularJTablePorId(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
								else
									popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
							}
						}
						else{
							if (IntegerObject.isInteger(txtPesquisar.getText()))
								popularJTablePorId(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtQtdPaginas.getText()));
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
		frmBandeira.getContentPane().add(txtPagina);
		
		JLabel label_3 = new JLabel("De");
		label_3.setBounds(1001, 50, 57, 14);
		frmBandeira.getContentPane().add(label_3);
		
		txtQtdPaginas = new JTextField();
		txtQtdPaginas.setEditable(false);
		txtQtdPaginas.setColumns(10);
		txtQtdPaginas.setBounds(1001, 67, 85, 20);
		frmBandeira.getContentPane().add(txtQtdPaginas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(545, 92, 541, 295);
		frmBandeira.getContentPane().add(scrollPane);
		
		jTblBandeiras = new JTable();
		jTblBandeiras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(jTblBandeiras);
		jTblBandeiras.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bandeira"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jTblBandeiras.getColumnModel().getColumn(0).setPreferredWidth(538);
		
		//Listener - Definir comportamento de seleção de item no JTable
		jTblBandeiras.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
				Bandeira bandeira = new Bandeira();
				try {
					if (jTblBandeiras.getSelectedRow() > -1){
						bandeira = bandeiraBll.procuraBandeiraPorId(jTblBandeiras.getValueAt(jTblBandeiras.getSelectedRow(), 0).toString());
						btnSalvar.setText("Alterar");
						mntmSalvar.setText("Alterar");
						preencherCampos(bandeira);
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
		jTblBandeiras.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//Instanciando DefaultTableCellRenderer para gerenciar JTable
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jTblBandeiras.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(JLabel.LEFT);
		
		btnNovo = new JButton("Novo");
		
		//Listener
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novo();
			}
		});
		btnNovo.setBounds(545, 387, 89, 23);
		frmBandeira.getContentPane().add(btnNovo);
		
		btnSalvar = new JButton("Salvar");
		
		//Listener
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					salvarAlterar();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(633, 387, 89, 23);
		frmBandeira.getContentPane().add(btnSalvar);
		
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
		frmBandeira.getContentPane().add(btnExcluir);
		
		cbQtdPorPagina = new JComboBox<String>();
		
		//Listener
		cbQtdPorPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (IntegerObject.isInteger(txtPesquisar.getText())){
						popularJTablePorId(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
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
		frmBandeira.getContentPane().add(cbQtdPorPagina);
		
		JButton btnFirst = new JButton("|<<");
		
		//Listener
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToFirst();
			}
		});
		btnFirst.setBounds(868, 387, 55, 23);
		frmBandeira.getContentPane().add(btnFirst);
		
		JButton btnPrevious = new JButton("<<");
		
		//Listener
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToPrevious();
			}
		});
		btnPrevious.setBounds(922, 387, 55, 23);
		frmBandeira.getContentPane().add(btnPrevious);
		
		JButton btnNext = new JButton(">>");
		
		//Listener
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToNext();
			}
		});
		btnNext.setBounds(976, 387, 55, 23);
		frmBandeira.getContentPane().add(btnNext);
		
		JButton btnLast = new JButton(">>|");
		
		//Listener
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToLast();
			}
		});
		btnLast.setBounds(1030, 387, 55, 23);
		frmBandeira.getContentPane().add(btnLast);
		
		frmBandeira.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (estaAlterandoCartao()){
					try {
						FormCartao.getInstance().popularCbBandeira();
						FormCartao.getInstance().getFrmCartoes().setEnabled(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		//Popular JTable na inicialização do formulário, setar quantidade de páginas e página inicial
		popularJTableCompleto(Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
		txtQtdPaginas.setText(String.valueOf(qtdPaginasJTable()));
		if (Integer.valueOf(txtQtdPaginas.getText()) > 0)
			txtPagina.setText("1");
		else
			txtPagina.setText("0");
	}
	
	public JFrame getFrmBandeira() {
		return frmBandeira;
	}

	private void novo(){
		limparCampos();
		jTblBandeiras.clearSelection();
		btnSalvar.setText("Salvar");
		mntmSalvar.setText("Salvar");
	}
	
	private void salvarAlterar() throws Exception{
		Bandeira bandeiraNula = bandeiraBll.procuraBandeiraPorId(txtNome.getText());
		Bandeira bandeira = new Bandeira();
		try {
			String novoNome = "";
			
			if (jTblBandeiras.getSelectedRow() > -1){
				bandeira.setNomeBandeira(jTblBandeiras.getValueAt(jTblBandeiras.getSelectedRow(), 0).toString());
				novoNome = txtNome.getText();
			}
			else
				bandeira.setNomeBandeira(txtNome.getText());
			
			if (Integer.parseInt(txtPagina.getText()) == 0)
				txtPagina.setText("1");
			
			if (getQtdCamposIncorretos() < 1){
				if (btnSalvar.getText() == "Salvar"){
					if (bandeiraNula == null){
						bandeiraBll.salvar(bandeira);
						JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
						if (IntegerObject.isInteger(txtPesquisar.getText()))
							popularJTablePorId(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtPagina.getText()));
						else
							popularJTablePorNome(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtPagina.getText()));
						limparCampos();
					}
					else
						JOptionPane.showMessageDialog(null, "Não foi possível efetuar o cadastro, bandeira já está cadastrada!");
				}
				else{
					int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja confirmar as alterações?","Alterar!", JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
						bandeiraBll.alterar(bandeira, novoNome);
						JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
						if (IntegerObject.isInteger(txtPesquisar.getText()))
							popularJTablePorId(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), Integer.valueOf(txtPagina.getText()));
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
		
		if (estaAlterandoCartao()){
			FormCartao.getInstance().popularCbBandeira();
			FormCartao.getInstance().getFrmCartoes().setEnabled(true);
			frmBandeira.setVisible(false);
		}
	}
	
	private void excluir() throws NumberFormatException, Exception{
		if (jTblBandeiras.getSelectedRow() > -1){
			int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja realmente excluir?","Excluir!", JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION){
				Bandeira bandeira = bandeiraBll.procuraBandeiraPorId(jTblBandeiras.getValueAt(jTblBandeiras.getSelectedRow(), 0).toString());
				bandeiraBll.excluir(bandeira);
				JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
				jTblBandeiras.clearSelection();
				if (IntegerObject.isInteger(txtPesquisar.getText()))
					popularJTablePorId(txtPesquisar.getText(), Integer.valueOf(cbQtdPorPagina.getSelectedItem().toString()), 1);
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
	
	private void preencherCampos(Bandeira bandeira){
		txtNome.setText(bandeira.getNomeBandeira());
	}
	
	private void chamarFormCartao(){
		try{
			FormCartao window = new FormCartao();
			window.getFrmCartoes().setVisible(true);
			frmBandeira.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void chamarFormCliente(){
		try{
			FormCliente window = new FormCliente();
			window.getFrmClientes().setVisible(true);
			frmBandeira.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void chamarFormPrestadorDeServico(){
		try{
			FormPrestadorDeServico window = new FormPrestadorDeServico();
			window.getFrmPrestadorDeServico().setVisible(true);
			frmBandeira.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void chamarFormProduto(){
		try{
			FormProduto window = new FormProduto();
			window.getFrmProdutos().setVisible(true);
			frmBandeira.setVisible(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void popularJTableCompleto(int qtdPorPagina, int numeroDaPagina) throws Exception{
		DefaultTableModel modeloTable = (DefaultTableModel) jTblBandeiras.getModel();
		List<Bandeira> bandeiras = bandeiraBll.procuraBandeira(qtdPorPagina, numeroDaPagina);
		
		for (Bandeira bandeira : bandeiras) {
            modeloTable.addRow(new Object[] { bandeira.getNomeBandeira() });
        }
	}
	
	private void popularJTablePorId(String id, int qtdPorPagina, int numeroDaPagina) throws Exception{
		DefaultTableModel modeloTable = (DefaultTableModel) jTblBandeiras.getModel();
		Bandeira bandeira = bandeiraBll.procuraBandeiraPorId(id);
		
		modeloTable.setNumRows(0);
		modeloTable.addRow(new Object[] { bandeira.getNomeBandeira() });
		txtPagina.setText(String.valueOf(numeroDaPagina));
	}
	
	private void popularJTablePorNome(String nome, int qtdPorPagina, int numeroDaPagina) throws Exception{
		DefaultTableModel modeloTable = (DefaultTableModel) jTblBandeiras.getModel();
		List<Bandeira> bandeiras = bandeiraBll.procuraBandeiraPorNome(nome, qtdPorPagina, numeroDaPagina);
		
		modeloTable.setNumRows(0);
		
		for (Bandeira bandeira : bandeiras) {
            modeloTable.addRow(new Object[] { bandeira.getNomeBandeira() });
        }
		
		txtPagina.setText(String.valueOf(numeroDaPagina));
	}
	
	private void limparCampos(){
		txtNome.setText(null);
		txtNome.requestFocus();
	}
	
	private int qtdPaginasJTable() throws Exception{
		int qtdRegistros = bandeiraBll.recordCount(txtPesquisar.getText());
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
						Relatorio.chamarRelatorio(Integer.valueOf(txtPesquisar.getText()), "id", "tbl_bandeira", "reports/bandeirareport.jrxml");
					else
						Relatorio.chamarRelatorio(txtPesquisar.getText(), "nomebandeira", "tbl_bandeira", "reports/bandeirareport.jrxml");
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		};
		chamarRelatorioThread.start();
	}
	
	private boolean estaAlterandoCartao(){
		if (frmBandeira.getTitle().equals("Bandeiras - Alterar"))
			return true;
		return false;
	}
}