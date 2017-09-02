package roc.cjm.slidedelete;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import roc.cjm.slidedelete.utils.Util;
import roc.cjm.slidedelete.views.SlideListView2;
import roc.cjm.slidedelete.views.SlideView2;


/**
 * Created by Administrator on 2017/9/1.
 */

public class TestActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private String TAG = "TestActivity";

    private List<String> listContent;
    private SlideListView2 listView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        listContent = new ArrayList<>();
        Random random = new Random();
        for (int i=0;i<100;i++) {
            listContent.add((random.nextInt()*100)+"");
        }

        listView = (SlideListView2) findViewById(R.id.listview);
        myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e(TAG , "onItemClick");
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return listContent.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                SlideView2 slideView = (SlideView2) LayoutInflater.from(TestActivity.this).inflate(R.layout.item_slideview, null);
                TextView cView = (TextView) LayoutInflater.from(TestActivity.this).inflate(R.layout.item_merge, null);
                slideView.setContentView(cView);
                View mergeView = LayoutInflater.from(TestActivity.this).inflate(R.layout.slide_view_merge, null);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(Util.dp2px(TestActivity.this,100), Util.dp2px(TestActivity.this,50));
                mergeView.setLayoutParams(params);
                slideView.setMergeView(mergeView);
                convertView = slideView;
            }

            SlideView2 slideView = (SlideView2) convertView;
            TextView tv = (TextView) slideView.getContentView();
            tv.setText(listContent.get(position));
            slideView.getMergeView().findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e(TAG, "onclick delete");
                }
            });

            slideView.getMergeView().findViewById(R.id.modify).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e(TAG, "onclick modify");
                }
            });

            return convertView;
        }
    }


}
