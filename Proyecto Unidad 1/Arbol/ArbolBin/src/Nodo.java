public class Nodo {

    public int info;
    private Nodo padre;
    public Nodo Izq;
    public Nodo Der;
 
    public Nodo(int valor) {
        this.info = valor;
    }
 
    public void setValor(int valor) {
        this.info = valor;
    }
    public int getValor() {
        return info;
    }
    public Nodo getPadre() {
        return padre;
    }
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
    public Nodo getHojaIzquierda() {
        return Izq;
    }
    public void setHojaIzquierda(Nodo hojaIzquierda) {
        this.Izq = hojaIzquierda;
    }
    public Nodo getHojaDerecha() {
        return Der;
    } 
    public void setHojaDerecha(Nodo hojaDerecha) {
        this.Der = hojaDerecha;
    }
}