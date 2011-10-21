package mecproc;

import espest.Operador;
import espest.Transicao;

public class No<E> {
	private E estado;
	private No<E> anterior;
	private Operador<E> operador;
	
	public No(E estado)
	{
		this(estado,null,null);
	}
	
	public No(Transicao<E> transicao, No<E> noAnterior)
	{
		this(transicao.obterEstadoSuc(), noAnterior, transicao.obterOperador());
	}
	
	public No(E estado,No<E> anterior, Operador<E> operador)
	{
		this.estado = estado;
		this.anterior = anterior;
		this.operador = operador;
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
}