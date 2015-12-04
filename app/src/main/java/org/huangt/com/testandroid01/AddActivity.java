package org.huangt.com.testandroid01;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import org.huangt.com.testandroid01.bean.Student;
import org.huangt.com.testandroid01.util.ToastUtil;

import cn.bmob.v3.listener.SaveListener;


public class AddActivity extends BaseActivity {
    private EditText et_name;
    private EditText et_address;
    private EditText et_schoolName;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        setTittle(R.string.add_title);
        setLeft(R.drawable.back, new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
        setRight(R.drawable.save, new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                save();
            }
        });
        initView();
    }
    @Override
    protected void initView()
    {
        super.initView();
        et_name = (EditText) this.findViewById(R.id.et_name);
        et_address = (EditText) this.findViewById(R.id.et_address);
        et_schoolName = (EditText) this.findViewById(R.id.et_school);
    }
    private void save()
    {
        Student student = new Student();
        String name = et_name.getText().toString().trim();
        String address = et_address.getText().toString().trim();
        String schoolName = et_schoolName.getText().toString().trim();
        if(velidate(name,address,schoolName))
        {
            student.setName(name);
            student.setAddress(address);
            student.setSchoolName(schoolName);
            student.save(AddActivity.this, new SaveListener() {
                @Override
                public void onSuccess()
                {
                    ToastUtil.showMsg(AddActivity.this,"添加成功");
                    finish();
                }
                @Override
                public void onFailure(int i, String s)
                {
                    ToastUtil.showMsg(AddActivity.this,"添加失败:"+s);
                }
            });
        }
    }
    private boolean velidate(String name,String address,String schoolName)
    {
        if(TextUtils.isEmpty(name))
        {
            ToastUtil.showMsg(this,"姓名不能为空");
            return false;
        }
        if(TextUtils.isEmpty(address))
        {
            ToastUtil.showMsg(this, "地址不能为空");
            return false;
        }
        if(TextUtils.isEmpty(schoolName))
        {
            ToastUtil.showMsg(this, "学校不能为空");
            return false;
        }
        return true;
    }
}
