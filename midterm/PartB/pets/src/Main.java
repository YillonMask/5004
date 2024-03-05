import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person owner = new Person("John", "Doe", 1990);

        Cat cat = new Cat("Kitty", 4, 4.5, "Meow", owner);
        Dog dog = new Dog("Rover", 4, 10.5, "Woof", owner);
        Chimpanzee chimpanzee = new Chimpanzee("Coco",
            2,
            50.0,
            "Ooh Ooh Ah Ah",
            owner);
	      Dolphin dolphin = new Dolphin("Adolpho", 500, "Eee Eee", owner);

        List<AbstractPetMammal> pets = new ArrayList<>();
        pets.add(cat);
        pets.add(dog);
        pets.add(chimpanzee);
	      pets.add(dolphin);

        for (AbstractPetMammal pet : pets) {
            System.out.println("Pet: " + pet.getPetName());
            System.out.println("Number of Legs: " + pet.getNumberOfLegs());
            System.out.println("Weight: " + pet.getWeight());
            System.out.println("Sound: " + pet.getSound());
            System.out.println("Land-based: " + pet.isLandBased());
            System.out.println("Owner: " + owner.toString());
            pet.makeSound();
            System.out.println();
        }
    }
}
