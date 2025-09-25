import java.util.Scanner;

public class EstruturaCondicional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Estrutura Condicional ===");
        System.out.print("Digite sua idade: ");
        int idade = sc.nextInt();

        // if-else
        if (idade >= 18) {
            System.out.println("Você é maior de idade!");
        } else {
            System.out.println("Você é menor de idade!");
        }

        // switch-case
        System.out.print("Digite um número de 1 a 3: ");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1: System.out.println("Opção 1 escolhida"); break;
            case 2: System.out.println("Opção 2 escolhida"); break;
            case 3: System.out.println("Opção 3 escolhida"); break;
            default: System.out.println("Opção inválida!");
        }

        // Condicional ternária
        String resultado = (idade >= 18) ? "Maior de idade" : "Menor de idade";
        System.out.println("Resultado: " + resultado);

        sc.close();
    }
}