package com.example.motogp;

import com.example.motogp.model.Bike;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Race {
    public static final int NUM_MOTOCICLISTAS = 10;
    public static final int DISTANCIA_CARRERA = 100;
    public static AtomicInteger[] posicion;
    public static Random random = new Random();


    private static void iniciarCarrera() throws InterruptedException {
        Thread[] motociclistas = new Thread[NUM_MOTOCICLISTAS];

        posicion = new AtomicInteger[NUM_MOTOCICLISTAS];
        for (int i = 0; i < NUM_MOTOCICLISTAS; i++) {
            posicion[i] = new AtomicInteger(0);
        }

        for (int i = 0; i < NUM_MOTOCICLISTAS; i++) {
            motociclistas[i] = new Thread(new Bike(i));
            motociclistas[i].start();
        }

        for (int i = 0; i < NUM_MOTOCICLISTAS; i++) {
            motociclistas[i].join();
        }
    }
}