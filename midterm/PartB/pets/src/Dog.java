class Dog extends AbstractPetMammal {
    public Dog(String petName,
        int numberOfLegs,
        double weight,
        String sound,
        Person owner) {
        super(petName, numberOfLegs, weight, sound, true, owner);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}
