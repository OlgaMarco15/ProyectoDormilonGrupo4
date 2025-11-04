package HiloDormilon;

class HiloDormilon extends Thread {
    @Override
    public void run() {
        try {
            // La lógica de dormir se ejecuta dentro del método run() de este hilo.
            System.out.println("Zzz... Me voy a dormir 30 segundos.");
            Thread.sleep(30000);
            System.out.println("¡Qué bien he dormido!"); // Esta línea no se ejecutará si es interrumpido.
        } catch (InterruptedException e) {
            // El bloque catch captura la interrupción y ejecuta la acción requerida.
            System.out.println("¡Ay! ¡Me despertaron!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        /*
         * Cread un Hilo (Dormilón) que intente dormir 30 segundos (Thread.sleep(30000)).
         *En su bloque catch (InterruptedException e), debe imprimir "¡Ay! ¡Me despertaron!".
         *En main, iniciad al Dormilón.
         *Esperad 2 segundos.
         *TIMED_WAITING: Imprimid el estado del Dormilón (debe estar durmiendo).
         *Llamad a dormilon.interrupt().
         *Llamad a dormilon.join() (para esperar a que termine) y volved a imprimir su estado.
         */

        try {
            // Se crea una instancia del nuevo hilo.
            HiloDormilon dormilon = new HiloDormilon();

            // En main, se inicia al Dormilón.
            dormilon.start();

            // Se espera 2 segundos antes de comprobar su estado.
            Thread.sleep(2000);

            // Se imprime el estado del Dormilón (debe ser TIMED_WAITING).
            System.out.println("Estado del hilo Dormilón: " + dormilon.getState());

            // Se interrumpe al hilo Dormilón.
            System.out.println("Interrumpiendo al dormilón...");
            dormilon.interrupt();

            // Se espera a que el hilo Dormilón termine su ejecución por completo.
            dormilon.join();

            // Se vuelve a imprimir su estado (debe ser TERMINATED).
            System.out.println("Estado final del hilo Dormilón: " + dormilon.getState());

        } catch (InterruptedException e) {
            // Este catch es por si el hilo main fuera interrumpido mientras duerme o espera.
            e.printStackTrace();
        }
    }
}