package comportamentosComMemoria;

import memorias.MemoriaDeTrabalho;
import ambiente.Accao;

public class LargarM extends ComportamentoComMemoria{

	private Accao accao;
	
	public LargarM(MemoriaDeTrabalho mdt) {
		super(mdt);
		
		accao = new Accao(0,1,Accao.Tipo.LARGAR);
	}

	@Override
	public Accao activar(byte[] per) {
		if(mdt.carregado && mdt.baseAdjacente)
			return accao;
		return null;
	}

}
