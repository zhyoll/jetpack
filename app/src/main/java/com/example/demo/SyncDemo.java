package com.example.demo;

public class SyncDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始执行主线程");
        Object obj = new Object();
        new Thread(() -> {
            synchronized (obj){
                System.out.println("开始执行子线程A");
                try {
                    Thread.sleep(5000);
//                    obj.wait(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("结束执行子线程A");
            }
        }, "A").start();


        //保证线程A始终先执行
        Thread.sleep(1000);
        new Thread(()->{
            synchronized (obj){
                System.out.println("执行子线程B");
            }
        },"B").start();

        new Thread(()->{

            System.out.println("执行子线程C");

        },"C").start();
    }
}
