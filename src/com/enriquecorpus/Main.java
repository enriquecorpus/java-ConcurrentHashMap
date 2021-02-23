package com.enriquecorpus;
import com.enriquecorpus.store.Data;

import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        new Thread("task1" ){
            public void run(){
                try {
                    while (true) {
                        int r = new Random().nextInt(1000);
                        Data.maps.put(r, r);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                   System.out.println(ex.toString());
                }
            }
        }.start();

        new Thread("task2" ){
            public void run(){
                while (true) {
                    try {
                        int r = new Random().nextInt(1000);
                        Data.maps.putIfAbsent(r,r);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

}
