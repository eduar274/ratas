
package rutas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.Scanner;
/**
 *
 * @author Eduar
 */
public class Rutas {

    static ArrayList<String> mant= new ArrayList();
    static ArrayList<String> rutaA= new ArrayList();
    static ArrayList<String> rutaB= new ArrayList();
    static ArrayList<String> rutaC= new ArrayList();
    
    static ArrayList<Double> rutaA2= new ArrayList();
    static ArrayList<Double> rutaB2= new ArrayList();
    static ArrayList<Double> rutaC2= new ArrayList();
    
    static ArrayList<String> rutaF= new ArrayList();
    static ArrayList<String> ciudades=new ArrayList();
    
    static Calendar cal = Calendar.getInstance();
    static double horasTotal=0.0;
    static double horaAct=0.0;
    
    public static void main(String[] args) {
       
       		Scanner Leer=new Scanner(System.in);
        	listas();
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 00);
		int horas1;
                int horas2;
                boolean ver=false;
               // System.out.println("24-hour clock : " + cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE));
                do{
                System.out.println("digite la hora en militar");
                horas1=Leer.nextInt();
                if(horas1<25 && horas1>-1){
                    cal.set(Calendar.HOUR_OF_DAY, horas1);
                    ver=true;
                }
                }while(ver==false);
                
                ver=false;
	    
                do{
                System.out.println("digite 30 minutos o 0 minutos");
                horas2=Leer.nextInt();
                	if(horas2==30 || horas2==0){
                    		cal.set(Calendar.MINUTE, horas2);
                    		ver=true;
                	}
                }while(ver==false);
                
	        ver=false;
                
                cal.set(Calendar.HOUR_OF_DAY, horas1);
                cal.set(Calendar.MINUTE, horas2);
                actHora();
                
                String ciudad1,ciudad2;
                System.out.println(ciudades);
                System.out.println("Digite la ciudad de inicio ");
                ciudad1=Leer.next();
                System.out.println("Digite la ciudad de destino ");
                ciudad2=Leer.next();
                rutaF.add(ciudad1);
                System.out.println(ciudad2);
                ruta(ciudad1,ciudad2);
                
