package aprendQ;

import simulador.Simulador;
import agente.IAgente;

public class AprendQTest
{
	private static String defAmb= "C:\\libs\\amb\\amb5.das";
	
	public void Iniciar()
	{
		IAgente agent = new AgenteAprend(); 
		Simulador simul = new Simulador();
		simul.iniciar(agent, defAmb, 70, true);
		simul.executar();
	}
}
