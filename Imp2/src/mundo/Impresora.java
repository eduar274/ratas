/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author Eduar
 */
import java.util.Iterator;
import java.util.LinkedList;

public class Impresora extends Thread {

    static LinkedList<String> cola = new LinkedList<String>();
    static LinkedList<String> cola1 = new LinkedList<String>();
    static int tipo;
    static String area;
    static String[] aux;

    public void run() {

        for (int i = 0; i < cola.size(); i++) {
            //System.out.println(cola1);
            aux = cola.get(i).split(" ");
            area = aux[0];
            tipo = Integer.parseInt(aux[1]);
            cola1.remove();
            try {
                switch (tipo) {
                    case 1://Sencillo tipo 1
                        System.out.println("Se ha enviado un trabajo de tipo: " + tipo + " desde el area de: " + area + " a la impresora numero 1, en cola estan: "+cola1);
                        System.out.println();
                        Thread.sleep(60000);
                        System.out.println("El trabajo de tipo: " + tipo + " desde el area de: " + area + " ha sido impreso desde la impresora 1");
                        System.out.println();
                        break;

                    case 2://Informe tipo 2
                        System.out.println("Se ha enviado un trabajo de tipo: " + tipo + " desde el area de: " + area + " a la impresora numero 1, en cola estan: "+cola1);
                        System.out.println();
                        Thread.sleep(180000);
                        System.out.println("El trabajo de tipo: " + tipo + " desde el area de: " + area + " ha sido impreso desde la impresora 1");
                        System.out.println();
                        break;

                    case 3://Catagalogo tipo 3
                        System.out.println("Se ha enviado un trabajo de tipo: " + tipo + " desde el area de: " + area + " a la impresora numero 1, en cola estan: "+cola1);
                        System.out.println();
                        Thread.sleep(300000);
                        System.out.println("El trabajo de tipo: " + tipo + " desde el area de: " + area + " ha sido impreso desde la impresora 1");
                        System.out.println();
                        break;

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void setCola(LinkedList<String> cola1) {
        Impresora.cola = cola1;
        Impresora.cola1= (LinkedList) cola.clone();
    }

}
