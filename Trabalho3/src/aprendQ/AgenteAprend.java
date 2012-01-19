package aprendQ;

import agente.Agente;
import ambiente.Accao;
import ambiente.Coordenada;
import ambiente.ElemAgente;
import ambiente.Accao.Tipo;

public class AgenteAprend extends Agente
{
	private final double MAX_REFORCO;
	private ElemAgente perProp;
	private MecAprendQ<Coordenada> mecAprend;
	private Accao a;
	private Coordenada s;
	private Coordenada sn;
	
	public AgenteAprend(){
		MAX_REFORCO = 100;
	}

	@Override
	public void agir()
	{
		if(perProp.isCarga())
		{
			getAmb().reIniciar();
			a = null;
		}
		
		if(a != null) {
			getActuador().actuar(a);
		}
	}

	@Override
	public void iniciar()
	{
		Accao[] accoes = Accao.gerarAccoes(Tipo.PEGAR);
		mecAprend = new MecAprendQ<>(accoes,0.5,0.95,0.1);
	}

	@Override
	public void percepcionar() {
		perProp = this.getSensorProprio().detectar();
	}

	@Override
	public void processar() {
		sn = perProp.getPosicao();
		
		if(a != null) {
			double r = gerarReforco();
			mecAprend.assimilar(s,a,sn,r);
		}
		
		s = sn;
		a = mecAprend.selAccao(s);
	}
	
	private double gerarReforco() {
		if(perProp.isCarga())
		{
			return MAX_REFORCO;
		}
		else 
			if(perProp.isColisao())
			{
				return -MAX_REFORCO;
			}
			else
			{
				return -s.dist(sn); 
			}
	}
}
