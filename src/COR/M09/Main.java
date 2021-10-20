package COR.M09;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ferParetSerial();
        ferParetConcurrent();
    }

    public static void ferParetSerial() {
        int numMaons = 10, ti, te;
        int numPaletes = 5;

        //instanciem els paletes
        Paleta[] P = new Paleta[numPaletes];

        //comencem a contar el temps
        ti = (int) System.currentTimeMillis();
        //Donem nom als paletes i els posem a fer fer la paret
        for (int i=0;i<numPaletes;i++) {
            P[i] = new Paleta("Paleta-"+i);
            P[i].posaMaons(numMaons);
        }
        //Han acabat i agafem el temps final
        te = (int) System.currentTimeMillis();
        System.out.println("SERIAL: Han trigat: " + (te - ti)/1000 + " segons");
    }

    public static void ferParetConcurrent() {
        int numMaons = 10, ti, te;
        int numPaletes = 5;

        //instanciem els paletes
        Paleta[] P = new Paleta[numPaletes];
        //ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        //comencem a contar el temps
        ti = (int) System.currentTimeMillis();
        //Donem nom als paletes
        for (int i=0;i<numPaletes;i++) {
            P[i] = new Paleta("Paleta-"+i);
            //P[i].posaMaons(numMaons);
            executor.execute(P[i]);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Han acabat i agafem el temps final
        te = (int) System.currentTimeMillis();
        System.out.println("CONCURRENT: Han trigat: " + (te - ti)/1000 + " segons");
    }
}
