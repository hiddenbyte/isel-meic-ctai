package espest;

import java.util.HashSet;
import java.util.Set;

public abstract class Operador<E> implements OperadorGeral<E> {
	
	public abstract Transicao<E> transitar(E estado);
	
	@Override
	public Set<Transicao<E>> aplicar(E estado)
	{
		Set<Transicao<E>> transicoes = new HashSet<Transicao<E>>(1);
		
		Transicao<E> trans = transitar(estado);
		if(trans != null)
			transicoes.add(trans);
		
		return transicoes; 
	}
}
