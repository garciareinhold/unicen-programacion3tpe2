package tpe;


public class Test {

	public static void main(String[] args) {

		LiteraryGenreAnalyzer tool= new LiteraryGenreAnalyzer();
		tool.generateGenreGraph("C:/datasets-etapa2/dataset0.csv");
		//System.out.println(tool.getBusquedaPorAristas());
		
		System.out.println(tool.getCantidadGeneros());
		//tool.printGenreGraph();
		
		System.out.println(tool.servicioA(6, "cine"));
		System.out.println(tool.getBusquedasGenero());
		
		//Servicio 2 y los contadores que arroja
		System.out.println(tool.servicioB("cine"));
		System.out.println(tool.getEntradasRecursivasS2());
		
		
		
		//Servicio 3 y los contadores que arroja
		System.out.println(tool.servicioC("cine"));
		System.out.println(tool.getEntradasRecursivasS3());
		System.out.println(tool.getComparacionesCiclo());

	}
}
