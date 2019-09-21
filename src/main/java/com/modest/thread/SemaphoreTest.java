package com.modest.thread;

import java.util.concurrent.Semaphore;


/**
 * 工人工作任务
 */
class SemaphoreTask implements Runnable{

    /**
     * public Semaphore(int permits) 参数:表示同时控制的资源个数
     */
    private Semaphore semaphore;

    public SemaphoreTask(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try{
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"占用一台设备生产");

            semaphore.release();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/**
 * description
 *
 * @author modest
 * @date 2019/07/25
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        SemaphoreTask semaphoreTask =  new SemaphoreTask(semaphore);
        for(int i=0; i<8; i++) {
            new Thread(semaphoreTask,"工人"+i).start();
        }
    }
}
