package repositorio;
import modelo.Livro;


public class RepositorioLivro implements Repositorio {
    protected Livro[] livros;
    private static final int Capacidade = 50;
    private int quantidade;

    public RepositorioLivro() {
        this.livros = new Livro[Capacidade];
        this.quantidade = 0;
    }

    @Override
    public void adicionar(Object obj) {
        if (!(obj instanceof Livro)) {
            System.out.println("Erro: O objeto fornecido não é um Livro.");
            return;
        }
        Livro novoLivro = (Livro) obj;
        if (buscador(novoLivro.getTitulo()) != null) {
            System.out.println("Erro: já existe um livro com titulo:  " + novoLivro.getTitulo());
            return;
        }
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] == null) {
                livros[i] = novoLivro;
                System.out.println("Livro " + novoLivro.getTitulo() + " adicionado.");
                this.quantidade++;
                return;
            }
        }
        System.out.println("Erro: Repositório de Livros cheio. Capacidade máxima de " + Capacidade + " atingida.");
    }

    @Override
    public void remover(String chave) {
        if (buscador(chave) == null) {
            System.out.println("Livro nao existe no repositório");
            return;
        }

        for(int i=0; i< livros.length; i++){
            if(livros[i] != null && livros[i].getTitulo().equals(chave)){
                this.quantidade--;
                System.out.println("Livro '" + livros[i].getTitulo() + "' removido.");
                livros[i] = null;
                return;
            }
        }
        System.out.println("Livro nao existente no repositório.");
    }

    @Override
    public Object buscar(String chave) {
        for (Livro livro : livros) {
            if (livro != null && livro.getTitulo().equals(chave)) {
                System.out.println("Aluno '" + livro.getTitulo() + "' buscado.");
                return livro;
            }
        }
        System.out.println("Busca falhou / nao existe no sistema..");
        return null;
    }

    @Override
    public Object[] listar() {
        // Conta quantos livros não são null
        int count = 0;
        for (Livro l : livros) {
            if (l != null) count++;
        }

        // Cria cópia apenas com válidos
        Livro[] copia = new Livro[count];
        int j = 0;
        for (Livro l : livros) {
            if (l != null) {
                copia[j++] = l;
            }
        }

        return copia;
    }

    //método auxiliar
    public Object buscador(String chave) {
        for (Livro livro : livros) {
            if (livro != null && livro.getTitulo().equals(chave)) {
                return livro;
            }
        }
        return null; // Não encontrado
    }
}