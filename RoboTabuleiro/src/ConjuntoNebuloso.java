import java.util.ArrayList;

public class ConjuntoNebuloso {
	public String Distancia(int x) {
		double pertinencia = Perto(x);
	    double comparacao = 0;
	    if(pertinencia == 1){
	        return "";//Retorna que obst�culo � menor que 0 (N�o tem dist�ncia)
	    } else if(pertinencia > 0 && pertinencia < 1){
	        comparacao = Medio(x);
	        if(pertinencia > comparacao){
	        	//listDistancia.add(pertinencia);
	        	//listDistancia.add("Perto");//perto
	        	//return listDistancia;
	        	return "Perto";
	        } else {
	        	/*listDistancia.add(comparacao);
	        	listDistancia.add("Medio");*///M�dio
	        	return "Medio";
	        }
	    } else if(pertinencia <= 0){ //<= 0 equivale � um n�mero muito grande para a categoria
	        pertinencia = Medio(x);
	        if(pertinencia <= 0){
	            return "";//Retorna que obst�culo � menor que 0 ou maior que 5 (N�o tem dist�ncia/Muito Longe)
	        } else {
	            comparacao = Longe(x);
	            if(pertinencia > comparacao){
	            	/*listDistancia.add(pertinencia);
		        	listDistancia.add("Medio");*///M�dio
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