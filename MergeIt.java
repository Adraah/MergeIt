package mergeit;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PatricioArath
 */
public class MergeIt {

    static public int points=0; 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Stack pila1 = new Stack();
        Stack pila2 = new Stack();
        Stack pila3 = new Stack();
        Stack pila4 = new Stack();
        int randomnum;
        do{
            System.out.println("");
            System.out.println("Puntos:" +points);
            System.out.println("SHOP");
            System.out.println("Borrar el ultimo elemento 30puntos");
            System.out.println("Cambiar los ultimos elementos de dos pilas 25puntos");
            randomnum = num();
            System.out.println("Numero:" +randomnum);
            System.out.print("P1: ");
            pila1.print();
            System.out.print("P2: ");
            pila2.print();
            System.out.print("P3: ");
            pila3.print();
            System.out.print("P4: ");
            pila4.print();
            System.out.println("En que pila poner:");
            int opc = in.nextInt();
            switch(opc){
                case 1: 
                    pila1.push(randomnum);
                    System.out.print("P1: ");
                    pila1.print();
                    System.out.print("P2: ");
                    pila2.print();
                    System.out.print("P3: ");
                    pila3.print();
                    System.out.print("P4: ");
                    pila4.print();
                    merge(pila1);
                    break;
                case 2: 
                    pila2.push(randomnum);
                    System.out.print("P1: ");
                    pila1.print();
                    System.out.print("P2: ");
                    pila2.print();
                    System.out.print("P3: ");
                    pila3.print();
                    System.out.print("P4: ");
                    pila4.print();
                    merge(pila2);
                    break;
                case 3: 
                    pila3.push(randomnum);
                    System.out.print("P1: ");
                    pila1.print();
                    System.out.print("P2: ");
                    pila2.print();
                    System.out.print("P3: ");
                    pila3.print();
                    System.out.print("P4: ");
                    pila4.print();
                    merge(pila3);
                    break;
                case 4: 
                    pila4.push(randomnum);
                    System.out.print("P1: ");
                    pila1.print();
                    System.out.print("P2: ");
                    pila2.print();
                    System.out.print("P3: ");
                    pila3.print();
                    System.out.print("P4: ");
                    pila4.print();
                    merge(pila4);
                    break;
                case 5:
                    shop(pila1,pila2,pila3,pila4);
            }
        }while((pila1.isFull()!=true)||(pila2.isFull()!=true)||(pila3.isFull()!=true)||(pila4.isFull()!=true));
        
        
    }
    
    public static void merge(Stack pl){  //Une los bloques si son iguales
        if(pl.size() == 1){  //Si la pila solo tiene un valor no hace nada
            
        }else if(pl.data[pl.size()-1] == pl.data[pl.size()-2]){  //Si los dos ultimos numeros son iguales se juntan
            points++;
            pl.data[pl.size()-1] = 0;
            pl.setSize(pl.size()-1);
            pl.data[pl.size()-1] = pl.data[pl.size()-1] + 1;
            if(pl.data[pl.size()-1] == 9){ //Si el bloque es un numero 9, se elimina y se suman 10 puntos
                try {
                    pl.pop();
                    points = points +10;
                } catch (Exception ex) {
                    Logger.getLogger(MergeIt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            merge(pl);
        }
    }
    
    public static int num(){ //Genera numeros con percentaje
        Random rand = new Random();
        int porcentaje = rand.nextInt(100) + 1;
        int result;
        if(porcentaje <=30){
            result = 1;
        }else if(porcentaje <=55){
            result = 2;
        }else if(porcentaje <=75){
            result = 3;
        }else if(porcentaje <=90){
            result = 4;
        }else if(porcentaje <= 98){
            result = 5;
        }else{
            result = 0;
        }
        return result;
    }
    
    public static void shop(Stack p1,Stack p2,Stack p3,Stack p4) throws Exception{  //tienda
        Scanner in = new Scanner(System.in);
        System.out.println("1. Borrar el ultimo elemento 30puntos");
        System.out.println("2. Cambiar los ultimos elementos de dos pilas 25puntos");
        int opc = in.nextInt();
        switch(opc){
            case 1:  //Elimina el ultimo elemento usanso pop
                points=points-30;
                System.out.println("Elige la pila:");
                int p = in.nextInt();
                switch(p){
                    case 1:
                        p1.pop();
                        break;
                    case 2:
                        p2.pop();
                        break;
                    case 3:
                        p3.pop();
                        break;
                    case 4:
                        p4.pop();
                        break;
                }
                break;
            case 2:   //Hace pop de una pila y luego pop de otra
                points=points-25;
                System.out.println("Elige la primer pila:");
                int op = in.nextInt();
                int num,num2;
                int pila2;
                switch(op){
                    case 1:
                        num = p1.pop();
                        System.out.println("Elige la segunda pila:");
                        pila2 = in.nextInt();
                        switch (pila2) {
                            case 2:
                                num2 = p2.pop();
                                p2.push(num);
                                p1.push(num2);
                                break;
                            case 3:
                                num2 = p3.pop();
                                p3.push(num);
                                p1.push(num2);
                                break;
                            case 4:
                                num2 = p4.pop();
                                p4.push(num);
                                p1.push(num2);
                                break;
                        }
                        break;
                    case 2:
                        num = p2.pop();
                        System.out.println("Elige la segunda pila:");
                        pila2 = in.nextInt();
                        switch (pila2) {
                            case 1:
                                num2 = p1.pop();
                                p1.push(num);
                                p2.push(num2);
                                break;
                            case 3:
                                num2 = p3.pop();
                                p3.push(num);
                                p2.push(num2);
                                break;
                            case 4:
                                num2 = p4.pop();
                                p4.push(num);
                                p2.push(num2);
                                break;
                        }
                        break;
                    case 3:
                        num = p3.pop();
                        System.out.println("Elige la segunda pila:");
                        pila2 = in.nextInt();
                        switch (pila2) {
                            case 2:
                                num2 = p2.pop();
                                p2.push(num);
                                p3.push(num2);
                                break;
                            case 1:
                                num2 = p1.pop();
                                p1.push(num);
                                p3.push(num2);
                                break;
                            case 4:
                                num2 = p4.pop();
                                p4.push(num);
                                p3.push(num2);
                                break;
                        }
                        break;
                    case 4:
                        num = p4.pop();
                        System.out.println("Elige la segunda pila:");
                        pila2 = in.nextInt();
                        switch (pila2) {
                            case 2:
                                num2 = p2.pop();
                                p2.push(num);
                                p4.push(num2);
                                break;
                            case 3:
                                num2 = p3.pop();
                                p3.push(num);
                                p4.push(num2);
                                break;
                            case 1:
                                num2 = p4.pop();
                                p1.push(num);
                                p4.push(num2);
                                break;
                        }
                        break;
                }
                break;
        }
    }
    
}
