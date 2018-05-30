package tpe;


public class Arista {

	int peso;
	Vertice origen;
	Vertice destino;
	
	public Arista(Vertice origen, Vertice destino) {
		this.peso=1;
		this.destino=destino;
		this.origen=origen;
	}
	
	public void setDestino(Vertice destino) {
		this.destino=destino;
	}
	
	public void setOrigen(Vertice origen) {
		this.origen=origen;
	}
	
	public Vertice getDestino() {
		return this.destino;
	}
	
	public Vertice getOrigen() {
		return this.origen;
	}
	
	public void setPeso(int peso) {
		this.peso=peso;
	}
	
	public int getPeso() {
		return this.peso;
	}

}
