import simulador.Simulador;
import agente.IAgente;
import agentes.Agente1;
import agentes.Agente2;



public class Test {

	/**
	 * @param args
	 */
	
	private static String defAmb= "amb1.das";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IAgente agent = new Agente2();
		Simulador simul = new Simulador();
		simul.iniciar(agent, defAmb, 70, true);
		simul.executar();
	}

}
