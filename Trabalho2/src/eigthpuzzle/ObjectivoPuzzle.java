package eigthpuzzle;

import mecproc.ObjectivoComHeuristica;
import puzzle.Puzzle;

public class ObjectivoPuzzle implements ObjectivoComHeuristica<Puzzle>{

	private Puzzle objectivo;
	
	public ObjectivoPuzzle(Puzzle p){
		
		objectivo = p;
	}

	@Override
	public boolean satisfeito(Puzzle estado) {
		return estado.equals(objectivo);
	}

	@Override
	public double getHeuristica(Puzzle estadoActual) {
		return estadoActual.distManhattan(objectivo);
	}
}
