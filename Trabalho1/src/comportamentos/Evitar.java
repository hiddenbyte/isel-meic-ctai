package comportamentos;

import ambiente.Accao;
import ambiente.Ambiente;

public class Evitar implements IComportamento{

	private Accao accao;

	public Evitar(){
		accao = new Accao(0.25,0,Accao.Tipo.MOVER);
	}

	@Override
	public Accao activar(byte[] per) {
		if(per[1]==Ambiente.IMG_OBST)
			return accao;
		return null;
	}

}