public class ArbolInventario {

    // Nodo principal (punto de inicio)
    Producto raiz;

    public ArbolInventario() {
        raiz = null; // inicia vacío
    }

    // INSERTAR (usa recursividad)
    public void insertar(int id, String nombre) {
        raiz = insertarRec(raiz, id, nombre);
    }

    private Producto insertarRec(Producto nodo, int id, String nombre) {

        // Caso base: si el espacio está vacío, se crea el nuevo nodo
        if (nodo == null) {
            return new Producto(id, nombre);
        }

        // Si el ID es menor, se va al sub-árbol izquierdo
        if (id < nodo.id) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, id, nombre);

        // Si el ID es mayor, se va al sub-árbol derecho
        } else if (id > nodo.id) {
            nodo.derecho = insertarRec(nodo.derecho, id, nombre);
        }

        return nodo;
    }

    // MOSTRAR INVENTARIO ORDENADO (recorrido inorden)
    public void mostrarInventario() {
        if (raiz == null) {
            System.out.println("El inventario está vacío.");
        } else {
            inorden(raiz);
        }
    }

    private void inorden(Producto nodo) {

        // Recorrido: izquierda -> raíz -> derecha
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.println("ID: " + nodo.id + " | Nombre: " + nodo.nombre);
            inorden(nodo.derecho);
        }
    }

    // BUSCAR PRODUCTO POR ID
    public Producto buscar(int id) {
        return buscarRec(raiz, id);
    }

    private Producto buscarRec(Producto nodo, int id) {

        // Caso base: no existe o se encontró
        if (nodo == null || nodo.id == id) {
            return nodo;
        }

        // Decide hacia qué lado continuar la búsqueda
        if (id < nodo.id) {
            return buscarRec(nodo.izquierdo, id);
        } else {
            return buscarRec(nodo.derecho, id);
        }
    }
}