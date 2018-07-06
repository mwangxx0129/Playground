public class Dog extends Animal {
    int value; // TODO: default access permission ?
    Dog(int value) {
        super(value); // TODO: if not call super(), raise compiler error; need to test on comand line
        this.value = value;
    }

    @Override //TODO: when override is necessary
    public void print() {
        System.out.println("dog: " + value);
    }

    public void print(String name) {
        System.out.println(name + value);
    }

    public void printDog() {
        System.out.println("doger");
    }

    public static void main(String[] args) {
        Dog dog = new Dog(9);
        dog.print();
        dog.print("xinxin:\t");

        Animal animal = new Dog(9);
        animal.print();
        System.out.println(Integer.toHexString(animal.hashCode()));
        System.out.println(animal.toString());
        System.out.println(animal.getClass());
        System.out.println(animal.equals(dog));
    }
}
