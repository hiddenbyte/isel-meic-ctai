package comportamentosComMemoria;

import memorias.MemoriaDeTrabalho;
import ambiente.Accao;

public class AproximarM extends ComportamentoComMemoria{

	private Accao accao;
	
	public AproximarM(MemoriaDeTrabalho mdt) {
		super(mdt);
		
		accao = new Accao(0, 1, Accao.Tipo.MOVER);
	}

	@Override
	public Accao activar(byte[] per) {
		if(!mdt.carregado && mdt.alvoEmVista ||
				mdt.carregado && mdt.baseEmVista)
			return accao;
		return null;
	}

}
