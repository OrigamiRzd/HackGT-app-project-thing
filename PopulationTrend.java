public class PopulationTrend {
    private String size;
    private float population;
    public PopulationTrend(String countrySize) {
        size = countrySize;
    }
    public float popSize() {
        if (size == "small") {
            population = 3500000f;
        }
        else if (size == "medium") {
            population = 35000000f;
        }
        else if (size == "large") {
            population = 350000000f;
        }
        else if (size == "colossal") {
            population = 3500000000f;
        }
        return population;
    }

}

