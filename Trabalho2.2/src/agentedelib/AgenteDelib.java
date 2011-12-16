package agentedelib;

import java.util.List;

import espest.OperadorGeral;

import agente.Agente;
import agente.MemElem;
import ambiente.Accao;
import ambiente.Coordenada;
import ambiente.Elemento;
import java.util.ArrayList;

public abstract class AgenteDelib extends Agente
{
	protected MemElem crencas = new MemElem();
	protected MemElem desejos = new MemElem();
	protected MemElem intencoes = new MemElem();
	protected List<Accao> plano;
	protected MemElem perGlobal;
	
	protected int  intervaloDeReconsideracaoForcada;
	protected int iteracao;
	
	protected List<OperadorGeral<Coordenada>> capacidades;
	
	public AgenteDelib(int intervaloDeReconsideracaoForcada){
	
		this.intervaloDeReconsideracaoForcada = intervaloDeReconsideracaoForcada;
		iteracao = 0;
	}
	
	@Override
	public void iniciar()
	{
		capacidades =  new ArrayList<OperadorGeral<Coordenada>>();
		capacidades.add(new OperadorAccaoGeral(crencas, Accao.Tipo.PEGAR));
		capacidades.add(new OperadorAccaoGeral(crencas, Accao.Tipo.LARGAR));
		capacidades.add(new OperadorAccaoGeral(crencas, Accao.Tipo.MOVER));
	}

	@Override
	public void percepcionar()
	{
		perGlobal = getSensorPanoramico().detectar();
	}
	
	@Override
	public void processar()
	{
		actualizarCrencas();
		if (reconsiderar())
		{
			deliberar();
			planear();
		}
	}

	protected void actualizarCrencas()
	{
		crencas.update(perGlobal);
	}

	protected boolean reconsiderar()
	{
		if(intervaloDeReconsideracaoForcada == 0)
			return crencas.alteracao();
		else
			if(iteracao%intervaloDeReconsideracaoForcada==0)
				return true;
		return false;
	}

	protected void deliberar()
	{
		gerarOpções();
		seleccionarOpcoes();
	}

	protected void gerarOpções()
	{
		desejos.clear();

		if (crencas.getAgente().isCarga())
			desejos.putAll(crencas.get(Elemento.Tipo.BASE, false));
		else
			desejos.putAll(crencas.get(Elemento.Tipo.ALVO, false));
	}

	protected void seleccionarOpcoes()
	{
		intencoes.clear();
		
		Elemento melhorOpcao = desejos.getProx(crencas.getAgente().getPosicao());
		
		if (melhorOpcao != null)
			intencoes.put(melhorOpcao);
	}

	protected abstract void planear();
	
	
	private Accao accao;
	
	@Override
	public void agir(){
		
		if(!plano.isEmpty()){
			
			accao = plano.remove(0);
			getActuador().actuar(accao);
			
		}
	}
}
