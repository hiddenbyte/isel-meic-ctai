package agentes;

import memorias.MemoriaDeTrabalho;
import comportamentos.IComportamento;
import comportamentos.Procurar;
import comportamentos.Vaguear;
import comportamentosComMemoria.*;
import discriminadores.Discriminador;
import discriminadores.IDiscriminador;

public class Agente3 extends Agente2{
	
	MemoriaDeTrabalho mdt;
	IDiscriminador disc;
	
	public Agente3(){
		mdt = new MemoriaDeTrabalho();
		disc= new Discriminador();
	}
	
	@Override
	public void percepcionar() {
		imagem=getSensorImagem().detectar();
		disc.descriminar(imagem, mdt);
	}
	
	@Override
	public void iniciar() {
		comp= new IComportamento[]{new AvaliacaoDeEstado(mdt), new RecolherM(mdt), new LargarM(mdt), new EvitarM(mdt),new AproximarM(mdt),new Procurar(),new Vaguear()};
	}

}