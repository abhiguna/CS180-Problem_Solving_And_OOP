public class PurdueStudent {
    boolean hasName;
    String name;
    int puid;

    // constructor with int...
    PurdueStudent(int puid) {
        this.puid = puid;
        hasName = false;
    }

    // constructor with String and int...
    PurdueStudent(String name, int puid) {
        this(puid);
        this.name = name;
        hasName = true;
    }
}
