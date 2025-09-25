import java.util.ArrayList;
import java.util.List;

/**
 * Este arquivo demonstra os principais conceitos da linguagem Java.
 * Para executar, compile o arquivo com 'javac EstudoJavaCompleto.java'
 * e depois execute com 'java EstudoJavaCompleto'.
 */
public class EstudoJavaCompleto {

    // O método 'main' é o ponto de entrada de qualquer programa Java.
    // É aqui que a JVM (Java Virtual Machine) começa a execução.
    public static void main(String[] args) {

        System.out.println("--- Base da linguagem Java e Criando nosso primeiro arquivo .Java ---");
        // A linha acima é uma instrução que imprime um texto no console.
        // Toda instrução em Java termina com um ponto e vírgula (;).
        // Java é "case-sensitive", ou seja, 'minhaVariavel' é diferente de 'MinhaVariavel'.
        System.out.println("Olá, Mundo! Este é nosso primeiro programa em Java.");
        System.out.println("--------------------------------------------------------------------\n");


        // Uma variável é um espaço na memória para armazenar um valor.
        // Declaração: [tipo] [nomeDaVariavel] = [valorInicial];
        String saudacao = "Bem-vindo ao estudo de Java!"; // Variável para armazenar texto
        int ano = 2025;                                 // Variável para armazenar um número inteiro
        System.out.println("--- Declarando variáveis ---");
        System.out.println(saudacao);
        System.out.println("Ano atual: " + ano);
        System.out.println("---------------------------\n");


        // Tipos primitivos são os tipos de dados mais básicos do Java. Não são objetos.
        System.out.println("--- Tipos Primitivos ---");
        byte   idadeByte    = 30;     // Inteiro de 8 bits (-128 a 127)
        short  populacaoPequena = 30000; // Inteiro de 16 bits
        int    populacaoGrande  = 2000000000; // Inteiro de 32 bits (mais comum)
        long   populacaoMundial = 8000000000L; // Inteiro de 64 bits (precisa do 'L' no final)

        float  precoFloat   = 19.99f; // Ponto flutuante de 32 bits (precisa do 'f' no final)
        double precoDouble  = 19.99;  // Ponto flutuante de 64 bits (mais preciso e comum)

        char   letra        = 'A';    // Um único caractere de 16 bits (aspas simples)
        boolean estaChovendo = false; // Valor lógico: true ou false

        System.out.println("Exemplo de int: " + populacaoGrande);
        System.out.println("Exemplo de double: " + precoDouble);
        System.out.println("Exemplo de boolean: " + estaChovendo);
        System.out.println("------------------------\n");


        // Condicionais permitem executar blocos de código com base em uma condição.
        System.out.println("--- Condicionais (if, else, else if) ---");
        int idadeParaVotar = 18;
        if (idadeParaVotar >= 70) {
            System.out.println("Voto facultativo (idoso).");
        } else if (idadeParaVotar >= 18) {
            System.out.println("Voto obrigatório.");
        } else if (idadeParaVotar >= 16) {
            System.out.println("Voto facultativo (jovem).");
        } else {
            System.out.println("Não pode votar.");
        }
        System.out.println("------------------------------------------\n");


        // Vetores (Arrays) são estruturas de dados com tamanho fixo para armazenar elementos do mesmo tipo.
        System.out.println("--- Vetores (Arrays) ---");
        // Declaração e inicialização de um array de inteiros
        int[] numeros = {10, 20, 30, 40, 50};
        String[] nomes = new String[3]; // Cria um array de Strings com 3 posições (vazias)
        nomes[0] = "Alice";
        nomes[1] = "Bob";
        nomes[2] = "Charlie";

        // Acessando um elemento (índices começam em 0)
        System.out.println("O segundo número é: " + numeros[1]); // Saída: 20
        System.out.println("O primeiro nome é: " + nomes[0]);   // Saída: Alice
        System.out.println("Tamanho do array de nomes: " + nomes.length);
        System.out.println("-------------------------\n");


        // ArrayList é semelhante ao array, mas com tamanho dinâmico (pode crescer e diminuir).
        // Faz parte do Java Collections Framework e só pode armazenar objetos.
        System.out.println("--- ArrayList ---");
        List<String> frutas = new ArrayList<>(); // Usamos a interface List e a classe ArrayList
        frutas.add("Maçã");
        frutas.add("Banana");
        frutas.add("Laranja");

        System.out.println("Frutas na lista: " + frutas);
        System.out.println("A primeira fruta é: " + frutas.get(0));
        frutas.remove("Banana"); // Remove pelo valor
        System.out.println("Lista após remover Banana: " + frutas);
        System.out.println("Tamanho atual da lista: " + frutas.size());
        System.out.println("-------------------\n");


        // Loops são usados para executar um bloco de código repetidamente.
        System.out.println("--- Loops (for, while) ---");

        System.out.println("-> Loop 'for' tradicional:");
        // Executa um número definido de vezes.
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Elemento do array na posição " + i + ": " + numeros[i]);
        }

