package pl.mobile.dynamicform.model;

import java.util.Collection;

import pl.mobile.dynamicform.enums.InputType;

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

    public InputType parseInputType() {
        if (getType().equalsIgnoreCase("TEXT")) {
            return InputType.TEXT;
        }
        if (getType().equalsIgnoreCase("EMAIL")) {
            return InputType.EMAIL;
        }
        if (getType().equalsIgnoreCase("CHECK")) {
            return InputType.CHECK;
        }
        if (getType().equalsIgnoreCase("SELECT")) {
            return InputType.SELECT;
        }
        throw new IllegalArgumentException("State string has invalid value");

    }


    @Override
    public String getType() {
        return field.getType();
    }

    @Override
    public void setType(String type) {
        field.setType(type);
    }

    @Override
    public String getName() {
        return field.getName();
    }

    @Override
    public void setName(String name) {
        field.setName(name);
    }

    @Override
    public String getLabel() {
        return field.getLabel();
    }

    @Override
    public void setLabel(String label) {
        field.setLabel(label);
    }

    @Override
    public String getRequired() {
        return field.getRequired();
    }

    @Override
    public void setRequired(String required) {
        field.setRequired(required);
    }

    @Override
    public String getMax_len() {
        return field.getMax_len();
    }

    @Override
    public void setMax_len(String max_len) {
        field.setMax_len(max_len);
    }

    @Override
    public String getDescription_text() {
        return field.getDescription_text();
    }

    @Override
    public void setDescription_text(String description_text) {
        field.setDescription_text(description_text);
    }

    @Override
    public String getDescription_html() {
        return field.getDescription_html();
    }

    @Override
    public void setDescription_html(String description_html) {
        field.setDescription_html(description_html);
    }

    @Override
    public String getRegex() {
        return field.getRegex();
    }

    @Override
    public void setRegex(String regex) {
        field.setRegex(regex);
    }

    @Override
    public String getDefaultValue() {
        return field.getDefaultValue();
    }

    @Override
    public void setDefaultValue(String defaultValue) {
        field.setDefaultValue(defaultValue);
    }

    @Override
    public String getSelect() {
        return field.getSelect();
    }

    @Override
    public void setSelect(String select) {
        field.setSelect(select);
    }

    @Override
    public Collection<Choice> getChoices() {
        return field.getChoices();
    }

    @Override
    public void setChoices(Collection<Choice> choices) {
        field.setChoices(choices);
    }

    @Override
    public String getUserInput() {
        return field.getUserInput();
    }

    @Override
    public void setUserInput(String userInput) {
        field.setUserInput(userInput);
    }

    @Override
    public String toString() {
        return field.toString();
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FieldWrapper that = (FieldWrapper) o;

        if (userInput != null ? !userInput.equals(that.userInput) : that.userInput != null)
            return false;
        return !(field != null ? !field.equals(that.field) : that.field != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userInput != null ? userInput.hashCode() : 0);
        result = 31 * result + (field != null ? field.hashCode() : 0);
        return result;
    }
}
