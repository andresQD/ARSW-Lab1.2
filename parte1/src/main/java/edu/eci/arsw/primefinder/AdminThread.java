/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.primefinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Andrés Quintero
 */
public class AdminThread extends Thread {

    private final int numeroHilos = 3;
    private final int cantidadNumeros = 30000000;
    private final int numerosPorHilo = cantidadNumeros / numeroHilos;
    private final PrimeFinderThread procesoPorHilo[];
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public AdminThread() {
        this.procesoPorHilo = new PrimeFinderThread[numeroHilos];
        for (int i = 0; i < numeroHilos; i++) {
            PrimeFinderThread pft = new PrimeFinderThread(numerosPorHilo * i, numerosPorHilo * (i + 1));
            procesoPorHilo[i] = pft;
        }
    }

    @Override
    public void run() {
        boolean ejecutando = true;
        for (int i = 0; i < numeroHilos; i++) {
            procesoPorHilo[i].start();
        }
        do {
            ejecutando = false;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < numeroHilos; i++) {
                System.out.println("Hilo número: " + (i + 1) + " primos calculados : " + procesoPorHilo[i].getPrimes().size());
                ejecutando = ejecutando || procesoPorHilo[i].corriendo();
            }
            try {
                bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            continuar();

        } while (ejecutando);

    }

    private void continuar() {
        for (PrimeFinderThread e : procesoPorHilo) {
            e.control();
        }
    }

    public void ejecutar() {
        procesoPorHilo.notifyAll();
    }

    public void pausa() {
        for (PrimeFinderThread e : procesoPorHilo) {
            e.pausa();
        }

    }
}
