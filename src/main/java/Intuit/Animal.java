package Intuit;

public abstract class Animal {
    abstract void makeSound();

    void makeSleep(){
        System.out.println("I am sleeping");
    }

    public static void main(String[] args){
        Animal dog = new Dog();
        Animal cat = new Cat();
        dog.makeSleep();

    }

}

