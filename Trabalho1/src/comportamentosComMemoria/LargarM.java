package comportamentosComMemoria;

import memorias.MemoriaDeTrabalho;
import ambiente.Accao;
import ambiente.Ambiente;

public class LargarM extends ComportamentoComMemoria{

	private Accao accao;
	
	public LargarM(MemoriaDeTrabalho mdt) {
		super(mdt);
		
		accao = new Accao(0,1,Accao.Tipo.LARGAR);
	}

	@Override
	public Accao activar(byte[] per) {
		if(mdt.carregado && per[1]==Ambiente.IMG_BASE)
			return accao;
		return null;
	}

}
