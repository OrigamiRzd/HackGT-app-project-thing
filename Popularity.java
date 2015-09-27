class Popularity {
    private float taxRate;
    private float budget;
    private float popularity;
    private float population;
    private int defenseCount;
    private int welfareCount;
    private int environmentCount;
    private float defPop;
    private float welPop;
    private float envPop;
    private float taxPop;
    private Country country;
    private int realDefense;
    private int realWelfare;
    private int realEnvironment;
    private float partEnvironment;
    private float partDefense;
    private float partWelfare;

    public Popularity(Country country) {
        this.country = country;
    }


    public void chooseWelfare(int welfareCount, int defenseCount, int environmentCount) {
        this.popularity = 0;
        this.budget = this.country.getBudget();
        this.popularity = (welfareCount + defenseCount + environmentCount - this.country.getTaxRate())/3;
        this.budget -= welfareCount*100 + defenseCount*100 + environmentCount*100;
        this.country.setBudget(this.budget);
    }
    public float findPopularity() {
        return this.popularity;
    }
}
