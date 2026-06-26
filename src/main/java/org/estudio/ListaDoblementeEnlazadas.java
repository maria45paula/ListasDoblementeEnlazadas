package org.estudio;

public class ListaDoblementeEnlazadas {
    Nodo cabeza;
    int tamanio;


    public void insertarAlPrincipio() {
    }

    public void insertarAlFinal() {
    }

    public void insertarPorIndice() {
    }

    public void eliminarAlPrincipio() {
        Nodo puntero = cabeza;

    }

    public void eliminarAlFinal() {

    }

    public int eliminarPorIndice(int indice) {
        if (indice < 0 || indice >= tamanio) {
            System.out.println("Error:indice fuera de rango.");
            return -10000;
        }

        if (indice == 0) {
            int valorEliminado = cabeza.valor;
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            }
            tamanio--;
            return valorEliminado;
        }


        Nodo puntero = cabeza;
        int contador = 0;

        while (contador <= indice - 1) {
            puntero = puntero.siguiente;
            contador++;
        }

        if (indice == tamanio - 1) {
            int valorAEliminar = puntero.valor;
            puntero.siguiente.anterior = puntero.anterior;
            puntero.anterior.siguiente = null;
            tamanio--;
            return valorAEliminar;

        }

        int valorAEliminar = puntero.valor;

        puntero.siguiente.anterior = puntero.anterior;
        puntero.anterior.siguiente = puntero.siguiente;
        tamanio--;
        return valorAEliminar;
    }

    public void limpiar() {
    }

    public void imprimirLista() {
    }


}
