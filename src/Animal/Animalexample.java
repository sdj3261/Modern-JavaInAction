package Animal;

public class Animalexample {
    public static void main(String[] args) {
        Dog a = new Dog();
        a.sound();
        Cat b = new Cat();
        b.sound();

        a.breathe();
        b.breathe();

        animalSound(new Dog());
        animalSound(new Cat());
    }
    public static void animalSound(Animal animal) {
        animal.sound();
    };
}
