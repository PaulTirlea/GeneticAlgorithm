package GeneticAlgorithm;

public class Pop {

    Chromosome[] chromosomes;

    /*
     * Constructors
     */
    // Create a Pop
    public Pop(int PopSize, boolean initialise) {
        chromosomes = new Chromosome[PopSize];
        // Initialise Pop
        if (initialise) {
            // Loop and create individuals
            for (int i = 0; i < size(); i++) {
                Chromosome newChromosome = new Chromosome();
                newChromosome.generateIndividual();
                saveIndividual(i, newChromosome);
            }
        }
    }

    /* Getters */
    public Chromosome getIndividual(int index) {
        return chromosomes[index];
    }

    public Chromosome getFittest() {
        Chromosome fittest = chromosomes[0];
        // Loop through individuals to find fittest
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }

    /* Public methods */
    // Get Pop size
    public int size() {
        return chromosomes.length;
    }

    // Save individual
    public void saveIndividual(int index, Chromosome indiv) {
        chromosomes[index] = indiv;
    }
}