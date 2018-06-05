package tpe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GrafoDirigido {

	double entradasRecursivasS2;
	double entradasRecursivasS3;
	double comparacionesCiclo;
	int busquedaPorAristas;
	List<Arista> aristas;
	Abb vertices;

	public GrafoDirigido() {
		entradasRecursivasS2=0;
		entradasRecursivasS3=0;
		comparacionesCiclo=0;
		busquedaPorAristas=0;
		aristas= new ArrayList <Arista>();
		vertices= new Abb();
	}

	public double getEntradasRecursivasS2() {
		return this.entradasRecursivasS2;
	}
	
	public double getEntradasRecursivasS3() {
		return this.entradasRecursivasS3;
	}
	
	public double getComparacionesCiclo() {
		return this.getComparacionesCiclo();
	}
	
	public int getBusquedaPorAristas() {
		return this.getBusquedaPorAristas();
	}

	public void addVertice(Vertice v) {
		this.vertices.insert(v);
	}
	
	public int getBusquedasGenero() {
		return this.vertices.getNodosVisitados();
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
			this.busquedaPorAristas++;
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
		}
		dfs_visit(origen, lista);
	}

	private void dfs_visit(Vertice vertice, List<String> lista) {
		this.entradasRecursivasS2++;
		vertice.setEstado("amarillo");
		List<Arista>vecinos= vertice.getAdyacentes();
		for(int j=0; j<vecinos.size(); j++) {
			if(vecinos.get(j).getDestino().getEstado().equals("blanco")) {
				dfs_visit(vecinos.get(j).getDestino(), lista);
			}
		}
		vertice.setEstado("negro");
		lista.add(vertice.getInfo());
	}

	public List<Vertice> getListaVertices() {
		return this.vertices.recorrerPreOrden();
	}

	public List<String> dfs_ciclo(String nombreGenero) {
		List<String> retorno= new ArrayList<String>();
		retorno.add(nombreGenero);
		List<Vertice> vertices= this.getListaVertices();
		for(int i=0; i<vertices.size();i++) {	
			vertices.get(i).setEstado("blanco");
			vertices.get(i).setPadre(null);
		}	
		Vertice genero=this.vertices.getElem(nombreGenero);
		genero.setEstado("amarillo");
		List <Arista> adyacentes=genero.getAdyacentes();
		int j=0;
		while(j<adyacentes.size()) {
			if(adyacentes.get(j).getDestino().getEstado().equals("blanco")) {
				thereIsAcycle(adyacentes.get(j).getDestino(), retorno, nombreGenero);
			}
			j++;
		}			
		return retorno;
	}

	private void thereIsAcycle(Vertice vertice, List<String> retorno, String generoOrigen) {
		this.entradasRecursivasS3++;
		vertice.setEstado("amarillo");
		List <Arista> adyacentes= vertice.getAdyacentes();	
		int j=0;
		while(j<adyacentes.size()) {
			Vertice v= adyacentes.get(j).getDestino();
			if(v.getEstado().equals("blanco")) {
				this.comparacionesCiclo++;
				v.setPadre(vertice);
				thereIsAcycle(v, retorno, generoOrigen);
			} 

			else {
				if(v.getEstado().equals("amarillo")) {
					this.comparacionesCiclo++;
					if(retorno.contains(v.getInfo())) {
						getGrafoResultante(vertice, retorno, generoOrigen);			
					}		

				} 
			}
			j++;
		}
		if(!retorno.contains(vertice.getInfo())) {
			vertice.setEstado("negro");
		}
	}


	private void getGrafoResultante(Vertice vertice, List<String> retorno, String generoOrigen) {
		if(!retorno.contains(vertice.getInfo()))	retorno.add(vertice.getInfo());

		Vertice padre= vertice.getPadre();
		while((padre!=null)&&(padre.getInfo()!=generoOrigen)) {
			if (!retorno.contains(padre.getInfo())) {
				retorno.add(padre.getInfo());

			}
			padre= padre.getPadre();
		}	
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
