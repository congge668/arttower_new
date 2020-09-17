package com.example.arttower.Frame;

/**
 * Created by l on 2019/3/29.
 */
public interface ICommonView<T> {
    void onError(int whichApi, Throwable e);
    void onResponse(int whichApi, T... t);
}
