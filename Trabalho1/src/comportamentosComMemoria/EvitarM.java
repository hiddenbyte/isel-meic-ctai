package comportamentosComMemoria;

import memorias.MemoriaDeTrabalho;
import ambiente.Accao;
import ambiente.Ambiente;

public class EvitarM extends ComportamentoComMemoria{

	private Accao accao;
	
	public EvitarM(MemoriaDeTrabalho mdt) {
		super(mdt);
		
		accao = new Accao(0.25,0,Accao.Tipo.MOVER);
	}

	@Override
	public Accao activar(byte[] per) {
		if(per[1]==Ambiente.IMG_OBST || 
				mdt.carregado && ( (per[1] & Ambiente.IMG_ALVO) ==  Ambiente.IMG_ALVO) ||
				!mdt.carregado && ( (per[1] & Ambiente.IMG_BASE) == Ambiente.IMG_BASE ))
			return accao;
		return null;
	}

}
