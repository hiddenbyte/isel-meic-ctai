package localizacoes;

import mecproc.Objectivo;

public class ObjectivoLocalidade implements Objectivo<EstadoLocalizacao> {
	private String loc;
	
	public ObjectivoLocalidade(String loc)
	{
		this.loc = loc;
	}
	
	public boolean satisfeito(EstadoLocalizacao estado) {
		return estado.localizacao.equals(loc);
	}
}
