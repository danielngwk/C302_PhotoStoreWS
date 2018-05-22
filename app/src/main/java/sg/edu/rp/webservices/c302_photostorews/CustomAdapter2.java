package sg.edu.rp.webservices.c302_photostorews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter2 extends ArrayAdapter<photostore> {
    private ArrayList<photostore> photostores;
    private Context context;
    private TextView tvTitle;
    private TextView tvDescp;
    private TextView created;
    private TextView image;

    public CustomAdapter2(Context context, int resource, ArrayList<photostore> objects) {
        super(context, resource, objects);

        photostores = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowVIew = inflater.inflate(R.layout.row_2, parent, false);
        tvTitle = (TextView) rowVIew.findViewById(R.id.textView3);
        tvDescp = (TextView) rowVIew.findViewById(R.id.textView4);
        created = (TextView) rowVIew.findViewById(R.id.textView5);
        image = (TextView) rowVIew.findViewById(R.id.textView6);
        photostore current = photostores.get(position);
        tvTitle.setText(current.getTitle());
        tvDescp.setText(current.getDescription());
        created.setText(current.getCreated());
        image.setText(current.getImage());
        return rowVIew;
    }
}
