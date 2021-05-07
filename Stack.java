package mergeit;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PatricioArath
 */
public class Stack {
      public static final int CAPACITY=10; //Espacio maximo de la pila
      public int[] data;
      private int size=0; //tamaño actual de la pila
      
      public Stack() {   //Crea una pila

         this.data  = new int[this.CAPACITY];
      }
      
      public boolean isEmpty(){   //Observa si la pila esta vacia

         return  (this.size==0);
      }
      
      public boolean isFull(){   //Observa si la pila esta llena

         return  (this.size==this.CAPACITY);
      }
      
      public int size(){ //Regresa el tamaño de la pila

         return  (this.size);
      }
      
      public void push(int value){ //Agrega un elemento en el tope

      this.data[this.size] = value;
      this.size++;
      }
      
      public int pop() throws Exception {  //Elimina el elemento de hasta arriba

        int result = 0;
        if (this.isEmpty()) {  //si está vacía la pila regresa una excepción

            throw new Exception("La  Pila está vacía");

        }
        result = this.data[this.size-1];
        this.data[this.size-1] = 0; //Garbage collector 
        this.size--;
        return result;
    }
      
      public void print(){  //Imprime la pila
          for(int i=0;i<this.size;i++){
              System.out.print(this.data[i]);
          }
          System.out.println();
      }
      
      

    public void setSize(int size) {
        this.size = size;
    }
      
      
}
