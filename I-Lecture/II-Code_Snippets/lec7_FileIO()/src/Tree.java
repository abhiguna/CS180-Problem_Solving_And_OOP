import java.io.*;

class Tree implements Serializable {
    long circumference;
    String species;

    Tree(long circumference, String species) {
        this.circumference = circumference;
        this.species = species;
    }

    public String toString() {
        return String.format("%x: circumference = %d,  species = %s",
                hashCode(), circumference, species);
    }
}
