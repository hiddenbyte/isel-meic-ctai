package agentedelib;

import simulador.Simulador;
import agente.IAgente;
import mecproc.MecProcuraAStar;
import ambiente.Coordenada;

public class Teste {

	private static String defAmb= "C:\\libs\\amb\\amb3.das";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IAgente agent = new AgenteDelibPEE(new MecProcuraAStar<Coordenada>()); //relatorio
		Simulador simul = new Simulador();
		simul.iniciar(agent, defAmb, 70, true);
		simul.executar();
	}
}
