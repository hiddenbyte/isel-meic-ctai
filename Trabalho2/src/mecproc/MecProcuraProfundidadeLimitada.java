package mecproc;

public class MecProcuraProfundidadeLimitada<E> extends MecProcuraProfundidade<E> {
	protected int limite;
	
	public MecProcuraProfundidadeLimitada(int limite) {
		this.limite = limite;
	}
	
	@Override
	protected void juntar(No<E> no) {
		if(no.getProf() <= limite)
			super.juntar(no);
	}
}
