package buffer;

import java.util.LinkedList;

public class BufferCircular implements Buffer {
	
	private LinkedList<Integer> buffer = new LinkedList<>();
	private static int MaxSize = 3;
	
	public static void setBufferSize(int tamanho) {
		MaxSize = tamanho;
	}

	@Override
	public synchronized void escrever(Produtor Escreve, int valor) throws InterruptedException {
		while (this.buffer.size() == MaxSize) {
			System.out.println("\nO Buffer está cheio");
			wait();
		}
		
		buffer.add(valor);
		System.out.println(String.format("\n\"%s\" escreveu o valor %s", Escreve.getNome(), valor));
		
		notifyAll();		
	}

	@Override
	public synchronized int ler(Consumidor Le) throws InterruptedException {
		while(this.buffer.size() == 0) {
			System.out.println("\nBuffer está vazio");
			wait();
		}
		
		int valor = this.buffer.removeFirst();
		System.out.println(String.format("\n\"%s\" leu o valor %s", Le.getNome(), valor));
		
		notifyAll();
		
		return valor;
		
	}

}
