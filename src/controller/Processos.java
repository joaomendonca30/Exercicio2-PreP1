package controller;

import java.util.concurrent.Semaphore;

public class Processos extends Thread{
    private int id;
    private int duracao;
    private Semaphore semaforo;

    public Processos(int id, int duracao, Semaphore semaforo) {
        this.id = id;
        this.duracao = duracao;
        this.semaforo = semaforo;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public void run() {
        try {
            semaforo.acquire();
            System.out.println("O processo " + id + " rodou por " + duracao + " s.");

            Thread.sleep(duracao * 1000);

            System.out.println("O processo " + id + " terminou.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }
}
