package pl.mobile.dynamicform;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class GenericCustomListAdapter<T> extends ArrayAdapter<T> {

    private ListItemInflater<T>	listItemInflater;
    protected Context context;

    public static final int POSITION_FLAG_BETWEEN = 0;
    public static final int POSITION_FLAG_FIRST = 1;
    public static final int POSITION_FLAG_LAST = 2;
    public static final int POSITION_FLAG_BOTH = POSITION_FLAG_FIRST + POSITION_FLAG_LAST;


    public GenericCustomListAdapter(ListItemInflater<T> listItemInflater, Context context) {
        super(context, 0);
        this.context = context;
        this.listItemInflater = listItemInflater;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int positionFlag = 0;
        if(position==0) {
            positionFlag+=POSITION_FLAG_FIRST;
        }
        if(position+1==getCount()) {
            positionFlag+=POSITION_FLAG_LAST;
        }
        return listItemInflater.getView(getItem(position), convertView, positionFlag);
    }





    public static interface ListItemInflater<T> {

        public View getView(T item, View convertView, int positionFlag);
    }



}