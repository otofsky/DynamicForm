package pl.mobile.dynamicform.model;


import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by zjuroszek on 10.02.15.
 */
public class Field {

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

    public Field() {
    }

    private String type;

    private String name;

    private String label;

    private String required;

    private String max_len;

    private String description_text;

    private String description_html;

    private String regex;

    private String defaultValue;

    private String select;

    private Collection<Choice> choices = new ArrayList<Choice>();

    private  String userInput;


    public Field(String type, String name, String label, String required, String max_len, String regex) {
        this.type = type;
        this.name = name;
        this.label = label;
        this.required = required;
        this.max_len = max_len;
        this.regex = regex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getMax_len() {
        return max_len;
    }

    public void setMax_len(String max_len) {
        this.max_len = max_len;
    }

    public String getDescription_text() {
        return description_text;
    }

    public void setDescription_text(String description_text) {
        this.description_text = description_text;
    }

    public String getDescription_html() {
        return description_html;
    }

    public void setDescription_html(String description_html) {
        this.description_html = description_html;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public Collection<Choice> getChoices() {
        return choices;
    }

    public void setChoices(Collection<Choice> choices) {
        this.choices = choices;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public String toString() {
        return "Field{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", label='" + label + '\'' +
                ", required='" + required + '\'' +
                ", max_len='" + max_len + '\'' +
                ", description_text='" + description_text + '\'' +
                ", description_html='" + description_html + '\'' +
                ", regex='" + regex + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                ", SELECT='" + select + '\'' +
                ", choices=" + choices +
                '}';
    }
}
