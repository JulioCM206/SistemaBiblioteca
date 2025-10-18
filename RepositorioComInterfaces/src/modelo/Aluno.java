package modelo;

public class Aluno {
    private final String nome;
    private final String matricula;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }
    public String getMatricula() {
        return matricula;
    }
    public String getNome() {
        return nome;
    }
    @Override
    public String toString() {
        return "{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
