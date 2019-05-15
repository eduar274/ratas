/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Eduar
 */
public class Impresora2 extends Thread {

    static LinkedList<String> cola = new LinkedList<String>();
    static LinkedList<String> cola1 = new LinkedList<String>();
    static LinkedList<String> cola2 = new LinkedList<String>();
    
    static int tipo;
    static String area;
    static String[] aux;

    public void run() {
        int n = 0;
        //System.out.println("Lista de entrada"+cola1);
        //System.out.println("Lista de espera"+cola2);
        
        for (int i = 0; i < cola.size(); i++) {
            //System.out.println(cola);
            aux = cola.get(i).split(" ");
            area = aux[0];
            tipo = Integer.parseInt(aux[1]);
            String aux2;
            cola1.remove();
            try {
                switch (tipo) {
                    case 1://Sencillo tipo 1
                        
                        System.out.println("Se ha enviado un trabajo de tipo: " + tipo + " desde el area de: " + area + " a la impresora numero 2 en cola esta: "+cola1+" en espera de entrar a la cola estan: "+cola2);
                        System.out.println();
                        Thread.sleep(60000);
                        System.out.println("El trabajo de tipo: " + tipo + " desde el area de: " + area + " ha sido impreso desde la impresora 2");
                        if(cola2.size()>0){
                        aux2= cola2.remove(0);
                        cola1.add(aux2);
                        }
                        System.out.println();
                        break;

                    case 2://Informe tipo 2
                        
                        System.out.println("Se ha enviado un trabajo de tipo: " + tipo + " desde el area de: " + area + " a la impresora numero 2 en cola esta: "+cola1+" en espera de entrar a la cola estan: "+cola2);
                        System.out.println();
                        Thread.sleep(180000);
                        System.out.println("El trabajo de tipo: " + tipo + " desde el area de: " + area + " ha sido impreso desde la impresora 2");
                        if(cola2.size()>0){
                        aux2= cola2.remove(0);
                        cola1.add(aux2);
                        }
                        System.out.println();
                        break;

                    case 3://Catagalogo tipo 3
                       
                        System.out.println("Se ha enviado un trabajo de tipo: " + tipo + " desde el area de: " + area + " a la impresora numero 2 en cola esta: "+cola1+" en espera de entrar a la cola estan: "+cola2);
                        System.out.println();
                        Thread.sleep(300000);
                        System.out.println("El trabajo de tipo: " + tipo + " desde el area de: " + area + " ha sido impreso desde la impresora 2");
                        if(cola2.size()>0){
                        aux2= cola2.remove(0);
                        cola1.add(aux2);
                        }
                        
                        System.out.println();
                        break;

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    public static void setCola(LinkedList<String> cola) {
        Impresora2.cola = cola;
        cola1.add(cola.get(0));
        cola1.add(cola.get(1));
        cola1.add(cola.get(2));
        cola2= (LinkedList) cola.clone();
        cola2.remove(0);
        cola2.remove(1);
        cola2.remove(2);
    }

}
