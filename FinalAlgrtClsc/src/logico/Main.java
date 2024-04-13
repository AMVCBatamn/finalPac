package logico;

public class Main {

	public static void main(String[] args) {
		
		Grafo grafo = new Grafo();
		
		Nodo A = new Nodo(10, "Moca", 10.5, 20.3);
		Nodo B = new Nodo(23, "La Vega", 15.2, 25.7);
		Nodo C = new Nodo(13, "Santiago", 20.8, 30.1);
		
		grafo.insertarNodo(A);
		grafo.insertarNodo(B);
		grafo.insertarNodo(C);
		
		Arista arista1 = new Arista(A, B, 5);
		Arista arista2 = new Arista(B, C, 8);
		
		///PROBANDO LOS METODOS:
		
		grafo.insertarArista(arista1);
		grafo.insertarArista(arista2);
		
		///ANTES DE ELIMINAR EL NODO B:
		System.out.println("ANTES DE ELIMINAR EL NODO B:\n");
		System.out.println("Nodos/Ubicaciones en el grafo:");
		
		for (Nodo nodo : grafo.getMisNodos()) {
		    System.out.println("Ubicación: " + nodo.getNombreUbicacion() + " con código: " + nodo.getCodigo() + " y con valor: " + nodo.getValor());
		}
		
		System.out.println("\nAristas/Conexiones en el grafo:");
		for (Arista a: grafo.getMisAristas()) {
			System.out.println("Origen " + a.getUbicacionOrigen().getNombreUbicacion() +
		                       " destino " + a.getUbicacionDestino().getNombreUbicacion() +
		                       " con distancia de " + a.getPeso());
		}
		
		///DESPUES DE ELIMINAR EL NODO B:
		grafo.eliminarNodo(B);
		System.out.println("\n\n\nDESPUES DE ELIMINAR EL NODO B:\n");
		System.out.println("Nodos/Ubicaciones en el grafo:");
		
		for (Nodo nodo : grafo.getMisNodos()) {
		    System.out.println("Ubicación: " + nodo.getNombreUbicacion() + " con código: " + nodo.getCodigo() + " y con valor: " + nodo.getValor());
		}
		
		System.out.println("\nAristas/Conexiones en el grafo:");
		for (Arista arista: grafo.getMisAristas()) {
			System.out.println("Origen " + arista.getUbicacionOrigen().getNombreUbicacion() +
		                       " destino " + arista.getUbicacionDestino().getNombreUbicacion() +
		                       " con distancia de " + arista.getPeso());
		}
	}

}
