package pl.mobile.dynamicform;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import pl.mobile.dynamicform.model.Field;


/**
 * Created by zjuroszek on 10.08.16.
 */
public class FieldInflater implements GenericCustomListAdapter.ListItemInflater<Field> {
    private LayoutInflater inflater;


    public FieldInflater(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final Field item, View convertView, int positionFlag) {
        final ViewHolder holder;
        if (convertView == null) {

            holder = new ViewHolder();
            Field.InputType inputType = null;
            switch (inputType) {
                case TEXT:
                    convertView = inflater.inflate(R.layout.input_text_item, null);
                    holder.label = (TextView) convertView.findViewById(R.id.labelTv);
                    holder.editText = (EditText) convertView.findViewById(R.id.editText);
                    break;
                case SELECT:
                    convertView = inflater.inflate(R.layout.input_select_item, null);
                    holder.label = (TextView) convertView.findViewById(R.id.labelTv);
                    holder.listView = (ListView) convertView.findViewById(R.id.listView);
                    break;
                case CHECK:
                    convertView = inflater.inflate(R.layout.input_check_item, null);
                    holder.label = (TextView) convertView.findViewById(R.id.labelTv);
                    holder.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
                    break;
                case EMAIL:
                    convertView = inflater.inflate(R.layout.input_email_item, null);
                    holder.label = (TextView) convertView.findViewById(R.id.labelTv);
                    holder.editText = (EditText) convertView.findViewById(R.id.editTextEmail);
                    break;

            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

 /*       private String type;

        private String name;

        private String label;

        private String required;

        private String max_len;

        private String description_text;

        private String description_html;

        private String regex;

        private String defaultValue;

        private String SELECT;*/


/*
        "type": "TEXT",
                "name": "firstname",
                "label": "Firstname",
                "required": "True",
                "max_len": "50",
                "regex": "^[\\w\\d _\\-]{0,50}$"*/


        holder.label.setText(item.getLabel());
       /* holder.editText.setText(item.);
        holder.editText.setText(item.);
        holder.editText.setText(item.);
        holder.editText.setText(item.);
        holder.editText.setMax*/


        holder.editText.addTextChangedListener(new DOTPAYTextWatcher(holder.editText) {
            @Override
            public void afterTextChanged(Editable s) {
                editText.removeTextChangedListener(this);
                editText.setText(s.toString().replace(" ", ""));
                editText.setSelection(editText.getText().length());
                editText.addTextChangedListener(this);
                // item.setFirstName(editText.getText().toString());
            }
        });


        //holder.creditCardMask.setText(item.getCardNumber());
        return convertView;
    }

    class DOTPAYTextWatcher implements TextWatcher {

        public EditText editText;

        public DOTPAYTextWatcher(EditText editText) {
            this.editText = editText;
        }


        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    }


    public static class ViewHolder {
        public TextView label;
        public EditText editText;
        public CheckBox checkBox;
        public ListView listView;

    }
}

