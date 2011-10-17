package agentes;

import comportamentos.Evitar;
import comportamentos.IComportamento;
import comportamentos.Aproximar;
import comportamentos.Procurar;
import comportamentos.Recolher;
import comportamentos.Vaguear;

public class Agente2 extends Agente1{
	
	protected IComportamento[] comp;

	@Override
	public void iniciar() {
		comp= new IComportamento[]{new Recolher(),new Evitar(),new Aproximar(),new Procurar(),new Vaguear()};
		
	}

	@Override
	public void processar() {
		for(IComportamento c : comp){
			if((accao = c.activar(imagem))!=null){
				break;
			}
		}
	}
}