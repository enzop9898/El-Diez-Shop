package model.beans;

public final class Utente {

	public String username, password, nome, cognome, tipo, email;

	public Utente() {
		
	}
	
	public Utente(String username, String password, String nome, String cognome, String tipo, String email) {
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.tipo = tipo;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getTipo() {
		return tipo;
	}

	public String getEmail() {
		return email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}