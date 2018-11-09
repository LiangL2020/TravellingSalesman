import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chromosome {

    private ArrayList<City> city;

    public Chromosome(){

        city = new ArrayList<>();

    }

    public Chromosome(ArrayList<City> cities) {
        city = new ArrayList<>();
        city.clear();
        for (int i = 0; i < cities.size(); i++) {
            city.add(new City(cities.get(i)));
        }
    }

    public ArrayList<City> randomizePath() {

       city = TestCities.getCities();
       Collections.shuffle(city);
       return city;

    }

    public ArrayList<City> getPathforREAL() {

        return city;

    }

    public int getDistance() {

        int k = 0;
        double d = 0;

        for (int i = 0; i < TestCities.numberOfCities(); i++) {

            if(i > TestCities.numberOfCities() - 1) {
                k = 0;
            } else if(i < TestCities.numberOfCities() - 1){
                k = i + 1;
            }

            d += getPathforREAL().get(i).distanceTo(getPathforREAL().get(k));

        }

        return (int) d;

    }

    public int setDistance(int hold){ return hold; }

    public void mutate(double chance){

        double rand = Math.random();

        if(rand < chance){

            int i = (int)(Math.random()*TestCities.numberOfCities() - 1);
            int j = (int)(Math.random()*TestCities.numberOfCities() - 1);

            City temp = getPathforREAL().get(i);
            getPathforREAL().set(i, getPathforREAL().get(j));
            getPathforREAL().set(j, temp);

        }
    }
}
