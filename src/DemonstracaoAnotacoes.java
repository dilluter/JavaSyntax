import java.util.List;
import java.util.ArrayList;

/**
 * Este arquivo é um exemplo único e completo que demonstra as anotações
 * mais comuns do Java. Cada anotação é explicada em detalhes nos comentários
 * Javadoc logo acima de seu uso prático.
 */
public class DemonstracaoAnotacoes {

    public static void main(String[] args) {
        System.out.println("--- Início da Demonstração de Anotações ---");

        // 1. Demonstração do @Override
        Veiculo meuCarro = new Carro();
        meuCarro.ligarMotor(); // A implementação da subclasse Carro será chamada.

        // 2. Demonstração do @Deprecated e @SuppressWarnings
        System.out.println("\n--- Usando método com @Deprecated e @SuppressWarnings ---");

        /**
         * ====================================================================
         * 3. @SuppressWarnings
         * ====================================================================
         * O que é?: Uma anotação para instruir o compilador a ignorar certos avisos (warnings).
         * O que faz?: Suprime os avisos de compilação especificados entre parênteses.
         * Exemplos comuns são "deprecation" (uso de código obsoleto) e
         * "unchecked" (operações com genéricos que não são 100% seguras em tipo).
         * Como é usada?: Colocada antes de uma classe, método ou declaração de variável.
         * Por que é usada?: Para limpar a saída do compilador quando um aviso é inevitável
         * ou quando o desenvolvedor já analisou o código e garante que ele
         * é seguro, apesar do aviso. DEVE SER USADA COM CUIDADO.
         * --------------------------------------------------------------------
         * Exemplo Abaixo: Sem o @SuppressWarnings("deprecation"), o compilador nos daria
         * um aviso de que estamos usando um método obsoleto. Com a anotação, nós
         * dizemos ao compilador: "Eu sei o que estou fazendo, pode ignorar este aviso."
         */
        @SuppressWarnings("deprecation")
                Utilidades.metodoAntigo();

        // 4. Demonstração do @FunctionalInterface
        System.out.println("\n--- Usando uma @FunctionalInterface com Lambda ---");
        // A interface 'Operacao' é uma interface funcional, por isso podemos usar uma lambda.
        Operacao soma = (a, b) -> a + b;
        System.out.println("Resultado da operação (15 + 7): " + soma.executar(15, 7));

        // 5. Demonstração do @SafeVarargs
        System.out.println("\n--- Usando método com @SafeVarargs ---");
        exibirEmListaSegura("Item 1", "Item 2", "Item 3");

        System.out.println("\n--- Fim da Demonstração ---");
    }

    /**
     * ====================================================================
     * 5. @SafeVarargs
     * ====================================================================
     * O que é?: Uma anotação para garantir ao compilador que um método que usa varargs
     * (argumentos variáveis) com tipos genéricos é seguro.
     * O que faz?: Suprime os avisos de compilação relacionados à "poluição de heap"
     * (heap pollution), que pode ocorrer quando se mistura genéricos com arrays.
     * Como é usada?: Em métodos ou construtores que são 'private', 'static' ou 'final'
     * (ou seja, não podem ser sobrescritos) e que usam varargs genéricos.
     * Por que é usada?: Para afirmar que o desenvolvedor do método garante que o corpo
     * do método não realiza operações inseguras com o array de varargs.
     * Isso limpa os avisos para quem chama o método.
     */
    @SafeVarargs
    private static <T> void exibirEmListaSegura(T... elementos) {
        // A implementação aqui é segura pois apenas lemos os elementos.
        List<T> lista = new ArrayList<>();
        for (T elemento : elementos) {
            lista.add(elemento);
        }
        System.out.println("Lista criada a partir dos elementos varargs: " + lista);
    }
}

// =================== CLASSES E INTERFACES DE APOIO ===================

/**
 * Superclasse para demonstrar o @Override.
 */
class Veiculo {
    public void ligarMotor() {
        System.out.println("Motor do veículo ligado (som genérico).");
    }
}

/**
 * Subclasse que usa @Override.
 */
class Carro extends Veiculo {
    /**
     * ====================================================================
     * 1. @Override
     * ====================================================================
     * O que é?: Uma anotação marcadora padrão do Java.
     * O que faz?: Informa ao compilador que este método TEM a intenção de
     * sobrescrever um método da superclasse (neste caso, da classe Veiculo).
     * Como é usada?: Colocada diretamente acima da assinatura de um método.
     * Por que é usada?: Principalmente para SEGURANÇA. Se você cometer um erro de digitação
     * no nome do método (ex: "ligarMotorr"), o compilador irá gerar um
     * ERRO, pois não encontrará um método com esse nome para sobrescrever.
     * Sem o @Override, um novo método seria criado, e o comportamento
     * esperado não aconteceria, o que seria um bug difícil de achar.
     */
    @Override
    public void ligarMotor() {
        System.out.println("Motor do carro ligado (Vrum vrum!).");
    }
}

/**
 * Classe com um método obsoleto para demonstrar @Deprecated.
 */
class Utilidades {
    /**
     * ====================================================================
     * 2. @Deprecated
     * ====================================================================
     * O que é?: Uma anotação padrão para marcar um elemento de código (classe, método, etc.)
     * como obsoleto.
     * O que faz?: Causa um aviso (warning) de compilação sempre que o código é usado.
     * As IDEs (ambientes de desenvolvimento) geralmente mostram o nome riscado.
     * Como é usada?: Colocada diretamente acima da declaração que está obsoleta.
     * Pode incluir 'since' (versão em que se tornou obsoleta) e 'forRemoval'
     * (se há planos de removê-la no futuro).
     * Por que é usada?: Para informar aos outros desenvolvedores que eles não devem mais
     * usar este pedaço de código. Geralmente, indica-se qual é a nova
     * alternativa a ser usada, ajudando na evolução de uma API ou sistema.
     */
    @Deprecated(since = "2.0", forRemoval = true)
    public static void metodoAntigo() {
        System.out.println("Este é um método antigo e será removido no futuro.");
    }
}

/**
 * ====================================================================
 * 4. @FunctionalInterface
 * ====================================================================
 * O que é?: Uma anotação informativa para indicar que uma interface foi projetada
 * para ser uma "interface funcional".
 * O que faz?: Garante, em tempo de compilação, que a interface tenha EXATAMENTE
 * um método abstrato. Se você tentar adicionar um segundo método abstrato,
 * o compilador gerará um erro. Métodos 'default' ou 'static' são permitidos.
 * Como é usada?: Colocada diretamente acima da declaração de uma interface.
 * Por que é usada?: Para deixar claro a intenção da interface e para permitir que ela
 * seja usada com expressões LAMBDA e Method References, que são
 * recursos chave do Java 8+. Garante que a interface permaneça funcional.
 */
@FunctionalInterface
interface Operacao {
    int executar(int a, int b);
}
