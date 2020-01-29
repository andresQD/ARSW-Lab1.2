package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;

public class PrimeFinderThread extends Thread {

    int a, b;
    private boolean ejecutando, pausado = false;

    private List<Integer> primes = new LinkedList<Integer>();

    public PrimeFinderThread(int a, int b) {
        super();
        this.a = a;
        this.b = b;
    }

    public void run() {
        for (int i = a; i <= b; i++) {
            if (pausado) {
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException x) {
                    x.printStackTrace();
                }

            }
            if (isPrime(i)) {
                primes.add(i);
                System.out.println(i);
            }
        }

    }
    
    public void pausa(){
        pausado = true;
    }
    
    public boolean corriendo(){
        return ejecutando;
    }
    
    public void control(){
        pausado = false;
        synchronized(this){
            this.notify();
        }
    }

    boolean isPrime(int n) {
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getPrimes() {
        return primes;
    }

}
