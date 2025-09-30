package modelo;

public abstract class Usuario {
    protected String matricula;
    protected String nome;
    protected String curso;
    public Usuario(String matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }
    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }
    public abstract int getPrazoDia();
}

