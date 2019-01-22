class Advertisement {
    private int adPrice;
    private int adCount;
    private int adExpenses;

    Advertisement() {
        adPrice = 5000;
    }

    int getAdCount() {
        return adCount;
    }

    int getExpenses() { return adExpenses; }

    int getAdPrice() { return adPrice; }

    void setAdExpenses() {adExpenses = adCount * adPrice;}

    void changeAdCount(int i){
        adCount = i;
    }


}
