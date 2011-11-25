package mecproc;

import espest.Operador;
import espest.Transicao;

public class No<E> {
	private E estado;
	private No<E> anterior;
	private Operador<E> operador;
	private boolean aberto;
	
	/** Profundidade do nó na árvore de procura */
	private int prof;
	/** Custo de percurso até ao nó */
	private double custo;
	
	public No(E estado)
	{
		this(estado,null,null,0,0);
	}
	
	public No(Transicao<E> transicao, No<E> noAnterior) 
	{
		this(transicao.obterEstadoSuc(),
				noAnterior, 
				transicao.obterOperador(), 
				noAnterior.getProf() +1,
				noAnterior.getCusto() + transicao.getCusto());
	}
	
	private No(E estado,No<E> anterior, Operador<E> operador,int prof, double custo)
	{
		this.estado = estado;
		this.anterior = anterior;
		this.operador = operador;
		this.prof = prof;
		this.custo = custo;
		this.aberto = true;
	}

	public E obterEstado() {
		return estado;
	}

	public No<E> obterAnterior() {
		return anterior;
	}
	
	public Operador<E> obterOperador()
	{
		return operador;
	}

	public int getProf() {
		return prof;
	}

	public void setProf(int prof) {
		this.prof = prof;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	@Override
	public String toString()
	{
		return (operador!=null?"operador: " + operador:"") + "; estado: " + estado
				+ "; prof:"+ prof;
	
	}
	
	public boolean isAberto(){
		return aberto;
	}
	
	public void setAberto(boolean aberto){
		this.aberto = aberto;
	}
}
