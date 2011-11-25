package agentedelib;

import espest.Operador;
import espest.Transicao;
import agente.Agente;
import agente.MemElem;
import ambiente.Accao;
import ambiente.Coordenada;

public class OperacaoAccao extends Operador<Coordenada> {
	protected MemElem crencas;
	protected Accao accao;
	
	public OperacaoAccao(MemElem crencas, Accao accao) {
		this.accao = accao;
		this.crencas = crencas;
	}

	public Transicao<Coordenada> transitar(Coordenada estado){
		boolean carga = crencas.getAgente().isCarga();
		Coordenada estSuc = Agente.simular(crencas, estado, accao, carga);
		if(estSuc != null){
			double custoTrans = estado.dist(estSuc);
			return new Transicao<Coordenada>(estado, estSuc, this, custoTrans);
		}
		else
			return null;
	}
	
	public Accao getAccao(){
		return accao;
	} 
	
	public String toString(){
		return getAccao().toString();
	}
}
