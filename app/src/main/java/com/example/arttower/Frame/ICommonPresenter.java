package com.example.arttower.Frame;

/**
 * Created by l on 2019/3/29.
 */
public interface ICommonPresenter<T> {
    void getData(int whichApi, T... t);
}
