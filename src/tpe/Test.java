package tpe;


public class Test {

	public static void main(String[] args) {

		LiteraryGenreAnalyzer tool= new LiteraryGenreAnalyzer();
		tool.generateGenreGraph("C:/datasets/dataset3.csv");
		//System.out.println(tool.getBusquedaPorAristas());
		
		System.out.println("//////////Cantidad de generos///////////");
		System.out.println(tool.getCantidadGeneros());
		//tool.printGenreGraph();
		
		System.out.println("//////////Resultado servicio A///////////");
		System.out.println(tool.servicioA(6, "cine"));
		System.out.println("//////////Busqueda de generos///////////");
		System.out.println(tool.getBusquedasGenero());
		
		//Servicio 2 y los contadores que arroja
		System.out.println("//////////Resultado servicio B///////////");
		System.out.println(tool.servicioB("cine"));
		System.out.println("//////////Cantidad de entradas recursivas///////////");
		System.out.println(tool.getEntradasRecursivasS2());
		
		
		
		//Servicio 3 y los contadores que arroja
		System.out.println("//////////Resultado servicio C///////////");
		System.out.println(tool.servicioC("cine"));
		System.out.println("//////////Cantidad de entradas recursivas///////////");
		System.out.println(tool.getEntradasRecursivasS3());
		System.out.println("//////////Cantidad de comparaciones en la busqueda de generos afines///////////");
		System.out.println(tool.getComparacionesCiclo());

	}
}
