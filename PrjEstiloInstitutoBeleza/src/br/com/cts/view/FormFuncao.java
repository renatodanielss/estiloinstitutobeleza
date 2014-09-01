package br.com.cts.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
import javax.swing.DefaultComboBoxModel;

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
	 */
	public FormFuncao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFuncao = new JFrame();
		frmFuncao.setTitle("Fun\u00E7\u00F5es");
		frmFuncao.setBounds(100, 100, 1137, 498);
		frmFuncao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFuncao.getContentPane().setLayout(null);
		
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
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarFormCliente();
			}
		});
		
		mntmCartoes = new JMenuItem("Cart\u00F5es");
		mntmCartoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarFormCartao();
			}
		});
		mnIr.add(mntmCartoes);
		mnIr.add(mntmClientes);
		
		JMenuItem mntmPrestadoresDeServicos = new JMenuItem("Prestadores de Servi\u00E7os");
		mntmPrestadoresDeServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamarFormPrestadorDeServico();
			}
		});
		mnIr.add(mntmPrestadoresDeServicos);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
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
		txtPesquisar.setColumns(10);
		txtPesquisar.setBounds(547, 67, 363, 20);
		frmFuncao.getContentPane().add(txtPesquisar);
		
		JLabel label_2 = new JLabel("P\u00E1gina");
		label_2.setBounds(913, 50, 67, 14);
		frmFuncao.getContentPane().add(label_2);
		
		txtPagina = new JTextField();
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
				"ID", "Função", "Comissão"
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
		
		//aqui
		jTblFuncoes.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
				//Cliente cliente = new Cliente();
				try {
					if (jTblFuncoes.getSelectedRow() > -1){
						//cliente = clienteBll.procuraClientePorId(Integer.valueOf(jTblClientes.getValueAt(jTblClientes.getSelectedRow(), 0).toString()));
						btnSalvar.setText("Alterar");
						mntmSalvar.setText("Alterar");
						//preencherCampos(cliente);
					}
					else{
						btnSalvar.setText("Salvar");
						mntmSalvar.setText("Salvar");
						//limparCampos();
					}
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	        }
	    });
		jTblFuncoes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jTblFuncoes.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(JLabel.LEFT);
		
		
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novo();
			}
		});
		btnNovo.setBounds(545, 387, 89, 23);
		frmFuncao.getContentPane().add(btnNovo);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarAlterar();
			}
		});
		btnSalvar.setBounds(633, 387, 89, 23);
		frmFuncao.getContentPane().add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnExcluir.setBounds(721, 387, 89, 23);
		frmFuncao.getContentPane().add(btnExcluir);
		
		JComboBox<String> cbQtdPorPagina = new JComboBox<String>();
		cbQtdPorPagina.setModel(new DefaultComboBoxModel<String>(new String[] {"10", "30", "50"}));
		cbQtdPorPagina.setBounds(812, 387, 55, 23);
		frmFuncao.getContentPane().add(cbQtdPorPagina);
		
		JButton btnFirst = new JButton("|<<");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToFirst();
			}
		});
		btnFirst.setBounds(868, 387, 55, 23);
		frmFuncao.getContentPane().add(btnFirst);
		
		JButton btnPrevious = new JButton("<<");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToPrevious();
			}
		});
		btnPrevious.setBounds(922, 387, 55, 23);
		frmFuncao.getContentPane().add(btnPrevious);
		
		JButton btnNext = new JButton(">>");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToNext();
			}
		});
		btnNext.setBounds(976, 387, 55, 23);
		frmFuncao.getContentPane().add(btnNext);
		
		JButton btnLast = new JButton(">>|");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToLast();
			}
		});
		btnLast.setBounds(1030, 387, 55, 23);
		frmFuncao.getContentPane().add(btnLast);
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
		
	}
	
	private void excluir(){
		
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
	
	private void limparCampos(){
		txtId.setText(null);
		txtFuncao.setText(null);
		txtComissao.setText(null);
		txtFuncao.requestFocus();
	}
	
	private void goToFirst(){
		
	}
	
	private void goToPrevious(){
		
	}

	private void goToNext(){
	
	}

	private void goToLast(){
	
	}
}