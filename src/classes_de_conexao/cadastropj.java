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

public class cadastropj extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cnpj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastropj frame = new cadastropj();
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
	public cadastropj() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Qual \u00E9 ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(183, 11, 70, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CNPJ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 75, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		cnpj = new JTextField();
		cnpj.setBounds(66, 74, 157, 20);
		contentPane.add(cnpj);
		cnpj.setColumns(10);
		
		JButton avancar = new JButton("Avan\u00E7ar");
		avancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cnpj.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Usuario e senha em branco");
			}else {
			
			try {
				Connection con = conexao.faz_conexao();
				String sql = "insert into banco_q4.usuario(cnpj) value(?)";
				
				PreparedStatement stmt = con.prepareStatement(sql);
				
				stmt.setString(1, cnpj.getText());
				
				stmt.execute();
				
				
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "cnpj cadastrado com sucesso");
				
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
		avancar.setFont(new Font("Tahoma", Font.BOLD, 13));
		avancar.setBounds(97, 121, 89, 23);
		contentPane.add(avancar);
	}

}
