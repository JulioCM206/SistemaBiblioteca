package app;

import modelo.Aluno;
import modelo.Livro;
import repositorio.RepositorioAluno;
import repositorio.RepositorioLivro;

//to-do list
//terminar de fazer os testes para livros e corrigir erros de RepositorioLivro (Passar coisas de repositorio aluno que funcionam para repositorio livro)

public class Main {

    public static void main() {

        System.out.println("         { DEMONSTRAÇÃO DE FUNCIONALIDADES }");

        System.out.println("\n--- 1. OPERAÇÕES COM REPOSITÓRIO DE ALUNOS ---");

        RepositorioAluno repoAlunos = new RepositorioAluno();

        //Alunos
        Aluno a1 = new Aluno("Maria Silva", "2024001");
        Aluno a2 = new Aluno("João Santos", "2024002");
        Aluno a3 = new Aluno("Pedro Lima", "2024003");

        //tentar imprimir lista vazia

        System.out.println("\n TESTE:Lista inicial (Vazia):\n");
        Imprimir.imprimirLista(repoAlunos.listar());
        //teste 1 inserir livro
        System.out.println("\n TESTE: adicionar (Espera-se mensagem de sucesso)\n");
        repoAlunos.adicionar(a1);
        repoAlunos.adicionar(a2);
        //teste 1.1 inserir existente
        System.out.println("\n TESTE: Adicionar Aluno ja existente: (Espera-se erro abaixo)\n");
        repoAlunos.adicionar(a1);
        //imprimir lista
        System.out.println("\n TESTE: Lista de Alunos (Apos adicionar): espera-se ter 2 alunos inseridos");
        Imprimir.imprimirLista(repoAlunos.listar());


        //teste 2 remover livro
        System.out.println("\n TESTE: Remover (Espera-se mensagem de removido abaixo + lista sem nenhum item) \n)");
        //2.1 remover livro existente
        repoAlunos.remover(a1.getMatricula());
        repoAlunos.remover(a2.getMatricula());
        Imprimir.imprimirLista(repoAlunos.listar());
        System.out.println("\n TESTE: Remover Aluno que nao existe no repositório e lista vazia (Espera-se 2 mensagens de ERRO abaixo) \n)");
        //2.2 remover livro não existente no repositorio
        repoAlunos.remover(a3.getMatricula()); //espera erro
        //2.3 remover livro lista vazia
        repoAlunos.remover(a1.getMatricula()); //espera erro



        //teste 3 buscar
        System.out.println("\n TESTE: Buscar (Lista atualmente vazia, Espera-se mensagem de adicionado e buscado abaixo) \n");
        //3.1 buscar existente
        repoAlunos.adicionar(a1);
        repoAlunos.buscar(a1.getMatricula());
        System.out.println("\n TESTE: Buscar nao existente (Espera-se erro abaixo) \n");
        //3.2 buscar não existente
        repoAlunos.buscar(a2.getMatricula());
        
        System.out.println("\n--- 1. OPERAÇÕES COM REPOSITÓRIO DE LIVROS---");

        RepositorioLivro repoLivros = new RepositorioLivro();

        //Livros
        Livro L1 = new Livro("Livro 1", "Lucas");
        Livro L2 = new Livro("Livro 2", "Fernando");
        Livro L3 = new Livro("Livro 3", "Julio");
        //tentar imprimir lista vazia
        System.out.println("\n TESTE:Lista inicial (Vazia):\n");
        Imprimir.imprimirLista(repoLivros.listar());
        //teste 1 inserir livro
        System.out.println("\n TESTE: adicionar (Espera-se 2 mensagem de sucesso)\n");
        repoAlunos.adicionar(a1);
        repoAlunos.adicionar(a2);
        //teste 1.1 inserir existente
        System.out.println("\n TESTE: Adicionar Livros ja existente: (Espera-se erro abaixo)\n");
        repoAlunos.adicionar(a1);
        //imprimir lista
        System.out.println("\n TESTE: Lista de Livros (Apos adicionar): espera-se ter 2 livros inseridos");
        Imprimir.imprimirLista(repoLivros.listar());

        //teste 2 remover livro
        System.out.println("\n TESTE: Remover (Espera-se mensagem de removido abaixo + lista sem nenhum item) \n)");
        //2.1 remover livro existente
        repoLivros.remover(L1.getTitulo());
        repoLivros.remover(L2.getTitulo());
        Imprimir.imprimirLista(repoLivros.listar());
        System.out.println("\n TESTE: Remover Livro que nao existe no repositório (Espera-se 2 mensagens de ERRO abaixo) \n)");
        //2.2 remover livro não existente no repositorio
        repoLivros.remover(L3.getTitulo()); //espera erro
        //2.3 remover livro lista vazia
        repoLivros.remover(L1.getTitulo()); //espera erro

        //imprimir lista

        //teste buscar
        System.out.println("\n TESTE: Buscar (Lista atualmente vazia, Espera-se mensagem de adicionado e buscado abaixo) \n");
        //3.1 buscar existente
        repoLivros.adicionar(L1);
        repoLivros.buscar(L1.getTitulo());
        System.out.println("\n TESTE: Buscar nao existente (Espera-se erro abaixo) \n");
        //3.2 buscar não existente
        repoLivros.buscar(L2.getTitulo());


        //testes tentar colocar objetos errados em cada repositorio
        System.out.println("teste inserir livro em aluno e aluno em livro (Espera-se 2 erros de tipo incompatível abaixo) \n)");
        repoAlunos.adicionar(L1);
        repoLivros.adicionar(a2);
    }
}
