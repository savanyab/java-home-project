public class Advertisement {
    private int price;
    private int count;
    private int expenses;

    public Advertisement() {
        price = 50000;
    }

    public int getAdCount() {
        return count;
    }

    public int getExpenses() { return expenses; }

    public int getAdPrice() { return price; }

    public void setAdExpenses() {expenses = count * price;}

    public void changeAdCount(int i){
        count = i;
    }


}
