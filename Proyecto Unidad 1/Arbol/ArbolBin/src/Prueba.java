import java.util.Scanner;

public class Prueba {

    public static void main(String[] args) {
        ArbolBin estructura=new ArbolBin();
    int Operacion=0;
    Scanner leer=new Scanner (System.in);
    
            System.out.println("Menu de operaciones");
            System.out.println("1:Crear");
            System.out.println("2:Agregar");
            System.out.println("3:Eliminar");
            System.out.println("4:Imprimir");
            System.out.println("5:Salir");
            System.out.print("Elige alguna opcion : \n");
            
    do{   
    Operacion=leer.nextInt();
    switch(Operacion){
        case 1:
            if (estructura==null){
               System.out.println("Se ha creado el arbol");  
            }
            else 
               System.out.println("El arbol ya existe\n");
               System.out.println("Menu de operaciones");
               System.out.println("2:Agregar");
               System.out.println("3:Eliminar");
               System.out.println("4:Imprimir");
               System.out.println("5:Salir");
               System.out.println("--Elige otra opcion--");
               break;                                             
                    
        case 2:        
               System.out.println("Introduce el nuevo nodo");
               int nodo=leer.nextInt();
               Nodo nuevoNodo=new Nodo(nodo);
               estructura.insertar(nodo);
               System.out.println("Menu de operaciones");
               System.out.println("2:Agregar");
               System.out.println("3:Eliminar");
               System.out.println("4:Imprimir");
               System.out.println("5:Salir");
               System.out.println("--Elige otra opcion--");
               break;
                        
        case 3:
               
               System.out.println("Nodo a eliminar");
               int a=leer.nextInt();
               estructura.removeNodo(a);
               System.out.println("Menu de operaciones");
               System.out.println("2:Agregar");
               System.out.println("3:Eliminar");
               System.out.println("4:Imprimir");
               System.out.println("5:Salir");
               System.out.println("--Elige otra opcion--");
               break;
                        
        case 4:
               System.out.println("Nodos almacenados en el arbol:");
               System.out.println("INORDEN: ");
               estructura.imprimirEntre();
               System.out.println("PREORDEN: ");
               estructura.imprimirPre();
               System.out.println("POSTORDEN: ");
               estructura.imprimirPost();
               System.out.println("Menu de operaciones");
               System.out.println("2:Agregar");
               System.out.println("3:Eliminar");
               System.out.println("4:Imprimir");
               System.out.println("5:Salir");
               System.out.println("--Elige otra opcion--");
               break;
                      
               default:
               System.out.println("Adios");
    }    
  }
            while(Operacion!=5);
}
}