package com.example.arttower.fragment.CoursePage.view.tabfragmetn;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.R;


public class SearchActivity extends AppCompatActivity {
    /**
     * 删除历史记录
     */
    private TextView mTvDeleteAll;
    private RecyclerView mMRecyclerView;
    private EditText mSearchView;

    private RecyclerView mRecyclerView;
    private RecyclerView mRenmenRecycler;
  //  private SeachRecordAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
    }


    private void initView() {

        mSearchView = (EditText) findViewById(R.id.mSearchView);
        mTvDeleteAll = (TextView) findViewById(R.id.tv_deleteAll);
        mMRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        mRenmenRecycler = (RecyclerView) findViewById(R.id.remen_Recycler);


   /*     mDbDao = new DbDao(this);
        mTvDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDbDao.deleteData();
                //mAdapter.updata(mDbDao.queryData(""));
            }
        });*/
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mAdapter = new SeachRecordAdapter(mDbDao.queryData(""), this);
      /*  mAdapter.setRvItemOnclickListener(new BaseRecycleAdapter.RvItemOnclickListener() {
            @Override
            public void RvItemOnclick(int position) {
                mDbDao.delete(mDbDao.queryData("").get(position));

                mAdapter.updata(mDbDao.queryData(""));
            }
        });*/

       // mRecyclerView.setAdapter(mAdapter);
        //监听事件

           mSearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*
                if (mSearchView.getText().toString().trim().length() != 0){
                    boolean hasData = mDbDao.hasData(mSearchView.getText().toString().trim());
                    if (!hasData){
                        mDbDao.insertData(mSearchView.getText().toString().trim());
                    }else {
                        Toast.makeText(SearchActivity.this, "该内容已在历史记录中", Toast.LENGTH_SHORT).show();
                    }

                    //
                 //   mAdapter.updata(mDbDao.queryData(""));

                }else {
                    Toast.makeText(SearchActivity.this, "请输入内容", Toast.LENGTH_SHORT).show();
                }*/

            }
        });

        //历史搜索管理器
        mMRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //热门搜索布局管理器
        mRenmenRecycler.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            /*隐藏软键盘*/
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(SearchActivity.this.getCurrentFocus().getWindowToken(), 0);
            }
           // mDbDao.insertData(mSearchView.getText().toString().trim());
            WebView webView = new WebView(this);
            webView.loadUrl("url");


            return true;
        }
        return super.dispatchKeyEvent(event);
    }
}