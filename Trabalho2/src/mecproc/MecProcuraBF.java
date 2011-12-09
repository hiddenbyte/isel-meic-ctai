package mecproc;

import java.util.Collection;
import java.util.LinkedList;

import espest.OperadorGeral;

public abstract class MecProcuraBF<E> extends MecProcuraGrafo<E>{
	
	private ObjectivoComHeuristica<E> objectivo;
	
	@Override
	public LinkedList<No<E>> procurar(E estadoInicial,Objectivo<E> objectivo,Collection<OperadorGeral<E>> operadores){
		this.objectivo = (ObjectivoComHeuristica<E>)objectivo;
		return super.procurar(estadoInicial, objectivo, operadores);
	}
	
	
	@Override
	public int compare(No<E> o1, No<E> o2) {
		return Double.compare(getF(o1), getF(o2));
	}
	
	private double getF(No<E> no){
		return getG(no) + getH(no);
	}
	
	protected double getG(No<E> no){
		return no.getCusto();
	}
	
	protected double getH(No<E> no){
		return objectivo.getHeuristica(no.obterEstado());
	}
}
