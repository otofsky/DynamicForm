package pl.mobile.dynamicform;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pl.mobile.dynamicform.model.Field;
import pl.mobile.dynamicform.model.FieldWrapper;


/**
 * Created by zjuroszek on 10.08.16.
 */
public class FieldInflater implements GenericCustomListAdapter.ListItemInflater<FieldWrapper> {
    private LayoutInflater inflater;


    public FieldInflater(Context context) {
        inflater = LayoutInflater.from(context);
    }
    /*
            "type": "TEXT",
                    "name": "firstname",
                    "label": "Firstname",
                    "required": "True",
                    "max_len": "50",
                    "regex": "^[\\w\\d _\\-]{0,50}$"*/
    @Override
    public View getView(final FieldWrapper item, View convertView, int positionFlag) {
        final ViewHolder holder;
        if (convertView == null) {

            holder = new ViewHolder();
            Field.InputType inputType = Field.InputType.TEXT;
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

        holder.label.setText(item.getLabel());
        holder.editText.addTextChangedListener(new DOTPAYTextWatcher(holder.editText) {
            @Override
            public void afterTextChanged(Editable s) {

                editText.removeTextChangedListener(this);
                editText.setText(s.toString().replace(" ", ""));
                editText.setSelection(editText.getText().length());
                editText.addTextChangedListener(this);
                buildValidator(item.getRegex(), editText.getText().toString());


                item.setUserInput(editText.getText().toString());
            }
        });


        //holder.creditCardMask.setText(item.getCardNumber());
        return convertView;
    }


    private void buildValidator(String regex, String input){

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
    public class InputValidatorHelper {
        public boolean isValidEmail(String string){
            final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(string);
            return matcher.matches();
        }

        public boolean isValidPassword(String string, boolean allowSpecialChars){
            String PATTERN;
            if(allowSpecialChars){
                //PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
                PATTERN = "^[a-zA-Z@#$%]\\w{5,19}$";
            }else{
                //PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})";
                PATTERN = "^[a-zA-Z]\\w{5,19}$";
            }



            Pattern pattern = Pattern.compile(PATTERN);
            Matcher matcher = pattern.matcher(string);
            return matcher.matches();
        }

        public boolean isNullOrEmpty(String string){
            return TextUtils.isEmpty(string);
        }

        public boolean isNumeric(String string){
            return TextUtils.isDigitsOnly(string);
        }

        //Add more validators here if necessary
    }
}

