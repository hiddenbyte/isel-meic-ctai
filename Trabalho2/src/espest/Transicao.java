package espest;

public class Transicao<E> {
	private E estadoAnt;
	private E estadoSuc;
	private Operador<E> operador;
	
	public Transicao(E estadoAnt,E estadoSuc,Operador<E> operador)
	{
		this.estadoAnt = estadoAnt;
		this.estadoSuc = estadoSuc;
		this.operador = operador;
	}
	
	public E obterEstadoSuc() {
		return estadoSuc;
	}

	
	public E obterEstadoAnt() {
		return estadoAnt;
	}

	public Operador<E> obterOperador() {
		return operador;
	}
} 
