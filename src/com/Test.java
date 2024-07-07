package com;

class A{
    synchronized void m(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+": "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
               
            }
        }
    }
    
    synchronized void m1(){
      for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+": "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
               
            }
        }  
    }
}

public class Test {
    public static void main(String[] args){
        
        A a = new A();
        
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                a.m();
            }
        });
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                a.m1();
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                a.m();
            }
        });
        
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                a.m1();
            }
        });
        
        t.start();
        t1.start();
        t2.start();
        t3.start();
       
    }
}
