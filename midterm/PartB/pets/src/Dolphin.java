class Dolphin extends AbstractPetMammal {
    public Dolphin(String petName,
        double weight,
        String sound,
        Person owner) {
	// Dolphins have no legs, so set number of legs to 0
        super(petName,0, weight, sound, false, owner);
    }

    @Override
    public void makeSound() {
        System.out.println("Eee Eee");
    }
}
