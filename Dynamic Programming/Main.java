abstract class Animal{
    String name;
    Animal(String name){
        this.name = name;
    }
    abstract void makeSound();
}

class Dog extends Animal{
    Dog(String name){
        super(name);
    }
    void makeSound(){
        System.out.println("The dog "+ name +" says : Woof!");
    }
}

class Cat extends Animal{
    Cat(String name){
        super(name);
    }
    void makeSound(){
        System.out.println("The cat "+ name +" says : Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog("Atul");
        animal.makeSound();

        Animal cat = new Cat("Chhavi");
        cat.makeSound();
    }
}
