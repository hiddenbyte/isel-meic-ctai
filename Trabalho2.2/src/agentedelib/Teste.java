package agentedelib;

import simulador.Simulador;
import agente.IAgente;

public class Teste {

	private static String defAmb= "C:\\libs\\amb\\amb3.das";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IAgente agent = new AgenteDelibConcreto(5); //relatorio
		Simulador simul = new Simulador();
		simul.iniciar(agent, defAmb, 70, true);
		simul.executar();
	}
}
