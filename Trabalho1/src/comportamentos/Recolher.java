package comportamentos;

import ambiente.Accao;
import ambiente.Ambiente;

public class Recolher implements IComportamento{

	private Accao accao;
	
	public Recolher(){
		accao = new Accao(0,1,Accao.Tipo.PEGAR);
	}
	
	@Override
	public Accao activar(byte[] per) {
		if(per[1]==Ambiente.IMG_ALVO)
			return accao;
		return null;
	}

}
