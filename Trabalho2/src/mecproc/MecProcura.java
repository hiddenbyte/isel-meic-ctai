package mecproc;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;

import espest.Operador;
import espest.Transicao;

public abstract class MecProcura<E>  {
	
	protected LinkedList<No<E>> fronteira; 
	
	public LinkedList<No<E>> procurar(E estadoInicial,Objectivo<E> objectivo,Collection<Operador<E>> operadores)
	{
		fronteira = new LinkedList<No<E>>();
		fronteira.add(new No<E>(estadoInicial));
		
		No<E> noActual;
		
		while(fronteira.size()>0){
			
			noActual = fronteira.removeFirst();
			
			if(objectivo.satisfeito(noActual.obterEstado()) )
				return solucao(noActual);
			else
				expandir(noActual, operadores);
		}
		
		return null;
	}
	
	private LinkedList<No<E>> solucao(No<E> noActual) {
		
		LinkedList<No<E>> resultado = new LinkedList<No<E>>();
		
		do{
			resultado.add(noActual);
			noActual=noActual.obterAnterior();
		}while(noActual!=null);
		
		return resultado;
	}

	private void expandir(No<E> no, Collection<Operador<E>> operadores)
	{
		Set<Transicao<E>> transicoes;

		for(Operador<E> op : operadores){
			transicoes = op.aplicar(no.obterEstado());
			for(Transicao<E> t : transicoes){
				juntar(new No<E>(t,no));
			}
		}
	}
	
	protected abstract void juntar(No<E> no);
}