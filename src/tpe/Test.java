package tpe;

public class Test {

	public static void main(String[] args) {
		
		LiteraryGenreAnalyzer tool= new LiteraryGenreAnalyzer();
		tool.generateGenreGraph("C:/datasets-etapa2/dataset1.csv");
		//tool.printGenreGraph();
		System.out.println(tool.servicioA(6, "tecnología"));
		System.out.println(tool.servicioB("tecnología"));
		tool.servicioC("tecnología");

	}

}
