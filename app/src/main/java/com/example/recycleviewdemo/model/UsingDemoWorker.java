package com.example.recycleviewdemo.model;

public class UsingDemoWorker {

    public void runTask() {
        // 使用 DemoStatic 裡面的 Worker 類別建立一個物件
        DemoStatic.Worker worker = new DemoStatic.Worker();
        worker.job();
    }

}
