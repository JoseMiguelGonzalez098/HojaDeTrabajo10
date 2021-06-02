
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
class main{
    public static void main(String [] args){

        Scanner scan = new Scanner(System.in);

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
        System.out.println("\n");
        System.out.println("\n");

        for(int i = 0; i < tamano; i++){
            for(int j = 0; j < tamano; j++){

                int val = grafo[i][j];
                if(val == 999999){
                    System.out.print("INF\t");
                }else{
                    System.out.print(val + "\t");
                }
                
            }
            System.out.println("\n");
        }
        for(int i = 0; i < tamano; i++){
            for(int j = 0; j < tamano; j++){

                String val = grafo2[i][j];
                
                System.out.print(val + "      \t");
                
                
            }
            System.out.println("\n");
        }
        
        System.out.println("\n\nBIENVENIDO AL PROGRAMA PARA ANALIZAR LAS RUTAS MAS CONVENIENTE DURANTE ESTE DESASTRE DE GOBIERNO \n\n");
        
        int opcion = 0;

        while (op != 3){ 
            
            //-------------------------------------------------------------------------------------------------------------------
            System.out.println("---MENU---");
            System.out.println("1. RUTA MAS CORTA");
            System.out.println("2. CENTRO PARA COLOCAR ESTACION");
            System.out.println("3. Salir\n\n");
            
            
            opcion = scan.nextInt();
            op = opcion;
            
            /****************************************************************************************/
            if (op == 1) {//OPCION PARA RUTA MAS CORTA

                String infoSalida;
                String infoLlegada;

                System.out.println("Ingrese el nombre de la ciudad de salida");
                infoSalida = scan.next();

                System.out.println("Ingrese el nombre de la ciudad de llegada");
                infoLlegada = scan.next();

                funciones.RutaMasCorta(infoSalida, infoLlegada, grafo2, grafo);
                
            /****************************************************************************************/
            } else if(op == 2){

                int modi = 0;

                while (modi != 3){ 
            
                    //-------------------------------------------------------------------------------------------------------------------
                    System.out.println("1. BLOQUEAR UNA RUTA");
                    System.out.println("2. MODIFICAR UNA RUTA");
                    System.out.println("3. Salir\n\n");
                    modi = scan.nextInt();

                    String infoSalida;
                    String infoLlegada;
                    int cambio = 0;
                    
                    /****************************************************************************************/
                    if (modi == 1) {//BLOQUEAR RUTA

                        System.out.println("Ingrese el lugar, de salida del lugar que desea bloquear ruta.");
                        infoSalida = scan.next();

                        System.out.println("Ingrese el lugar, de llegada del lugar que desea bloquear ruta.");
                        infoLlegada = scan.next();

                        funciones.EdicionDeGrafo(grafo, infoSalida, infoLlegada, cambio, modi);
                        
                    /****************************************************************************************/
                    } else if(modi == 2){//MODIFICAR RUTA

                        System.out.println("Ingrese el lugar, de salida del lugar que desea modificar la ruta.");
                        infoSalida = scan.next();

                        System.out.println("Ingrese el lugar, de llegada del lugar que desea modificar la ruta.");
                        infoLlegada = scan.next();

                        System.out.println("Ingrese el nuevo valor de la ruta.");
                        cambio = scan.nextInt();

                        funciones.EdicionDeGrafo(grafo, infoSalida, infoLlegada, cambio, modi);

                    /****************************************************************************************/
                    } else if(modi == 3){
        
                        System.out.println("Adios");
        
                    /****************************************************************************************/    
                    } else{
        
                        System.out.println("opcion no valida");
        
                    }

                    grafo = funciones.areglarGrafo(grafo, retornar);
                    grafo2 = funciones.CompletarGrafo2(grafo, grafo2);
                    grafo = funciones.CompletarGrafo(grafo);

                }
                
            /****************************************************************************************/
            } else if(op == 3){

                System.out.println("Adios");

            /****************************************************************************************/    
            } else{

                System.out.println("opcion no valida");

            }
        }
    }
}