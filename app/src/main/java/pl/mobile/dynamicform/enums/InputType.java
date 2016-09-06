package pl.mobile.dynamicform.enums;

/**
 * Created by zjuroszek on 06.09.16.
 */
public enum InputType {
    TEXT("TEXT"),
    EMAIL("email"),
    CHECK("CHECK"),
    SELECT("SELECT");

    private String type;

    InputType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
