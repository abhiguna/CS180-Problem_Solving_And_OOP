import java.io.*;

public class ObjectIO {
    public static void main(String[] args) throws Exception {
        File f = new File("object");

        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Tree tree1 = new Tree(42, "elm");
        oos.writeObject(tree1);                 // write the object out
        oos.close();

        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Tree tree2 = (Tree) ois.readObject();   // read the object back

        ois.close();

        System.out.printf("tree1 = %s\n", tree1);
        System.out.printf("tree2 = %s\n", tree2);
    }
}