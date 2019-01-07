package model;

import java.io.Serializable;

public class Pessoa implements Comparable<Pessoa>, Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String email;

	public Pessoa(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "" + this.nome + "," + this.email;
	}

	public int compareTo(Pessoa p) {
		return this.email.compareTo(p.email);
	}

}
