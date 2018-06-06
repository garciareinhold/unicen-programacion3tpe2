package tpe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Test {
	
	private static final int MAX_DATASET = 4;
	private static final int MAX_SERV = 3;
	private static final int MAX_GENEROS = 100;

	

	public static void main(String[] args) {
		
		
		//Cambiar el parámetro de run(boolean) a TRUE si se desea imprimir el grafo 
		//para ser visualizado en https://graphs.grevian.org/graph
		run(false);
		
		
		//Para personalizar la ruta hacia los archivos de lectura modificarla en run(boolean)
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	private static void run(boolean imprimir) {
		
		LiteraryGenreAnalyzer tool= new LiteraryGenreAnalyzer();
		System.out.println("Elección de un dataset sobre el cual ejecutar los servicios, del 1 al 4");
		int dataset= cargarNumero(MAX_DATASET);
		
		
		//*****Modificar la parte estática de la ruta hacia el archivo******
		
		tool.generateGenreGraph("C:/datasets-etapa2/dataset"+dataset+".csv");
		
		if(imprimir) tool.printGenreGraph();

		
		String genero= cargarGenero();
		int servicio=0;
		
		while(servicio!=-1) {
			System.out.println("Elección del Servicio a ejecutar, para salir ingrese -1");
			servicio=cargarNumero(MAX_SERV);
			switch (servicio) {
				case 1:
					System.out.println("Eleccion de la cantidad de generos más buscados luego de "+genero+":");
					int n= cargarNumero(MAX_GENEROS);
					System.out.println("Resultado: "+tool.servicioA(n, genero)+"\n");
				break;
				case 2:
					System.out.println("Todos los generos buscados luego de: "+genero);
					List<String> resultB= tool.servicioB(genero);
					if (resultB.size()==1) {
						System.out.println("No hay géneros buscados luego de: "+genero+"\n");
					}
					else {
						System.out.println("Resultado: "+resultB);
					}
				break;
				case 3:
					System.out.println("Géneros afines de: "+genero);
					List<String> resultC= tool.servicioC(genero);
					if (resultC.size()<=1) {
						System.out.println("No hay géneros afines de: "+genero+"\n");
					}
					else {
						System.out.println("Resultado: "+resultC+"\n");
					}
				break;
			}
			
		}
		System.out.println("Para servicios sobre otro dataset, vuelva a ejecutar el programa.");
	}

	private static String cargarGenero() {
		String genre="";
		boolean valido=false;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		do
			try{
				System.out.println("Ingrese el nombre del género: (recuerde que los arhcivos .csv no copian bien los acentos)");
				genre = new String(entrada.readLine());
				valido=true;
				
			}catch(Exception ex){
				System.out.print("Caracteres ingresados invalidos.");
				valido=false;
			}
		while(!valido);
		return genre;
	}
	
	public static int cargarNumero(int valorMax){
		int valor=0;
		boolean entero=false;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		do
			try{
				System.out.println("Ingrese un número :");
				valor = new Integer(entrada.readLine());
				if(valor>=1 && valor<=valorMax) {
					entero=true;
				}
				else if (valor==-1) entero=true;
			}catch(Exception ex){
				System.out.print("Valor ingresado invalido");
				entero=false;
			}
		while(!entero);
		return valor;
	}
	
}