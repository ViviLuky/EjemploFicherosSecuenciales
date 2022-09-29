package creaccio_deFicheros;

import java.io.File;
import java.io.IOException;

public class Ejemplo2 {
    public static void main(String[ ]args ){
        //como crear una nueva carpeta > PRUEBAS
        File directorio =new File("Pruebas");
        directorio.mkdir();

        File f1= new File(directorio,"f1.text");
        File f2= new File(directorio,"f2.txt");

        try {
           boolean f1Created= f1.createNewFile();
            boolean f2Created= f2.createNewFile();
            if(f1Created)
                System.out.println("Fichero 1 creado");

            else System.out.println("Fichero 1 no creado");

            if(f2Created)
                System.out.println("Fichero 2 creado");

            else System.out.println("Fichero 2 no creado");

            // reenombrar fichero

            if(f1Created) {
              boolean renombrado=  f1.renameTo(new File(directorio, "F1NEW.txt"));
              if(renombrado)
                  System.out.println(" Fichero Reenombrado");
              else
                  System.out.println("Error al reenombra el fichero");
            }

            // Borrar fichero o directorios

            boolean borrado= f2.delete();
            if(borrado)
                System.out.println("Fichero borrado");
            else
                System.out.println("El fichero sigue vivo ");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
