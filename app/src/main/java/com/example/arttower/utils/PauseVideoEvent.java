package com.example.arttower.utils;

/**
 * create by libo
 * create on 2020-05-21
 * description 控制播放器的播放和暫停
 */
public class PauseVideoEvent {
    private boolean playOrPause;

    public PauseVideoEvent(boolean playOrPause) {
        this.playOrPause = playOrPause;
    }

    public boolean isPlayOrPause() {
        return playOrPause;
    }
}
