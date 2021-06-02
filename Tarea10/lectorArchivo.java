import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class lectorArchivo{
    public String[] leerTxt(String direccion){

        String cont = "";
    
        String [] reto = {};

        String [] retornar = {};
    
        try{
    
            BufferedReader bufer = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
    
            
            while((bfRead = bufer.readLine()) != null){
                //el ciclo se hace mientras bfRead tenga un dato
    
                temp = temp + "," +bfRead;
            }
    
            cont = temp;
    
            reto = cont.split(",");

            String temporalLector = "";

            for(int i = 0; i < reto.length; i++){
                temporalLector = temporalLector + reto[i];
            }

            retornar = temporalLector.split(" ");
    
        }catch(Exception e){
            System.out.println("No se ha encontrado el archivo solicitado");
        }

        return retornar;

    }

    public void SobreEscribir(String a){

        

    }
}