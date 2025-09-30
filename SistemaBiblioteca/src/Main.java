import Servico.Biblioteca;
import Test.Test;
import modelo.Aluno;
import modelo.Livro;
import modelo.Professor;
import modelo.Usuario;

private static Biblioteca biblioteca = new Biblioteca();
private static final Scanner scanner = new Scanner(System.in);

void main() {

    biblioteca = new Biblioteca();

    int opcao;

    do {
        exibirMenu();
        if (scanner.hasNextInt()) {
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    cadastrarLivro();
                    break;
                case 3:
                    realizarEmprestimo();
                    break;
                case 4:
                    registrarDevolucao();
                    break;
                case 5:
                    biblioteca.imprimirEmprestimosEmAndamento();
                    break;
                case 6:
                    Test.executarTestes(); // Chama a classe de testes
                    break;
                case 0:
                    IO.println("Saindo do sistema...");
                    break;
                default:
                    IO.println("Opção inválida. Tente novamente.");
            }
        } else {
            IO.println("Entrada inválida. Digite um número.");
            scanner.nextLine();
            opcao = -1;
        }

    } while (opcao != 0 && opcao != 6);
}

private static void exibirMenu() {
    IO.println("\n--- MENU PRINCIPAL DA BIBLIOTECA ---");
    IO.println("1. Cadastrar Usuário");
    IO.println("2. Cadastrar Livro");
    IO.println("3. Realizar Empréstimo");
    IO.println("4. Registrar Devolução");
    IO.println("5. Listar Empréstimos em Andamento");
    IO.println("6. **Realizar testes do sistema**");
    IO.println("0. Sair");
    IO.print("Escolha uma opção: ");
}


private static void cadastrarUsuario() {
    IO.println("\n--- CADASTRO DE USUÁRIO ---");
    IO.print("Tipo (A=Aluno, P=Professor): ");
    String tipo = scanner.nextLine().toUpperCase();
    IO.print("Matrícula: ");
    String matricula = scanner.nextLine();
    IO.print("Nome: ");
    String nome = scanner.nextLine();
    IO.print("Curso: ");
    String curso = scanner.nextLine();

    Usuario novoUsuario;
    if (tipo.equals("A")) {
        novoUsuario = new Aluno(matricula, nome, curso);
    } else if (tipo.equals("P")) {
        novoUsuario = new Professor(matricula, nome, curso);
    } else {
        IO.println("Tipo de usuário inválido.");
        return;
    }

    biblioteca.cadastrarUsuario(novoUsuario);
}

private static void cadastrarLivro() {
    IO.println("\n--- CADASTRO DE LIVRO ---");
    IO.print("Título: ");
    String titulo = scanner.nextLine();
    IO.print("Autor: ");
    String autor = scanner.nextLine();
    IO.print("Ano: ");
    int ano = scanner.nextInt();
    IO.print("Quantidade (inicial): ");
    int quantidade = scanner.nextInt();
    scanner.nextLine(); // Consumir a nova linha

    Livro novoLivro = new Livro(titulo, autor, ano, quantidade);
    biblioteca.cadastrarLivro(novoLivro);
}

private static void realizarEmprestimo() {
    IO.println("\n--- REALIZAR EMPRÉSTIMO ---");
    IO.print("Matrícula do Usuário: ");
    String matricula = scanner.nextLine();
    IO.print("Título do Livro: ");
    String titulo = scanner.nextLine();
    IO.print("Autor do Livro: ");
    String autor = scanner.nextLine();

    biblioteca.realizarEmprestimo(matricula, titulo, autor);
}

private static void registrarDevolucao() {
    IO.println("\n--- REGISTRAR DEVOLUÇÃO ---");
    int id;

    while (true) {
        biblioteca.imprimirEmprestimosEmAndamento();
        IO.print("ID do Empréstimo: ");
        if (scanner.hasNextInt()) {
            id = scanner.nextInt();
            scanner.nextLine();
            break;
        } else {
            IO.println("Entrada inválida. Por favor, digite um número inteiro.");
            scanner.nextLine();
        }
    }
    biblioteca.registrarDevolucao(id);
}