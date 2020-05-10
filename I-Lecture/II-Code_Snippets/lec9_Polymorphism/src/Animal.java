public abstract class Animal {
    abstract void speak();

    public static void main(String[] args) {
        Animal[] animals = new Animal[2];

        animals[0] = new Cat();
        animals[1] = new Dog();

        for (int i = 0; i < animals.length; i++)
            animals[i].speak();
    }
}
