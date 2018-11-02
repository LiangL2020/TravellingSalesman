import java.util.ArrayList;

public class Chromosome {

    private int cost;
    private boolean[] code; //if went to the city then set to true

    public Chromosome(){
        code = new boolean[TestCities.numberOfCities()];
        cost = 0;
    }

    public int getPath() {

        int rand = (int)(Math.random()*TestCities.numberOfCities() + 1);

        return 1;

    }

    //should return the distance between two cities
    //have to know between which two cities
    //TODO
    public int calcScore(){
        int total = 0;
        for (int i = 0; i < code.length; i++) {
        }


        return cost;
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
