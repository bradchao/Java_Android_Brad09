package tw.org.iii.brad09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import io.github.codefalling.recyclerviewswipedismiss.SwipeDismissRecyclerViewTouchListener;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<String> dataset = new LinkedList<String>();
        for (int i = 0; i < 100; i++){
            dataset.add("item" + i);
        }

        adapter = new MyAdapter(dataset);
        recyclerView.setAdapter(adapter);

        SwipeDismissRecyclerViewTouchListener listener = new SwipeDismissRecyclerViewTouchListener.Builder(
                recyclerView,
                new SwipeDismissRecyclerViewTouchListener.DismissCallbacks() {
                    @Override
                    public boolean canDismiss(int position) {
                        return true;
                    }

                    @Override
                    public void onDismiss(View view) {
                        int id = recyclerView.getChildPosition(view);
                        adapter.mDataset.remove(id);
                        adapter.notifyDataSetChanged();

                        Toast.makeText(getBaseContext(), String.format("Delete item %d",id),Toast.LENGTH_LONG).show();
                    }
                })
                .setIsVertical(false)
                .setItemTouchCallback(
                        new SwipeDismissRecyclerViewTouchListener.OnItemTouchCallBack() {
                            @Override
                            public void onTouch(int index) {
                                //showDialog(String.format("Click item %d", index));
                            }
                        })
                .create();

        recyclerView.setOnTouchListener(listener);

    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        public List<String> mDataset;

        public MyAdapter(List<String> dataset) {
            super();
            mDataset = dataset;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = View.inflate(viewGroup.getContext(), android.R.layout.simple_list_item_1, null);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.mTextView.setText(mDataset.get(i));
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            public TextView mTextView;
            public ViewHolder(View itemView) {
                super(itemView);
                mTextView = (TextView) itemView;
            }
        }
    }

}
