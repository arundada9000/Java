public class AbstractClass {
    public static void main(String args[]) {
        Dog dog = new Dog();
        dog.breathe();
        dog.makeSound();
    }
}

abstract class Animal {
    abstract void makeSound(); // Rule for all animals

    void breathe() {
        System.out.println("Breathing...");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Woof!");
    }
}
