public class OTOPICOS {
    public static void main(String[] args) {
        System.out.println("=== Outros Tópicos Básicos ===");

        // Convenções de nomes: camelCase para variáveis, PascalCase para classes

        // Operadores bitwise
        int x = 6;  // 110 em binário
        int y = 3;  // 011 em binário
        System.out.println("x & y (AND): " + (x & y)); // 010 = 2
        System.out.println("x | y (OR): " + (x | y));  // 111 = 7
        System.out.println("x ^ y (XOR): " + (x ^ y)); // 101 = 5

        // Funções para String
        String nome = "Java";
        System.out.println("Tamanho: " + nome.length());
        System.out.println("Maiúsculo: " + nome.toUpperCase());
        System.out.println("Substituir: " + nome.replace("a", "@"));

        // Comentários em Java:
        // linha única
        /*
         * múltiplas linhas
         */
        /**
         * Comentário de documentação
         */
    }
}

