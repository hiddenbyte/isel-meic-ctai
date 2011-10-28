package localizacoes;

import espest.Operador;
import espest.Transicao;

public class OperadorLocalizacao extends Operador<EstadoLocalizacao> 
{
	private EstadoLocalizacao estadoCorrente;
	private EstadoLocalizacao estadoSeguinte;
	private double custo;
	
	public OperadorLocalizacao(EstadoLocalizacao estadoCorrente, 
			EstadoLocalizacao estadoSeguinte,
			double custo)
	{
		this.estadoCorrente = estadoCorrente;
		this.estadoSeguinte = estadoSeguinte;
		this.custo = custo;
	}
	
	public Transicao<EstadoLocalizacao> transitar(EstadoLocalizacao estado) {
		
		if(estadoCorrente.equals(estado))
			return new Transicao<EstadoLocalizacao>(estado, estadoSeguinte, this, custo);
		return null;
	}
	
	@Override
	public String toString()
	{
		return String.format("(%s,%s,%s)",
				estadoCorrente.localizacao,estadoSeguinte.localizacao, custo);
	}

}
