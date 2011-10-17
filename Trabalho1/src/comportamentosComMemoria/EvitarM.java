package comportamentosComMemoria;

import memorias.MemoriaDeTrabalho;
import ambiente.Accao;

public class EvitarM extends ComportamentoComMemoria{

	private Accao accao;
	
	public EvitarM(MemoriaDeTrabalho mdt) {
		super(mdt);
		
		accao = new Accao(0.25,0,Accao.Tipo.MOVER);
	}

	@Override
	public Accao activar(byte[] per) {
		if(mdt.obstaculoAdjacente || mdt.alvoEmBaseAdjacente || 
				mdt.carregado && mdt.alvoAdjacente ||
				!mdt.carregado && mdt.baseAdjacente)
			return accao;
		return null;
	}

}
