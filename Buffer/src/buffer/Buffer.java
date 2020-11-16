package buffer;

public interface Buffer {
	
	public void escrever(Produtor Escreve, int valor) throws InterruptedException;
		
	public int ler(Consumidor Le) throws InterruptedException;

}
