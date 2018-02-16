public class ArbolBin {

    private Nodo raiz;

    public ArbolBin() {
        raiz=null;
    }
 
    public ArbolBin( int valor ) {
        this.raiz = new Nodo( valor );
    }
 
    public ArbolBin( Nodo raiz ) {
        this.raiz = raiz;
    }
    
    public Nodo getRaiz() {
        return raiz;
    }
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void insertar(int info){
        Nodo nuevo;
        nuevo=new Nodo(info);
        nuevo.info=info;
        nuevo.Izq=null;
        nuevo.Der=null;
        if(raiz==null)
            raiz=nuevo;
        else{
               Nodo anterior=null, reco;
               reco=raiz;
               while(reco!=null){
                         anterior=reco;
               if(info<reco.info)
                   reco=reco.Izq;
               else
                     reco=reco.Der;
               }
               if(info<anterior.info)
                  anterior.Izq=nuevo;
               else
                   anterior.Der=nuevo;
         }
    }
 
    private void imprimirPre(Nodo reco){
                 if(reco!=null){
                     System.out.print(reco.info+" ");
                     imprimirPre(reco.Izq);
                     imprimirPre(reco.Der);
                 }
      }
      public void imprimirPre(){
                  imprimirPre(raiz);
                  System.out.println();
      }
      private void imprimirEntre(Nodo reco){
                  if(reco!=null){
                     imprimirEntre(reco.Izq);
                      System.out.print(reco.info+" ");
                     imprimirEntre(reco.Der);
                 }
       }
       public void imprimirEntre(){
                     imprimirEntre(raiz);
                     System.out.println();
       }
       public void imprimirPost(Nodo reco){
                   if(reco!=null){
                       imprimirPost(reco.Izq);
                       imprimirPost(reco.Der);
                       System.out.print(reco.info+" ");

                   }
       }
       public void imprimirPost(){
                   imprimirPost(raiz);
                   System.out.println();
      }
    public boolean removeNodo( Nodo nodo ) {
        boolean tieneNodoDerecha = nodo.getHojaDerecha()!=null;
        boolean tieneNodoIzquierda = nodo.getHojaIzquierda()!=null;
        if (!tieneNodoDerecha && !tieneNodoIzquierda) {
            return removeNodoCaso1( nodo );
        }
        if ( tieneNodoDerecha && !tieneNodoIzquierda ) {
            return removeNodoCaso2( nodo );
        }
        if ( !tieneNodoDerecha && tieneNodoIzquierda ) {
            return removeNodoCaso2( nodo );
        }
        if ( tieneNodoDerecha && tieneNodoIzquierda ) {
            return removeNodoCaso3( nodo );
        }
        return false;
    }
 
    private boolean removeNodoCaso1( Nodo nodo ) {
        Nodo hijoIzquierdo = nodo.getPadre().getHojaIzquierda();
        Nodo hijoDerecho = nodo.getPadre().getHojaDerecha();
        if ( hijoIzquierdo == nodo ) {
            nodo.getPadre().setHojaIzquierda( null );
            return true;
        }
        if ( hijoDerecho == nodo) {
            nodo.getPadre().setHojaDerecha( null );
            return true;
        }
        return false;
    }
 
    private boolean removeNodoCaso2( Nodo nodo ) {
        Nodo hijoIzquierdo = nodo.getPadre().getHojaIzquierda();
        Nodo hijoDerecho = nodo.getPadre().getHojaDerecha();
        Nodo hijoActual = nodo.getHojaIzquierda() != null ? 
                nodo.getHojaIzquierda() : nodo.getHojaDerecha(); 
        if ( hijoIzquierdo == nodo ) {
            nodo.getPadre().setHojaIzquierda( hijoActual );
            hijoActual.setPadre(nodo.getPadre());
            nodo.setHojaDerecha(null);
            nodo.setHojaIzquierda(null);
            return true;
        } 
        if ( hijoDerecho == nodo) {
            nodo.getPadre().setHojaDerecha( hijoActual );
            hijoActual.setPadre(nodo.getPadre());
            nodo.setHojaDerecha(null);
            nodo.setHojaIzquierda(null); 
            return true;
        }  
        return false;
    }
 
    private boolean removeNodoCaso3( Nodo nodo ) {
        Nodo nodoMasALaIzquierda = recorrerIzquierda( nodo.getHojaDerecha() );
        if ( nodoMasALaIzquierda != null ) {
            nodo.setValor( nodoMasALaIzquierda.getValor() );
            removeNodo( nodoMasALaIzquierda );
            return true;
        }
        return false;
    }
 
    private Nodo recorrerIzquierda(Nodo nodo) {
        if (nodo.getHojaIzquierda() != null) {
            return recorrerIzquierda( nodo.getHojaIzquierda() );
        }
        return nodo;
    }
}