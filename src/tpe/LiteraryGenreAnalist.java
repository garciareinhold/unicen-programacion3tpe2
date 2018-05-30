package tpe;

import java.util.List;

public class LiteraryGenreAnalist {

	private CSVReader reader;
	GrafoDirigido genreGraph;
	
	public LiteraryGenreAnalist() {
		this.reader= new CSVReader();
		this.genreGraph= new GrafoDirigido();
	}
	
	public void generateGenreGraph(String path) {
		
		//Traigo una lista con todas las lineas del archivo
		List<String[]> lineas = this.reader.readCsv(path);
		
		//por cada una de las lineas...
		for(int i=0; i<lineas.size(); i++) {
			//rescato la primer linea
			String []linea = lineas.get(i);
			// rescato el primer genero
			String genero= linea[0]; 
			// si no existe el vértice con ese género lo agrego, si no no hago nada.
			Vertice v= this.genreGraph.getVertice(genero);
			
			if(v==null) {
				v= new Vertice(genero);
				genreGraph.addVertice(v);
			}
			
			//defino un vertice auxiliar para que vaya cambiando con el siguiente
			Vertice auxAnterior= v;
			
			//por cada genero de la linea, después del primero
			for(int j=1; j<linea.length; j++) {
				//me fijo si existe el vertice
				Vertice siguiente=  this.genreGraph.getVertice(linea[j]);
				if(siguiente!=null) {
					// si existe pregunto si tiene arista con el anterior
					Arista a=this.genreGraph.existeArista(auxAnterior, siguiente);
					
					//si tiene arista con el anterior, le incremento 1 al peso
					if(a!=null) {
						a.setPeso(a.getPeso()+1);
					}
					// si no tiene arista con el anterior, la creo
					else {
						this.genreGraph.addArista(auxAnterior, siguiente);					
					}
				}
				//si no existe el vértice lo creo y creo su arista con el anterior
				else {
					siguiente = new Vertice(linea[j]);
					this.genreGraph.addVertice(siguiente);
					this.genreGraph.addArista(auxAnterior, siguiente);
				}
				auxAnterior= siguiente;
			}
		}
	}

	public void printGenreGraph() {
		this.genreGraph.printGraph();
	}
	
		
}
