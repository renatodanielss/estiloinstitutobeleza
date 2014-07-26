package br.com.cts.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class FormCliente {

	private JFrame frmClientes;
	private JTextField textField;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenuItem mntmNovo;

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
	 */
	public FormCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClientes = new JFrame();
		frmClientes.setTitle("Clientes");
		frmClientes.setBounds(100, 100, 1032, 424);
		frmClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setBounds(99, 36, 86, 20);
		textField.setColumns(10);
		
		JButton btnTeste = new JButton("Teste");
		btnTeste.setBounds(99, 67, 77, 23);
		btnTeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmClientes.getContentPane().setLayout(null);
		frmClientes.getContentPane().add(textField);
		frmClientes.getContentPane().add(btnTeste);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1016, 21);
		frmClientes.getContentPane().add(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		mntmNovo = new JMenuItem("Novo");
		mnArquivo.add(mntmNovo);
	}
}
