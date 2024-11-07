public class Produtos {
    private static int contadorID = 1;
    private int ID;
    private String nome;
    private int quant;

    public Produtos(String nome, int quant) {
        this.ID = contadorID++;
        this.nome = nome;
        this.quant = quant;
    }

    public int getID() {
        return ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public void imprimir() {
        System.out.println("ID: " + ID + ", Nome: " + nome + ", Quantidade: " + quant);
    }
}
