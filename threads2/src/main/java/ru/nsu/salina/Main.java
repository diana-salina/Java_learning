package ru.nsu.salina;

import ru.nsu.salina.stages.Road;
import ru.nsu.salina.stages.Tunnel;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public   static   final   int  CARS_COUNT =  4 ;
    public static ExecutorService executor = Executors.newFixedThreadPool(CARS_COUNT);
    public   static   final CyclicBarrier startBarrier = new CyclicBarrier(CARS_COUNT + 1);
    public   static   void   main (String[] args) {
        System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!" );
        Race race =  new  Race( new Road( 60 ),  new Tunnel(),  new  Road( 40 ));
        Car[] cars =  new  Car[CARS_COUNT];
        AtomicReference<Car> winner = new AtomicReference<Car>(null);
        CompletableFuture[] results = new CompletableFuture[CARS_COUNT];
        for  ( int  i =  0 ; i < cars.length; i++) {
            cars[i] =  new  Car(race,  20  + ( int ) (Math.random() *  10 ), startBarrier);
        }
        for  ( int  i =  0 ; i < cars.length; i++) {
            final int carId = i;
            results[i] = CompletableFuture.runAsync(cars[i], executor)
                    .thenRun(() -> {
                        if (winner.compareAndSet(null, cars[carId])) {
                            System.out.println(winner.get().getName() + " - WIN");
                        }
                    });
        }
        executor.shutdown();
        try {
            startBarrier.await();

            System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!" );
            CompletableFuture.allOf(results).join();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}