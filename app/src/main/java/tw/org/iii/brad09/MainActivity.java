package tw.org.iii.brad09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private SimpleAdapter adapter;
    private LinkedList<HashMap<String,String>> data;
    private String[] from = {"brad1","brad2"};
    private int[] to = {R.id.item_title, R.id.item_content};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


    }


}
