import java.util.ArrayList;
import java.util.Collections;

public class Chromosome {

//    private int cost;
//    private boolean[] code; //if went to the city then set to true
//
//    public Chromosome(){
//        code = new boolean[TestCities.numberOfCities()];
//        cost = 0;
//    }

    public ArrayList<City> getPath() {

        ArrayList<City> Cities = new ArrayList<>();

        for (int i = 0; i < TestCities.numberOfCities(); i++) {

            Cities.add(TestCities.getCity(i));

        }

        Collections.shuffle(Cities);

        return Cities;

    }

//    //should return the distance between two cities
//    //have to know between which two cities
//    public int calcScore(){
//        int total = 0;
//        for (int i = 0; i < code.length; i++) {
//        }
//
//
//        return cost;
//    }

//    public boolean getCode(){
//        for (int i = 0; i < code.length; i++) {
//            if (code[i])
//                return true;
//        }
//        return false;
//    }
//
//    public int getCost() {
//        return cost;
//    }

    public int getDistance() {

        double cost = 0.0;

        for (int i = 0; i < TestCities.numberOfCities(); i++) {

            if(i == TestCities.numberOfCities() - 1)
                cost += getPath().get(i).distanceTo(getPath().get(0));
            else if(i < TestCities.numberOfCities() -1)
                cost += getPath().get(i).distanceTo(getPath().get(i+1));

        }

        return (int)cost;

    }

    public void mutate(double chance){
        double rand = Math.random();
        if(rand < chance){
            int i = (int)(Math.random()*TestCities.numberOfCities() - 1);
            City temp = getPath().get(i);
            getPath().set(i, getPath().get(i+1));
            getPath().set(i+1, temp);
        }
    }

}
