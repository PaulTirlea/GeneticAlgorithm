package GeneticAlgorithm;

public class Advance {
    
    private static final double uniform = 0.5;
    private static final double mutation = 0.015;
    private static final int tourSize = 5;
    private static final boolean elitism = true;


    public static Pop evolvePop(Pop pop) {
        Pop newPop = new Pop(pop.size(), false);

        if (elitism) {
            newPop.saveIndividual(0, pop.getFittest());
        }

        int elitismOffset;
        if (elitism) {
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }
        
        for (int i = elitismOffset; i < pop.size(); i++) {
            Chromosome firstIndivide = tourSel(pop);
            Chromosome secondIndivide = tourSel(pop);
            Chromosome newIndivide = crossover(firstIndivide, secondIndivide);
            newPop.saveIndividual(i, newIndivide);
        }

        for (int i = elitismOffset; i < newPop.size(); i++) {
            mutate(newPop.getIndividual(i));
        }

        return newPop;
    }

    private static Chromosome crossover(Chromosome firstIndivide, Chromosome secondIndivide) {
        Chromosome newSol = new Chromosome();
        for (int i = 0; i < firstIndivide.size(); i++) {
            // Crossover
            if (Math.random() <= uniform) {
                newSol.setGene(i, firstIndivide.getGene(i));
            } else {
                newSol.setGene(i, secondIndivide.getGene(i));
            }
        }
        return newSol;
    }

    private static void mutate(Chromosome indiv) {
        // Loop through genes
        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= mutation) {
                // Create random gene
                byte gene = (byte) Math.round(Math.random());
                indiv.setGene(i, gene);
            }
        }
    }

    private static Chromosome tourSel(Pop pop) {
        Pop tournament = new Pop(tourSize, false);
        for (int i = 0; i < tourSize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            tournament.saveIndividual(i, pop.getIndividual(randomId));
        }
        Chromosome fittest = tournament.getFittest();
        return fittest;
    }
}