import java.util.ArrayList;
import java.util.List;

public class Listas {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Igor");
        nomes.add("Ana");
        nomes.add("Bruno");

        System.out.println("Lista: " + nomes);

        nomes.remove("Ana"); // remove pelo valor
        System.out.println("Depois de remover: " + nomes);

        // Laço for-each
        for (String nome : nomes) {
            System.out.println("Nome: " + nome);
        }
    }
}

