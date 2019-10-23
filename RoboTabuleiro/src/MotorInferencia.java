import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class MotorInferencia {
	private String[][] campo = new String[50][50];
	private Interface tela = new Interface();
	private BaseConhecimento base = new BaseConhecimento();
	private Robo robo = new Robo();

	public void GerarTabuleiro() {
		int[] x = new int[180];
		int[] y = new int[180];
		for (int i = 0; i < 180;) {
			Random r = new Random();
			x[i] = r.nextInt(50 - 0) + 0;
			y[i] = r.nextInt(50 - 0) + 0;
			// System.out.println("Valor: "+ x[i] + " e "+ y[i]);
			boolean condition = VerificarExistencia(x, y, i);
			if (!condition && ((x[i] != 0 && y[i] != 0) || (x[i] != 49 && y[i] != 49))) {
				if (campo[x[i]][y[i]] == null || !campo[x[i]][y[i]].equals("P")) {
					campo[x[i]][y[i]] = "P";
					i++;
				} else {
					System.out.println("Repetido");
				}
			}
		}
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				if (campo[i][j] == null) {
					campo[i][j] = " ";
				}
			}
		}
		campo[0][0] = "R";
		campo[49][49] = "S";
		int[] posiInicial = { 0, 0 };
		int[] posiAnterior = { 0, 0 };
		robo.setPosiAnterior(posiAnterior);
		robo.setPosiAtual(posiInicial);
		tela.ImprimirTabuleiro(campo);
	}

	public String Fuzzificador(int espacos) {
		return base.ConjuntosNebulosos(espacos);
	}

	public boolean VerificarExistencia(int[] x, int[] y, int i) {
		for (int j = 0; j < i; j++) {
			if (x[j] == x[i] && y[j] == y[i]) {
				return true;
			}
		}
		return false;
	}

	public boolean Movimento() {
		int posiColunaRobo = robo.getPosiAtual()[1] + 1;
		int posiLinhaRobo = robo.getPosiAtual()[0] + 1;
		int contadorBaixo = 0;
		int contadorEsquerda = 0;
		int contadorDireita = 0;
		int contadorCima = 0;
		boolean achou = false;
		String valor = ""; // Consertar verificações para as direções (Estão trocadas; Ex: Baixo com
							// direita)

		for (int i = posiLinhaRobo; i < posiLinhaRobo + 5; i++) {// Verifica para baixo
			if (i >= 0 && i < 50) {
				valor = campo[i][posiColunaRobo - 1];
				if (i >= 0 && valor != null) {
					if (!valor.equals("P") || valor.equals("S")) {
						if (valor.equals("S")) {
							if (i == posiLinhaRobo) {
								achou = true;
							} else {
								contadorBaixo++;
							}
						} else {
							contadorBaixo++;
						}
					} else {
						break;
					}
				}
			} else {
				break;
			}
		}

		for (int j = posiColunaRobo; j < posiColunaRobo + 5; j++) {// Verifica para direita
			if (j >= 0 && j < 50) {
				valor = campo[posiLinhaRobo - 1][j];
				if (j >= 0 && valor != null) {
					if (!valor.equals("P") || valor.equals("S")) {
						if (valor.equals("S")) {
							if (j == posiColunaRobo) {
								achou = true;
							} else {
								contadorDireita++;
							}
						} else {
							contadorDireita++;
						}
					} else {
						break;
					}
				}
			} else {
				break;
			}
		}
		int index = posiColunaRobo - 2;
		if (index >= 0) {
			for (int j = posiColunaRobo - 2; j >= posiColunaRobo - 6; j--) {// Verifica para esquerda
				if (j >= 0 && j < 50) {
					valor = campo[posiLinhaRobo - 1][j];
					if (j >= 0 && valor != null) {
						if (!valor.equals("P") || valor.equals("S")) {
							if (valor.equals("S")) {
								if (j == posiColunaRobo) {
									achou = true;
								} else {
									contadorEsquerda++;
								}
							} else {
								contadorEsquerda++;
							}
						} else {
							break;
						}
					}
				} else {
					break;
				}
			}
		}
		index = posiLinhaRobo - 2;
		if (index >= 0) {
			for (int i = posiLinhaRobo - 2; i >= posiLinhaRobo - 6; i--) {// Verifica para cima
				if (i >= 0 && i < 50) {
					valor = campo[i][posiColunaRobo - 1];
					if (i >= 0 && valor != null) {
						if (!valor.equals("P") || valor.equals("S")) {
							if (valor.equals("S")) {
								if (i == posiLinhaRobo) {
									achou = true;
								} else {
									contadorCima++;
								}
							} else {
								contadorCima++;
							}
						} else {
							break;
						}
					}
				} else {
					break;
				}
			}
		}
		if (!achou) {
			int[] posicaoAtual = new int[2];
			posicaoAtual = robo.getPosiAtual();
			robo.setDistanciaBaixo(String.valueOf(Fuzzificador(contadorBaixo)));
			robo.setDistanciaDireita(String.valueOf(Fuzzificador(contadorDireita)));
			robo.setDistanciaEsquerda(String.valueOf(Fuzzificador(contadorEsquerda)));
			robo.setDistanciaCima(String.valueOf(Fuzzificador(contadorCima)));
			InferenciaNebulosa inferencia = new InferenciaNebulosa();
			String direcao = inferencia.InferenciaNebulosa(robo.getDistanciaBaixo(), robo.getDistanciaDireita(),
					robo.getDistanciaEsquerda(), robo.getDistanciaCima());
			if (direcao.equals("Sem Saida")) {// Movimentação fica no desfuzzyficador
				System.out.println("Tô Trancado!!");
				return true;
			} else {
				posicaoAtual = Defuzzyficador(direcao, posicaoAtual);
				robo.setPosiAtual(posicaoAtual);
			}
			
			
			/*else if (direcao.equals("Baixo")) {//Se robo.Baixo == Longe entao posiAtual += 5 Se robo.Baixo == Medio entao posiAtual+=2 Senao posiAtual++; 
				posicaoAtual[0]++;
				robo.setPosiAtual(posicaoAtual);
			} else if (direcao.equals("Direita")) {
				posicaoAtual[1]++;
				robo.setPosiAtual(posicaoAtual);
			} else if (direcao.equals("Esquerda")) {
				posicaoAtual[1]--;
				robo.setPosiAtual(posicaoAtual);
			} else if (direcao.equals("Cima")) {
				posicaoAtual[0]--;
				robo.setPosiAtual(posicaoAtual);
			}*/
			campo[robo.getPosiAnterior()[0]][robo.getPosiAnterior()[1]] = " ";
			campo[robo.getPosiAtual()[0]][robo.getPosiAtual()[1]] = "R";

			if (campo[robo.getPosiAtual()[0]][robo.getPosiAtual()[1]].equals("R")) {
				int[] posicaoAnterior = new int[2];
				posicaoAnterior[0] = robo.getPosiAtual()[0];
				posicaoAnterior[1] = robo.getPosiAtual()[1];
				robo.setPosiAnterior(posicaoAnterior);
			}

			tela.ImprimirTabuleiro(campo);// , robo.getPosiAnterior(), robo.getPosiAtual());
			return false;
		} else {
			//JOptionPane.showMessageDialog(null, "Cheguei!!");
			//System.out.println("Cheguei!!");
			return true;
		}
	}
	
	public int[] Defuzzyficador(String direcao, int[] posicaoAnterior) {
		if (direcao.equals("Baixo")) {
			if(robo.getDistanciaBaixo().equals("Longe") && !campo[(posicaoAnterior[0] + 5)][posicaoAnterior[1]].equals("S")) {
				posicaoAnterior[0] += 4;
			} else if (robo.getDistanciaBaixo().equals("Medio") && !campo[(posicaoAnterior[0] + 2)][posicaoAnterior[1]].equals("S")) {
				posicaoAnterior[0] += 2;
			} else {
				posicaoAnterior[0] += 1;
			}			
		} else if (direcao.equals("Direita")) {
			if(robo.getDistanciaDireita().equals("Longe") && !campo[posicaoAnterior[0]][(posicaoAnterior[1] + 5)].equals("S")) {
				posicaoAnterior[1] += 4;
			} else if (robo.getDistanciaDireita().equals("Medio") && !campo[posicaoAnterior[0]][(posicaoAnterior[1] + 2)].equals("S")) {
				posicaoAnterior[1] += 2;
			} else {
				posicaoAnterior[1] += 1;
			}
		} else if (direcao.equals("Esquerda")) {
			/*if(robo.getDistanciaEsquerda().equals("Longe") && !campo[posicaoAnterior[0]][(posicaoAnterior[1] - 5)].equals("S")) {
				posicaoAnterior[1] -= 4;
			} else if (robo.getDistanciaEsquerda().equals("Medio") && !campo[posicaoAnterior[0]][(posicaoAnterior[1] - 2)].equals("S")) {
				posicaoAnterior[1] -= 2;
			} else {*/
				posicaoAnterior[1] -= 1;
			//}
		} else if (direcao.equals("Cima")) {
			if(robo.getDistanciaCima().equals("Longe") && !campo[(posicaoAnterior[0] - 5)][posicaoAnterior[1]].equals("S")) {
				posicaoAnterior[0] -= 3;
			} else if (robo.getDistanciaCima().equals("Medio") && !campo[(posicaoAnterior[0] - 2)][posicaoAnterior[1]].equals("S")) {
				posicaoAnterior[0] -= 2;
			} else {
				posicaoAnterior[0] -= 1;
			}
		}
		return posicaoAnterior;
	}
}