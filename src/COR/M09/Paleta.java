package COR.M09;

public class Paleta implements Runnable {
    private String Nom;

    public Paleta(String nom) {
        Nom = nom;

    }

    public void posaMaons(int maons) {
        //Temps que triga a col·locar els maons entre 1 i 4 segons per cada maó
        System.out.println(Nom + " posant maons...");
        try {
            Thread.sleep((long) ((Math.random()*300)+100)*maons );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Nom + " ha acabat.");
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    @Override
    // Posa Maons CONCURRENT
    public void run() {
        //int maons = 10;
        posaMaons(10);
        /*
        //Temps que triga a col·locar els maons entre 1 i 4 segons per cada maó
        System.out.println(Nom + " posant maons...");
        try {
            Thread.sleep((long) ((Math.random()*300)+100)*maons );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Nom + " ha acabat.");

         */
    }
}