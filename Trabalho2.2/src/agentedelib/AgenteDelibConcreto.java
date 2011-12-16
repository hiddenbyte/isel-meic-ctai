package agentedelib;

import java.util.LinkedList;
import java.util.List;

import mecproc.MecProcura;
import mecproc.MecProcuraAStar;
import mecproc.No;
import ambiente.Accao;
import ambiente.Coordenada;

public class AgenteDelibConcreto extends AgenteDelib{
	
	public AgenteDelibConcreto(int intervaloDeReconsideracaoForcada){
	
		super(intervaloDeReconsideracaoForcada);
	}

	@Override
	protected void planear() {
		
		plano = new LinkedList<Accao>();
		MecProcura<Coordenada> mec = new MecProcuraAStar<Coordenada>();
		List<No<Coordenada>>nos = mec.procurar(crencas.getAgente().getPosicao(), new ObjectivoNoMapa(intencoes.getFirst().getPosicao()), capacidades);
		nos.remove(0); //head da solu��o
		
		for(No<Coordenada> no : nos){
			OperadorAccao operador = (OperadorAccao)(no.obterOperador());
			//if(operador != null) //head da solu��o
				plano.add(operador.getAccao());
		}
	}

}
