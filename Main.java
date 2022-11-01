package GeneticAlgorithm;

public class Main {
    public static void main(String[] args) {

        FitnessClass.setSol("1001000000000011000000001100000100000000011010001100100010000011");

        Pop myPop = new Pop(50, true);

        int generationCount = 0;
        while (myPop.getFittest().getFitness() < FitnessClass.getMaxFitness()) {
            generationCount++;
            System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());
            myPop = Advance.evolvePop(myPop);
        }
        System.out.println("Solution found!");
        System.out.println("Generation: " + generationCount);
        System.out.println("Genes:");
        System.out.println(myPop.getFittest());

    }}