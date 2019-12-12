package advanced.one.spliterator;

public enum Gender {
    FEMALE("Zenski"),MALE("Muski"),  TRANS("Srednji");

    private String name;

    private Gender(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

}
