package com.example.arttower.Frame;

/**
 * Created by l on 2019/3/29.
 */
public interface ICommonModel<T> {
    void getData(ICommonView view, int whichApi, T... t);
}
