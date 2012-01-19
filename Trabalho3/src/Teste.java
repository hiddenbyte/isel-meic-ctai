import simulador.Simulador;
import Markov.AgenteDelibPDM;
import agente.IAgente;
import aprendQ.AgenteAprend;

public class Teste {

	private static String defAmb= "C:\\libs\\amb\\amb6.das";
	
	public static void main(String[] args) {
		
//		IAgente agent = new AgenteDelibPDM(100000, 0.1, 0.95); 
		IAgente agent = new AgenteAprend();
		Simulador simul = new Simulador();
		simul.iniciar(agent, defAmb, 70, true);
		simul.executar();
	}
}
