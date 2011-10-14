package agentes;

import agente.Agente;
import ambiente.Accao;
import ambiente.Ambiente;

public class Agente1 extends Agente{

	protected byte[] imagem;

	protected Accao accao;


	@Override
	public void agir() {
		if(accao!=null){
			getActuador().actuar(accao);
			getConsola().mostrar(accao.toString());
		}
	}

	@Override
	public void iniciar() {
	}

	@Override
	public void percepcionar() {
		imagem=getSensorImagem().detectar();
	}

	@Override
	public void processar() {

		if(imagem[1]==Ambiente.IMG_ALVO){
			accao = new Accao(0,1,Accao.Tipo.PEGAR);
		}else if(imagem[1]==Ambiente.IMG_OBST){
			accao = new Accao(0.25,0,Accao.Tipo.MOVER);
		}else{
			accao= new Accao(0, 1, Accao.Tipo.MOVER);
		}
	}

}