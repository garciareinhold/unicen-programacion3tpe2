package tpe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GrafoDirigido {

	List<Arista> aristas;
	Abb vertices;
	List<Vertice> padres;
	List<String> estados;
	
	public GrafoDirigido() {
		aristas= new ArrayList <Arista>();
		padres= new ArrayList <Vertice>();
		estados= new ArrayList<String>();
		vertices= new Abb();
	} 
	
	public void addVertice(Vertice v) {
			this.vertices.insert(v);
	}

	public void addArista(Vertice v1, Vertice v2) {
		Arista nueva= new Arista(v1,v2);
	    this.aristas.add(nueva);
	    v1.addAdyacentes(nueva);
	}

	public int numeroAristas() {
		return this.aristas.size();
	}

	public Arista existeArista(Vertice origen, Vertice destino) {
		Iterator<Arista> it = aristas.iterator();
		while(it.hasNext()) {
			Arista aux= it.next();
			if((aux.getOrigen().getInfo()==origen.getInfo())&&(aux.getDestino().getInfo()==destino.getInfo())) return aux;
		}
		return null;
	}
	
	public Vertice getVertice(String g) {
		return this.vertices.getElem(g);
	}

	public List<Arista> getAdyacentes(Vertice c) {	
		return c.getAdyacentes();
	}

	public void dfs(Vertice origen, List<String> lista) {
		List<Vertice> listaVertices = vertices.recorrerPreOrden();
		for(int i=0; i<listaVertices.size(); i++) {
			listaVertices.get(i).setEstado("blanco");
			listaVertices.get(i).setPadre(null);
		}
		dfs_visit(origen, lista);
	}

	private void dfs_visit(Vertice vertice, List<String> lista) {
		vertice.setEstado("amarillo");
		List<Arista>vecinos= vertice.getAdyacentes();
		for(int j=0; j<vecinos.size(); j++) {
			if(vecinos.get(j).getDestino().getEstado().equals("blanco")) {
				vecinos.get(j).getDestino().setPadre(vertice);
				dfs_visit(vecinos.get(j).getDestino(), lista);
			}
		}
		vertice.setEstado("negro");
		lista.add(vertice.getInfo());
	}
	
	public List<Vertice> getListaVertices() {
		return this.vertices.recorrerPreOrden();
	}
	
	public void printGraph() {
		List<Vertice> listaVertices= this.vertices.recorrerPreOrden();
		for(int i=0; i<listaVertices.size(); i++) {
			List<Arista> aristasV= listaVertices.get(i).getAdyacentes();
			for(int j=0; j<aristasV.size(); j++) {
				System.out.println(listaVertices.get(i).getInfo()+" -> "+aristasV.get(j).getDestino().getInfo()+"[label="+(char)34+aristasV.get(j).getPeso()+(char)34+",weight="+(char)34+aristasV.get(j).getPeso()+(char)34+"];");
			}
		}
	}
}
