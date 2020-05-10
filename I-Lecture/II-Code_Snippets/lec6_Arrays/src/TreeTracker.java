import java.util.Random;

public class TreeTracker {
    final static int NUMTREES = 100;

    public static void main(String[] args) {
        Random r = new Random();
        String[] species = { "pine", "elm", "spruce", "oak", "walnut" };

        var trees = new Tree[NUMTREES];

        for (int i = 0; i < trees.length; i++) {
            String specie = species[r.nextInt(species.length)];
            trees[i] = new Tree(i, r.nextDouble()*100, specie);
        }

        for (int i = 0; i < trees.length; i++)
            System.out.println(trees[i].describe());
    }
}