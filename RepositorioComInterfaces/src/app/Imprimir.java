package app;

public class Imprimir {
    public static void imprimirLista(Object[] lista) {
        System.out.println("\n---  Repositório ---");

        if (lista == null || lista.length == 0) {
            System.out.println("(nenhum item encontrado)");
            System.out.println("\n--------------------");
            return;
        }

        for (Object obj : lista) {
            System.out.println(obj);
        }
        System.out.println("\n---------------------");
    }
}
