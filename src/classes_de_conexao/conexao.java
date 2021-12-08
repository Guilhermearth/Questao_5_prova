package classes_de_conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 

public class conexao {
	
	public static Connection faz_conexao() throws SQLException {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost/banco_q4", "root","Guilherme0203@");
					
		} catch (ClassNotFoundException e) {
			
			throw new SQLException(e.getException());
		}
		
		
	}
	
}