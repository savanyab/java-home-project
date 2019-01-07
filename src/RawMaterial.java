public abstract class RawMaterial {

    protected int stock;
    protected int expenses;

    public int getStock() {
        return stock;
    }

    public int getExpenses() { return expenses; }

    public abstract void purchase();



}
