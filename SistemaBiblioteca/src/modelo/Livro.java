package modelo;

public class Livro {
    private final String titulo;
    private final String autor;
    private final int ano;
    private int quantidade;
    public Livro(String titulo, String autor, int ano, int quantidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.quantidade = quantidade;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public int getAno() {
        return ano;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public boolean emprestar(){
        if(this.quantidade <= 0){
            return false;
        }
        quantidade--;
        return true;
    }
    public void desemprestar(){
        this.quantidade++;
    }
    public void adicionarEstoque(int quantidadeAdicional) {
        this.quantidade += quantidadeAdicional;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return titulo.equalsIgnoreCase(livro.titulo) && autor.equalsIgnoreCase(livro.autor);
    }
}
