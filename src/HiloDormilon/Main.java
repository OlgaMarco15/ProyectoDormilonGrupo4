package HiloDormilon;

//TODO: complicar codigo y hacer javadoc
//Comentario Guillermo
//Comentario Olga

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
            System.out.println("Iniciando hilo");
            Thread dormilon = new HiloDormilon();
            System.out.println("Estado del hilo: " + dormilon.getState());

            System.out.println("Ejecutando hilo");
            dormilon.start();
            System.out.println("Estado del hilo: " + dormilon.getState());

            System.out.println("Durmiendo hilo");
            dormilon.sleep(2000);
            System.out.println("Estado del hilo: " + dormilon.getState());

            System.out.println("Interrumpo el hilo");
            dormilon.interrupt();
            System.out.println("Estado del hilo: " + dormilon.getState());

            System.out.println("Se vuelve a dormir el hilo");
            dormilon.join();
            System.out.println("Estado del hilo: " + dormilon.getState());

        }catch (InterruptedException e){
            System.out.println("Uy va!, me han despertado");
        }
    }
}
