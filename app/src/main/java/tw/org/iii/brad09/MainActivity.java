package tw.org.iii.brad09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private SimpleAdapter adapter;
    private LinkedList<HashMap<String,String>> data;
    private String[] from = {"brad1","brad2"};
    private int[] to = {R.id.item_title, R.id.item_content};

    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.newdata);
        listView = (ListView)findViewById(R.id.listView);
        initListView();
    }

    private void initListView(){
        data = new LinkedList<>();

        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0], "data 0");
        d0.put(from[1], "cont 0");
        data.add(d0);

        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0], "data 1");
        d1.put(from[1], "cont 1");
        data.add(d1);

        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0], "data 2");
        d2.put(from[1], "cont 2");
        data.add(d2);

        adapter = new SimpleAdapter(this,data,R.layout.listitem,
                from,to);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Click: "+i, Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this, "LongClick: "+i, Toast.LENGTH_SHORT).show();
                removeData(i);
                return true;
            }
        });



    }

    private void removeData(int i){
        data.remove(i);
        adapter.notifyDataSetChanged();
    }

    public void addData(View v){
        String title = input.getText().toString();
        String cont = "OK";

        HashMap<String,String> itemdata = new HashMap<>();
        itemdata.put(from[0], title);
        itemdata.put(from[1], cont);
        data.add(itemdata);

        adapter.notifyDataSetChanged();

    }


}
