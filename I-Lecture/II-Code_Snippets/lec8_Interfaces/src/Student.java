public class Student extends Person{
    private String[] classes;
    private String[] grades;

    public Student(String name, String address, String[] classes,
                   String[] grades) {
        super(name, address);
        //super(...,...) can be used to invoke the constructor.
        this.classes = classes;
        this.grades = grades;
    }

    public String[] getClasses() {
        return classes;
    }

    public void setClasses(String[] classes) {
        this.classes = classes;
    }

}
