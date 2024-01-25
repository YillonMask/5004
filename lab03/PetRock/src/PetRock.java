public class PetRock {
    public boolean happy = false;
    private String name;
    public double massInGrams;

    public double getMassInGrams() {
        return massInGrams;
    }

    public PetRock(String name,double massInGrams) {
        this.name = name;
        this.massInGrams = massInGrams;
    }

    public boolean isHappy() {
        return happy;
    }

    public String getName(){
        return name;
    }

    public void happyAfterPlay() {
        happy = true;
    }
    public String printHappyMessage(){
        if(!happy){
            throw new IllegalStateException();
        }
        return "I'am happy";
    }

    @Override
    public String toString() {
        return "PetRock{" +
                "happy=" + happy +
                ", name='" + name + '\'' +
                ", massInGrams=" + massInGrams +
                '}';
    }

    public static void main(String[] args){
        PetRock rocky = new PetRock("rocky",89.64);
        PetRock keyrock = new PetRock("keyrock",89.64);
        System.out.println(rocky);
        System.out.println(keyrock);
    }
}
