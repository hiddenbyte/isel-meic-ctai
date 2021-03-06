package teste;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import puzzle.*;
import puzzle.Puzzle.Movimento;

import eigthpuzzle.ObjectivoPuzzle;
import eigthpuzzle.OperadorPuzzle;
import espest.*;

import localizacoes.EstadoLocalizacao;
import localizacoes.ObjectivoLocalidade;
import localizacoes.OperadorLocalizacao;
import mecproc.MecProcura;
import mecproc.MecProcuraAStar;
import mecproc.MecProcuraGrafoLargura;
import mecproc.MecProcuraLargura;
import mecproc.MecProcuraProfundidade;
import mecproc.MecProcuraProfundidadeIterativa;
import mecproc.MecProcuraSofrega;
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
		
		System.out.println(String.format("N�s criados:%s, N�s processados:%s",mec.obterNosCriados(),mec.obterNosProcessados()));
		
		*/
		
		Collection<OperadorGeral<Puzzle>> operadores = new ArrayList<OperadorGeral<Puzzle>>();
		
		
		operadores.add(new OperadorPuzzle(Movimento.BAIXO));
		operadores.add(new OperadorPuzzle(Movimento.CIMA));
		operadores.add(new OperadorPuzzle(Movimento.DIR));
		operadores.add(new OperadorPuzzle(Movimento.ESQ));



		
//		Puzzle estadoInicial = new Puzzle(new int[][]{{1,2,3},{8,4,5},{6,7,0}});
		Puzzle estadoInicial = new Puzzle(new int[][]{{8,4,5},{6,1,2},{3,7,0}});
		Puzzle estadoFinal = new Puzzle(new int[][]{{1,2,3},{4,5,6},{7,8,0}});
		
		MecProcura<Puzzle> mec;
		LinkedList<No<Puzzle>> nos;
		System.out.println("		Custo Solu��o	Complex Espacial	Complex Temporal   ");
//		mec = new MecProcuraLargura<Puzzle>();
//		nos = mec.procurar(estadoInicial, new ObjectivoPuzzle(estadoFinal), operadores);
//		System.out.println("Largura	" + "	" + mec.imprimirEstatisticas());
//		mec = new MecProcuraProfundidade<Puzzle>();
//		nos = mec.procurar(estadoInicial, new ObjectivoPuzzle(estadoFinal), operadores);
//		System.out.println("Profundidade" + "		" + mec.imprimirEstatisticas());
		mec = new MecProcuraProfundidadeIterativa<Puzzle>(15,1);
		nos = mec.procurar(estadoInicial, new ObjectivoPuzzle(estadoFinal), operadores);
		System.out.println("Iteractiva" + "	" + mec.imprimirEstatisticas());
		mec = new MecProcuraGrafoLargura<Puzzle>();
		nos = mec.procurar(estadoInicial, new ObjectivoPuzzle(estadoFinal), operadores);
		System.out.println("G_Largura" + "	" + mec.imprimirEstatisticas());
		mec = new MecProcuraSofrega<Puzzle>();
		nos = mec.procurar(estadoInicial, new ObjectivoPuzzle(estadoFinal), operadores);
		System.out.println("Sofrega	" + "	" + mec.imprimirEstatisticas());
		mec = new MecProcuraAStar<Puzzle>();
		nos = mec.procurar(estadoInicial, new ObjectivoPuzzle(estadoFinal), operadores);
		System.out.println("Astar	" + "	" + mec.imprimirEstatisticas());
		
		
		//MecProcura<Puzzle> mec = new MecProcuraGrafoLargura<Puzzle>();
		//MecProcura<Puzzle> mec = new MecProcuraAStar<Puzzle>();
		/*LinkedList<No<Puzzle>> nos = mec.procurar(estadoInicial, 
				new ObjectivoPuzzle(estadoFinal), operadores);
		
		System.out.println("fim de procura");
		
		if(nos == null)
			System.out.println("Sem solu��o.");
		else
			for(No<Puzzle> no :  nos)
				System.out.println(no.toString());*/
	}
}
