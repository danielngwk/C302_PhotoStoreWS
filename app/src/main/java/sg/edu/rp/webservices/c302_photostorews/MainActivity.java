package sg.edu.rp.webservices.c302_photostorews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvCategories;
    ArrayList<Category> alCategories = new ArrayList<Category>();
    ArrayAdapter<String> aaCategories;
    CustomAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();


        lvCategories = (ListView) findViewById(R.id.listViewCategories);
        aa = new CustomAdapter(this, R.layout.row, alCategories);
        lvCategories.setAdapter(aa);
//        aaCategories = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alCategories);
//        lvCategories.setAdapter(aaCategories);

        // Code for step 1 start
        HttpRequest request = new HttpRequest
                ("http://10.0.2.2/C302_P06_PhotoStoreWS/getCategories.php");
        request.setOnHttpResponseListener(mHttpResponseListener);
        request.setMethod("GET");
        request.execute();
        // Code for step 1 end
        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Category current = alCategories.get(position);
                Intent i = new Intent(MainActivity.this, Activity2.class);
                Integer currid = current.getCategory_id();
                i.putExtra("current",currid.toString());
                startActivity(i);
            }
        });
    }

    // Code for step 2 start
    private HttpRequest.OnHttpResponseListener mHttpResponseListener =
            new HttpRequest.OnHttpResponseListener() {
                @Override
                public void onResponse(String response) {

                    // process response here
                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObj = jsonArray.getJSONObject(i);

                            int categoryId = jsonObj.getInt("category_id");
                            String categoryName = jsonObj.getString("name");
                            String description = jsonObj.getString("description");
                            Category current = new Category(categoryId, categoryName, description);
                            alCategories.add(current);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    aa.notifyDataSetChanged();
                }
            };
    // Code for step 2 end

}

