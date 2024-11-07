import java.util.ArrayList;

public class Estoque {
    private static int contadorID = 1;
    private int ID;
    private String categoria;
    private ArrayList<Produtos> produtos;

    public Estoque(String categoria) {
        this.ID = contadorID++;
        this.categoria = categoria;
        this.produtos = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void adicionarProduto(Produtos produto) {
        produtos.add(produto);
    }

    public void removerProduto(int idProduto) {
        produtos.removeIf(produto -> produto.getID() == idProduto);
    }

    public void imprimir() {
        System.out.println("Estoque ID: " + ID + ", Categoria: " + categoria);
        System.out.println("Produtos no Estoque:");
        for (Produtos produto : produtos) {
            produto.imprimir();
        }
    }
}
