package ru.nsu.salina.stages;

import ru.nsu.salina.Car;
import ru.nsu.salina.Main;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tunnel extends Stage{
    private Semaphore semaphore;
    public   Tunnel () {
        this.semaphore = new Semaphore(Main.CARS_COUNT);
        this .length =  80 ;
        this .description =  "Тоннель "  + length +  " метров" ;
    }
    @Override
    public   void   go (Car c) {
        try  {
            try  {
                if (!semaphore.tryAcquire()) {
                    System.out.println(c.getName() + " готовится к этапу(ждет): " +
                            description);
                    semaphore.acquire();
                }
                System.out.println(c.getName() +  " начал этап: "  + description);
                Thread.sleep(length / c.getSpeed() *  1000 );
            }  catch  (InterruptedException e) {
                e.printStackTrace();
            }  finally  {
                System.out.println(c.getName() +  " закончил этап: "  +
                        description);
                semaphore.release();
            }
        }  catch  (Exception e) {
            e.printStackTrace();
        }
    }
}
