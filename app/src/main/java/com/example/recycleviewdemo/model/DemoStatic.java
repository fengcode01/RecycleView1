package com.example.recycleviewdemo.model;

import android.util.Log;

public class DemoStatic {

    String data;
    public String getData() {
        return data;
    }


    public static class Worker {
        public void job() {
            Log.d("tag_static", "just a test");
        }
    }

}
