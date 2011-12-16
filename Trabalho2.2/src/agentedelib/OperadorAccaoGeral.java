package agentedelib;

import java.util.HashSet;
import java.util.Set;

import agente.MemElem;
import ambiente.Accao;
import ambiente.Coordenada;
import espest.OperadorGeral;
import espest.Transicao;

public class OperadorAccaoGeral implements OperadorGeral<Coordenada>
{
	protected MemElem crencas;
	protected Accao.Tipo tipoDeAccao;

	public OperadorAccaoGeral(MemElem crencas, Accao.Tipo tipoDeAccao)
	{
		this.tipoDeAccao = tipoDeAccao;
		this.crencas = crencas;
	}
	
	@Override
	public Set<Transicao<Coordenada>> aplicar(Coordenada estado)
	{
		Set<Transicao<Coordenada>> transicoes = new HashSet<Transicao<Coordenada>>();
		Accao[] accoes = Accao.gerarAccoes(tipoDeAccao);
		OperadorAccao operadorAccao;
		Transicao<Coordenada> transicao;

		for (Accao accao : accoes)
		{
			operadorAccao = new OperadorAccao(crencas, accao);
			
			transicao = operadorAccao.transitar(estado);
			
			if (transicao != null)
				transicoes.add(transicao);
		}

		return transicoes;
	}
}
