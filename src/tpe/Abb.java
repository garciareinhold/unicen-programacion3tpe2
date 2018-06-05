package tpe;

import java.util.ArrayList;
import java.util.List;

public class Abb{
	
	private class NodoArbol {
		
		private Vertice info;
		private NodoArbol left;
		private NodoArbol right;
		
		private NodoArbol(Vertice g) {
			info= g;
			left=null;
			right=null;
		}
		
		private NodoArbol() {
			info=null;
			left=null;
			right=null;
		}
		
		protected Vertice getInfo() {
			return this.info;
		}
		
		protected NodoArbol getLeft() {
			return this.left;
		}
		
		protected NodoArbol getRight() {
			return this.right;
		}
		
		protected void setLeft(NodoArbol left) {
			this.left=left;
		}
		
		protected void setRight(NodoArbol right) {
			this.right=right;
		}
		
	}

	private NodoArbol root;
	private int nodosVisitados;
	

	public Abb(Vertice g) {
		this.root= new NodoArbol(g);
		this.nodosVisitados=0;
	}
	
	public Abb() {
		this.root=null;
		this.nodosVisitados=0;
	}

	public boolean isEmpty() {
		return (root==null);
	}

	public Vertice getElem(String o) {
		if(!this.isEmpty()) return getElem(this.root, o);
		else return null;
	}

	private Vertice getElem(NodoArbol rootAux, String o) {
		this.nodosVisitados++;
		if (rootAux!=null) {
			int compare= rootAux.getInfo().getInfo().compareTo(o);
			if(compare==0) return rootAux.getInfo();
			else if (compare<0) return getElem(rootAux.getRight(), o);
			else return getElem(rootAux.getLeft(), o);
		}
		else return null;
	}
	
	public int getNodosVisitados() {
		return this.nodosVisitados;
	}
	
	public void resetNodosVisitados() {
		this.nodosVisitados=0;
	}

	public void insert(Vertice g) {
		//Si el árbol esta vacio, seteo el root y le agrego su libro, además de registrar la visita al primer nodo
		if (this.isEmpty()) {
			this.root= new NodoArbol (g);
			this.nodosVisitados++;
		}
		else{
				this.insert(g, root);
		}
		
	}

	private void insert(Vertice g, NodoArbol nodo) {
		this.nodosVisitados++;
		if(nodo.getInfo().getInfo().compareTo(g.getInfo())>0) {
			if(nodo.getLeft()!=null){
				this.insert(g, nodo.getLeft());
			}
			else{
				NodoArbol nuevo= new NodoArbol(g);
				nodo.setLeft(nuevo);
			}
		}
		else if(nodo.getInfo().getInfo().compareTo(g.getInfo())<0) {
			if(nodo.getRight()!=null){
				this.insert(g, nodo.getRight());
  			}
			else{
				NodoArbol nuevo= new NodoArbol(g);
				nodo.setRight(nuevo);
			}
		}
		
	}
	
	public List<Vertice> recorrerPreOrden() {
		List<Vertice> listaVertices= new ArrayList<Vertice>();
		recorrerPreOrden(this.root, listaVertices);
		return listaVertices;
	}

	private void recorrerPreOrden(NodoArbol root, List<Vertice> listaVertices) {
		if(root != null) {
			listaVertices.add(root.getInfo());
			recorrerPreOrden(root.getLeft(), listaVertices);
			recorrerPreOrden(root.getRight(), listaVertices);
		}
	} 

}