        System.out.println("\n-> Loop 'for-each' (enhanced for):");
        // Mais simples para percorrer coleções e arrays.
        for (String fruta : frutas) {
            System.out.println("Fruta da vez: " + fruta);
        }

        System.out.println("\n-> Loop 'while':");
        // Executa enquanto uma condição for verdadeira.
        int contador = 0;
        while (contador < 3) {
            System.out.println("Contador: " + contador);
            contador++; // Importante: incrementar para não criar um loop infinito!
        }
        System.out.println("---------------------------\n");


        // Casting é a conversão de um tipo de dado para outro.
        System.out.println("--- Castings (mudança de tipos) ---");

        // Casting Implícito (Widening): de um tipo menor para um maior. É seguro.
        int meuInt = 100;
        double meuDouble = meuInt; // int é convertido para double automaticamente.
        System.out.println("Casting implícito (int para double): " + meuDouble);

        // Casting Explícito (Narrowing): de um tipo maior para um menor. Risco de perda de dados.
        double outroDouble = 9.78;
        int outroInt = (int) outroDouble; // Precisamos "forçar" a conversão com (int).
        System.out.println("Casting explícito (double para int): " + outroInt); // A parte decimal é perdida (truncada).
        System.out.println("-------------------------------------\n");


        // Programação Orientada a Objetos (POO)
        System.out.println("--- Classes, Objetos, Métodos Construtores ---");

        // Criando um OBJETO da CLASSE Carro.
        // `new Carro(...)` chama o MÉTODO CONSTRUTOR da classe.
        Carro meuCarro = new Carro("Ford", "Mustang", 2023);
        Carro carroDaVizinha = new Carro("Honda", "Civic", 2024);

        // Usando os métodos do objeto
        meuCarro.exibirInfo();
        meuCarro.acelerar();

        carroDaVizinha.exibirInfo();
        System.out.println("A cor do carro da vizinha é: " + carroDaVizinha.cor); // Acessando atributo público
        // System.out.println(carroDaVizinha.marca); // ERRO! 'marca' é private e não pode ser acessado daqui.
        System.out.println("------------------------------------------------\n");


        // Herança e Polimorfismo
        System.out.println("--- Herança e Polimorfismo ---");
        // Criando um objeto da subclasse CarroEletrico
        CarroEletrico meuTesla = new CarroEletrico("Tesla", "Model S", 2025, 100);

        // O objeto 'meuTesla' herdou métodos da classe 'Carro'
        meuTesla.exibirInfo(); // Chama o método sobrescrito (polimorfismo)
        meuTesla.acelerar();   // Chama o método herdado

        // Polimorfismo em ação: um objeto CarroEletrico PODE SER TRATADO como um Carro.
        Carro carroGenerico = new CarroEletrico("BYD", "Dolphin", 2024, 75);
        carroGenerico.exibirInfo(); // Executa a versão do método de CarroEletrico!
        // A JVM decide em tempo de execução qual método chamar.
        System.out.println("--------------------------------\n");


        // Interfaces e Classes Abstratas
        System.out.println("--- Interfaces e Classes Abstratas ---");
        // Não podemos criar um objeto de uma classe abstrata:
        // Animal meuAnimal = new Animal(); // ERRO!

        Cachorro rex = new Cachorro();
        Gato felix = new Gato();

        rex.emitirSom(); // Método implementado da classe abstrata
        rex.dormir();    // Método concreto herdado da classe abstrata

        felix.emitirSom();
        felix.movimentar(); // Método implementado da interface
        System.out.println("--------------------------------------\n");


