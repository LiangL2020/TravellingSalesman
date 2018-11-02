import java.util.ArrayList;

public class Chromosome {

    private int cost;
    private boolean[] code; //if went to the city then set to true

    public Chromosome(){
        code = new boolean[TestCities.numberOfCities()];
        cost = 0;
    }

    public ArrayList<City> getPath() {

        int rand = (int)(Math.random()*TestCities.numberOfCities() + 1);

    }

    public boolean getCode(){
        for (int i = 0; i < code.length; i++) {
            if (code[i])
                return true;
        }
        return false;
    }

    public int getCost() {
        return cost;
    }
}
