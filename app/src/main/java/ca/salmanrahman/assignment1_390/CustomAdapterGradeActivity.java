package ca.salmanrahman.assignment1_390;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterGradeActivity extends ArrayAdapter<Course> {

    public CustomAdapterGradeActivity(Context context, ArrayList<Course> courses) {
        super(context, 0, courses);


    }

    // Using custom array adapter -->  https://bit.ly/2qtVNYW
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // getting data for the position
        Course course = getItem(position);

        // check if an existing view is being reused, otherwise make new row
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.custom_row_grade_activity_list_view, parent, false);
        }

        // Lookup view for data population
        TextView courseTitle = convertView.findViewById(R.id.courseTitleIDGA);
        TextView courseAverage = convertView.findViewById(R.id.courseAverageIDGA);

        // Populate the data into the template view using the data object
        courseTitle.setText(course.getCourseTitle());
        courseAverage.setText("50");

        TextView textView = new TextView(getContext());
        RelativeLayout relativeLayout = convertView.findViewById(R.id.customRowsGA);
        generateAssignmentTextView(relativeLayout, textView);
        // textView.setText(Integer.toString(position));

//        ArrayList<Integer> assignmentArrayListSizes = extractAssignmentArrayListSizes(course,
//                position);

        int assignmentListSize = course.getAssignments().size();

        // testing the values of the assignmentArrayListSizes
         textView.setText(Integer.toString(assignmentListSize));


        // Checking the row position values
        // textView.setText(Integer.toString(position));


        // Checking the assignment ArrayList sizes for each courses
        // textView.setText(Integer.toString(course.getAssignments().size()));

        // return the completed view to render on screen
        return convertView;
    }


    public void generateAssignmentTextView(RelativeLayout relativeLayout, TextView textView) {

        int allPadding = 10;

        RelativeLayout.LayoutParams textViewLayout = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textViewLayout.addRule(RelativeLayout.BELOW, R.id.courseTitleIDGA);
        textView.setPadding(dpToPx(allPadding), dpToPx(allPadding), dpToPx(allPadding), dpToPx(allPadding));
        textView.setLayoutParams(textViewLayout);
        relativeLayout.addView(textView);
    }

    public int generateAssignmentTextView (Course course, int numberOfAssignments){


        return numberOfAssignments;
    }


    // https://bit.ly/2DsU7q3
    public int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    // https://bit.ly/2DsU7q3
    public int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }


}

