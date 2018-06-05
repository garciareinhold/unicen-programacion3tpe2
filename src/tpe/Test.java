package tpe;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		LiteraryGenreAnalyzer tool= new LiteraryGenreAnalyzer();
		tool.generateGenreGraph("C:/Users/German/Downloads/datasets-2da etapa/dataset4.csv");
		//tool.printGenreGraph();
		System.out.println(tool.servicioA(6, "tecnología"));
		System.out.println(tool.servicioB("tecnología"));
		List<String> resultado = new ArrayList<String>();
		tool.servicioC("tecnología", resultado);
		for(int i=0;i<resultado.size();i++) {
			System.out.println(resultado.get(i));
		}

	}

}
