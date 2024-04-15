package logico;

import java.util.ArrayList;

public class Grafo {
	
	private ArrayList<Nodo> misNodos;
	private ArrayList<Arista> misAristas;
	
	public Grafo() {
		super();
		this.misNodos = new ArrayList<Nodo>();
		this.misAristas = new ArrayList<Arista>();
	}
	
	public ArrayList<Nodo> getMisNodos() {
		return misNodos;
	}
	
	public void setMisNodos(ArrayList<Nodo> misNodos) {
		this.misNodos = misNodos;
	}
	
	public ArrayList<Arista> getMisAristas() {
		return misAristas;
	}
	
	public void setMisAristas(ArrayList<Arista> misAristas) {
		this.misAristas = misAristas;
	}
	
	public void insertarNodo(Nodo nodo) {
		misNodos.add(nodo);
	}
	
	public void eliminarNodo(Nodo nodo) {
		
		ArrayList<Arista> tempAristas = new ArrayList<Arista>(nodo.getMisAristas());
		
		for(Arista arista: tempAristas) {
			
			Nodo origen = arista.getUbicacionOrigen();
			Nodo destino = arista.getUbicacionDestino();
			
			origen.eliminarArista(arista);
			destino.eliminarArista(arista);
			
			misAristas.remove(arista);
		}
		misNodos.remove(nodo);
	}
	
	public void actualizarNodo(Nodo nodo, String nombre, double longuitud, double latitud) {
		nodo.setNombreUbicacion(nombre);
	    nodo.setLonguitud(longuitud);
	    nodo.setLatitud(latitud);
	}
	
	public void insertarArista(Arista arista) {
		arista.getUbicacionOrigen().insertarArista(arista);
	    arista.getUbicacionDestino().insertarArista(arista);
		misAristas.add(arista);
	}
	
	public void eliminarArista(Arista arista) {
		arista.getUbicacionOrigen().eliminarArista(arista);
		arista.getUbicacionDestino().eliminarArista(arista);
		misAristas.remove(arista);
	}
	
	
	public int [][] generarMatrizAdyacencia(){
		
		int numN = misNodos.size();
	    int[][] matrizAdyacencia = new int[numN][numN];

	    for (int i = 0; i < numN; i++) {
	        for (int j = 0; j < numN; j++) {
	            matrizAdyacencia[i][j] = 0; //No conectado en tal caso.
	        }
	    }

	    for (Arista arista : misAristas) {
	    	
	    	int origen = misNodos.indexOf(arista.getUbicacionOrigen());
	    	int destino = misNodos.indexOf(arista.getUbicacionDestino());
	        matrizAdyacencia[destino][origen] = matrizAdyacencia[origen][destino] = arista.getPeso();
	    }

	    return matrizAdyacencia;
	}
	
	public void imprimirMatrizAdyacencia(int[][] matriz) {
	    
		int filas = matriz.length;
	    int columnas = matriz[0].length;

	    System.out.println("\nMatriz de Adyacencia:");
	   
	    System.out.print("  ");
	    for (int j = 0; j < columnas; j++) {
	        System.out.print(j + " ");
	    }
	    System.out.println();
	    
	    for (int i = 0; i < filas; i++) {
	        
	    	System.out.print(i + " ");
	        
	        for (int j = 0; j < columnas; j++) {
	            System.out.print(matriz[i][j] + " ");
	        }
	        
	        System.out.println();
	    }
	}
	
	public Nodo buscarNodoByNombre(String nombre) {
	    
		Nodo aux = null;
	    boolean encontrado = false;
	    int i = 0;
	    
	    while (!encontrado && i < misNodos.size()) {
	    	if (misNodos.get(i).getNombreUbicacion().equalsIgnoreCase(nombre)) {
	    		encontrado = true;
	    		aux = misNodos.get(i);
	    	}
	    	i++;
	    }
	    return aux;
	}
	
	public int buscarIndexByNombre(String nombre) {
		
		int index = -1;
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i < misNodos.size()) {
			
			if(misNodos.get(i).getNombreUbicacion().equalsIgnoreCase(nombre)) {
				encontrado = true;
				index = i;
			}
			i++;
		}
		return index;
	}

    public int[] calcularDijkstra(int matrizAdyacencia[][], int origen)  {
    	
    	int numN = misNodos.size();
        int distancia[] = new int[numN];
        boolean[] visitado = new boolean[numN];
   
        for (int i = 0; i < numN; i++) { 
        	distancia[i] = Integer.MAX_VALUE; //Maxima distancia posible, tiende a infinito segun la teoria.
            visitado[i] = false; 
        } 
   
        distancia[origen] = 0; 
        
        for (int j = 0; j < numN - 1; j++) { 
            int u = minimaDistancia(distancia, visitado); 
            visitado[u] = true; 
            for (int v = 0; v < numN; v++) {
            	if (!visitado[v] && matrizAdyacencia[u][v] != 0 && distancia[u] != Integer.MAX_VALUE && distancia[u] + matrizAdyacencia[u][v] < distancia[v]) {
                	distancia[v] = distancia[u] + matrizAdyacencia[u][v];
                } 
            }    
        }   
        return distancia;
    }
    
	private int minimaDistancia(int[] distancia, boolean[] visitado) {
		
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		
		for (int i = 0; i < misNodos.size(); i++) {
			if(visitado[i] == false && distancia[i] <= min) {
				min = distancia[i];
				min_index = i;
			}
		}
		return min_index;
	}
    
	public void imprimirResultadosDijkstra(int distancia[], String ubicacion){
		
		String destino = "";
		int maxLen = 0;
	    
	    for (Nodo nodo : misNodos) {
	        int len = nodo.getNombreUbicacion().length();
	        if (len > maxLen) {
	        	maxLen = len;
	        }
	    }
	    
	    int maxVal = Integer.MIN_VALUE;
	    for (int i = 0; i < distancia.length; i++) {
	        int val = distancia[i];
	        if (val > maxVal) {
	            maxVal = val;
	        }
	    }
		
		System.out.println("Destino: \t Distancia Mínima Desde " + ubicacion + ":"); 
		
        for (int i = 0; i < misNodos.size(); i++) {
        	destino = misNodos.get(i).getNombreUbicacion();
        	System.out.printf("%-" + maxLen + "s \t\t %" + Math.abs(maxLen-maxVal) + "d km %n", destino, distancia[i]);
        }
    }
}
