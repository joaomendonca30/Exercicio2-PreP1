package view;

import controller.Processos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int numero = 20;
        Semaphore semaforo = new Semaphore(1);

        List<Processos> p = new ArrayList<>();

        for (int i = 1; i <= numero; i++) {
            int duracao = (int) Math.floor(Math.random() * 117) + 4;
            Processos processos = new Processos(i, duracao, semaforo);
            p.add(processos);
        }

        Collections.sort(p, Comparator.comparingInt(Processos::getDuracao));

        for (Processos processos : p) {
            processos.start();
        }
    }
}