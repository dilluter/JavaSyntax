public class EstruturaRepeticao {
    public static void main(String[] args) {
        System.out.println("=== Estruturas de Repetição ===");

        // while
        int i = 1;
        while (i <= 5) {
            System.out.println("While: " + i);
            i++;
        }

        // for
        for (int j = 1; j <= 5; j++) {
            System.out.println("For: " + j);
        }

        // do-while
        int k = 1;
        do {
            System.out.println("Do-While: " + k);
            k++;
        } while (k <= 5);
    }
}