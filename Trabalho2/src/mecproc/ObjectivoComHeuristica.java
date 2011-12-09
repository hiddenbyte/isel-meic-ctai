package mecproc;

public interface ObjectivoComHeuristica<E> extends Objectivo<E>{

	public double getHeuristica(E estadoActual);
}
