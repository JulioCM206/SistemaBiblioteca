package modelo;

import java.time.LocalDate;

public class Emprestimo {
    private static int proximoId = 1;
    private final int id;
    private final Usuario usuario;
    private final Livro livro;
    private final LocalDate dataEmprestimo;
    private final LocalDate dataPrevista;
    private LocalDate dataDevolucao;

    public Emprestimo(Usuario usuario, Livro livro) {
        this.id = proximoId++;
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevista = this.dataEmprestimo.plusDays(usuario.getPrazoDia()); //data de quando deve entregar o livro de volta
    }
    public void registrarDevolucao() {
        this.dataDevolucao = LocalDate.now();
    }

    // Getters
    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean estaEmAndamento() {
        return dataDevolucao == null;
    }
}
