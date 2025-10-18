package repositorio;
import modelo.Aluno;

public class RepositorioAluno implements Repositorio {
    protected Aluno[] alunos;
    protected static int Capacidade = 50;
    private int quantidade;

    public RepositorioAluno(){
        alunos = new Aluno[Capacidade];
        this.quantidade = 0;
    }

    @Override
    public void adicionar(Object obj) {
        if (!(obj instanceof Aluno)) {
            System.out.println("Erro: O objeto fornecido não é um Aluno.");
            return;
        }
        Aluno novoAluno = (Aluno) obj;
        if(buscador(novoAluno.getMatricula()) != null){
            System.out.println("Erro: já existe um aluno com a matrícula " + novoAluno.getMatricula());
            return;
        }
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] == null) {
                alunos[i] = novoAluno;
                System.out.println("Aluno " + novoAluno.getNome() + " adicionado.");
                this.quantidade++;
                return;
            }
        }
        System.out.println("Erro: Repositório de Alunos cheio. Capacidade máxima de " + Capacidade + " atingida.");
    }

    @Override
    public void remover(String chave) {
        if (buscador(chave) == null) {
            System.out.println("Aluno nao existe no repositório");
            return;
        }

        for(int i=0; i< alunos.length; i++){
            if(alunos[i] != null && alunos[i].getMatricula().equals(chave)){
                this.quantidade--;
                System.out.println("Aluno '" + alunos[i].getMatricula() + "' removido.");
                alunos[i] = null;
                return;
            }
        }
        System.out.println("Aluno nao existente no repositorio.");
    }

@Override
public Object buscar(String chave) {
    for (Aluno aluno : alunos) {
        if (aluno != null && aluno.getMatricula().equals(chave)) {
            System.out.println("Aluno '" + aluno.getNome() + "' buscado.");
            return aluno;
        }
    }
    System.out.println("Busca falhou / nao existe no sistema..");
    return null; // Não encontrado
}

    @Override
    public Object[] listar() {
        // Conta quantos alunos não são null
        int count = 0;
        for (Aluno a : alunos) {
            if (a != null) count++;
        }

        // Cria cópia apenas com válidos
        Aluno[] copia = new Aluno[count];
        int j = 0;
        for (Aluno a : alunos) {
            if (a != null) {
                copia[j++] = a;
            }
        }

        return copia;
    }

    //método auxiliar
    public Object buscador(String chave) {
        for (Aluno aluno : alunos) {
            if (aluno != null && aluno.getMatricula().equals(chave)) {
                return aluno;
            }
        }
        return null; // Não encontrado
    }
}
