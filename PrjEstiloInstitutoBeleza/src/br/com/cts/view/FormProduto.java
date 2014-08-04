package br.com.cts.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormProduto {

	private JFrame frmProdutos;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_4;

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
	 */
	public FormProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProdutos = new JFrame();
		frmProdutos.setTitle("Produtos");
		frmProdutos.setBounds(100, 100, 634, 273);
		frmProdutos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProdutos.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Descri\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panel.setBounds(10, 38, 530, 148);
		frmProdutos.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 38, 285, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(11, 24, 46, 14);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("C\u00F3digo de Barras:");
		lblNewLabel_1.setBounds(11, 60, 119, 14);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 75, 499, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(305, 38, 204, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Tipo de Unidade: ");
		lblNewLabel_2.setBounds(305, 24, 101, 14);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Valor:");
		lblNewLabel_3.setBounds(11, 99, 46, 14);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 113, 252, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(272, 113, 237, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Valor de Venda:");
		lblNewLabel_4.setBounds(273, 99, 95, 14);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(22, 195, 89, 23);
		frmProdutos.getContentPane().add(btnNewButton);
	}
}
