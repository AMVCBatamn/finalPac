package logico;

public class Arista {
	
    private Nodo ubicacionOrigen;
    private Nodo ubicacionDestino;
    private double longitud;
    private int peso;
    
    
    
	public Nodo getUbicacionOrigen() {
		return ubicacionOrigen;
	}
	
	public void setUbicacionOrigen(Nodo ubicacionOrigen) {
		this.ubicacionOrigen = ubicacionOrigen;
	}
	
	public Nodo getUbicacionDestino() {
		return ubicacionDestino;
	}
	
	public void setUbicacionDestino(Nodo ubicacionDestino) {
		this.ubicacionDestino = ubicacionDestino;
	}
	
	public double getLongitud() {
		return longitud;
	}
	
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
    
    

}
