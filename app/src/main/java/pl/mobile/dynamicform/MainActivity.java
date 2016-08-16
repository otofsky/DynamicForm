package pl.mobile.dynamicform;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.Arrays;
import java.util.List;

import pl.mobile.dynamicform.model.Field;
import pl.mobile.dynamicform.model.FieldWrapper;
import pl.mobile.dynamicform.presenter.FormPresenter;

public class MainActivity extends AppCompatActivity {

    FormPresenter formPresenter;

    LinearLayout paymentFormContainer;
    /*
        "type": "TEXT",
                "name": "firstname",
                "label": "Firstname",
                "required": "True",
                "max_len": "50",
                "regex": "^[\\w\\d _\\-]{0,50}$"*/


    Field field1 = new Field("TEXT","firstname","Firstname","True","5","^[\\w\\d _\\-]{0,5}$");
    Field field2 = new Field("TEXT","lastname","Lastname","True","5","^[\\w\\d _\\-]{0,5}$");
    Field field3 = new Field("CHECK","lastname","Aggrement","True","5","^[\\w\\d _\\-]{0,5}$");


    FieldWrapper[] fields = {new FieldWrapper(field1),new FieldWrapper(field2),new FieldWrapper(field3)};
    List<FieldWrapper>fieldList = Arrays.asList(fields);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        formPresenter = new FormPresenter();
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        paymentFormContainer = (LinearLayout) findViewById(R.id.container);
        //setSupportActionBar(toolbar);
        initPaymentTypeView(fieldList);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, fieldList.get(0).getUserInput(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    private void initPaymentTypeView(List<FieldWrapper> fieldList) {

        FieldAdapter formAdapter = new FieldAdapter(new FieldInflater(this), this);
        populateField(fieldList, paymentFormContainer, formAdapter);


    }

    private static void populateField(List<FieldWrapper> fieldList, LinearLayout container, FieldAdapter adapter) {
        for (FieldWrapper field : fieldList) {
            adapter.add(field);
        }
        for (int i = 0; i < adapter.getCount(); ++i) {
            container.addView(adapter.getView(i, null, null));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
