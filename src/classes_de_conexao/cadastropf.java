package classes_de_conexao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class cadastropf extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cpf;
	private JTextField rg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastropf frame = new cadastropf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public cadastropf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Qual o seu:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(150, 11, 123, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 60, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		cpf = new JTextField();
		cpf.setBounds(52, 59, 182, 20);
		contentPane.add(cpf);
		cpf.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("RG");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 98, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		rg = new JTextField();
		rg.setBounds(52, 97, 182, 20);
		contentPane.add(rg);
		rg.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cpf.getText().equals("") || rg.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Usuario e senha em branco");
			}else {
			
			try {
				Connection con = conexao.faz_conexao();
				String sql = "insert into banco_q4.usuario(cpf, rg) value(?, ?)";
				
				PreparedStatement stmt = con.prepareStatement(sql);
				
				stmt.setString(1, cpf.getText());
				stmt.setString(2, rg.getText());
				
				stmt.execute();
				
				
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
				exibir exibir = new exibir();
				exibir.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(104, 128, 89, 23);
		contentPane.add(btnNewButton);
	}

}
