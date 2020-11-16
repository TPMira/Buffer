package buffer;

public abstract class Entidade implements Runnable {
	
	protected Buffer bufferShared;
	protected String nome;
	
	public Entidade(String nome, Buffer bufferShared) {
		this.bufferShared = bufferShared;
		this.nome = nome;		
	}
	
	
	public String getNome() {
		return this.nome;
	}

	@Override
	public abstract void run();
	
	@Override
	public String toString() {
		return this.getClass().getName() + " " + this.nome;
	}
}
