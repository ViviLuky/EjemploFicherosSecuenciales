package ficherosDeobjetos;

import java.io.*;
import java.util.ArrayList;

public class Main {
     private static ArrayList<Dado> dados;
     private static File dadosFicheros;


     static {
         dados= new ArrayList<>();
         dadosFicheros=new File("Dados.dat");
     }

    public static void main(String[] args) throws FileNotFoundException {

        crearTiradas();
        escribirTiradas();
        leerTiradas();
    }

    private static void leerTiradas() {
        FileInputStream fis;
        try {

                fis = new FileInputStream(dadosFicheros);
                ObjectInputStream ois = new ObjectInputStream(fis);

                while (true) {
                    Dado dado = (Dado) ois.readObject();
                    System.out.printf("Tirada es : %d%n", dado.getTirada());
                }

        }catch (FileNotFoundException e){

        }catch (EOFException e){

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private static void escribirTiradas() throws FileNotFoundException {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(dadosFicheros, true);
            ObjectOutputStream ous;
            if (dadosFicheros.exists()){
                ous = new MiObjetOutputStream(new FileOutputStream(dadosFicheros,true));
            } else {
                ous = new ObjectOutputStream(new FileOutputStream(dadosFicheros,true));
            }


            for (Dado dado : dados) {
                ous.writeObject(dado);

            }

                ous.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void crearTiradas() {

        for (int i = 0; i < 1000; i++) {
            dados.add(new Dado((int)(Math.random()*Dado.CARAS+1)));
        }
    }
}
