package com.modest.thread;

/**
 * d
 *
 * @author modest
 * @date 2019/09/19
 */
public class ProducerAndConsumer {
    public static void main(String[] args) throws InterruptedException{
        Good good = new Good("Dior",0);
        Thread producer = new Thread(new Producer(good),"producer");
        Thread consumer = new Thread(new Consumer(good),"consumer");

        producer.start();
        Thread.sleep(5000);
        consumer.start();
    }
}

class Good{
    String name;
    int count;
    public Good(String name,int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    public synchronized void produce() {
        System.out.println(Thread.currentThread().getName()+toString());

        while(count >= 20) {
            System.out.println("产品量足够");

            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        this.count++;
        System.out.println(Thread.currentThread().getName()+ "已经生产了"+count+"个");;
        notifyAll();
    }

    public synchronized void consume() {
        while(count <= 0) {
            System.out.println("商品卖完了");
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.count--;
        System.out.println(Thread.currentThread().getName()+"还剩"+count+"个");
        notifyAll();
    }
}

class Producer implements Runnable{
    Good good;
    public Producer(Good good) {
        this.good = good;
    }

    @Override
    public void run() {
        while(true) {
            good.produce();
        }

    }
}

class Consumer implements Runnable{
    Good good;
    public Consumer(Good good) {
        this.good = good;
    }

    @Override
    public void run() {
        while (true){
            good.consume();
        }
    }
}


