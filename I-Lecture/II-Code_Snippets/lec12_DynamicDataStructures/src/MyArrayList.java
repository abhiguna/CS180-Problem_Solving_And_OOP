public class MyArrayList {
    private String[] strings;
    private int size;

    public MyArrayList() {
        strings = new String[10];
        size = 0;
    }

    public String get(int i) {
        return strings[i];
    }

    public void set(int i, String s) {
        strings[i] = s;
    }

    public void add(String string) {
        if (size >= strings.length) {
            reallocate();
        }
        strings[size++] = string;
    }

    public void reallocate() {
        String[] newstrings = new String[strings.length * 2];
        for (int i = 0; i < size; i++)
            newstrings[i] = strings[i];
        strings = newstrings;
    }
}
