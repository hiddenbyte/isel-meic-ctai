package agentedelib;

import java.util.Set;

import espest.Transicao;
import agente.MemElem;
import ambiente.Accao.Tipo;
import ambiente.Coordenada;

public class OperadorAccaoGeral {
	protected MemElem crencas;
	protected Tipo accao;
	
	public OperadorAccaoGeral(MemElem crencas, Tipo accao) {
		this.accao = accao;
		this.crencas = crencas;
	}
	
	public Set<Transicao<Coordenada>> aplicar(Coordenada estado){
		return null;
	}

}
