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
		Set<Transicao<Coordenada>> transicoes = new HashSet<>();
		Accao[] accoes = Accao.gerarAccoes(tipoDeAccao);

		for (Accao accao : accoes)
		{
			OperadorAccao operadorAccao = new OperadorAccao(crencas, accao);
			
			Transicao<Coordenada> transicao = operadorAccao.transitar(estado);
			
			if (transicao != null)
				transicoes.add(transicao);
		}

		return transicoes;
	}
}
