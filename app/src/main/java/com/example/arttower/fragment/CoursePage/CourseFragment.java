package com.example.arttower.fragment.CoursePage;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.model.HomeModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseFragment extends BaseMvpFragment<HomeModel> {

    static CourseFragment fragment;
    @BindView(R.id.course_guangao)
    ImageView courseGuangao;
    @BindView(R.id.img_kechengku)
    ImageView imgKechengku;
    @BindView(R.id.txt_kck)
    TextView txtKck;
    @BindView(R.id.img_huodongke)
    ImageView imgHuodongke;
    @BindView(R.id.txt_hdk)
    TextView txtHdk;
    @BindView(R.id.img_zhuanyedz)
    ImageView imgZhuanyedz;
    @BindView(R.id.txt_zyd)
    TextView txtZyd;
    @BindView(R.id.img_dashike)
    ImageView imgDashike;
    @BindView(R.id.txt_dsk)
    TextView txtDsk;
    @BindView(R.id.rlv_course)
    RecyclerView rlvCourse;
    private int offset = 1;
    private int rows = 10;


    private List<CourseDataBean.DataBean> list;
    private CourseRlvAdapter courseRlvAdapter;

    public static CourseFragment newInstance() {
        if (fragment == null) fragment = new CourseFragment();
        return fragment;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_course;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        courseRlvAdapter = new CourseRlvAdapter(getContext(), list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rlvCourse.setLayoutManager(linearLayoutManager);
        rlvCourse.setAdapter(courseRlvAdapter);
    }


    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.COURSE_DATA, offset, rows);
    }

    @Override
    public HomeModel getModel() {
        return new HomeModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.COURSE_DATA:
                CourseDataBean courseDataBean = (CourseDataBean) t[0];
                List<CourseDataBean.DataBean> data = courseDataBean.getData();
                list.addAll(data);
                Log.i("课程数据", "onResponse: "+data.toString());
                courseRlvAdapter.notifyDataSetChanged();
                break;
        }
    }
}
