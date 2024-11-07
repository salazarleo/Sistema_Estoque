abstract class Item {
    private static int idCounter = 1;
    private final int ID;

    public Item() {
        this.ID = idCounter++;
    }

    public int getID() {
        return ID;
    }

    public abstract void imprimir();
}
