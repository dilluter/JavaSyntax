public class EstruturaSequencial {
    public static void main(String[] args) {
        // Saída de dados
        System.out.println("=== Estrutura Sequencial ===");

        // Variáveis e tipos básicos
        int idade = 18;
        double altura = 1.75;
        char genero = 'M';
        boolean ativo = true;

        System.out.println("Idade: " + idade);
        System.out.println("Altura: " + altura);
        System.out.println("Gênero: " + genero);
        System.out.println("Ativo: " + ativo);

        // Expressões aritméticas
        int a = 10, b = 3;
        System.out.println("Soma: " + (a + b));
        System.out.println("Divisão real: " + ((double) a / b)); // Casting

        // Funções matemáticas
        System.out.println("Raiz quadrada de 16: " + Math.sqrt(16));
        System.out.println("Potência 2^3: " + Math.pow(2, 3));
    }
}
