package app;

import model.Pessoa;
import collection.Pessoas;

public class Principal {

	public static void main(String[] args) {
		try {
			Pessoas collection = new Pessoas();
			collection.add(new Pessoa("John Doe", "johndoe@email.com"));
			collection.add(new Pessoa("Bryan Singer", "bryansinger@email.com"));
			collection.print();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
