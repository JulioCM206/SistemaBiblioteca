package repositorio;

public interface Repositorio {
    void adicionar(Object obj);
    void remover(String chave);
    Object buscar(String chave);
    Object[] listar();
}
