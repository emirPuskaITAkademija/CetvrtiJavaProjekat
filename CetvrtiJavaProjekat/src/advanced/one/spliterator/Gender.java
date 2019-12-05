package advanced.one.spliterator;

public enum Gender {
    MALE("Muski"), FEMALE("Zenski"), TRANS("Srednji");

    private String name;

    private Gender(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

}
