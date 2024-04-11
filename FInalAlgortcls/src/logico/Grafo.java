package logico;

import java.util.ArrayList;
//ir haciendo los metodos porx
public class Grafo {
	
	 private ArrayList<Nodo> misNodos;
	 private ArrayList<Arista> misAristas;
	 //
	 
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

}
