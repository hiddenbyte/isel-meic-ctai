package discriminadores;

import memorias.MemoriaDeTrabalho;

public interface IDiscriminador {

	void descriminar(byte[] per, MemoriaDeTrabalho mdt);
	
}