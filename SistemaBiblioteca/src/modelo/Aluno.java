package modelo;

public class Aluno extends Usuario {
    public Aluno(String matricula, String nome, String curso){
        super(matricula, nome, curso);
    }
    @Override
    public int getPrazoDia() {
        return 7;
    }
}
