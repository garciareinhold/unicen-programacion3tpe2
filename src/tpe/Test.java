package tpe;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LiteraryGenreAnalist tool= new LiteraryGenreAnalist();
		tool.generateGenreGraph("C:/datasets-etapa2/dataset0.csv");
		tool.printGenreGraph();
	}

}
