package buffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newCachedThreadPool();
		Buffer bufferShared = new BufferCircular();
		
		final int NumProdutores = 2;
		final int NumConsumidores = 2;
		final int BufferSize = 2;
				
		LinkedList<Integer> dados = new LinkedList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		Produtor.setDados(dados);
		BufferCircular.setBufferSize(BufferSize);
		
		Produtor[] produtores = new Produtor[NumProdutores];
		for (int i = 0; i < NumProdutores; i++) {
			Produtor produtor = new Produtor("Produtor " + i, bufferShared);
			produtores[i] = produtor;
		}
		
		Consumidor[] consumidores =  new Consumidor[NumConsumidores];
		for (int i = 0; i < NumConsumidores; i++) {
			Consumidor consumidor = new Consumidor("Consumidor " + i, bufferShared);
			consumidores[i] = consumidor;
		}
		
		System.out.println("Incio");
		
		for (Consumidor consumidor : consumidores) {
			pool.execute(consumidor);
		}
		for (Produtor produtor : produtores) {
			pool.execute(produtor);
		}
		
		pool.shutdown();
	}
}
