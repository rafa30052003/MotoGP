package com.example.motogp;

import com.example.motogp.model.Bike;

import java.util.Random;

public class Race {
    private static final int NUM_MOTOCICLISTAS = 10;
    public static final int DISTANCIA_CARRERA = 100;

    public static int posicion[] = new int[NUM_MOTOCICLISTAS];
    public static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        Thread[] motociclistas = new Thread[NUM_MOTOCICLISTAS];

        for (int i = 0; i < NUM_MOTOCICLISTAS; i++) {
            motociclistas[i] = new Thread(new Bike(i));
            motociclistas[i].start();
        }

        for (int i = 0; i < NUM_MOTOCICLISTAS; i++) {
            motociclistas[i].join();
        }

        System.out.println("Resultados finales:");
        for (int i = 0; i < NUM_MOTOCICLISTAS; i++) {
            System.out.println("Motociclista " + i + ": " + posicion[i]);
        }
    }
}
