package comportamentosComMemoria;

import memorias.MemoriaDeTrabalho;
import ambiente.Accao;
import ambiente.Ambiente;

public class AproximarM extends ComportamentoComMemoria{

	private Accao accao;
	
	public AproximarM(MemoriaDeTrabalho mdt) {
		super(mdt);
		
		accao = new Accao(0, 1, Accao.Tipo.MOVER);
	}

	@Override
	public Accao activar(byte[] per) {
		if(!mdt.carregado && per[per.length-1]==Ambiente.IMG_ALVO ||
				mdt.carregado && per[per.length-1]==Ambiente.IMG_BASE)
			return accao;
		return null;
	}

}
