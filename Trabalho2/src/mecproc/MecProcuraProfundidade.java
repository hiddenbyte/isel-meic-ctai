package mecproc;

public class MecProcuraProfundidade<E> extends MecProcura<E> {
	@Override
	public int compare(No<E> noIns, No<E> no) {
		return  no.getProf() - noIns.getProf();
	}
}
