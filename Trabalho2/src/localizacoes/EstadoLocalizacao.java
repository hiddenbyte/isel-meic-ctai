package localizacoes;

public class EstadoLocalizacao {
	public String localizacao;
	
	public EstadoLocalizacao(String l){
		localizacao=l;
	}
	
	@Override
	public boolean equals(Object e) {
		EstadoLocalizacao el = (EstadoLocalizacao)e;
		return el.localizacao.equals(localizacao);
	}
	
	@Override
	public String toString()
	{
		return localizacao;
	}
}
