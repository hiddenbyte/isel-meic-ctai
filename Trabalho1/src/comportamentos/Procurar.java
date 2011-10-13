package comportamentos;

import ambiente.Accao;

public class Procurar implements IComportamento{

	private static final int OBSERVAR_ESQ = 0;
	private static final int OBSERVAR_DIR = 1;
	private static final int OBSERVAR_FRE = 2;
	private static final int PAUSA = 3;
	
	private int estado;
	
	public Procurar(){
		estado=OBSERVAR_ESQ;
	}
	
	@Override
	public Accao activar(byte[] per) {

		switch(estado){
		case OBSERVAR_ESQ:
			estado=OBSERVAR_DIR;
			return new Accao(0.125,0,Accao.Tipo.MOVER);
		case OBSERVAR_DIR:
			estado=OBSERVAR_FRE;
			return new Accao(-0.25,0,Accao.Tipo.MOVER);
		case OBSERVAR_FRE:
			estado=PAUSA;
			return new Accao(0.125,0,Accao.Tipo.MOVER);
		case PAUSA:
			estado=OBSERVAR_ESQ;
		}
		return null;
	}

}
