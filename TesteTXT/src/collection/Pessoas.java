package collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeSet;

import model.Pessoa;

public class Pessoas {

	private TreeSet<Pessoa> pessoas = null;

	public Pessoas() throws ClassNotFoundException, IOException {
		if (pessoas == null) {
			this.pessoas = new TreeSet<Pessoa>();
		}

		lerDados();
	}

	private void gravarDados() throws IOException {
		FileOutputStream stream = new FileOutputStream("src/data/pessoas.txt");
		ObjectOutputStream output = new ObjectOutputStream(stream);
		output.writeObject(pessoas);
		output.close();
	}

	private void lerDados() throws IOException, ClassNotFoundException {
		FileInputStream fileIn = new FileInputStream("src/data/pessoas.txt");
		ObjectInputStream input = new ObjectInputStream(fileIn);
		this.pessoas = (TreeSet<Pessoa>) input.readObject();
		input.close();
		fileIn.close();
	}

	public boolean add(Pessoa p) throws IOException {
		boolean add = pessoas.add(p);
		if (add) {
			gravarDados();
		}
		return add;
	}

	public void print() {
		for (Pessoa p : this.pessoas) {
			System.out.println(p.toString());
		}
	}

	public TreeSet<Pessoa> getPessoas() {
		return pessoas;
	}

}
