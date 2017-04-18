package com.nku.healthhelper.setting;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVUser;
import com.nku.healthhelper.entity.Users;

import android.app.Application;

public class MyLeanCloudApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        
        AVUser.alwaysUseSubUserClass(Users.class);

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"e4vidVv6CrhVYOqJCjQfmXLE-gzGzoHsz","9f9e92teQRjg4sxpx6OjvPRp");
        // 启用北美节点
//        AVOSCloud.setDebugLogEnabled(true);
    }
}

