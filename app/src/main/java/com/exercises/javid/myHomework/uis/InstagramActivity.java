package com.exercises.javid.myHomework.uis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.exercises.javid.myHomework.R;

public class InstagramActivity extends AppCompatActivity {

    String[] numbers = new String[30];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);

        this.setTitle(R.string.instagram);

        ArrayAdapter adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.numbers));

        ListView listView = (ListView) findViewById(R.id.lv_insta);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemString = parent.getAdapter().getItem(position).toString();
                Toast.makeText(getApplicationContext(), itemString, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onClickMenuItem(View view) {
        String[] menu_items = getResources().getStringArray(R.array.menu_items);
        int id = view.getId();

        switch (id) {
            case R.id.img_insta_home:
                id = 0;
                break;
            case R.id.img_insta_search:
                id = 1;
                break;
            case R.id.img_insta_cam:
                id = 2;
                break;
            case R.id.img_insta_favorite:
                id = 3;
                break;
            case R.id.img_insta_person:
                id = 4;
                break;
            default:
                id = 0;
        }

        Toast.makeText(getApplicationContext(), menu_items[id], Toast.LENGTH_SHORT).show();
    }
}
