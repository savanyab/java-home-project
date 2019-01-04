public abstract class RawMaterial {

    protected int stock;
    protected int expenses;

    public int getStock() {
        return stock;
    }

    public int getExpenses() { return expenses; }

    public void setStock(int a) {stock = a;}

    public abstract void purchase();



}
