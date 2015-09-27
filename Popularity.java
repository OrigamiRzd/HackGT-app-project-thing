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


    public void chooseWelfare(welfareCount) {
        int x = 0;
        while ( x < welfareCount) {
             population = country.getPop();
             gdp = country.getGDP();
             budget = country.getBudget();
             budget = budget - (population*1100);
             population = population * 1.1f;
             gdp = gdp * 1.05f;
             if (budget >= 0) {
                 country.setPop(population);
                 country.setGDP(gdp);
                 country.setBudget(budget);
                 realWelfare += 1;
             }
             x += 1;
           }
    }
    public void chooseDefense(defenseCount) {
        int x = 0;
        while ( x < defenseCount) {
             population = country.getPop();
             gdp = country.getGDP();
             budget = country.getBudget();
             budget = budget - (population*2500);
             population = population * 0.9f;
             gdp = gdp * 1.09f;
             if (budget >= 0){
                 country.setPop(population);
                 country.setGDP(gdp);
                 country.setBudget(budget);
                 realDefense += 1;
             }
             x += 1;
           }
    }

    public void chooseEnvironment(environmentCount) {
        int x = 0;
        while ( x < environmentCount) {
             population = country.getPop();
             gdp = country.getGDP();
             budget = country.getBudget();
             budget = budget - (population*500);
             population = population * 1.2f;
             gdp = gdp * 0.95f;
             if (budget >= 0){
                 country.setPop(population);
                 country.setGDP(gdp);
                 country.setBudget(budget);
                 realEnvironment += 1;
             }
             x += 1;
           }
    }
    public float findPopularity(){
        float total = realEnvironment + realDefense + realWelfare;
        taxRate = country.getTaxRate();
        taxPop = 25- Math.abs(25-taxRate);
        if (taxPop < 0) {
            taxPop = 0;
        }
        if (total > 0) {
            partEnvironment = realEnvironment/total;
            partDefense = realDefense/total;
            partWelfare = realWelfare/total;
            envPop = ((1/3) - Math.abs((1/3)-partEnvironment))*300/4;
            welPop = ((1/3) - Math.abs((1/3)-partWelfare))*300/4;
            defPop = ((1/3) - Math.abs((1/3)-partDefense))*300/4;

            if (envPop < 0){
                envPop = 0;
            }
            if (welPop < 0){
                welPop = 0;
            }
            if (defPop < 0){
                defPop = 0;
            }
      }
      else {
           envPop = 0;
           welPop = 0;
           defPop = 0;
      }
      popularity = taxPop + envPop + welPop + defPop;
      return popularity;


    }



}
