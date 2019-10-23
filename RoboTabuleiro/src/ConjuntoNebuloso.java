import java.util.ArrayList;

public class ConjuntoNebuloso {
	public String Distancia(int x) {
		double pertinencia = Perto(x);
	    double comparacao = 0;
	    if(pertinencia == 1){
	        return "";//Retorna que obstáculo é menor que 0 (Não tem distância)
	    } else if(pertinencia > 0 && pertinencia < 1){
	        comparacao = Medio(x);
	        if(pertinencia > comparacao){
	        	//listDistancia.add(pertinencia);
	        	//listDistancia.add("Perto");//perto
	        	//return listDistancia;
	        	return "Perto";
	        } else {
	        	/*listDistancia.add(comparacao);
	        	listDistancia.add("Medio");*///Médio
	        	return "Medio";
	        }
	    } else if(pertinencia <= 0){ //<= 0 equivale à um número muito grande para a categoria
	        pertinencia = Medio(x);
	        if(pertinencia <= 0){
	            return "";//Retorna que obstáculo é menor que 0 ou maior que 5 (Não tem distância/Muito Longe)
	        } else {
	            comparacao = Longe(x);
	            if(pertinencia > comparacao){
	            	/*listDistancia.add(pertinencia);
		        	listDistancia.add("Medio");*///Médio
		        	return "Medio";
	                } else {
	                	/*listDistancia.add(comparacao);
	    	        	listDistancia.add("Longe");*///Longe
	    	        	return "Longe";
	                }
	            }
	        }
		return "";
	}
	
	public double Perto(int x) {
		return (3 - (double)x) / 3;
	}
	
	public double Medio(int x) {
		double total = (((double)x) / 3);
	    if(total > 1){
	    	total = (6 - (double)x) / 3;
	    }
	    return total;
	}
	public double Longe(int x) {
		return ((double)x - 3) / 3;
	}
}