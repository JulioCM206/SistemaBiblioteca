package Test;

import modelo.Aluno;
import modelo.Livro;
import modelo.Professor;
import Servico.Biblioteca;
public class Test {

    public static void executarTestes() {

        System.out.println("--- 1. INICIALIZANDO O SISTEMA ---");
        Biblioteca biblioteca = new Biblioteca();

        Professor prof1 = new Professor("P001", "Ana Silva", "Engenharia");

        Aluno aluno1 = new Aluno("A123", "Bruno Costa", "Computação");

        biblioteca.cadastrarUsuario(prof1);
        biblioteca.cadastrarUsuario(aluno1);
        System.out.println("Usuários cadastrados.");

        // Livro 1 (2 cópias)
        Livro l1 = new Livro("Estruturas de Dados", "Autor X", 2018, 2);
        // Livro 2 (1 cópia)
        Livro l2 = new Livro("POO com Java", "Autor Y", 2020, 1);

        biblioteca.cadastrarLivro(l1);
        biblioteca.cadastrarLivro(l2);
        System.out.println("Livros cadastrados. Estoque inicial:");
        System.out.println("- " + l1.getTitulo() + ": " + l1.getQuantidade()); // Estoque 2
        System.out.println("- " + l2.getTitulo() + ": " + l2.getQuantidade()); // Estoque 1
        System.out.println("\n");


        System.out.println("--- 2. TESTE EMPRÉSTIMOS ---");

        // Empréstimo 1: Professor (P001) pega "Estruturas de Dados"
        // Este empréstimo terá prazo de 14 dias
        System.out.println("TEST: Empréstimo 1 (Professor):");
        biblioteca.realizarEmprestimo(
                "P001",
                "Estruturas de Dados",
                "Autor X"
        );
        // Estoque de L1 passa a ser 1.

        System.out.println("\nTEST: Empréstimo 2 (Aluno):");
        // Empréstimo 2: Aluno (A123) pega "POO com Java"
        // Este empréstimo terá prazo de 7 dias
        biblioteca.realizarEmprestimo(
                "A123",
                "POO com Java",
                "Autor Y"
        );
        // Estoque de L2 passa a ser 0.

        System.out.println("\nTEST: Empréstimo Falho (Sem estoque):\n");
        // Tentativa de Empréstimo 3: Aluno tenta pegar "POO com Java" novamente
        biblioteca.realizarEmprestimo(
                "A123",
                "POO com Java",
                "Autor Y"
        ); // Deve falhar e imprimir "Erro: Livro indisponível no estoque."

        System.out.println("\nEstoque após empréstimos:");
        System.out.println("- " + l1.getTitulo() + ": " + l1.getQuantidade()); // Estoque 1
        System.out.println("- " + l2.getTitulo() + ": " + l2.getQuantidade()); // Estoque 0
        System.out.println("\n");



        System.out.println("--- 3. TESTE LISTA DE EMPRÉSTIMOS EM ANDAMENTO ---");
        biblioteca.imprimirEmprestimosEmAndamento();

        System.out.println("--- 4. TESTE DO REGISTRANDO DEVOLUÇÃO ---");
        // Devolve o Empréstimo 2 (ID assumido como 2)
        boolean devolvido = biblioteca.registrarDevolucao(2);
        if (devolvido) {
            System.out.println("Devolução do Empréstimo ID 2 registrada com sucesso."); //esperado
        } else {
            System.out.println("Falha ao registrar devolução do Empréstimo ID 2."); //so vai retornar se tiver algum erro na funçao devolver
        }

        System.out.println("\nEstoque após devolução:");
        System.out.println("- " + l2.getTitulo() + ": " + l2.getQuantidade()); // Estoque deve voltar a ser 1.
        System.out.println("\n");

        //verificaçao adicional pare ver se imprimir a lista esta correto depois de uma devoluçao

        System.out.println("--- 5. LISTA DE EMPRÉSTIMOS EM ANDAMENTO (ATUALIZADA) ---");
        // Apenas o Empréstimo 1 deve aparecer agora.
        biblioteca.imprimirEmprestimosEmAndamento();
        System.out.println("Sistema encerrado.");
    }
}