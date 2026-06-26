package org.estudio;

public class ListaDoblementeEnlazadas {
    Nodo cabeza;
    int tamanio;


    public int getTamanio() {
        return tamanio;
    }

    public void insertarAlPrincipio(int valor) {
        Nodo nodoNuevo = new Nodo(valor);
        if (cabeza != null) {
            cabeza.anterior = nodoNuevo;
        }
        nodoNuevo.siguiente = cabeza;
        cabeza = nodoNuevo;
        tamanio++;
    }

    public void insertarAlFinal(int valor) {
        Nodo nodoNuevo = new Nodo(valor);
        if (this.cabeza == null) {
            this.cabeza = nodoNuevo;
        } else {
            Nodo puntero = cabeza;

            while (puntero.siguiente != null) {
                puntero = puntero.siguiente;
            }
            puntero.siguiente = nodoNuevo;
            nodoNuevo.anterior = puntero;
        }
        tamanio++;
    }

    public boolean insertarPorIndice(int valor, int indice) {
        if (indice < 0 || indice >= tamanio) {
            System.out.println("Indice no valido");
            return false;
        }
        if (indice == 0) {
            insertarAlPrincipio(valor);
            return true;
        } else {
            Nodo puntero = cabeza;
            int contador = 0;
            while (contador < indice - 1) {
                puntero = puntero.siguiente;
                contador++;
            }
            Nodo nodoNuevo = new Nodo(valor);
            nodoNuevo.siguiente = puntero;
            nodoNuevo.anterior = puntero.anterior;
            puntero.anterior.siguiente = nodoNuevo;
            puntero.anterior = nodoNuevo;
            tamanio++;
            return true;
        }

    }

    public int eliminarAlPrincipio() {

        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacia");
        }
        int valorEliminado = cabeza.valor;
        cabeza = cabeza.siguiente;

        if (cabeza != null) {
            cabeza.anterior = null;
        }
        tamanio--;
        return valorEliminado;

    }

    public int eliminarAlFinal() {
        Nodo puntero = cabeza;
        int contador = 0;

        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacia");
        }

        if (tamanio == 1) {
            int valorAEliminar = cabeza.valor;
            cabeza = null;
            tamanio--;
            return valorAEliminar;
        }

        while (contador < tamanio - 1) {
            puntero = puntero.siguiente;
            contador++;
        }
        int valorAEliminar = puntero.valor;
        puntero.anterior.siguiente = null;
        tamanio--;
        return valorAEliminar;

    }

    /**
     * Metodo que permite eliminar un nodo de la lista doblemente enlazada por indice
     *
     * @param indice posicion del nodo a eliminar
     * @Return devuelve el valor que tenia internamente el nodo que se elimino
     **/
    public int eliminarPorIndice(int indice) {

        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacia");
        }

        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }

        if (indice == 0) {
            return eliminarAlPrincipio();
        }

        if (indice == tamanio - 1) {
            int valorEliminado = eliminarAlFinal();
            return valorEliminado;
        }

        Nodo puntero = cabeza;
        int contador = 0;

        while (contador < indice) {
            puntero = puntero.siguiente;
            contador++;
        }

        int valorAEliminar = puntero.valor;

        puntero.siguiente.anterior = puntero.anterior;
        puntero.anterior.siguiente = puntero.siguiente;
        tamanio--;
        return valorAEliminar;
    }

    public void limpiar() {
        this.cabeza = null;
        tamanio = 0;
    }

    public void imprimirLista() {
        if (this.cabeza != null) {
            Nodo puntero = cabeza;
            while (puntero != null) {
                System.out.println(puntero.valor);
                puntero = puntero.siguiente;
            }
        } else {
            System.out.println("Lista vacia");
        }
    }

    public boolean isEmpty() {
        return tamanio == 0;
    }
}
