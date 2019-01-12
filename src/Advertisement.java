public class Advertisement {
    private int adPrice;
    private int adCount;
    private int adExpenses;

    public Advertisement() {
        adPrice = 5000;
    }

    public int getAdCount() {
        return adCount;
    }

    public int getExpenses() { return adExpenses; }

    public int getAdPrice() { return adPrice; }

    public void setAdExpenses() {adExpenses = adCount * adPrice;}

    public void changeAdCount(int i){
        adCount = i;
        System.out.println("Reklámok száma: " + adCount);
    }


}
