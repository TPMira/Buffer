package buffer;

import java.util.LinkedList; 

public class Produtor extends Entidade {
	
	private static LinkedList<Integer> dados;
	
	public Produtor(String nome, Buffer bufferShared) {
		super(nome, bufferShared);
	}

	public static void setDados(LinkedList<Integer> dados) {
		Produtor.dados = dados;
	}

	public void run() {
		while (dados.size() > 0) {
			int dado = dados.removeFirst();
			try {
				this.bufferShared.escrever(this, dado);				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
