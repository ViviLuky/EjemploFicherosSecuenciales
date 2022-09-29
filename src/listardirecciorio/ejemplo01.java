package listardirecciorio;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ejemplo01 {


    public static void main (String[] args){

        Scanner leer = new Scanner(System.in);

        System.out.println("Dime la ruta ");
        listarFicheroActual(leer.nextLine());
    }

    private static void listarFicheroActual(String dirActual) {


        File file = new File(dirActual);
        if (file.exists()) {
            String[] archivos = file.list();




            System.out.printf("Ficheros en el dir %s : %d %n", file.getName(), archivos.length);
            for (String fichero : archivos) {
                File temp = new File(file, fichero);
                System.out.printf("Nombre: %s - File: %b - DIR: %b%n ", temp.getName(), temp.isFile(), temp.isDirectory());


            }
        }else {
            System.out.println("no existe la ruta");
        }
    }
}
