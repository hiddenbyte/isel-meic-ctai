import simulador.Simulador;
import agente.IAgente;
import agentes.*;

public class Test {

	/**
	 * @param args
	 */
	
	private static String defAmb= "C:\\libs\\amb\\amb2.das";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IAgente agent = new Agente3();
		Simulador simul = new Simulador();
		simul.iniciar(agent, defAmb, 70, true);
		simul.executar();
	}

}