package agentes;

import memorias.MemoriaDeTrabalho;
import comportamentos.IComportamento;
import comportamentos.Procurar;
import comportamentos.Vaguear;
import comportamentosComMemoria.*;

public class Agente3 extends Agente2{
	
	MemoriaDeTrabalho mdt;
	
	public Agente3(){
		mdt = new MemoriaDeTrabalho();
	}
	
	@Override
	public void iniciar() {
		comp= new IComportamento[]{new AvaliacaoDeEstado(mdt), new RecolherM(mdt), new LargarM(mdt), new EvitarM(mdt),new AproximarM(mdt),new Procurar(),new Vaguear()};
	}

}