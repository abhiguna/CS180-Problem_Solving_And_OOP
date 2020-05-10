public class TreeMaker {
    public static void main(String[] args) {
        while (Math.random() < 0.9) {
            PhysicalTrees t = new PhysicalTrees(Math.random() * 100);
            System.out.printf("tree has radius %.3f\n",
                    t.getRadius());
        }
        System.out.printf("created %d trees\n",
                PhysicalTrees.getNumberOfTrees());
    }
}