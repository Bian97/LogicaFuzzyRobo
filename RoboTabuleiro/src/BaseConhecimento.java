import java.util.ArrayList;

public class BaseConhecimento {
	ConjuntoNebuloso conjuntoNebuloso = new ConjuntoNebuloso();
	
	public String ConjuntosNebulosos(int espacos) {
		return conjuntoNebuloso.Distancia(espacos);
	}
}
