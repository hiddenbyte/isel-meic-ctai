package mecproc;

public class MecProcuraLargura<E> extends MecProcuraGrafo<E> {
	@Override
	public int compare(No<E> noIns, No<E> no) {
		return  noIns.getProf() - no.getProf();
	}
}
