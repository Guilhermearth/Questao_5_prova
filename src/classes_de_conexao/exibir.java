package classes_de_conexao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class exibir extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable dados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					exibir frame = new exibir();
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
	public exibir() {
		setTitle("Pessoas cadastradas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Todos cadastrados");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(126, 11, 201, 19);
		contentPane.add(lblNewLabel);
		
		JButton btlistar = new JButton("Listar");
		btlistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = conexao.faz_conexao();
					
					String sql ="select *from banco_q4.usuario";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel modelo = (DefaultTableModel)dados.getModel();
					modelo.setNumRows(0);
					
					while (rs.next()) {
					
						modelo.addRow(new Object[] {rs.getString("nome"), rs.getString("endereco"), rs.getString("cep"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cpf"), rs.getString("rg"), rs.getString("cnpj")});
						
					}
					
					rs.close();
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btlistar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btlistar.setBounds(172, 231, 89, 23);
		contentPane.add(btlistar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 414, 179);
		contentPane.add(scrollPane);
		
		dados = new JTable();
		dados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Endere\u00E7o", "CEP", "cidade", "Estado", "CPF", "RG", "CNPJ"
			}
		));
		scrollPane.setViewportView(dados);
	}

}