                imp();
                System.out.println("\nTermino recorrido");
            System.out.println(rutaF);
            System.out.println("Horas viajadas: "+horasTotal);
            System.out.println("hora actual EN 12H: "+horaAct+" o "+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE));
	    System.out.println("hora actual EN 24H: "+horaAct+" o "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE));
    }
	
    public static void imp(){
        System.out.println("Recorrido sin llegar a destino");
            System.out.println(rutaF);
            System.out.println("Horas viajadas: "+horasTotal);
            System.out.println("hora actual EN 12H: "+horaAct+" o "+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE));
	    System.out.println("hora actual EN 24H: "+horaAct+" o "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE));
    }
	
    public static void ruta(String inicio,String terminar){
        boolean a=false;
        boolean b=false;
        boolean c=false;
        boolean ver=true;
        System.out.println("ruta: "+" "+inicio+"-"+terminar);
        
        ver=compMant(rutaF.get(rutaF.size()-1),mant,horaAct);
        System.out.println((rutaF.get(rutaF.size()-1))+" "+ver);
        if(inicio.startsWith(terminar)){
            System.out.println("\nFinal recorrido");
            System.out.println(rutaF);
            System.out.println("Horas viajadas: "+horasTotal);
            System.out.println("hora actual EN 12H: "+horaAct+" o "+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE));
	    System.out.println("hora actual EN 24H: "+horaAct+" o "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE));
        }else{
             if(false==ver){
            System.out.println("No puede salir de la ciudad actual");
            System.out.println(rutaF);
            System.out.println("Horas viajadas: "+horasTotal);
            System.out.println("hora actual EN 12H: "+horaAct+" o "+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE));
	    System.out.println("hora actual EN 24H: "+horaAct+" o "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE));
            }else{
        if(rutaA.contains(inicio)&& rutaA.contains(terminar)){
            a=true;
        }
        if(rutaB.contains(inicio)&& rutaB.contains(terminar)){
            b=true;    
        }
        if(rutaC.contains(inicio)&& rutaC.contains(terminar)){
            c=true;        
        }
        if(a==true || b==true || c==true){
            escoger(inicio,a,b,c,terminar);
        }else{
            if(a==false && b==false && c==false){
                    if(rutaA.contains(inicio)){
                        a=true;
                    }
                    if(rutaA.contains(inicio)){
                        b=true;
                    }
                    if(rutaA.contains(inicio)){
                        c=true;
                    }
                    escoger(inicio,a,b,c,terminar);
        	}
              }	          
           }
        }
        

    }
    
    public static void escoger(String inicio,boolean a,boolean b,boolean c,String terminar){
        boolean n2=false;
        int numero;
        //System.out.println("escoger");
         while(n2==false){
            numero  = (int)(Math.random()*3+1);
            //System.out.print(numero);
            if(numero==1 && a==true){
               n2=true;
               Mov(inicio,rutaA,rutaA2,terminar);  
            }
            if(numero==2 && b==true){
               n2=true;
               Mov(inicio,rutaB,rutaB2,terminar);      
            }
            if(numero==3 && c==true){
               n2=true;
               Mov(inicio,rutaC,rutaC2,terminar);         
            }     
        }
         
    }
    
    public static void Mov(String ciu, ArrayList String,ArrayList horas,String terminar){ //REVISAR { }
        double hor;
        boolean retorno=true;
        System.out.println("mov1");
        if(String.indexOf(ciu)== String.size()-1){
            ciu = (String) String.get(0);
            hor = (double) horas.get(String.size()-1);
            sumar(hor);
            sumar2(hor);
            rutaF.add(ciu);
            retorno=compMant(ciu,mant,horaAct);
            imp();
                if(retorno==false){
                    Mov2(ciu,String,horas,terminar);
                    
                } else{
                    if(ciu.equals(terminar)){
                    System.out.println("\nFinal recorrido");
                    System.out.println(rutaF);
                    System.out.println("Horas viajadas: "+horasTotal);
                    System.out.println("hora actual EN 12H: "+horaAct+" o "+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE));
                    System.out.println("hora actual EN 24H: "+horaAct+" o "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE));
                }else{
                    ruta(ciu,terminar);
                }
                }
        }else{
                    ciu= (String) String.get(String.indexOf(ciu)+1);
                    hor= (double) horas.get(String.indexOf(ciu));
                    sumar(hor);
                    sumar2(hor);
                    rutaF.add(ciu);
                    retorno=compMant(ciu,mant,horaAct);
                    imp();
                        if(retorno==false){
                            Mov2(ciu,String,horas,terminar);
                        }else{
                            if(ciu.equals(terminar)){
                    System.out.println("\nFinal recorrido");
                    System.out.println(rutaF);
                    System.out.println("Horas viajadas: "+horasTotal);
                    System.out.println("hora actual EN 12H: "+horaAct+" o "+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE));
                    System.out.println("hora actual EN 24H: "+horaAct+" o "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE));
                }else{
                    ruta(ciu,terminar);
                }
                        }         
        }
    }
    
    public static void Mov2(String ciu, ArrayList String,ArrayList horas,String terminar){
        double hor;
        boolean retorno=true;
        System.out.println("mov2");
        if(String.indexOf(ciu)==0){
             ciu= (String) String.get(String.size()-1);
             hor=  (double) horas.get(horas.size()-1);
             retorno=compMant(ciu,mant,horaAct);
             rutaF.add(ciu);
             sumar2(hor);
             sumar(hor);
            imp();
             if(retorno==false){
                 System.out.print("Mantenimiento en la ciudades de dezplazamiento");
                 System.out.println(rutaF);
             }else{
                 if(ciu.equals(terminar)){
                    System.out.println("\nFinal recorrido");
                    System.out.println(rutaF);
                    System.out.println("Horas viajadas: "+horasTotal);
                    System.out.println("hora actual EN 12H: "+horaAct+" o "+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE));
                    System.out.println("hora actual EN 24H: "+horaAct+" o "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE));
                }else{
                    ruta(ciu,terminar);
                }
             }           
        }else{
                 ciu= (String) String.get(String.indexOf(ciu)-1);
                 hor= (double) horas.get(String.indexOf(ciu)-1);
                 sumar(hor);
                 sumar2(hor);
                 rutaF.add(ciu);
                 retorno=compMant(ciu,mant,horaAct);
                 imp();
                 if(retorno==false){
                 System.out.print("Mantenimiento en la ciudades de dezplazamiento");
                 System.out.println(rutaF);
             }else{
                     if(ciu.equals(terminar)){
                    System.out.println("\nFinal recorrido");
                    System.out.println(rutaF);
                    System.out.println("Horas viajadas: "+horasTotal);
                    System.out.println("hora actual EN 12H: "+horaAct+" o "+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE));
                    System.out.println("hora actual EN 24H: "+horaAct+" o "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE));
                }else{
                    ruta(ciu,terminar);
                }
                 }
             }
    }
    
    public static void actHora(){
        if(cal.get(Calendar.MINUTE)==30){
            horaAct=cal.get(Calendar.HOUR)+0.5;
        }else{
            horaAct=cal.get(Calendar.HOUR);
        }
    }
    
    public static void sumar2(double x){
        if(x%2==0.5){
         cal.add(Calendar.HOUR, (int) (x-0.5));
         cal.add(Calendar.MINUTE, 30);  
        }else{
            cal.add(Calendar.HOUR, (int) x);        
        }
        actHora();
    }
    public static void sumar(double x){
        horasTotal=horasTotal+x;
    }
    
    public static void listas(){
        // relleno lista de mantenimiento
        mant.add("riohacha");
        mant.add("14"); mant.add("18");
        mant.add("santa marta");
        mant.add("1"); mant.add("4");
        mant.add("barranquilla");
        mant.add("15"); mant.add("21");
        mant.add("cartagena");  // esta va en otra forma
        mant.add("23"); mant.add("3");
        mant.add("sincelejo");
        mant.add("3"); mant.add("6");
        mant.add("monteria");
        mant.add("16"); mant.add("19");
        mant.add("valledupar");
        mant.add("6"); mant.add("11");
        mant.add("plato");  // este va en otra
        mant.add("22"); mant.add("2");
        mant.add("la paz");
        mant.add("10"); mant.add("13");
        //relleno lista de la ruta A
        rutaA.add("santa-marta"); rutaA.add("la-paz"); rutaA.add("monteria"); rutaA.add("sincelejo"); rutaA.add("cartagena"); rutaA.add("barranquilla");
        //relleno lista de la ruta A2
         rutaA2.add(4.0); rutaA2.add(6.0);rutaA2.add(2.5); rutaA2.add(3.0); rutaA2.add(1.5); rutaA2.add(1.0);
        //relleno lista de la ruta B
        rutaB.add("cartagena"); rutaB.add("riohacha"); rutaB.add("valledupar"); rutaB.add("la-paz"); rutaB.add("san-benito");
        //relleno lista de la ruta B2
        rutaB2.add(4.5); rutaB2.add(2.5); rutaB2.add(1.5); rutaB2.add(4.0); rutaB2.add(3.5);
        //relleno lista de la ruta C
        rutaC.add("valledupar"); rutaC.add("plato"); rutaC.add("san-benito"); rutaC.add("monteria"); rutaC.add("santa-marta");
        //relleno lista de la ruta C2
        rutaC2.add(1.5); rutaC2.add(3.0); rutaC2.add(2.0); rutaC2.add(4.0); rutaC2.add(3.0);
	//relleno lista de ciudades
        ciudades.add("riohacha"); ciudades.add("santa-marta"); ciudades.add("barranquilla"); ciudades.add("cartagena"); ciudades.add("sincelejo"); ciudades.add("monteria");
  	ciudades.add("valledupar"); ciudades.add("plato"); ciudades.add("la-paz"); ciudades.add("san-benito");  
    }
    
    public static boolean compMant(String ciu, ArrayList<String> n,double hora){
   
        if(mant.contains(ciu)){
                int n2=n.lastIndexOf(ciu);
        int n3=n.lastIndexOf(n.get(n2+1));
        int n4=n.lastIndexOf(n.get(n2+2));
        //System.out.println("mant");
        Double nn= Double.parseDouble(n.get(n3));
        Double nn2= Double.parseDouble(n.get(n4));
        //System.out.println(ciu+" "+" "+n.get(n3)+" "+n.get(n4));
            if(ciu.equals("plato")||ciu.equals("cartagena")){
                  if(hora<nn && hora>nn2){//mirar si tengo que sumar o restar una hora
                   //System.out.println("puede pasar");
                      return true;
                    }else{
                        System.out.println("no puede ingresar");
                        return false;
                    }
            }else{ 
                if(hora>nn-0.1 && hora<nn2+0.1 ){
                    System.out.println("no puede ingresar");
                    return false;
                }else{
                    //System.out.println("puede pasar");
                    return true;
            }
        }
        }else{
            //System.out.println("puede pasar");
            return true;
        }
    }
 
}
