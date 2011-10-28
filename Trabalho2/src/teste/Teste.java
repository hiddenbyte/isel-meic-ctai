package teste;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import espest.*;

import localizacoes.EstadoLocalizacao;
import localizacoes.ObjectivoLocalidade;
import localizacoes.OperadorLocalizacao;
import mecproc.MecProcura;
import mecproc.MecProcuraLargura;
import mecproc.No;

public class Teste {
	public static void main(String[] args) {
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

		MecProcura<EstadoLocalizacao> mec = new MecProcuraLargura<>();
		LinkedList<No<EstadoLocalizacao>> nos = mec.procurar(new EstadoLocalizacao("loc0"), 
				new ObjectivoLocalidade("loc4"), operadores);

		for(No<EstadoLocalizacao> no :  nos)
			System.out.println(no.toString());
	}
}
