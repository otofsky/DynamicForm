package pl.mobile.dynamicform.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by zjuroszek on 10.02.15.
 */
public class Choice {

    private String value;

    private String label;



    //<type>SELECT</type><name>country</name><label>Państwo</label><required>True</required>


    private Collection<Field> fields = new ArrayList<Field>();


    public Choice() {

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Collection<Field> getFields() {
        return fields;
    }

    public void setFields(Collection<Field> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return label;
    }
}
