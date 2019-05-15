package interfaz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import mundo.Impresora;
import mundo.Impresora2;


public class InterfazApp{
	
	
	private static Impresora imprimir = new Impresora();
	private static Impresora2 imprimir2 = new Impresora2();
	private static LinkedList<String> cola = new LinkedList<String>();
	private static LinkedList<String> cola1 = new LinkedList<String>();
	private static LinkedList<String> cola2 = new LinkedList<String>();
	
	public static void main(String[] args){
		
		try {
		
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Eduar\\Desktop\\Lista.txt"));
			String linea;
			String [] temp;
			
			while((linea = br.readLine()) != null) {
				cola.add(linea);
			}
			
			int tiempo1 = 0, tiempo2 = 0;
			
			for (int i = 0; i < cola.size(); i++) {
				temp = cola.get(i).split(" ");
                               // System.out.println(i+" "+temp[1]+" "+cola.get(i));
                               // System.out.println("Cola imp 1: "+cola1);
                               // System.out.println("Cola imp 2: "+cola2);
				if(temp[0].equalsIgnoreCase("GERENCIA") && tiempo1 < 5) {
					cola1.add(cola.get(i));
					tiempo1= sumarHora(temp[1], tiempo1);
				}else {
                                    if(tiempo1 < tiempo2 && temp[0].equalsIgnoreCase("GERENCIA")){
                                        cola1.add(cola.get(i));
					tiempo1 = sumarHora(temp[1], tiempo1);
                                    }else{
                                        if(tiempo2<tiempo1 && cola2.size() < 3 && temp[0].equalsIgnoreCase("GERENCIA")){ //cola para gerencia 3 o 4
                                            cola2.add(cola.get(i));
                                            tiempo2 = sumarHora(temp[1], tiempo1);
                                        }else{
                                            if(tiempo2<tiempo1 && cola2.size() > 3 && temp[0].equalsIgnoreCase("GERENCIA")){
                                                cola1.add(cola.get(i));
                                                tiempo1 = sumarHora(temp[1], tiempo1);
                                            }else{
                                                if(temp[0].equalsIgnoreCase("ADMON")){
                                                    cola1.add(cola.get(i));
                                                    tiempo1 = sumarHora(temp[1], tiempo1);
                                                }else{
                                                    if(temp[0].equalsIgnoreCase("MERCADEO") || temp[0].equalsIgnoreCase("PRODUC")){
                                                        cola2.add(cola.get(i));
                                                        tiempo2 = sumarHora(temp[1], tiempo1);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                        
				}
			}
			//System.out.println("Cola : "+cola);
			System.out.println("Cola imp 1: "+cola1);
                        System.out.println("Cola imp 2: "+cola2);
			
			Impresora.setCola(cola1);
                        Impresora2.setCola(cola2);
			
                        imprimir.start();
                        imprimir2.start();
			//hilo1.start();
			//hilo2.start();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
	}
	
	
	private static int sumarHora(String n, int tiempo) {
		if(n.equalsIgnoreCase("1")) {
			tiempo+=1;
		}else {
			if(n.equalsIgnoreCase("2")) {
				tiempo+=3;
			}else {
				if(n.equalsIgnoreCase("3")) {
					tiempo+=5;
				}
			}
		}
		return tiempo;
	}
	
}
