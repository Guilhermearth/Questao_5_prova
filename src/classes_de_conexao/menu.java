package classes_de_conexao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Voc\u00EA \u00E9:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(139, 11, 120, 31);
		contentPane.add(lblNewLabel);
		
		JButton pf = new JButton("Pessoa fisica");
		pf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cadastropf exibir = new cadastropf();
				exibir.setVisible(true);
				setVisible(false);
				
			}
		});
		pf.setFont(new Font("Tahoma", Font.BOLD, 15));
		pf.setBounds(124, 66, 154, 23);
		contentPane.add(pf);
		
		JButton PJ = new JButton("Pessoa Juridica");
		PJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cadastropj exibir = new cadastropj();
				exibir.setVisible(true);
				setVisible(false);
				
			}
		});
		PJ.setFont(new Font("Tahoma", Font.BOLD, 15));
		PJ.setBounds(124, 100, 154, 23);
		contentPane.add(PJ);
	}
}
