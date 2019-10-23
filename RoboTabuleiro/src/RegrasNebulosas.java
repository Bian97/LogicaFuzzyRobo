public class RegrasNebulosas {
	public String Decisao(String baixo, String direita, String esquerda, String cima) {// Perto, Medio ou Longe
		String direcao = "";
		if (baixo.equals("Longe") && direita.equals("Longe") && esquerda.equals("")) {
			direcao = "Baixo";
		} else if (baixo.equals("Longe") && (direita.equals("Perto") || direita.equals("Medio"))
				&& esquerda.equals("Medio") && cima.equals("Medio")) {
			direcao = "Baixo";
		} else if (baixo.equals("") && direita.equals("Perto") && esquerda.equals("Medio") && cima.equals("Longe")) {
			direcao = "Direita";
		} else if (baixo.equals("Longe") && (direita.equals("Perto") || direita.equals("Medio"))
				&& (esquerda.equals("") || esquerda.equals("Medio") || esquerda.equals("Longe"))
				&& cima.equals("Longe")) {
			direcao = "Baixo";
		} else if (baixo.equals("Longe") && direita.equals("Perto") && esquerda.equals("Perto")
				&& cima.equals("Longe")) {
			direcao = "Baixo";
		} else if (baixo.equals("Longe") && direita.equals("") && (esquerda.equals("") || esquerda.equals("Longe"))
				&& cima.equals("Longe")) {
			direcao = "Baixo";
		} else if (baixo.equals("Longe") && direita.equals("") && (esquerda.equals("Perto") || esquerda.equals("Medio"))
				&& (cima.equals("Medio") || cima.equals("Longe"))) {
			direcao = "Baixo";
		} else if (baixo.equals("Longe") && (direita.equals("Perto") || direita.equals("Longe"))
				&& esquerda.equals("Medio") && (cima.equals("") || cima.equals("Perto"))) {
			direcao = "Baixo";
		} else if (baixo.equals("Longe") && (direita.equals("Medio") || direita.equals("Longe"))
				&& (esquerda.equals("Perto") || esquerda.equals("Medio") || esquerda.equals("Longe"))
				&& (cima.equals("Perto") || cima.equals("Longe"))) {
			direcao = "Baixo";
		} else if (baixo.equals("Longe") && direita.equals("Longe") && esquerda.equals("Longe")
				&& cima.equals("Medio")) {
			direcao = "Baixo";
		} else if (baixo.equals("Longe") && direita.equals("Longe") && esquerda.equals("Medio")
				&& cima.equals("Medio")) {
			direcao = "Direita";
		} else if (baixo.equals("Longe") && direita.equals("Longe") && esquerda.equals("Perto")
				&& (cima.equals("") || cima.equals("Medio") || cima.equals("Longe"))) {
			direcao = "Baixo";
		} else if (baixo.equals("Longe") && !direita.equals("Longe") && !esquerda.equals("Medio")
				&& !cima.equals("Longe")) {
			direcao = "Baixo";
		} else if (baixo.equals("Longe") && direita.equals("Longe") && esquerda.equals("Longe")
				&& cima.equals("")) {
			direcao = "Baixo";
		} else if (baixo.equals("Longe") && direita.equals("Medio") && esquerda.equals("Longe")
				&& cima.equals("Longe")) {
			direcao = "Baixo";
		} else if (baixo.equals("Medio") && (direita == "" || direita.equals("Perto") || direita.equals("Medio"))
				&& !esquerda.equals("Longe") && (cima.equals("Perto") || cima.equals("Medio"))) {
			direcao = "Baixo";
		} else if (baixo.equals("Medio") && direita == ""
				&& esquerda.equals("Longe") && cima.equals("")) {
			direcao = "Baixo";
		} else if (baixo.equals("Medio") && (direita.equals("Perto"))
				&& (esquerda.equals("Medio") || esquerda.equals("Longe")) && cima.equals("")) {
			direcao = "Baixo";
		} else if (baixo.equals("Medio") && (direita.equals("")) && esquerda.equals("Longe")
				&& (cima.equals("Medio") || cima.equals("Longe"))) {
			direcao = "Baixo";
		} else if (baixo.equals("Medio") && direita.equals("") && esquerda.equals("Longe") && cima.equals("Perto")) {
			direcao = "Baixo";
		} else if (baixo.equals("Medio") && direita.equals("Perto") && cima.equals("Longe")) {
			direcao = "Baixo";
		} else if (baixo.equals("Medio") && direita.equals("Medio") && cima.equals("")) {
			direcao = "Direita";
		} else if (baixo.equals("Medio") && direita.equals("Medio") && cima.equals("Longe")) {
			direcao = "Direita";
		} else if (baixo.equals("Medio") && direita.equals("Longe")) {
			direcao = "Direita";
		} else if (baixo.equals("Perto") && direita.equals("") && !esquerda.equals("Longe")
				&& (!cima.equals("Perto") || !cima.equals(""))) {
			direcao = "Cima";
		} else if (baixo.equals("Perto") && direita.equals("") && esquerda.equals("Longe")
				&& (cima.equals("") || cima.equals("Medio") || cima.equals("Longe"))) {
			direcao = "Baixo";
		} else if (baixo.equals("Perto") && direita.equals("Perto") && esquerda.equals("Longe")
				&& !cima.equals("Medio")) {
			direcao = "Direita";
		} else if (baixo.equals("Perto") && direita.equals("Perto") && esquerda.equals("Medio")
				&& cima.equals("Longe")) {
			direcao = "Direita";
		} else if (baixo == "" && direita.equals("") && cima.equals("Longe")) {
			direcao = "Cima";
		} else if ((baixo.equals("Perto") || baixo == "") && (direita.equals("Medio") || direita.equals("Longe"))) {
			direcao = "Direita";
		} else if ((baixo.equals("Perto") || baixo == "") && direita.equals("") && esquerda.equals("Longe")
				&& (cima.equals("Medio") || cima.equals("Longe"))) {
			direcao = "Cima";
		} else if ((baixo.equals("Perto") || baixo == "") && direita.equals("Perto") && esquerda.equals("Longe")
				&& (cima.equals("Medio"))) {
			direcao = "Direita";
		} else if (baixo == "" && direita.equals("Perto") && esquerda.equals("Longe")
				&& (cima.equals("Longe"))) {
			direcao = "Cima";
		} else if ((baixo.equals("Perto") || baixo == "") && (direita.equals("Perto") || direita == "")
				&& cima.equals("Perto") && (esquerda.equals("Medio") || esquerda.equals("Longe"))) {
			direcao = "Esquerda";
		} else if ((baixo.equals("Perto") || baixo == "") && (direita.equals("Perto") || direita == "")
				&& (esquerda.equals("Perto") || esquerda == "") && (cima.equals("Perto") || cima == "")) {
			direcao = "Sem Saida";
		} else if ((baixo.equals("Perto")) && (direita.equals("Perto")) && (esquerda.equals(""))
				&& (cima.equals("Longe"))) {
			direcao = "Direita";
		} else if ((baixo.equals("Perto")) && (direita.equals("Perto")) && (esquerda.equals("Medio"))
				&& (cima.equals(""))) {
			direcao = "Direita";
		} else if (baixo.equals("Perto") && direita.equals("Perto") && esquerda.equals("Perto")
				&& cima.equals("Longe")) {
			direcao = "Direita";
		} else if (baixo.equals("Medio") && direita.equals("Medio") && esquerda.equals("Longe")
				&& cima.equals("Perto")) {
			direcao = "Direita";
		} else if (baixo.equals("Medio") && direita.equals("Medio") && esquerda.equals("Longe")
				&& cima.equals("Medio")) {
			direcao = "Baixo";
		} else if (baixo.equals("Medio") && direita.equals("") && esquerda.equals("")
				&& (cima.equals("Medio") || cima.equals("Longe"))) {
			direcao = "Baixo";
		} else if (baixo.equals("Medio") && direita.equals("Perto") && esquerda.equals("Longe")
				&& (cima.equals("Perto") || cima.equals("Medio") || cima.equals("Longe"))) {
			direcao = "Baixo";
		} else if (baixo.equals("Medio") && direita == "" && esquerda.equals("Medio") && cima.equals("Longe")) {
			direcao = "Baixo";
		} else if (baixo.equals("Longe") && direita.equals("Medio") && esquerda.equals("Medio") && cima.equals("")) {
			direcao = "Baixo";
		} else if (baixo.equals("") && direita.equals("") && (esquerda.equals("Medio") || esquerda.equals("Longe")) && cima.equals("Medio")) {
			direcao = "Cima";
		} else if (baixo.equals("Longe") && direita.equals("") && esquerda.equals("Medio") && cima.equals("")) {
			direcao = "Baixo";
		} else if (baixo.equals("") && direita.equals("Perto") && esquerda.equals("Perto") && cima.equals("Longe")) {
			direcao = "Cima";
		} else if (baixo.equals("Longe") && direita.equals("") && esquerda.equals("Medio") && cima.equals("Perto")) {
			direcao = "Baixo";
		}
		return direcao;
	}
}