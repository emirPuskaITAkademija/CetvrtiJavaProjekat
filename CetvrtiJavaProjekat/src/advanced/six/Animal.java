package advanced.six;

public class Animal {

    private int id;
    private String animalType;
    private String name;
    private Person owner;

    public String getAnimalType() {
        return animalType;
    }

    public Animal setAnimalType(String animalType) {
        this.animalType = animalType;
        return this;
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {
        return id;
    }

    public Animal setId(int id) {
        this.id = id;
        return this;
    }

    public Person getOwner() {
        return owner;
    }

    public Animal setOwner(Person owner) {
        this.owner = owner;
        return this;
    }
}
