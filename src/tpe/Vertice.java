package tpe;

import java.util.ArrayList;
import java.util.List;


public class Vertice {

	String info;
	List <Arista> adyacentes;
	int distancia;
	String estado;
	Vertice padre;
	
	public Vertice(String info) {
		this.info=info;
		adyacentes= new ArrayList<Arista>();
	}
	public void setDistancia(int distancia) {
		this.distancia=distancia;
	}
	
	public void setPadre (Vertice v) {
		this.padre=v;
	}
	
	public void setEstado (String e) {
		this.estado=e;
	}
	
	public Vertice getPadre() {
		return this.padre;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public void setInfo(String o) {
		this.info=o;
	}
	
	public String getInfo() {
		return this.info;
	}	
		
	public int getDistancia() {
		return this.distancia;
	}
	
	public void addAdyacentes(Arista arista) {
		this.adyacentes.add(arista);
	}
	
	public List<Arista> getAdyacentes() {
		return this.adyacentes;
	}
	
	public int sizeAdyacentes() {
		return this.adyacentes.size();
	}
}
