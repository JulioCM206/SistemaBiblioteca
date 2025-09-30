package modelo;

public class Professor extends Usuario {
    public Professor(String matricula, String nome, String curso){
        super(matricula, nome, curso);
    }
    @Override
    public int getPrazoDia() {
        return 14;
    }
}
