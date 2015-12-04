package org.huangt.com.testandroid01.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by tao on 2015/12/4.
 */
public class ToastUtil {

    public static void showMsg(Context context,String msg)
    {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
