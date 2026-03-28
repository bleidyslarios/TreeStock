public class Producto {
    
    // Datos del producto (carga del nodo)
    int id;
    String nombre;

    // Punteros
    Producto izquierdo;
    Producto derecho;

    // Constructor: crea un nuevo nodo con sus datos (sin hijos)
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }
}