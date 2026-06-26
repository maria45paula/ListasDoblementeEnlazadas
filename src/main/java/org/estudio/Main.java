package org.estudio;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ListaDoblementeEnlazadas listaDoble = new ListaDoblementeEnlazadas();
        listaDoble.insertarAlFinal(2);
        listaDoble.insertarAlPrincipio(3);
        listaDoble.insertarAlFinal(6);
        listaDoble.insertarPorIndice(5, 2);
        listaDoble.eliminarAlFinal();
        listaDoble.eliminarPorIndice(7);
        int tamanioLista = listaDoble.getTamanio();
        listaDoble.imprimirLista();
        System.out.println("el tamaño de la lista es:" + tamanioLista);


    }
}