package Biblio.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	
	static ResultSet resultat;
	static Connection conn = null;
	
    public static  Connection Connect()  {
       
    	try {
            // The newInstance() call is a work around for some
            // broken Java implementations
        	System.out.println("Chargement du driver ...");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Chargement du driver OK !");
        } catch (Exception ex) {
           System.err.println("Erreur Exception ex");
        }
        try {
        	System.out.println("Connexion à la BDD...");
            conn =
               DriverManager.getConnection("jdbc:mysql://localhost/biblio",
                                           "user","pwd");
            
            System.out.println("Connexion réussie !");
            
            return conn;
            
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
           

		return conn;
}
}