package eightPuzzle;

import puzzle.Puzzle;
import mecproc.Objectivo;

public class ObjectivoPuzzle implements Objectivo<Puzzle>{

	private Puzzle objectivo;
	
	public ObjectivoPuzzle(Puzzle objectivo)
	{                  
		this.objectivo = objectivo;
	}
	
	@Override
	public boolean satisfeito(Puzzle estado) {
		return estado.equals(objectivo);
	}
}
