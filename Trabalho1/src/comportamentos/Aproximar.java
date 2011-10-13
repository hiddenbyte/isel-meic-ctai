package comportamentos;

import ambiente.Accao;
import ambiente.Ambiente;

public class Aproximar implements IComportamento{

	private Accao accao;
	
	public Aproximar(){
		accao = new Accao(0, 1, Accao.Tipo.MOVER);
	}
	
	@Override
	public Accao activar(byte[] per) {
		if(per[per.length-1]==Ambiente.IMG_ALVO)
			return accao;
		return null;
	}
	
}
