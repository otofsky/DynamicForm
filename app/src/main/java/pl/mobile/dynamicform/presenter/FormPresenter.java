package pl.mobile.dynamicform.presenter;

import java.util.HashMap;
import java.util.Map;

import pl.mobile.dynamicform.MainMvpView;
import pl.mobile.dynamicform.base.BasePresenter;
import pl.mobile.dynamicform.model.FieldWrapper;

/**
 * Created by zjuroszek on 16.08.16.
 */
public class FormPresenter extends BasePresenter<MainMvpView> {


    private Map<String, String> additionalData = new HashMap<>();


    public boolean validateFields(FieldWrapper fieldWrapper) {
        switch (fieldWrapper.parseInputType()) {
            case TEXT:
                //validateField(fieldWrapper);
                break;
            case SELECT:
                //validateField(fieldWrapper);
                break;
            case CHECK:
               // validateField(fieldWrapper);
                break;
            case EMAIL:
                //validateField(fieldWrapper);
                break;
        }
        return false;
    }

    private void validateField(FieldWrapper fieldWrapper) {
        if (fieldWrapper.getUserInput() == null || fieldWrapper.getUserInput().equalsIgnoreCase("")) {
            getMvpView().showErrorText();
        } else {
            setUserData(fieldWrapper);
        }
    }

    private void setUserData(FieldWrapper fieldWrapper) {
        additionalData.put(fieldWrapper.getName(), fieldWrapper.getUserInput());
    }
}
