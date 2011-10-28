package mecproc;

public class MecProcuraCustoUnif<E> extends MecProcura<E>{
	@Override
	public int compare(No<E> noIns, No<E> no) {
		return Double.compare(noIns.getCusto(),no.getCusto());
	}
}
