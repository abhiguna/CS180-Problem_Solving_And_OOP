public interface Addressable {
    String getStreet();
    String getCity();
    default String getFullAddress() {
        return getStreet() + ", " + getCity();
    }
}

/*  Classes that "implement" interfaces INHERIT their
    Default methods but can override them.
 */
