package discriminadores;

import ambiente.Ambiente;
import memorias.MemoriaDeTrabalho;

public class Discriminador implements IDiscriminador{

	@Override
	public void descriminar(byte[] per, MemoriaDeTrabalho mdt) {
		
		mdt.alvoAdjacente= per[1] == Ambiente.IMG_ALVO;
		
		mdt.baseAdjacente= per[1] == Ambiente.IMG_BASE;
		
		mdt.obstaculoAdjacente= per[1] == Ambiente.IMG_OBST;
		
		mdt.alvoEmVista= per[per.length-1] == Ambiente.IMG_ALVO;
		
		mdt.baseEmVista= per[per.length-1] == Ambiente.IMG_BASE;
		
		mdt.alvoEmBaseAdjacente = per[1] == (Ambiente.IMG_ALVO | Ambiente.IMG_BASE);

	}

}