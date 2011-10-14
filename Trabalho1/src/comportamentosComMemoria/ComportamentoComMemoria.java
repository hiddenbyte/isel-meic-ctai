package comportamentosComMemoria;

import memorias.MemoriaDeTrabalho;
import comportamentos.IComportamento;

public abstract class ComportamentoComMemoria implements IComportamento{
	
	MemoriaDeTrabalho mdt;
	
	public ComportamentoComMemoria(MemoriaDeTrabalho mdt){
		this.mdt = mdt;
	}
	
}