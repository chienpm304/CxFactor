package com.android.chienfx.core.helper;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Toast;

public class MyHelper {
    public static void toast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static  boolean hasSMSPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }


    public static String trimString(String string, int length) {
        if(string.length() >= length)
            return string.substring(0, length-1) + "...";
        return string;
    }


    public static String getTimeString(int t){
        int h = t/60;

        String sH = String.valueOf(h);
        if(h<10) sH = "0"+sH;

        int m = t%60;
        String sM = String.valueOf(m);
        if(m<10) sM = "0"+sM;

        return sH + ":" + sM;
    }
}
