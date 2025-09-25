// Arquivo: EstruturaEComportamentoDeClasse.java

// Aqui criamos a classe Produto (NÃO é public, porque só pode ter 1 public por arquivo)
class Produto {
    // ===============================
    // 🔒 Atributos (ou campos da classe)
    // ===============================
    // private = só podem ser acessados dentro da própria classe
    private String nome;       // texto (cadeia de caracteres)
    private double preco;      // número decimal
    private int quantidade;    // número inteiro

    // ===============================
    // 🏗 Construtores (formas de criar objetos Produto)
    // ===============================

    // Construtor vazio (sem parâmetros)
    // Serve para criar um Produto sem passar dados na hora
    public Produto() {}

    // Construtor completo: inicializa nome, preço e quantidade
    public Produto(String nome, double preco, int quantidade) {
        // this = referência ao atributo da classe
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Sobrecarga (overload): outro construtor só com nome e preço
    // Aqui reaproveitamos o construtor completo, passando 0 como quantidade
    public Produto(String nome, double preco) {
        this(nome, preco, 0);
    }

    // ===============================
    // ⚙ Getters e Setters (encapsulamento)
    // ===============================
    // Usamos para controlar acesso aos atributos privados
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public int getQuantidade() { return quantidade; }
    // não tem setQuantidade, porque a ideia é mudar só via métodos adicionar/remover

    // ===============================
    // 📦 Métodos da classe
    // ===============================
    // Calcula o valor total em estoque (preço * quantidade)
    public double valorTotalEmEstoque() {
        return preco * quantidade;
    }

    // Adiciona produtos ao estoque
    public void adicionarProdutos(int quantidade) {
        this.quantidade += quantidade; // += soma ao valor atual
    }

    // Remove produtos do estoque
    public void removerProdutos(int quantidade) {
        this.quantidade -= quantidade; // -= subtrai do valor atual
    }

    // ===============================
    // 🖨 toString() sobrescrito
    // ===============================
    // @Override = estamos sobrescrevendo o método padrão do Java
    // toString() é chamado automaticamente quando fazemos System.out.println(objeto)
    @Override
    public String toString() {
        return nome + ", R$" + preco + ", " + quantidade + " unidades, Total: R$" + valorTotalEmEstoque();
    }
}

// ===============================
// 🚀 Classe principal do programa
// ===============================
// Só pode existir UMA classe public com o mesmo nome do arquivo
public class EstruturaEComportamentoDeClasse {
    // Ponto de entrada do programa
    public static void main(String[] args) {
        // Criamos um objeto Produto usando o construtor completo
        Produto p = new Produto("TV", 1500.0, 5);

        // Como temos o toString() sobrescrito, o objeto é mostrado de forma personalizada
        System.out.println(p);

        // Adiciona 2 TVs ao estoque
        p.adicionarProdutos(2);
        System.out.println("Depois da adição: " + p);

        // Remove 3 TVs do estoque
        p.removerProdutos(3);
        System.out.println("Depois da remoção: " + p);
    }
}

