package ca.salmanrahman.assignment1_390;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import android.widget.ArrayAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GradeActivityCustomAdapter extends BaseAdapter {

    private Activity gradeActivity;
    private ArrayList<Course> courses;
    private int numberOfCourses;

    public GradeActivityCustomAdapter(Activity activityName,
                                      ArrayList<Course> courses,
                                      int numberOfCourses) {
        courses = generateCourses(numberOfCourses);

    }

    // All the views of an individual row of the list view
    static class ViewHolder{
        TextView courseTitles;
        TextView assignmentTitles;
        TextView assignmentGrades;
        TextView courseAverageGrades;
        LinearLayout.LayoutParams params;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) gradeActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_row_grade_activity_list_view, parent, false);
            final ViewHolder holder = new ViewHolder();
//            holder.

        } else return convertView;
        return null;
    }


    // To generate courseTitle
    private ArrayList<Course> generateCourses(int numberCourses) {
        ArrayList<Course> courses = new ArrayList<Course>(5);
        for (int i = 1; i < numberCourses; i++) {
            courses.add(Course.generateRandomCourse());
        }
        return courses;
    }



}

