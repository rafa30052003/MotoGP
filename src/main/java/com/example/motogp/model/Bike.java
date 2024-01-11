package com.example.motogp.model;

import static com.example.motogp.Race.*;

public class Bike implements Runnable{
    private int id;

    public Bike(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < DISTANCIA_CARRERA; i++) {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (posicion) {
                int currentPosition = posicion[id].get();
                if (currentPosition < NUM_MOTOCICLISTAS - 1) {
                    int nextPosition = posicion[currentPosition + 1].get();
                    if (nextPosition > currentPosition) {
                        posicion[currentPosition].incrementAndGet();
                        posicion[currentPosition + 1].decrementAndGet();
                    }
                }
            }
        }
    }
}
