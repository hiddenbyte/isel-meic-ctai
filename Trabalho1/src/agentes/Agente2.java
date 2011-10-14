package agentes;

import comportamentos.Evitar;
import comportamentos.IComportamento;
import comportamentos.Aproximar;
import comportamentos.Procurar;
import comportamentos.Recolher;
import comportamentos.Vaguear;

import agente.Agente;
import ambiente.Accao;

public class Agente2 extends Agente{

	protected byte[] imagem;

	protected Accao accao;
	
	protected IComportamento[] comp;
	
	@Override
	public void agir() {
		if(accao!=null){
			getActuador().actuar(accao);
			getConsola().mostrar(accao.toString());
		}
	}

	@Override
	public void iniciar() {
		comp= new IComportamento[]{new Recolher(),new Evitar(),new Aproximar(),new Procurar(),new Vaguear()};
		
	}

	@Override
	public void percepcionar() {
		imagem=getSensorImagem().detectar();
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