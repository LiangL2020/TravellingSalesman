import java.util.*;

public class Population {

    private Chromosome[] chromosome;
    private int size;

    public Population(){
        chromosome = new Chromosome[TestCities.numberOfCities()];
        for (int i = 0; i < chromosome.length; i++) {
            chromosome[i] = new Chromosome();
        }
        size = TestCities.numberOfCities();
    }

    public void sort(){
        List<Chromosome> asList = (ArrayList<Chromosome>)(Arrays.asList(chromosome));
        Collections.sort(asList, new Comparator<Chromosome>() {
            @Override
            public int compare(Chromosome o1, Chromosome o2) {
                return o1.calcScore() - o2.calcScore();
            }
        });

        for (int i = 0; i < asList.size(); i++) {
            chromosome[i] = asList.get(i);
        }
    }


}
