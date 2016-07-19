package oyf.com.lvdeldm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mLv;

    private List<String> mData = new ArrayList<>(Arrays.asList("初学者","绅士","我好像在哪见过你",
            "你还要我怎样","刚刚好","勇敢一点","认真的雪","丑八怪","演员"));
    private ArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initEvent();
    }

    /**
     * Event
     */
    private void initEvent() {
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mAdapter.remove(mData.get(position));

                Toast.makeText(MainActivity.this, "Delete Item "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Data
     */
    private void initData() {
        mAdapter = new ArrayAdapter(MainActivity.this,
                R.layout.support_simple_spinner_dropdown_item,
                mData);
        mLv.setAdapter(mAdapter);

    }

    /**
     * View
     */
    private void initView() {
        mLv = (ListView) findViewById(R.id.lv_lv);
    }
}
