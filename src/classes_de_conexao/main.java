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

public class main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField endereco;
	private JTextField cep;
	private JTextField cidade;
	private JTextField estado;

	/**
	 * Launch the application.
	 */
	public main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setTitle("Cadastro de pessoas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(128, 11, 147, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(28, 81, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Endere\u00E7o");
		lblNewLabel_2.setBounds(28, 106, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CEP");
		lblNewLabel_3.setBounds(28, 132, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cidade");
		lblNewLabel_4.setBounds(28, 157, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Estado");
		lblNewLabel_5.setBounds(28, 182, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		nome = new JTextField();
		nome.setBounds(84, 78, 219, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		endereco = new JTextField();
		endereco.setBounds(84, 103, 219, 20);
		contentPane.add(endereco);
		endereco.setColumns(10);
		
		cep = new JTextField();
		cep.setBounds(84, 129, 126, 20);
		contentPane.add(cep);
		cep.setColumns(10);
		
		cidade = new JTextField();
		cidade.setBounds(84, 154, 126, 20);
		contentPane.add(cidade);
		cidade.setColumns(10);
		
		estado = new JTextField();
		estado.setBounds(84, 179, 126, 20);
		contentPane.add(estado);
		estado.setColumns(10);
		
		JButton btsalvar = new JButton("Salvar");
		btsalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(nome.getText().equals("") || endereco.getText().equals("") || cep.getText().equals("") || cidade.getText().equals("") || estado.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Usuario e senha em branco");
			}else {
			
			try {
				Connection con = conexao.faz_conexao();
				String sql = "insert into banco_q4.usuario(nome, endereco, cep, cidade, estado) value(?, ?, ?, ?, ?)";
				
				PreparedStatement stmt = con.prepareStatement(sql);
				
				stmt.setString(1, nome.getText());
				stmt.setString(2, endereco.getText());
				stmt.setString(3, cep.getText());
				stmt.setString(4, cidade.getText());
				stmt.setString(5, estado.getText());
				
				stmt.execute();
				
				
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Pessoa cadastrada");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
				
				menu exibir = new menu();
				exibir.setVisible(true);
				setVisible(false);
				
			}
		});
		btsalvar.setBounds(155, 210, 89, 23);
		contentPane.add(btsalvar);
	}
}
