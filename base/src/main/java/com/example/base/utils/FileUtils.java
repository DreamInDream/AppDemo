package com.example.base.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;

import java.io.File;
import java.lang.annotation.Target;

public class FileUtils {
    public static String getAppCacheDir(Context context){
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())||!isExternelStorageRemovable()?getExternalCacheDir(context).getPath():context.getCacheDir().getPath();
    }
    @TargetApi(9)
    public static boolean isExternelStorageRemovable(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.GINGERBREAD){
            return Environment.isExternalStorageRemovable();
        }
        return true;
    }
    @TargetApi(8)
    public static File getExternalCacheDir(Context context) {
        final String cacheDir = "/Android/data/" + context.getPackageName() + "/cache/";
        return new File(Environment.getExternalStorageDirectory().getPath() + cacheDir);
    }
}
