public class Animal {
    private int value;
    Animal(int value) {
        this.value = value;
    }

    public void print() {
        System.out.println("animal: " + value);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
