package com.nku.healthhelper.setting;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.nku.healthhelper.entity.*;

import android.app.Application;

public class MyLeanCloudApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        
        AVUser.alwaysUseSubUserClass(Users.class);
//        注册AVObject子类
        AVObject.registerSubclass(Food.class);
        AVObject.registerSubclass(DietRecordDetail.class);
        AVObject.registerSubclass(DietRecord.class);
        AVObject.registerSubclass(Photo.class);
        AVObject.registerSubclass(UploadFood.class);
        AVObject.registerSubclass(FoodRating.class);

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"e4vidVv6CrhVYOqJCjQfmXLE-gzGzoHsz","9f9e92teQRjg4sxpx6OjvPRp");
//        AVOSCloud.setDebugLogEnabled(true);
    }
}

