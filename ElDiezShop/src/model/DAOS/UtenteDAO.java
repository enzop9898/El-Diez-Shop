package model.DAOS;

import java.util.ArrayList;

import database.Conn;
import database.Record;
import database.Table;
import model.beans.Utente;

public class UtenteDAO {

	public static Utente doRetrieve(String username, String password) {
		Conn c = Conn.hold();
		Table t = c.query("SELECT * FROM utente WHERE Username = ? AND Password= ?", username,password);
		if (t.count() == 0) {
			return null;
		}
		Conn.release(c);
		Record r = t.get(0);
		return new Utente((String) r.get(0), (String) r.get(1), (String) r.get(2), (String) r.get(3), (String) r.get(4),
				(String) r.get(5));
	}
	
	public ArrayList<Utente> doRetrieveAll() {
		ArrayList<Utente> list=new ArrayList<Utente>();
		Conn c = Conn.hold();
		Table t = c.query("SELECT * FROM utente");
		if (t.count() == 0) {
			return null;
		}
		Conn.release(c);
		int i=0;
		while(i<t.count()) {
		Record r = t.get(i);
		Utente ut= new Utente((String) r.get(0), (String) r.get(1), (String) r.get(2), (String) r.get(3), (String) r.get(4),
				(String) r.get(5));
		list.add(ut);
		i++;
		}
	  return list;
	}

}
