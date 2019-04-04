package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DizionarioDAO {

	public Set<String> dizionario() {
		
		final String sql = "SELECT * FROM parola";
		ResultSet rs; 
		boolean res; 
		Set<String> risultato = new HashSet<String>(); 
		String parola;
		
		try {
			Connection conn= ConnectDB.getConnection();
			PreparedStatement st= conn.prepareStatement(sql); 
			
			rs= st.executeQuery(); 
			
			
			while(rs.next()) {
				parola= rs.getString("nome"); 
				risultato.add(parola); 
				
				
			}
				
				
			
			conn.close();
		} catch(SQLException e) {
			throw new RuntimeException("Errore DB");
		}
		return risultato; 
	}

}
