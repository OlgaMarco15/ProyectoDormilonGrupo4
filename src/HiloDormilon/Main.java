package HiloDormilon;

//TODO: complicar codigo y hacer javadoc
//Comentario Guillermo
//Comentario Olga

class HiloDormilon extends Thread {
    @Override
    public void run() {
        try{
            System.out.println("Uyyyy que sueeñoo me voy a dormir...");
            Thread.sleep(5000); // duerme este mismo hilo
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
            System.out.println("Estado del hilo: " + dormilon.getState());  //NEW

            System.out.println("Ejecutando hilo");
            dormilon.start();
            System.out.println("Estado del hilo: " + dormilon.getState());  //RUNNABLE

            System.out.println("Durmiendo hilo");
            dormilon.sleep(2000);
            System.out.println("Estado del hilo: " + dormilon.getState());  //TIME_WAITING

            System.out.println("Interrumpo el hilo");
            dormilon.interrupt();
            System.out.println("Estado del hilo: " + dormilon.getState());

            dormilon.join();
            System.out.println("Estado del hilo: " + dormilon.getState());  //TERMINATED

        }catch (InterruptedException e){
            System.out.println("Uy va!, me han despertado");
        }
    }
}
