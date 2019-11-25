/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Luis Andrés Fallas Valenciano
 */
public class Utilitario {

    /**
     * Retorna un número aleatorio dentro de un minimo y un maximo.
     *
     * @param minimo
     * @param maximo
     * @return numeroAleatorio
     */
    public int generaNumeroAleatorio(int minimo, int maximo) {
        int numeroAleatorio = 0;
        numeroAleatorio = (int) Math.floor(Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return numeroAleatorio;
    }

}
