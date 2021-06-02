import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitTest {

	@Test
	public void testRutaMasCorta() {
		
		String cont = "";
        String direccion = "guategrafo.txt";

        lectorArchivo lectorArchivo = new lectorArchivo();

        String [] retornar = lectorArchivo.leerTxt(direccion);

        
        for(int i = 0; i < retornar.length; i++){
            System.out.println(retornar[i]);
        }

        //variables
        int op= 999999;
        int tamano = 5;

        int grafo[][] = {{0,  999999, 999999, 999999, 999999},
                        {999999, 0, 999999, 999999, 999999},
                        {999999, 999999, 0, 999999, 999999},
                        {999999, 999999, 999999, 0, 999999},
                        {999999, 999999, 999999, 999999, 0}};

        //A = MIXCO | B = ANTIGUA | C = SANTA LUCIA | D = GUATEMALA | E = ESCUINTLA
        String grafo2[][] = {{"Z",    "ANTIGUA", "SANTA LUCIA", "GUATEMALA", "ESCUINTLA"},
                            {"MIXCO", "Z",       "SANTA LUCIA", "GUATEMALA", "ESCUINTLA"},
                            {"MIXCO", "ANTIGUA", "Z",           "GUATEMALA", "ESCUINTLA"},
                            {"MIXCO", "ANTIGUA", "SANTA LUCIA", "Z",         "ESCUINTLA"},
                            {"MIXCO", "ANTIGUA", "SANTA LUCIA", "GUATEMALA", "Z"}};


        funciones funciones = new funciones();

        grafo = funciones.areglarGrafo(grafo, retornar);
        grafo2 = funciones.CompletarGrafo2(grafo, grafo2);
        grafo = funciones.CompletarGrafo(grafo);
		
		int prueba = funciones.RutaMasCorta("ESCUINTLA", "GUATEMALA", grafo2, grafo);
		
		int resultado = 70;
		
		assertEquals(prueba,resultado);
		
		int prueba2 = funciones.RutaMasCorta("ESCUINTLA", "ANTIGUA", grafo2, grafo);
		
		int resultado2 = 110;
		
		assertEquals(prueba2,resultado2);
		
	}

}
