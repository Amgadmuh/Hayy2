package amgad.com.hayy2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import amgad.com.hayy2.db.DbBackend;


public class MainActivity extends Activity {

    //SearchView searchView;
    private EditText filterText;
    private ArrayAdapter<String> listAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filterText = (EditText)findViewById(R.id.editText);
        final ListView itemList = (ListView)findViewById(R.id.listView);
        final DbBackend dbBackend = new DbBackend(MainActivity.this);
        String[] terms = dbBackend.placesNames();

        // What is simple_list_item_1?
        // http://stackoverflow.com/questions/6079344/what-is-android-r-layout-simple-list-item-1
        // ArrayAdapter(Context context, int resource, int textViewResourceId, T[] objects)
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, terms);

        // to initially clear the list before typing
        MainActivity.this.listAdapter.getFilter().filter("pppppppp");
        itemList.setAdapter(listAdapter);



        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long _id) {

                String itemText = listAdapter.getItem(position);
                int id = dbBackend.getPlace_ID_ByTypeAndName(itemText);

                //Toast.makeText(getApplicationContext(), "item text is  " + itemText, Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), "ID is  " + id, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, PlaceInfoActivity.class);
                intent.putExtra("_id", id);

                startActivity(intent);
            }
        });





        filterText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.this.listAdapter.getFilter().filter(s);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }



    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) { MenuInflater menuInflater = getMenuInflater(); menuInflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_icon:
                onSearchRequested();
                return true;
            default:
                return super.onOptionsItemSelected(item); }
    }
    */
}
