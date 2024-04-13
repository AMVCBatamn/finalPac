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
		
		for(Arista arista: nodo.getMisAristas()) {
			
			Nodo origen = arista.getUbicacionOrigen();
			Nodo destino = arista.getUbicacionDestino();
			
			origen.eliminarArista(arista);
			destino.eliminarArista(arista);
			
			misAristas.remove(arista);
		}
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
}
