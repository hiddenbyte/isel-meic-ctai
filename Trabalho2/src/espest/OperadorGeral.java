package espest;
import java.util.Set;

public interface OperadorGeral<E> {
	public Set<Transicao<E>> aplicar(E estado);
}
