public class Vetores {
    public static void main(String[] args) {
        // Array de números
        int[] numeros = {10, 20, 30, 40, 50};

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Posição " + i + ": " + numeros[i]);
        }

        // For-each
        for (int n : numeros) {
            System.out.println("Número: " + n);
        }
    }
}

