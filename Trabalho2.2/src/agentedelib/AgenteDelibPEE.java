package agentedelib;

import java.util.LinkedList;
import java.util.List;

import mecproc.MecProcura;
import mecproc.No;
import ambiente.Accao;
import ambiente.Coordenada;

public class AgenteDelibPEE extends AgenteDelib<Coordenada>{
	
	private MecProcura<Coordenada> mecProc;
	protected List<Accao> plano;
	
	public AgenteDelibPEE(MecProcura<Coordenada> m/*, int intervaloDeReconsideracaoForcada*/){
	
		//super(intervaloDeReconsideracaoForcada);
		mecProc = m;
	}

	@Override
	protected void planear() {
		
		plano = new LinkedList<Accao>();
		
		
		List<No<Coordenada>> nos = mecProc.procurar(crencas.getAgente().getPosicao(), new ObjectivoNoMapa(intencoes.getFirst().getPosicao()), capacidades);
		nos.remove(0); //head da solução
		
		for(No<Coordenada> no : nos){
			OperadorAccao operador = (OperadorAccao)(no.obterOperador());
			//if(operador != null) //head da solução
				plano.add(operador.getAccao());
		}
	}
	
	private Accao accao;
	
	@Override
	public void agir(){
		
		if(!plano.isEmpty()){
			
			accao = plano.remove(0);
			getActuador().actuar(accao);
			
		}
	}

}
