package pl.mobile.dynamicform;

import android.content.Context;

import pl.mobile.dynamicform.model.Field;
import pl.mobile.dynamicform.model.FieldWrapper;
import pl.mobile.dynamicform.model.Form;


/**
 * Created by zjuroszek on 22.06.15.
 */
public class FieldAdapter extends GenericCustomListAdapter<FieldWrapper> {

    public FieldAdapter(ListItemInflater<FieldWrapper> listItemInflater, Context context) {
        super(listItemInflater, context);
    }


}


