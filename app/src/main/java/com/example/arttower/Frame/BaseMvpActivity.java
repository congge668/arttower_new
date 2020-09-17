package com.example.arttower.Frame;

import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.jaeger.library.StatusBarUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by l on 2019/4/1.
 */
public abstract class BaseMvpActivity<M> extends BaseActivity implements ICommonView {

    private Unbinder mBind;
    public CommonPresenter mPresenter;
    public M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        mBind = ButterKnife.bind(this);
        mPresenter = getPresenter();
        mModel = getModel();
        if (mPresenter != null) mPresenter.attach(this, (ICommonModel) mModel);
        initView();
        initData();
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();

    public CommonPresenter getPresenter(){
        return new CommonPresenter();
    }

    public abstract M getModel();

    @Override
    protected void onDestroy() {
        if (mBind != null) {
            mBind.unbind();
        }
        if (mPresenter!= null) {
            mPresenter.detach();
        }
        super.onDestroy();

    }
    protected void setStatusBar() {
        //这里做了两件事情，1.使状态栏透明并使contentView填充到状态栏 2.预留出状态栏的位置，防止界面上的控件离顶部靠的太近。这样就可以实现开头说的第二种情况的沉浸式状态栏了
        StatusBarUtil.setTransparent(this);
    }
    public void netErrorToast(Throwable e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
