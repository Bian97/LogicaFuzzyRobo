
public class Robo {
	private int[] PosiAtual = new int[2];
	private int[] PosiAnterior = new int[2];
	private String DistanciaBaixo;
	private String DistanciaDireita;
	private String DistanciaEsquerda;
	private String DistanciaCima;
	
	public int[] getPosiAtual() {
		return PosiAtual;
	}
	public void setPosiAtual(int[] posiAtual) {
		PosiAtual = posiAtual;
	}
	public int[] getPosiAnterior() {
		return PosiAnterior;
	}
	public void setPosiAnterior(int[] posiAnterior) {
		PosiAnterior = posiAnterior;
	}
	public String getDistanciaBaixo() {
		return DistanciaBaixo;
	}
	public void setDistanciaBaixo(String distanciaBaixo) {
		DistanciaBaixo = distanciaBaixo;
	}
	public String getDistanciaDireita() {
		return DistanciaDireita;
	}
	public void setDistanciaDireita(String distanciaDireita) {
		DistanciaDireita = distanciaDireita;
	}
	public String getDistanciaEsquerda() {
		return DistanciaEsquerda;
	}
	public void setDistanciaEsquerda(String distanciaEsquerda) {
		DistanciaEsquerda = distanciaEsquerda;
	}
	public String getDistanciaCima() {
		return DistanciaCima;
	}
	public void setDistanciaCima(String distanciaCima) {
		DistanciaCima = distanciaCima;
	}	
}