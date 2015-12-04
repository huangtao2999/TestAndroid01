package org.huangt.com.testandroid01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tao on 2015/12/4.
 */
public class BaseActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
    }

    protected void setTittle(String tittle)
    {
        TextView tv_title = (TextView) this.findViewById(R.id.tv_title);
        if(tv_title != null)
        {
            tv_title.setText(tittle);
        }
    }
    protected void setTittle(int resID)
    {
        TextView tv_title = (TextView) this.findViewById(R.id.tv_title);
        if(tv_title != null)
        {
            tv_title.setText(resID);
        }
    }
    protected void initView(){}
    protected void setLeft(int resId,View.OnClickListener listener)
    {
        ImageView btn_left = (ImageView) this.findViewById(R.id.btn_left);
        if(btn_left != null)
        {
            btn_left.setVisibility(View.VISIBLE);
            btn_left.setImageResource(resId);
            btn_left.setOnClickListener(listener);
        }
    }
    protected void setRight(int resId,View.OnClickListener listener)
    {
        ImageView btn_right = (ImageView) this.findViewById(R.id.btn_right);
        if(btn_right != null)
        {
            btn_right.setVisibility(View.VISIBLE);
            btn_right.setImageResource(resId);
            btn_right.setOnClickListener(listener);
        }
    }
    protected void startOtherActivity(Class<?>cls,Intent intent)
    {
        if(intent == null)
        {
            intent = new Intent();
        }
        startActivity(intent.setClass(this,cls));
    }
}
