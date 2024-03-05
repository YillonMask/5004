abstract class AbstractPetMammal implements PetMammal {
    private String petName;
    private int numberOfLegs;
    private double weight;
    private String sound;
    private boolean isLandBased;
    private Person owner;

    public AbstractPetMammal(String petName,
           int numberOfLegs,
			     double weight,
			     String sound,
			     boolean isLandBased,
			     Person owner) {
        this.petName = petName;
        this.numberOfLegs = numberOfLegs;
        this.weight = weight;
        this.sound = sound;
        this.isLandBased = isLandBased;
        this.owner = owner;
    }

    public String getPetName() {
        return petName;
    }
    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public double getWeight() {
        return weight;
    }

    public String getSound() {
        return sound;
    }

    public boolean isLandBased() {
        return isLandBased;
    }

    public Person getOwner() {
        return owner;
    }

    abstract public void makeSound();
}
