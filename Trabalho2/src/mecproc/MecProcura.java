package mecproc;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

import espest.OperadorGeral;
import espest.Transicao;

public abstract class MecProcura<E> implements Comparator<No<E>> {
	
	protected PriorityQueue<No<E>> abertos; //change to PriorityQueue<No<E>> ???
	
	public MecProcura()
	{
		this.abertos = new PriorityQueue<No<E>>(1,this);
	}
	
	public void iniciar()
	{
		abertos.clear();
	}
	
	public LinkedList<No<E>> procurar(E estadoInicial,Objectivo<E> objectivo,Collection<OperadorGeral<E>> operadores)
	{
		iniciar();
		
		abertos.add(new No<E>(estadoInicial));
		
		No<E> noActual;
		
		while(!abertos.isEmpty()){
			
			noActual = abertos.remove();
			
			if(objectivo.satisfeito(noActual.obterEstado()) )
				return solucao(noActual);
			
			expandir(noActual, operadores);
		}
		
		return null;
	}
	
	private LinkedList<No<E>> solucao(No<E> noActual) {
		
		LinkedList<No<E>> resultado = new LinkedList<No<E>>();
		
		do{
			resultado.addFirst(noActual);
			noActual=noActual.obterAnterior();
		}while(noActual!=null);
		
		return resultado;
	}

	private void expandir(No<E> no, Collection<OperadorGeral<E>> operadores)
	{
		Set<Transicao<E>> transicoes;

		for(OperadorGeral<E> op : operadores){
			transicoes = op.aplicar(no.obterEstado());
			for(Transicao<E> t : transicoes){
				juntar(new No<E>(t,no));
			}
		}
	}
	
	private void juntar(No<E> no)
	{
		abertos.add(no);
	}
}