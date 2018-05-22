package sg.edu.rp.webservices.c302_photostorews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Category> {
    private ArrayList<Category> category;
    private Context context;
    private TextView tvName;
    private TextView tvDesc;

    public CustomAdapter(Context context, int resource, ArrayList<Category> objects) {
        super(context, resource, objects);

        category = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowVIew = inflater.inflate(R.layout.row, parent, false);
        tvName = (TextView) rowVIew.findViewById(R.id.textView);
        tvDesc = (TextView) rowVIew.findViewById(R.id.textView2);
        Category current = category.get(position);
        tvName.setText(current.getName());
        tvDesc.setText(current.getDescription());
        return rowVIew;
    }
}
