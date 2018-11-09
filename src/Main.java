public class Main {

    public static void main(String[] args) {

        TestCities cities = new TestCities();

        Population population = new Population();

        population.generation();

        while(true) {

            population.generation();

        }

    }

}


