public class PopulationTrend {
    private String size;
    private float population;
    public PopulationTrend(String countrySize) {
        size = countrySize;
    }
    public float popSize() {
        if (size.equals("small")) {
            population = 350000f;
        }
        else if (size.equals("medium")) {
            population = 3500000f;
        }
        else if (size.equals("large")) {
            population = 35000000f;
        }
        else if (size.equals("colossal")) {
            population = 350000000f;
        }
        return population;
    }

}

