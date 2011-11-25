package eightPuzzle;

import puzzle.Puzzle;
import puzzle.Puzzle.Movimento;
import espest.Operador;
import espest.Transicao;

public class OperadorEightPuzzle extends Operador<Puzzle> {
	private Movimento movimento;
	
	public OperadorEightPuzzle(Movimento movimento)
	{
		this.movimento = movimento;
	}
	
	public Transicao<Puzzle> transitar(Puzzle estado) {
		
		Puzzle novoEstado = estado.movimentar(movimento);
		if(novoEstado == null)
			return null;
		return new Transicao<Puzzle>(estado,novoEstado,this,1);
	}

}
