package mecproc;

public class MecProcuraProfundidade<E> extends MecProcura<E>{

	@Override
	protected void juntar(No<E> no) {
		fronteira.addFirst(no);
	}

}
