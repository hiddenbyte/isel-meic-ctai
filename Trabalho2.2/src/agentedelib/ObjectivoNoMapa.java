package agentedelib;

import mecproc.ObjectivoComHeuristica;
import ambiente.Coordenada;

public class ObjectivoNoMapa implements ObjectivoComHeuristica<Coordenada> {
	
	private Coordenada objectivo;
	
	public ObjectivoNoMapa(Coordenada c){
		
		objectivo = c;
	}

	@Override
	public boolean satisfeito(Coordenada estado) {
		return estado.equals(objectivo);
	}

	@Override
	public double getHeuristica(Coordenada estado) {
		return estado.dist(objectivo);
	}

}
