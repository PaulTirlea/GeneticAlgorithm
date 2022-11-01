package GeneticAlgorithm;

public class FitnessClass {

    static byte[] sol = new byte[64];

    public static void setSol(byte[] solutinNew) {
        sol = solutinNew;
    }

    static void setSol(String solutinNew) {
        sol = new byte[solutinNew.length()];
        for (int i = 0; i < solutinNew.length(); i++) {
            String chr = solutinNew.substring(i, i + 1);
            if (chr.contains("0") || chr.contains("1")) {
                sol[i] = Byte.parseByte(chr);
            } else {
                sol[i] = 0;
            }
        }
    }

    static int getFitness(Chromosome chromosome) {
        int fitness = 0;
        for (int i = 0; i < chromosome.size() && i < sol.length; i++) {
            if (chromosome.getGene(i) == sol[i]) {
                fitness++;
            }
        }
        return fitness;
    }

    static int getMaxFitness() {
        int maxFitness = sol.length;
        return maxFitness;
    }
}
