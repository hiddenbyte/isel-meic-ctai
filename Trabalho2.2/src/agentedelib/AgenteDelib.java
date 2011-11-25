package agentedelib;

import agente.Agente;
import agente.MemElem;
import ambiente.Accao;
import ambiente.Elemento;

public abstract class AgenteDelib extends Agente {
	protected MemElem crencas = new MemElem();
	protected MemElem desejos = new MemElem();
	protected MemElem intencoes = new MemElem();
	protected OperadorAccaoGeral[] capacidades;
	protected MemElem perGlobal;

	@Override
	public void iniciar()
	{
		capacidades = new OperadorAccaoGeral[] {
				new OperadorAccaoGeral ( crencas, Accao.Tipo.PEGAR),
				new OperadorAccaoGeral ( crencas, Accao.Tipo.LARGAR),
				new OperadorAccaoGeral ( crencas, Accao.Tipo.LARGAR)
		};
	}

	@Override
	public void processar(){
		actualizarCrencas();
		if(reconsiderar()){
			deliberar();
			planear();
		}
	}

	@Override
	public void percepcionar()
	{
		perGlobal = getSensorPanoramico().detectar();
	}
	
	//@Override
	protected void deliberar() {
		gerarOpções();
		seleccionarOpcoes();
	}

	private boolean reconsiderar() {
		return crencas.alteracao();
	}

	private void actualizarCrencas() {
		crencas.update(perGlobal);
	}

	protected void gerarOpções(){
		desejos.clear();

		if(crencas.getAgente().isCarga())
			desejos.putAll(crencas.get(Elemento.Tipo.BASE,false));
		else
			desejos.putAll(crencas.get(Elemento.Tipo.ALVO,false));
	}
	
	protected void seleccionarOpcoes() 
	{		
		intencoes.clear();
		
		Elemento melhorOpcao = desejos.getProx(crencas.getAgente().getPosicao());
		if(melhorOpcao != null)
			intencoes.put(melhorOpcao);
	}
	
	protected abstract void planear();
}
