package pl.mobile.dynamicform.model;

import java.util.Collection;

/**
 * Created by zjuroszek on 16.08.16.
 */
public class FieldWrapper extends Field {
    String userInput;
    Field field;

    public FieldWrapper(Field field) {
        super();
        this.field = field;
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getLabel() {
        return super.getLabel();
    }

    @Override
    public void setLabel(String label) {
        super.setLabel(label);
    }

    @Override
    public String getRequired() {
        return super.getRequired();
    }

    @Override
    public void setRequired(String required) {
        super.setRequired(required);
    }

    @Override
    public String getMax_len() {
        return super.getMax_len();
    }

    @Override
    public void setMax_len(String max_len) {
        super.setMax_len(max_len);
    }

    @Override
    public String getDescription_text() {
        return super.getDescription_text();
    }

    @Override
    public void setDescription_text(String description_text) {
        super.setDescription_text(description_text);
    }

    @Override
    public String getDescription_html() {
        return super.getDescription_html();
    }

    @Override
    public void setDescription_html(String description_html) {
        super.setDescription_html(description_html);
    }

    @Override
    public String getRegex() {
        return super.getRegex();
    }

    @Override
    public void setRegex(String regex) {
        super.setRegex(regex);
    }

    @Override
    public String getDefaultValue() {
        return super.getDefaultValue();
    }

    @Override
    public void setDefaultValue(String defaultValue) {
        super.setDefaultValue(defaultValue);
    }

    @Override
    public String getSelect() {
        return super.getSelect();
    }

    @Override
    public void setSelect(String select) {
        super.setSelect(select);
    }

    @Override
    public Collection<Choice> getChoices() {
        return super.getChoices();
    }

    @Override
    public void setChoices(Collection<Choice> choices) {
        super.setChoices(choices);
    }

    @Override
    public String getUserInput() {
        return super.getUserInput();
    }

    @Override
    public void setUserInput(String userInput) {
        super.setUserInput(userInput);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "FieldWrapper{" +
                "userInput='" + userInput + '\'' +
                ", field=" + field +
                '}';
    }
}
