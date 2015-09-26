public class PopulationTrend {
    private String size;
    private long population;
    public PopulationTrend(String countrySize) {
        size = countrySize;
    }
    public long popSize() {
        if (size == "small") {
            population = 3500000L;
        }
        else if (size == "medium") {
            population = 35000000L;
        }
        else if (size == "large") {
            population = 350000000L;
        }
        else if (size == "colossal") {
            population = 3500000000L;
        }
        return population;
    }

}



// generate a random population
// small, medium, large, colossal country
// population based on that
