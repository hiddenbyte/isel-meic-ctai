package espest;

public class Transicao<E> {
	private E estadoAnt;
	private E estadoSuc;
	private Operador<E> operador;
	private double custo;
	
	public Transicao(E estadoAnt,E estadoSuc,Operador<E> operador,double custo)
	{
		this.estadoAnt = estadoAnt;
		this.estadoSuc = estadoSuc;
		this.operador = operador;
		this.custo = custo;
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

	public double getCusto() {
		return custo;
	}

} 
