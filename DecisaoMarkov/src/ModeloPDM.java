import java.util.Set;

import espest.OperadorGeral;
import espest.Transicao;


public interface ModeloPDM<E> {
	
	double t(Transicao<E> trans);
	double r(Transicao<E> trans);
	Set<E> s();
	Set<OperadorGeral<E>> o(E s);
	void pintar();
}
