package tw.org.iii.brad09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        initListView();
    }

    private void initListView(){

        adapter = new SimpleAdapter(this,data,R.layout.activity_main,from,to);
        listView.setAdapter();


    }


}
