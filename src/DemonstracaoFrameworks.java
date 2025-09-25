// Importações necessárias para as anotações dos frameworks.
// Em um projeto real, elas seriam resolvidas pelas dependências (Maven/Gradle).
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
// import javax.persistence.*;
// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * =================================================================================
 * ARQUIVO DE DEMONSTRAÇÃO DE ANOTAÇÕES DE FRAMEWORKS
 * =================================================================================
 * IMPORTANTE: Este código é um exemplo conceitual para explicar as anotações.
 * Para compilá-lo e executá-lo, é necessário criar um projeto com as
 * dependências do Spring Boot, Spring Data JPA e JUnit 5.
 * ---------------------------------------------------------------------------------
 */

/**
 * A anotação @SpringBootApplication é um atalho que inclui:
 * @Configuration: Marca a classe como uma fonte de definições de beans.
 * @EnableAutoConfiguration: Tenta configurar automaticamente o Spring.
 * @ComponentScan: Procura por outros componentes, serviços e controladores no pacote.
 */
// @SpringBootApplication
public class DemonstracaoFrameworks {

    // Em um projeto Spring Boot, o método main inicia toda a aplicação.
    public static void main(String[] args) {
        // SpringApplication.run(DemonstracaoFrameworks.class, args);
        System.out.println("Este arquivo serve como uma demonstração conceitual.");
        System.out.println("Cada classe abaixo explica o uso de anotações de frameworks.");
    }
}

// =================== CAMADA DE DADOS (JPA / HIBERNATE) ===================

/**
 * ====================================================================
 * 1. @Entity
 * ====================================================================
 * O que é?: Uma anotação do Java Persistence API (JPA).
 * O que faz?: Marca esta classe como uma "entidade", o que significa que ela
 * representa uma tabela em um banco de dados.
 * Como é usada?: Colocada diretamente acima da declaração da classe.
 * Por que é usada?: Para habilitar o Mapeamento Objeto-Relacional (ORM). O framework
 * (como o Hibernate) saberá que objetos da classe 'Usuario' devem ser
 * persistidos na tabela 'usuario' do banco de dados. Ele cria a ponte
 * entre o mundo da Orientação a Objetos (classes) e o mundo Relacional (tabelas).
 */
// @Entity
class Usuario {

    /**
     * ====================================================================
     * 2. @Id
     * ====================================================================
     * O que é?: Uma anotação do JPA.
     * O que faz?: Marca o campo abaixo como a chave primária (Primary Key) da tabela.
     * Como é usada?: Colocada diretamente acima do campo que servirá como ID.
     * Por que é usada?: Para identificar unicamente cada registro na tabela do
     * banco de dados. Todo @Entity precisa ter um @Id.
     */
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o valor do ID automaticamente
    private Long id;

    /**
     * ====================================================================
     * 3. @Column
     * ====================================================================
     * O que é?: Uma anotação do JPA.
     * O que faz?: Mapeia o campo da classe para uma coluna específica na tabela
     * do banco de dados. Permite customizar o nome, tamanho, nulidade, etc.
     * Como é usada?: Colocada diretamente acima de um campo da entidade.
     * Por que é usada?: Para ter controle sobre o schema do banco de dados. Se
     * você não usar, o framework usará o nome do campo como o nome da
     * coluna por padrão. Aqui, estamos forçando que o campo 'email'
     * seja mapeado para uma coluna chamada "user_email" que não pode ser nula.
     */
    // @Column(name = "user_email", nullable = false, unique = true)
    private String email;

    // Construtores, Getters e Setters omitidos para brevidade.
}


// =================== CAMADA DE SERVIÇO E CONTROLE (SPRING) ===================

// Em um projeto real, teríamos interfaces e classes de serviço.
// @Service
class UsuarioService {
    public Usuario buscarPorId(Long id) {
        // Lógica para buscar um usuário no banco de dados...
        System.out.println("Buscando usuário com ID: " + id);
        return new Usuario(); // Retorna um usuário de exemplo
    }
}


