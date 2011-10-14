package comportamentosComMemoria;

import memorias.MemoriaDeTrabalho;
import ambiente.Accao;
import ambiente.Ambiente;

public class AvaliacaoDeEstado extends ComportamentoComMemoria{

	public AvaliacaoDeEstado(MemoriaDeTrabalho mdt) {
		super(mdt); 
	}

	@Override
	public Accao activar(byte[] per) {

		mdt.carregado = ( per[0] & Ambiente.IMG_ALVO)==Ambiente.IMG_ALVO; 
		
		return null;
	}

}
