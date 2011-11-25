package teste;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import puzzle.Puzzle;

import eightPuzzle.ObjectivoPuzzle;
import eightPuzzle.OperadorEightPuzzle;
import espest.*;

import localizacoes.EstadoLocalizacao;
import localizacoes.ObjectivoLocalidade;
import localizacoes.OperadorLocalizacao;
import mecproc.MecProcura;
import mecproc.MecProcuraLargura;
import mecproc.MecProcuraProfundidade;
import mecproc.MecProcuraProfundidadeIterativa;
import mecproc.No;

public class Teste {
	public static void main(String[] args) {
		/*
		Collection<OperadorGeral<EstadoLocalizacao>> operadores = new ArrayList<OperadorGeral<EstadoLocalizacao>>();
		operadores.add(new OperadorLocalizacao(new EstadoLocalizacao("loc0"), 
				new EstadoLocalizacao("loc1"), 5));
		operadores.add(new OperadorLocalizacao(new EstadoLocalizacao("loc0"), 
				new EstadoLocalizacao("loc2"), 25));
		operadores.add(new OperadorLocalizacao(new EstadoLocalizacao("loc1"), 
				new EstadoLocalizacao("loc3"), 12));
		operadores.add(new OperadorLocalizacao(new EstadoLocalizacao("loc1"), 
				new EstadoLocalizacao("loc6"), 5));
		operadores.add(new OperadorLocalizacao(new EstadoLocalizacao("loc2"), 
				new EstadoLocalizacao("loc4"), 30));
		operadores.add(new OperadorLocalizacao(new EstadoLocalizacao("loc3"), 
				new EstadoLocalizacao("loc2"), 10));
		operadores.add(new OperadorLocalizacao(new EstadoLocalizacao("loc3"), 
				new EstadoLocalizacao("loc5"), 5));
		operadores.add(new OperadorLocalizacao(new EstadoLocalizacao("loc4"), 
				new EstadoLocalizacao("loc3"), 2));
		operadores.add(new OperadorLocalizacao(new EstadoLocalizacao("loc5"), 
				new EstadoLocalizacao("loc4"), 10));
		operadores.add(new OperadorLocalizacao(new EstadoLocalizacao("loc5"), 
				new EstadoLocalizacao("loc6"), 8));
		operadores.add(new OperadorLocalizacao(new EstadoLocalizacao("loc6"), 
				new EstadoLocalizacao("loc3"), 15));

		//MecProcura<EstadoLocalizacao> mec = new MecProcuraProfundidade<EstadoLocalizacao>();
		//MecProcura<EstadoLocalizacao> mec = new MecProcuraProfundidadeLimitada<EstadoLocalizacao>(2);
		MecProcura<EstadoLocalizacao> mec = new MecProcuraProfundidadeIterativa<EstadoLocalizacao>(10,1);
		LinkedList<No<EstadoLocalizacao>> nos = mec.procurar(new EstadoLocalizacao("loc0"), 
				new ObjectivoLocalidade("loc4"), operadores);
		
		System.out.println(String.format("Nós criados:%s, Nós processados:%s",mec.obterNosCriados(),mec.obterNosProcessados()));
		
		if(nos == null)
			System.out.println("Sem solução.");
		else
			for(No<EstadoLocalizacao> no :  nos)
				System.out.println(no.toString());
		*/
		
		Collection<OperadorGeral<Puzzle>> operadores = new ArrayList<OperadorGeral<Puzzle>>();
		operadores.add(new OperadorEightPuzzle(Puzzle.Movimento.BAIXO));
		operadores.add(new OperadorEightPuzzle(Puzzle.Movimento.CIMA));
		operadores.add(new OperadorEightPuzzle(Puzzle.Movimento.DIR));
		operadores.add(new OperadorEightPuzzle(Puzzle.Movimento.ESQ));
		
		int[][] estadoInicial = new int[][] {{1,2,3},{8,4,5},{6,7,0}};
		int[][] estadoFinal = new int[][] {{1,2,3},{4,5,6},{7,8,0}};
		
		System.out.println("início de procura.");
		
		MecProcura<Puzzle> mec = new MecProcuraLargura<Puzzle>();
		LinkedList<No<Puzzle>> nos = mec.procurar(new Puzzle(estadoInicial), new ObjectivoPuzzle(new Puzzle(estadoFinal)), operadores);
		
		System.out.println("fim de procura.");
		
		if(nos == null)
			System.out.println("Sem solução.");
		else
			for(No<Puzzle> no :  nos)
				System.out.println(no.toString());
	}
}
