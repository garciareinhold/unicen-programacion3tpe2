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
	
public void dfs_ciclo(String vertice) {
		
		List <Arista> adyacentes= this.getVertice(vertice).getAdyacentes();

		boolean cycle=false;
		
		for(int j=0; j<adyacentes.size(); j++) {
			List<Vertice> parcial = new ArrayList<Vertice>();
			adyacentes.get(j).getDestino().setEstado("blanco");
			this.vertices.getElem(vertice).setEstado("amarillo");
			thereIsAcycle(adyacentes.get(j).getDestino(), parcial, vertice); 
			System.out.println(cycle + " " + adyacentes.get(j).getDestino().getInfo());
			for(int i=0;i<parcial.size();i++) {
				System.out.println(parcial.get(i).getInfo()); 
			}		
			System.out.println("////////////////////////////////////////////////////////////////");
		}
		
	}
	
	private void thereIsAcycle(Vertice vertice, List<Vertice> parcial, String comienzoCiclo) {
		
		vertice.setEstado("amarillo"); 
		List <Arista> adyacentes= vertice.getAdyacentes();	
		int j=0;
		parcial.add(vertice);
		
		while((j<adyacentes.size())) {

			if(adyacentes.get(j).getDestino().getEstado().equals("blanco")) { 
				
				thereIsAcycle(adyacentes.get(j).getDestino(), parcial, comienzoCiclo);				
			} 
			else {
				if (adyacentes.get(j).getDestino().getEstado().equals("amarillo") && 
						adyacentes.get(j).getDestino().getInfo() == comienzoCiclo)	{				
				}					
			}
			 
			j++; 
		}
		vertice.setEstado("negro"); 
	
	}
	
	public void getCiclo (String vertice) {
		this.dfs_ciclo(vertice);
	}
	
	/*public List<String> dfs_ciclo(String nombreGenero) {
		List<String> retorno= new ArrayList<String>();
		List<Vertice> vertices= this.getListaVertices();
		for(int i=0; i<vertices.size();i++) {	
			vertices.get(i).setEstado("blanco");
			vertices.get(i).setPadre(null);
		}	
			Vertice genero=this.vertices.getElem(nombreGenero);;
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
		vertice.setEstado("amarillo");
		List <Arista> adyacentes= vertice.getAdyacentes();	
		int j=0;
		while(j<adyacentes.size()) {
			Vertice v= adyacentes.get(j).getDestino();
			if(v.getEstado().equals("blanco")) {
				v.setPadre(vertice);
				thereIsAcycle(v, retorno, generoOrigen);
			} 
				
			else {
				if(v.getEstado().equals("amarillo")) {
					getGrafoResultante(vertice, retorno, generoOrigen);				
					
				} 
			}
			j++;
		}
		vertice.setEstado("negro");
	}

	
	private void getGrafoResultante(tpe.Vertice vertice, List<String> retorno, String generoOrigen) {
		retorno.add(vertice.getInfo());
		Vertice padre= vertice.getPadre();
		while((padre!=null)&&(padre.getInfo()!=generoOrigen)) {
			if (!retorno.contains(padre.getInfo())) {
				retorno.add(padre.getInfo());
				padre= padre.getPadre();
			}
			
		}	
	}*/

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
