package comportamentosComMemoria;

import comportamentos.Recolher;

import memorias.MemoriaDeTrabalho;
import ambiente.Accao;

public class RecolherM extends ComportamentoComMemoria{

	Recolher recolher;
	
	public RecolherM(MemoriaDeTrabalho mdt) {
		super(mdt);
	}

	@Override
	public Accao activar(byte[] per) {
		
		if(!mdt.carregado){
			if(recolher==null){
				recolher = new Recolher();
			}
			return recolher.activar(per);
		}
		return null;
	}

}
