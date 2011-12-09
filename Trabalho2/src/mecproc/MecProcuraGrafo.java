package mecproc;

import java.util.HashMap;

public abstract class MecProcuraGrafo<E> extends MecProcura<E> {
	private HashMap<E,No<E>> grafo;

	public MecProcuraGrafo()
	{
		grafo = new HashMap<E,No<E>>();
	}

	@Override
	protected void juntar(No<E> no) {
		No<E> noGrafo = grafo.get(no.obterEstado());

		if(noGrafo == null){
			abrir(no);
		} else {
			if(compare(no, noGrafo) < 0)
			{
				if(noGrafo.isAberto())
				{
					abertos.remove(noGrafo);
				}
				abrir(no);
			}
		}
	}

	private void abrir(No<E> no)
	{
		super.juntar(no);
		E estado = no.obterEstado();
		grafo.put(estado, no);
		if(grafo.size()>nosMantidosEmMemoria)
			nosMantidosEmMemoria=grafo.size();
		no.setAberto(true);
	}
}