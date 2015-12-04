package org.huangt.com.testandroid01;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import org.huangt.com.testandroid01.adapter.StudentListAdapter;
import org.huangt.com.testandroid01.bean.Student;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;


public class MainActivity extends BaseActivity{
    private final static String appKey = "ab6736f32350a8dd77c1a3012acffa22";
    private ListView lv_students;
    private StudentListAdapter mAdapter;
    private List<Student> students = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, appKey);//bmob初始化
        setTittle(R.string.main_title);
        setRight(R.drawable.add, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startOtherActivity(AddActivity.class, null);
            }
        });
        initView();
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        initData();
    }
    private void initData()
    {
        BmobQuery<Student> query = new BmobQuery<Student>();
        query.findObjects(MainActivity.this, new FindListener<Student>() {
            @Override
            public void onSuccess(List<Student> list)
            {
                students = list;
                mAdapter.setStudents(students);
                mAdapter.notifyDataSetChanged();
            }
            @Override
            public void onError(int i, String s)
            {

            }
        });
    }
    @Override
    protected void initView()
    {
        super.initView();
        mAdapter = new StudentListAdapter(MainActivity.this,students);
        lv_students = (ListView) this.findViewById(R.id.lv_students);
        lv_students.setAdapter(mAdapter);
    }
}
