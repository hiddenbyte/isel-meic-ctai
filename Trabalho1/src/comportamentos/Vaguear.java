package comportamentos;

import ambiente.Accao;

public class Vaguear implements IComportamento{

	@Override
	public Accao activar(byte[] per) {
		
		if(Accao.getDirAleat()>0.5){
			return new Accao(Accao.getDirAleat(),0,Accao.Tipo.MOVER);
		}else{
			return new Accao(0,1,Accao.Tipo.MOVER);
		}
		
		 
	}

}