        // Tratamento de Exceções
        System.out.println("--- Tratamento de Exceções ---");
        try {
            // Bloco 'try': tentamos executar um código que pode dar erro (lançar uma exceção).
            int[] valores = {1, 2, 3};
            System.out.println("Tentando acessar uma posição que não existe...");
            System.out.println(valores[5]); // Isso vai lançar uma ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            // Bloco 'catch': se o erro esperado acontecer, este bloco é executado.
            System.err.println("ERRO: Você tentou acessar um índice fora dos limites do array.");
            // 'e.getMessage()' pode dar mais detalhes sobre o erro.
        } finally {
            // Bloco 'finally': este código SEMPRE é executado, com ou sem erro.
            System.out.println("O bloco de tratamento de exceções foi finalizado.");
        }
        System.out.println("O programa continua executando após a exceção ser tratada.");
        System.out.println("--------------------------------\n");
    }
}


// CLASSE: É um molde/planta para criar objetos. Define atributos (variáveis) e métodos (funções).
class Carro {
    // Modificadores de acesso
    // ATRIBUTOS (variáveis de instância)
    private String marca;      // private: só pode ser acessado DENTRO desta classe
    protected String modelo;   // protected: acessível nesta classe, subclasses e classes do mesmo pacote
    public String cor = "Preto"; // public: acessível de qualquer lugar
    int ano;                   // default (ou package-private): acessível por classes no mesmo pacote

    // MÉTODO CONSTRUTOR: Um método especial para criar e inicializar objetos.
    // Tem o mesmo nome da classe e não tem tipo de retorno.
    public Carro(String marca, String modelo, int ano) {
        // 'this' se refere ao objeto atual que está sendo criado.
        // Usamos para diferenciar o atributo da classe do parâmetro do método.
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    // MÉTODOS (comportamentos do objeto)
    public void acelerar() {
        System.out.println("O carro " + this.marca + " " + this.modelo + " está acelerando!");
    }

    public void exibirInfo() {
        System.out.println("Carro: " + this.marca + " " + this.modelo + " | Ano: " + this.ano);
    }
}


// Herança: A classe CarroEletrico HERDA tudo que é público e protegido da classe Carro.
// CarroEletrico é uma SUBCLASSE (ou classe filha), Carro é a SUPERCLASSE (ou classe pai).
class CarroEletrico extends Carro {
    private int capacidadeBateria; // Atributo específico de CarroEletrico

    // Construtor da subclasse
    public CarroEletrico(String marca, String modelo, int ano, int capacidadeBateria) {
        // 'super(...)' chama o construtor da superclasse (Carro).
        // Deve ser a primeira linha do construtor da subclasse.
        super(marca, modelo, ano);
        this.capacidadeBateria = capacidadeBateria;
    }

    // Polimorfismo (Sobrescrita de Método - Override)
    // Estamos fornecendo uma nova implementação para um método que já existe na superclasse.
    @Override // Anotação opcional, mas boa prática para indicar sobrescrita.
    public void exibirInfo() {
        // 'super.exibirInfo()' chama a implementação original do método da classe pai.
        super.exibirInfo();
        System.out.println("Capacidade da Bateria: " + this.capacidadeBateria + " kWh");
    }
}


// INTERFACE: é um "contrato" que define um conjunto de métodos abstratos (sem corpo).
// Uma classe que "implementa" uma interface é obrigada a fornecer uma implementação para todos os seus métodos.
interface Movivel {
    void movimentar(); // Métodos em interfaces são public e abstract por padrão.
}


// CLASSE ABSTRATA: não pode ser instanciada. Pode ter métodos abstratos e métodos concretos.
// Serve como uma base para outras classes.
abstract class Animal {
    // Método abstrato: não tem implementação, deve ser implementado pelas subclasses.
    public abstract void emitirSom();

    // Método concreto: já tem uma implementação e é herdado pelas subclasses.
    public void dormir() {
        System.out.println("O animal está dormindo... Zzz...");
    }
}

// Cachorro herda de Animal e é obrigado a implementar 'emitirSom'.
class Cachorro extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Au Au!");
    }
}

// Gato herda de Animal E implementa a interface Movivel.
// É obrigado a implementar os métodos abstratos de AMBOS.
class Gato extends Animal implements Movivel {
    @Override
    public void emitirSom() {
        System.out.println("Miau!");
    }

    @Override
    public void movimentar() {
        System.out.println("O gato está andando silenciosamente.");
    }
}