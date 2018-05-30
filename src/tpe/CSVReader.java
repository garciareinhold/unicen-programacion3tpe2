package tpe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

	final static int NOMBRE= 0;
	final static int GENERO=3;
	
	public List<String[]> readCsv(String archivo){
	    //Leo linea por linea del archivo generando los libros con su nombre y un arreglo de generos,
		//los agregamos a la lista vinculada y la retornamos
        String line = "";
        String cvsSplitBy = ",";
        List<String[]> lineas= new ArrayList<String[]>();
        //Usamos un contador para tomar desde el primer libro y no el titulo del .csv
        int cont=0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            while ((line = br.readLine()) != null) {
            	if(cont>0) {
            		String[] items = line.split(cvsSplitBy);
            		lineas.add(items);
            	}
            	cont++;
            }
            	
            
        }         
        catch (IOException e) {
            e.printStackTrace();
        }     
        return lineas;     
    }
    
    
}

