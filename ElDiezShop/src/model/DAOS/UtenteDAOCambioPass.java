package model.DAOS;

import java.sql.SQLException;

import database.Conn;
import database.Record;
import database.Table;
import model.beans.Utente;

public class UtenteDAOCambioPass {

	public static Utente doRetrieve(String username, String password, String nome, String cognome, String tipo, String email) throws SQLException  {
		Conn c = Conn.hold();
		
		/*c.deleteUtente("DELETE from utente WHERE Username = ?;",username);
		c.insertUtente("INSERT INTO utente (Username,Password,Nome,Cognome,Tipo,Email) VALUES (?,?,?,?,?,?);",username,password,nome,cognome,tipo,email);
		*/

		c.update("UPDATE utente\r\n" + 
				"SET Password = ?\r\n" + 
				"WHERE (Username = ?);", password, username);
		Table t = c.query("SELECT * FROM utente WHERE Username = ?", username);

		if (t.count() == 0) {
			return null;
		}
		Conn.release(c);
		Record r = t.get(0);
		return new Utente((String) r.get(0), (String) r.get(1), (String) r.get(2), (String) r.get(3), (String) r.get(4),
				(String) r.get(5));
	}

}