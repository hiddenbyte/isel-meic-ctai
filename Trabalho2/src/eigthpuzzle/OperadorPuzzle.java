package eigthpuzzle;

import puzzle.Puzzle;
import puzzle.Puzzle.Movimento;
import espest.Operador;
import espest.Transicao;

public class OperadorPuzzle extends Operador<Puzzle> {
	
	private Movimento mov;
	
	public OperadorPuzzle(Movimento m){
		mov = m;
	}

	@Override
	public Transicao<Puzzle> transitar(Puzzle estado) {
		
		if(estado.movimentar(mov)!=null)
			return new Transicao<Puzzle>(estado, estado.movimentar(mov), this, 1);
		return null;
	}

}
