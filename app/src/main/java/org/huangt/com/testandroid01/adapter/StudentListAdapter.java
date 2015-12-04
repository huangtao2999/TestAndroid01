package org.huangt.com.testandroid01.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.huangt.com.testandroid01.R;
import org.huangt.com.testandroid01.bean.Student;

import java.util.List;
public class StudentListAdapter  extends BaseAdapter{
    private List<Student> students;
    private LayoutInflater mInflater;
    private Context context;

    public StudentListAdapter(Context context,List<Student> students)
    {
        this.context = context;
        this.students = students;
        this.mInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public List<Student> getStudents()
    {
        return students;
    }
    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    @Override
    public int getCount()
    {
        return students.size();
    }

    @Override
    public Object getItem(int i)
    {
        return students.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        ViewHolder viewHolder;
        if(view == null)
        {
            viewHolder = new ViewHolder();
            view = this.mInflater.inflate(R.layout.item_student,null);
            viewHolder.tv_name = (TextView) view.findViewById(R.id.tv_name);
            viewHolder.tv_address = (TextView) view.findViewById(R.id.tv_address);
            viewHolder.tv_schoolName = (TextView) view.findViewById(R.id.tv_schoolName);
            viewHolder.tv_date = (TextView) view.findViewById(R.id.tv_date);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }
        Student student = students.get(i);
        viewHolder.tv_name.setText(student.getName());
        viewHolder.tv_address.setText(student.getAddress());
        viewHolder.tv_schoolName.setText(student.getSchoolName());
        viewHolder.tv_date.setText(student.getCreatedAt());
        return view;
    }
    static class ViewHolder{
        TextView tv_name;
        TextView tv_address;
        TextView tv_schoolName;
        TextView tv_date;

    }
}
