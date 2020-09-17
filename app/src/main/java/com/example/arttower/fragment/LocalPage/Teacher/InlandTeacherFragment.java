package com.example.arttower.fragment.LocalPage.Teacher;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.Frame.BaseRvAdapter;
import com.example.arttower.R;
import com.example.arttower.adapter.ImageAdapter;
import com.example.arttower.adapter.inlandAdapter;
import com.example.arttower.fragment.LocalPage.bean.InlandBanner;
import com.example.arttower.fragment.LocalPage.bean.InlandTeacherBean;
import com.example.arttower.fragment.LocalPage.model.InlandTeacherModel;
import com.example.arttower.fragment.LocalPage.view.TeacherDataActivity;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class InlandTeacherFragment extends BaseMvpFragment<InlandTeacherModel> {

    @BindView(R.id.inland_banner)
    Banner Banner;
    @BindView(R.id.l_local)
    LinearLayout local;
    @BindView(R.id.img_shaixuan)
    ImageView imgShaixuan;
    @BindView(R.id.img_paixu)
    ImageView imagepaixu;
    @BindView(R.id.img_fujin)
    ImageView imgFujin;
    @BindView(R.id.img_renqi)
    ImageView imgRenqi;

    @BindView(R.id.inland_rlv)
    RecyclerView inlandrlv;


    private int offset = 1;
    private int rows = 10;

    private ArrayList<InlandTeacherBean.DataBean> list;
    private com.example.arttower.adapter.inlandAdapter inlandAdapter;
    private Intent intent;
    private ArrayList<InlandBanner.DataBean> dataBeans;
    private ImageAdapter imageAdapter;
    private int hou;
    private int qian;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_inland_teacher;
    }

    @Override
    public void initView() {
        hou = R.mipmap.select_kuang;
        qian = R.mipmap.unselect_kuang;


    }

    @Override
    public void initData() {
        /*
         * 国内教师Banner数据
         * */
        // mPresenter.getData(ApiConfig.THEACHERBANNER);
        //集合
       /* dataBeans = new ArrayList<>();
        imageAdapter = new ImageAdapter(getContext(),dataBeans);
        Banner.setAdapter(imageAdapter);
        Banner.setIndicator(new CircleIndicator(getActivity()));
        Banner.setIndicatorGravity(IndicatorConfig.Direction.CENTER);*/
        /*
         * 国内教师Recyclerview
         * 布局管理器
         * */
        mPresenter.getData(ApiConfig.INLANDTEACHER_DATA, offset, rows);
        //数据集合
        list = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        inlandrlv.setLayoutManager(layoutManager);
        //分割线
        inlandrlv.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        //Adapter
        inlandAdapter = new inlandAdapter(getContext(), list);
        inlandrlv.setAdapter(inlandAdapter);

        //点击条目获取事件
        inlandAdapter.setOnItemClickListener(new BaseRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                String uid = list.get(position).getUid();

                intent = new Intent(getContext(), TeacherDataActivity.class);
                intent.putExtra("uid",uid);
                startActivity(intent);

            }
        });


    }


    @OnClick({R.id.img_shaixuan, R.id.img_renqi, R.id.img_fujin, R.id.img_paixu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //筛选
            case R.id.img_shaixuan:
                //弹出popupwindow
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.inland_screening, null);
                PopupWindow popupWindow = new PopupWindow(getContext());
                popupWindow.setContentView(inflate);
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(500);
                //获取焦点
                popupWindow.setFocusable(true);
                //点击弹窗以外的弹窗关闭
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAsDropDown(local);

                break;
            //人气
            case R.id.img_renqi:
                imgFujin.setImageResource(qian);
                imagepaixu.setImageResource(qian);
                imgRenqi.setImageResource(hou);

                break;
            //附近
            case R.id.img_fujin:
                imgFujin.setImageResource(hou);
                imagepaixu.setImageResource(qian);
                imgRenqi.setImageResource(qian);
                break;
            //排序
            case R.id.img_paixu:
                imgFujin.setImageResource(qian);
                imagepaixu.setImageResource(hou);
                imgRenqi.setImageResource(qian);
                break;

        }
    }


    @Override
    public InlandTeacherModel getModel() {
        return new InlandTeacherModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.INLANDTEACHER_DATA:
                Log.e("TAGAAAA", "onError: " + e.getMessage());
                break;
        }


    }

    @Override
    public void onResponse(int whichApi, Object... t) {
        switch (whichApi) {
            case ApiConfig.INLANDTEACHER_DATA:
                InlandTeacherBean inlandTeacherBean = (InlandTeacherBean) t[0];
                List<InlandTeacherBean.DataBean> data = inlandTeacherBean.getData();
                list.addAll(data);
                //刷新适配器
                inlandAdapter.notifyDataSetChanged();
                break;
            case ApiConfig.THEACHERBANNER:
                InlandBanner inlandBanner = (InlandBanner) t[0];
                List<InlandBanner.DataBean> bannerData = inlandBanner.getData();
                dataBeans.addAll(bannerData);
                //刷新适配器
                imageAdapter.notifyDataSetChanged();
                break;

        }

    }

}
