import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.*;

public class Population {

    private Chromosome[] chromosome;
    private int generationNum, lowestScore;

    public Population(){
        chromosome = new Chromosome[20];
        for (int i = 0; i < chromosome.length; i++) {
            chromosome[i] = new Chromosome();
            chromosome[i].randomizePath();
        }
    }

    public void sort(){

        List<Chromosome> asList = (List<Chromosome>)(Arrays.asList(chromosome));
        Collections.sort(asList, new Comparator<Chromosome>() {
            @Override
            public int compare(Chromosome o1, Chromosome o2) {
                return o1.getDistance() - o2.getDistance();
            }
        });

        chromosome = (Chromosome[])asList.toArray();

    }


    public void generation() {

        sort();

        for (int i = 0; i < chromosome.length; i++) {
            if (i < chromosome.length / 5) {
                chromosome[i].mutate(0.4);
            } else {
                chromosome[i] = new Chromosome(chromosome[0].getPathforREAL());
                chromosome[i].mutate(1);
            }
            sort();
        }

        for (int i = 0; i < chromosome.length; i++) {
            System.out.println(chromosome[i].getDistance());
        }

        if(chromosome[0].getDistance()<lowestScore) {
            lowestScore = chromosome[0].getDistance();
        }

        sort();
        generationNum++;
        System.out.println("\nGeneration: " + generationNum);
        System.out.println("Low Score: " + lowestScore);

        if(chromosome[0].getDistance() < 4000) {
            System.out.println(chromosome[0].getPathforREAL());
        }
    }

}
