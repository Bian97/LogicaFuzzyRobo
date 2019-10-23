public class InferenciaNebulosa {
	public String InferenciaNebulosa(String baixo, String direita, String esquerda, String cima) {
		RegrasNebulosas regras = new RegrasNebulosas();
		return regras.Decisao(baixo, direita, esquerda, cima);
	}
}