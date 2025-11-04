package HiloDormilon;

class HiloDormilon extends Thread {
    @Override
    public void run() {
        try{
            Thread dormilon = new Thread();
            dormilon.start();
            System.out.println("Uyyyy que sueeñoo me voy a dormir...");
            dormilon.sleep(30000);
            System.out.println("Zzzzzzzzz");
        }catch (InterruptedException e){
            System.out.println("¡Uy va!, me han despertado");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Thread dormilon = new HiloDormilon();
            dormilon.start();
            dormilon.sleep(2000);
            System.out.println("Estado del hilo: " + dormilon.getState());
            dormilon.interrupt();
            dormilon.join();
            System.out.println("Estado del hilo: " + dormilon.getState());

        }catch (InterruptedException e){
            System.out.println("Uy va!, me han despertado");
        }
    }
}