import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class funciones{

    public int[][] EdicionDeGrafo(int grafo[][], String salida, String llegada, int modi, int opcion){

        int V = 5;

        int posicion1 = 0;
        int posicion2 = 0;

        if(opcion == 2){

            String buscar = salida.toUpperCase();
            String buscar2 = llegada.toUpperCase();

            switch (buscar) {
                case ("MIXCO"):
                    posicion1 = 0; 
                    break;

                case ("ANTIGUA"):
                    posicion1 = 1; 
                    break;

                case ("SANTA LUCIA"):
                    posicion1 = 2; 
                    break;

                case ("GUATEMALA"):
                    posicion1 = 3; 
                    break;

                case ("ESCUINTLA"):
                    posicion1 = 4; 
                    break;
            
                default:
                    break;
            }

            switch (buscar2) {
                case ("MIXCO"):
                    posicion2 = 0; 
                    break;

                case ("ANTIGUA"):
                    posicion2 = 1; 
                    break;

                case ("SANTA LUCIA"):
                    posicion2 = 2; 
                    break;

                case ("GUATEMALA"):
                    posicion2 = 3; 
                    break;

                case ("ESCUINTLA"):
                    posicion2 = 4; 
                    break;
            
                default:
                    break;
            }

            grafo[posicion1][posicion2] = modi;

        } else if(opcion == 1){

            String buscar = salida.toUpperCase();
            String buscar2 = llegada.toUpperCase();

            switch (buscar) {
                case ("MIXCO"):
                    posicion1 = 0; 
                    break;

                case ("ANTIGUA"):
                    posicion1 = 1; 
                    break;

                case ("SANTA LUCIA"):
                    posicion1 = 2; 
                    break;

                case ("GUATEMALA"):
                    posicion1 = 3; 
                    break;

                case ("ESCUINTLA"):
                    posicion1 = 4; 
                    break;
            
                default:
                    break;
            }

            switch (buscar2) {
                case ("MIXCO"):
                    posicion2 = 0; 
                    break;

                case ("ANTIGUA"):
                    posicion2 = 1; 
                    break;

                case ("SANTA LUCIA"):
                    posicion2 = 2; 
                    break;

                case ("GUATEMALA"):
                    posicion2 = 3; 
                    break;

                case ("ESCUINTLA"):
                    posicion2 = 4; 
                    break;
            
                default:
                    break;
            }

            grafo[posicion1][posicion2] = 999999;

        }

        return grafo;

    }

    public int RutaMasCorta(String salida, String Llegada, String grafo[][], int grafo2[][]){

        int respuestaInt = 0;

        ArrayList<String> respuesta = new ArrayList<>();

        int V = 5;

        int posicion1=0;

        int posicion2=0;

        String buscar = salida.toUpperCase();
        String buscar2 = Llegada.toUpperCase();

        respuesta.add(buscar);

        switch (buscar) {
            case ("MIXCO"):
                posicion1 = 0; 
                break;

            case ("ANTIGUA"):
                posicion1 = 1; 
                break;

            case ("SANTA LUCIA"):
                posicion1 = 2; 
                break;

            case ("GUATEMALA"):
                posicion1 = 3; 
                break;

            case ("ESCUINTLA"):
                posicion1 = 4; 
                break;
        
            default:
                break;
        }

        switch (buscar2) {
            case ("MIXCO"):
                posicion2 = 0; 
                break;

            case ("ANTIGUA"):
                posicion2 = 1; 
                break;

            case ("SANTA LUCIA"):
                posicion2 = 2; 
                break;

            case ("GUATEMALA"):
                posicion2 = 3; 
                break;

            case ("ESCUINTLA"):
                posicion2 = 4; 
                break;
        
            default:
                break;
        }

        String busqueda = grafo[posicion1][posicion2];

        

        respuesta.add(busqueda);

        int posi = 0;
        
        System.out.println("\n");
        System.out.println("PESO DEL VIAJE = " + grafo2[posicion1][posicion2]);
        respuestaInt = grafo2[posicion1][posicion2];
        if(busqueda.toUpperCase().equals(Llegada.toUpperCase())){

            for(int j = 0; j < respuesta.size(); j++){

                System.out.print(respuesta.get(j) + " ");

            }

        }else{

            switch (busqueda) {
                case ("MIXCO"):
                    posi = 0; 
                    break;
    
                case ("ANTIGUA"):
                    posi = 1; 
                    break;
    
                case ("SANTA LUCIA"):
                    posi = 2; 
                    break;
    
                case ("GUATEMALA"):
                    posi = 3; 
                    break;
    
                case ("ESCUINTLA"):
                    posi = 4; 
                    break;
            
                default:
                    break;
            }

            for(int i = 0; i < V; i++){
                
                String a = grafo[posi][i];

                if(a.toUpperCase().equals(Llegada.toUpperCase()) && i <1){
                    
                    respuesta.add(a);
                }
            }
            for(int j = 0; j < respuesta.size(); j++){

                System.out.print(respuesta.get(j) + " ");
    
            }
        }
        
        System.out.println("\n");
        return respuestaInt;
        
    }

    public int[][] CompletarGrafo(int grafo[][]){

        int V = 5;

        int grafoR[][] = new int[V][V];//[fila][columna]
        int i, j, k;
 
        for (i = 0; i < V; i++){
            for (j = 0; j < V; j++){
                grafoR[i][j] = grafo[i][j];
            }
        }


        for (k = 0; k < V; k++){
            for (i = 0; i < V; i++){
                for (j = 0; j < V; j++){
                    if (grafoR[i][k] + grafoR[k][j] < grafoR[i][j])
                        grafoR[i][j] = grafoR[i][k] + grafoR[k][j];
                }
            }
        }

        return grafoR;

    }

    public String[][] CompletarGrafo2(int grafo[][], String grafo2[][]){

        int V = 5;

        int grafoR[][] = grafo;//[fila][columna]
        String grafoR2[][] = grafo2;//[fila][columna]
        int i, j, k;
 
        for (i = 0; i < V; i++){
            for (j = 0; j < V; j++){
                grafoR[i][j] = grafo[i][j];
            }
        }
        for (k = 0; k < V; k++){
            for (i = 0; i < V; i++){
                for (j = 0; j < V; j++){
                    if (grafoR[i][k] + grafoR[k][j] < grafoR[i][j]){
                        grafoR[i][j] = grafoR[i][k] + grafoR[k][j];

                        if(k == 0){
                            grafoR2[i][j] = "MIXCO";
                        } else if(k == 1){
                            grafoR2[i][j] = "ANTIGUA";
                        }else if(k == 2){
                            grafoR2[i][j] = "SANTA LUCIA";
                        }else if(k == 3){
                            grafoR2[i][j] = "GUATEMALA";
                        }else if(k == 4){
                            grafoR2[i][j] = "ESCUINTLA";
                        }
                    }
                        
                }
            }
        }

        return grafoR2;

    }

    public int[][] areglarGrafo(int[][] grafo, String[] info){

        int grafoR[][] = grafo;

        String lugarSalida = "";
        int respuestaS = -1;

        String lugarLlegada = "";
        int respuestaL = -1;

        int colocar = -1;

        for(int i = 0; i < info.length; i++){

            int k = i;

            //System.out.println(info[k] + "---------" + k);
            lugarSalida = info[k];
            
            k++;
            //System.out.println(info[k] + "---------" + k);
            lugarLlegada = info[k];
            

            k++;
            //System.out.println(info[k] + "---------" + k);
            colocar = Integer.valueOf(info[k]);
            
            

            respuestaS = Salida(lugarSalida);

            respuestaL = Llegada(lugarLlegada);

            grafoR[respuestaS][respuestaL] = colocar;

            i = i + 2;

        }

        return grafoR;

    }
    public int Salida(String lugarSalida){

        int respuestaS = 0;

        switch (lugarSalida) {
            case ("Mixco"):
                respuestaS = 0; 
                break;

            case ("Antigua"):
                respuestaS = 1; 
                break;

            case ("Santa-Lucia"):
                respuestaS = 2; 
                break;

            case ("Guatemala"):
                respuestaS = 3; 
                break;

            case ("Escuintla"):
                respuestaS = 4; 
                break;
        
            default:
                break;
        }

        return respuestaS;
    }
    public int Llegada(String lugarLlegada){

        int respuestaL = 0;

        switch (lugarLlegada) {
            case ("Mixco"):
                respuestaL = 0; 
                break;

            case ("Antigua"):
                respuestaL = 1; 
                break;

            case ("Santa-Lucia"):
                respuestaL = 2; 
                break;

            case ("Guatemala"):
                respuestaL = 3; 
                break;

            case ("Escuintla"):
                respuestaL = 4; 
                break;
        
            default:
                break;
        }

        return respuestaL;
    }

}