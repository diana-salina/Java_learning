package ru.nsu.salina.stages;

import ru.nsu.salina.Car;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tunnel extends Stage{
    private Semaphore semaphore;
    private final Lock lock;
    public   Tunnel () {
        this .length =  80 ;
        this .description =  "Тоннель "  + length +  " метров" ;
        lock = new ReentrantLock();
    }
    @Override
    public   void   go (Car c) {
        lock.lock();
        if (semaphore == null) {
            semaphore = new Semaphore(Car.getCarCount() / 2);
        }
        lock.unlock();
        try  {
            try  {
                System.out.println(c.getName() +  " готовится к этапу(ждет): "  +
                        description);
                semaphore.acquire();
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