/**
 * ====================================================================
 * 4. @RestController
 * ====================================================================
 * O que é?: Uma anotação do Spring Framework. É uma especialização de @Controller.
 * O que faz?: Marca a classe como um controlador web e garante que os dados
 * retornados pelos métodos sejam serializados diretamente no corpo da
 * resposta HTTP (geralmente em formato JSON).
 * Como é usada?: Colocada diretamente acima da declaração da classe do controlador.
 * Por que é usada?: Para criar APIs RESTful de forma rápida e fácil. Você não
 * precisa se preocupar em converter seus objetos para JSON manualmente;
 * o Spring cuida disso.
 */
// @RestController
// @RequestMapping("/usuarios") // Define o caminho base para todos os endpoints nesta classe
class UsuarioController {

    private final UsuarioService usuarioService;

    /**
     * ====================================================================
     * 5. @Autowired
     * ====================================================================
     * O que é?: Uma anotação do Spring para injeção de dependência.
     * O que faz?: Pede ao Spring para encontrar um "bean" (um objeto gerenciado
     * pelo Spring) do tipo especificado (aqui, UsuarioService) e
     * injetá-lo automaticamente nesta variável.
     * Como é usada?: Em construtores (prática recomendada), campos ou métodos setter.
     * Por que é usada?: Para aplicar o princípio de Inversão de Controle (IoC).
     * Em vez de a classe `UsuarioController` criar sua própria instância
     * de `UsuarioService` (ex: `new UsuarioService()`), ela delega essa
     * responsabilidade ao Spring. Isso desacopla os componentes, tornando
     * o código mais modular, fácil de testar e de manter.
     */
    // @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * ====================================================================
     * 6. @GetMapping
     * ====================================================================
     * O que é?: Uma anotação do Spring para mapeamento de requisições HTTP.
     * O que faz?: Mapeia requisições HTTP do tipo GET para o método anotado.
     * O valor "/{id}" indica que ele espera um valor na URL (ex: /usuarios/123),
     * que será capturado pela anotação @PathVariable.
     * Como é usada?: Colocada diretamente acima de um método em um @RestController.
     * Por que é usada?: Para definir os "endpoints" da sua API de forma declarativa
     * e limpa. É a porta de entrada para as requisições que chegam à sua
     * aplicação. Existem também @PostMapping, @PutMapping, @DeleteMapping, etc.
     */
    // @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(/*@PathVariable*/ Long id) {
        return usuarioService.buscarPorId(id);
    }
}


// =================== CAMADA DE TESTES (JUNIT) ===================

class UsuarioControllerTest {

    /**
     * ====================================================================
     * 7. @Test
     * ====================================================================
     * O que é?: A anotação principal do framework de testes JUnit.
     * O que faz?: Marca um método como um caso de teste. O executor de testes
     * do JUnit irá procurar por esta anotação e executar os métodos marcados.
     * Como é usada?: Colocada diretamente acima de um método (geralmente void e público).
     * Por que é usada?: Para automatizar a verificação do código. Testes garantem
     * que seu código funciona como esperado e ajudam a prevenir regressões
     * (quando uma nova alteração quebra algo que já funcionava). Escrever
     * testes é uma prática fundamental no desenvolvimento de software de qualidade.
     */
    // @Test
    void quandoBuscarUsuario_deveRetornarUsuarioCorreto() {
        // 1. Preparação (Setup)
        UsuarioService serviceMock = new UsuarioService(); // Em um teste real, usaríamos um "mock".
        UsuarioController controller = new UsuarioController(serviceMock);

        // 2. Ação (Act)
        Usuario resultado = controller.buscarUsuarioPorId(1L);

        // 3. Verificação (Assert)
        System.out.println("Executando um teste com JUnit...");
        // assertEquals(1L, resultado.getId()); // Exemplo de verificação do JUnit
    }
}
