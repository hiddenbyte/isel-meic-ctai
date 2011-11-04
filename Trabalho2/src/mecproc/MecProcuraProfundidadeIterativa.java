package mecproc;

import java.util.Collection;
import java.util.LinkedList;

import espest.OperadorGeral;

public class MecProcuraProfundidadeIterativa<E> extends MecProcuraProfundidadeLimitada<E> {
	private static final int LIMITE_INICIAL = 0;
	private int limiteMaximo;
	private int incremento;
	
	public MecProcuraProfundidadeIterativa(int limiteMaximo,int incremento) {
		super(LIMITE_INICIAL);
		this.limiteMaximo = limiteMaximo;
		this.incremento = incremento;
	}
	
	@Override
	public LinkedList<No<E>> procurar(E estadoInicial, Objectivo<E> objectivo, Collection<OperadorGeral<E>> operadores) 
	{
		LinkedList<No<E>> solucao;
		
		while(limite <= limiteMaximo) {
			solucao = super.procurar(estadoInicial, objectivo, operadores);
			if(solucao != null)
				return solucao;
			limite += incremento;
		}
		
		return null;
	}
}
