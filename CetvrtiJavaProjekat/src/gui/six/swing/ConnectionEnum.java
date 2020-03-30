package gui.six.swing;

//http://collabedit.com/nusv3
public enum ConnectionEnum {

    URL("jdbc:derby://localhost:1527/gui"), 
    USERNAME("puska"), 
    PASSWORD("puska");

    private String value;

    private ConnectionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
