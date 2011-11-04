package mecproc;

import java.util.ArrayList;

public abstract class MecProcuraGrafo<E> extends MecProcura<E> {
	private ArrayList<E> fechados; //TODO: change to a HashTable
	
	public MecProcuraGrafo()
	{
		fechados = new ArrayList<E>();
	}
	
	@Override
	protected void juntar(No<E> no) {
		boolean contidoEmFechados = fechados.contains(no);
		boolean contidoEmAbertos = abertos.contains(no);
		
		if(!contidoEmAbertos && !contidoEmFechados)
			abertos.add(no);
		
		//TODO: slide 11, in Procura em Espaços de Estados - Parte 2.
		
		super.juntar(no);
	}
}