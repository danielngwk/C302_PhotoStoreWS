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

public class Activity2 extends AppCompatActivity {

    private ListView lvPhoto;
    ArrayList<photostore> alPhoto = new ArrayList<photostore>();
    ArrayAdapter<String> aaPhoto;
    CustomAdapter2 aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent i = getIntent();
        String current = i.getStringExtra("current");
        lvPhoto = (ListView) findViewById(R.id.lv);
        aa = new CustomAdapter2(this, R.layout.row_2, alPhoto);
        lvPhoto.setAdapter(aa);
//        aaCategories = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alCategories);
//        lvCategories.setAdapter(aaCategories);

        // Code for step 1 start

        HttpRequest request = new HttpRequest
                ("http://10.0.2.2/C302_P06_PhotoStoreWS/getPhotoStoreByCategory.php?category_id="+current);
        request.setOnHttpResponseListener(mHttpResponseListener);
        request.setMethod("GET");
        request.execute();
        // Code for step 1 end
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

                            int photoId = jsonObj.getInt("photo_id");
                            String title = jsonObj.getString("title");
                            String description = jsonObj.getString("description");
                            String image = jsonObj.getString("image");
                            int catId = jsonObj.getInt("category_id");
                            String created = jsonObj.getString("created_by");

                            photostore current = new photostore(photoId, title, description,image,catId,created);
                            alPhoto.add(current);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    aa.notifyDataSetChanged();
                }
            };
    // Code for step 2 end

}

