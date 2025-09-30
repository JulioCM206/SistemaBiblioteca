package Servico;

import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final List<Livro> livros = new ArrayList<>();
    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();


public void cadastrarUsuario(Usuario usuarioo) {
    if (usuarios.stream().anyMatch(user -> user.getMatricula().equals(usuarioo.getMatricula()))) {
        System.out.println("ERRO: Usuário com matrícula " + usuarioo.getMatricula() + " já cadastrado.");
        return;
    }
    if(buscarUsuarioPorMatricula(usuarioo.getMatricula()) == null) {
        this.usuarios.add(usuarioo);
        System.out.println("Usuário cadastrado: " + usuarioo.getNome() + " (" + usuarioo.getClass().getSimpleName() + ")");
        return;
    }
    System.out.println("Usuario ja existe no sistema");
}

    public void cadastrarLivro(Livro livroNovo) {
        int index = this.livros.indexOf(livroNovo);

        if (index >= 0) {

            Livro livroExistente = this.livros.get(index);
            livroExistente.adicionarEstoque(livroNovo.getQuantidade());

            System.out.println("SUCESSO: Livro '" + livroExistente.getTitulo() + "' (Autor: " + livroExistente.getAutor() + "/ Ano: " + livroExistente.getAno() + " )" + " teve estoque atualizado. Adicionadas " + livroNovo.getQuantidade() + " cópias.");
            System.out.println("  Estoque Total: " + livroExistente.getQuantidade() + " cópias.");
        } else {
            this.livros.add(livroNovo);
            System.out.println("SUCESSO: Livro '" + livroNovo.getTitulo() + "' (Autor: " + livroNovo.getAutor() + "/ Ano: " + livroNovo.getAno() + " )" + " cadastrado com " + livroNovo.getQuantidade() + " cópias.");
        }
    }

    // --- METODOS AUXILIARES ---

public Usuario buscarUsuarioPorMatricula(String matricula) {
    for (Usuario u : usuarios) {
        if (u.getMatricula().equals(matricula)) {
            return u;
        }
    }
    return null; // não encontrou
}

    public Livro buscarLivroPorTituloAutor(String titulo, String autor) {
        Livro livroBusca = new Livro(titulo, autor, 0, 0);
        int index = this.livros.indexOf(livroBusca);
        if (index >= 0) {
            return this.livros.get(index);
        }
        return null; //não encontrou
    }


public void realizarEmprestimo(String matricula, String titulo, String autor) {
    // 1. Validar a existência do Usuário
    Usuario usuario = buscarUsuarioPorMatricula(matricula);
    if (usuario == null) {
        System.out.println("Erro: Usuário com matrícula " + matricula + " não encontrado.");
        return;
    }

    // 2. Validar a existência do Livro
    Livro livro = buscarLivroPorTituloAutor(titulo, autor);
    if (livro == null) {
        System.out.println("Erro: Livro (" + titulo + " por " + autor + ") não encontrado.");
        return;
    }
    if (livro.emprestar()) { //ja decrementa estoque
        Emprestimo novoEmprestimo = new Emprestimo(usuario, livro);
        this.emprestimos.add(novoEmprestimo);
        System.out.println("\nSUCESSO: Empréstimo realizado com sucesso! (Dia: " + novoEmprestimo.getDataEmprestimo() + ")");
        System.out.println("  Usuário: " + usuario.getNome() + " (" + usuario.getClass().getSimpleName() + ")");
        System.out.println("  Livro: " + livro.getTitulo());
        System.out.println("  Data Prevista de Devolução: " + novoEmprestimo.getDataPrevista());
        System.out.println("  Estoque Atual do Livro: " + livro.getQuantidade());
        return;
    }
    System.out.println("Erro: Livro indisponível no estoque.");
}
    // --- DEVOLUCAO ---
public boolean registrarDevolucao(int idEmprestimo) {
    for (Emprestimo e : emprestimos) {
        if (e.getId() == idEmprestimo && e.estaEmAndamento()) {
            e.registrarDevolucao();
            this.emprestimos.remove(e);
            e.getLivro().desemprestar();
            System.out.println("SUCESSO: Devoluçao feita com sucesso! (Dia: " + e.getDataDevolucao() + ")");
            return true;
        }
    }
    System.out.println("ERRO: Empréstimo não encontrado ou já devolvido");
    return false;
}
    // --- LISTAGEM ---
    public List<Emprestimo> listarEmprestimosEmAndamento() {
        List<Emprestimo> emAndamento = new ArrayList<>();
        for (Emprestimo e : this.emprestimos) {
            if (e.estaEmAndamento()) {
                emAndamento.add(e);
            }
        }
        return emAndamento;
    }
    public void imprimirEmprestimosEmAndamento() {
        List<Emprestimo> emAndamento = listarEmprestimosEmAndamento();
        System.out.println("\n--- LISTA DE EMPRÉSTIMOS EM ANDAMENTO (" + emAndamento.size() + ") ---");
        if (emAndamento.isEmpty()) {
            System.out.println("Nenhum empréstimo em andamento no momento.");
        } else{
            for(Emprestimo e : emAndamento) {
                System.out.println("ID: " + e.getId() + ", Usuário: " + e.getUsuario().getNome() + ", Livro: " + e.getLivro().getTitulo());
            }
        }
        System.out.println("---------------------------------------------------------\n");
    }
 }