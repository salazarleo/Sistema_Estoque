package Model;
public class Produtos {
    private int produtoID;
    private String nome;
    private double preco;
    private String descricao;
    private String material;
    private int quantidade;

    public Produtos(int produtoID, String nome, double preco, String descricao, String material, int quantidade) {
        this.produtoID = produtoID;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.material = material;
        this.quantidade = quantidade;
    }

    public Produtos(String nome, double preco, String descricao, String material, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.material = material;
        this.quantidade = quantidade;
    }

    public int getProdutoID() {
        return produtoID;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getMaterial() {
        return material;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Método para imprimir os dados do produto
    public void imprimir() {
        System.out.println("ID: " + produtoID + ", Nome: " + nome + ", Preco: " + preco + ", Descricao: " + descricao + ", Material: " + material + ", Quantidade: " + quantidade);
    }
}