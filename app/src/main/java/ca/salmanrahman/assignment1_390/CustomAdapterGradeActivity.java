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



        // Getting reference to the Relative Layout
        RelativeLayout relativeLayout = convertView.findViewById(R.id.customRowsGA);

        // Dynamic TextView Generated

//        TextView textView = new TextView(getContext());
//        generateAssignmentTextView(relativeLayout, textView);
        // textView.setText(Integer.toString(position));

//        ArrayList<Integer> assignmentArrayListSizes = extractAssignmentArrayListSizes(course,
//                position);

        int numberOfAssignments = course.getAssignments().size();
        addAssignmentTextViewsToLayout(course, relativeLayout, position,
                numberOfAssignments);

        // testing the values of the assignmentArrayListSizes
//        textView.setText(Integer.toString(numberOfAssignments));


        // Checking the row position values
        // textView.setText(Integer.toString(position));


        // Checking the assignment ArrayList sizes for each courses
        // textView.setText(Integer.toString(course.getAssignments().size()));

        // return the completed view to render on screen
        return convertView;
    }


    public void addAssignmentTextViewsToLayout (Course course, RelativeLayout relativeLayout, int position, int numberOfAssignments){

        for (int i = 0; i < numberOfAssignments; i++) {

//            TextView textView = new TextView(getContext());
            TextView textView;
            textView = generateAssignmentTextView(course, relativeLayout, position, i);
            // The following adds the textView to the relative layout
            relativeLayout.addView(textView);
        }
    }

    public TextView generateAssignmentTextView(Course course, RelativeLayout relativeLayout, int position, int index ) {

        // Create new textView objects
        TextView textView = new TextView(getContext());
        // Generating ID for current TextView
        int id = Integer.parseInt(generateID(position, index));
        // set each TextView object with new id
        textView.setId(id);
        // Layout for textView Objects
        RelativeLayout.LayoutParams textViewLayout = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        // Generating First CheckID
        int firstIDInRow = Integer.parseInt(generateID(position, 0));
        // for the first dynamic TextView in row, should be added below the Course Title
        if (id == firstIDInRow) {
            firstTextViewInRow(textViewLayout);
        } else {
            otherTextViewInRow(textViewLayout, id);
        }

        //textViewLayout.addRule(RelativeLayout.BELOW, R.id.courseTitleIDGA);

        int allPadding = 5;
        textView.setPadding(dpToPx(allPadding), dpToPx(allPadding), dpToPx(allPadding), dpToPx(allPadding));
        textView.setLayoutParams(textViewLayout);

        // setting textView text
        String text = course.getAssignments().get(index).getAssignmentTitle() + "        " +
                Integer.toString(course.getAssignments().get(index).getAssignmentGrade());
//        textView.setText();

        textView.setText(text);

//                textView.setText("0011");
        return textView;
    }

    public void firstTextViewInRow(RelativeLayout.LayoutParams textViewLayout) {
        textViewLayout.addRule(RelativeLayout.BELOW, R.id.courseTitleIDGA);
    }
    public void otherTextViewInRow(RelativeLayout.LayoutParams textViewLayout, int id) {
        int prevID = (id - 1);
        textViewLayout.addRule(RelativeLayout.BELOW, prevID);
    }



    public static String generateID(int position, int index) {
        String newID = Integer.toString(position) + Integer.toString(index);
        return newID;
    }



    public void generateSingleTextView(RelativeLayout relativeLayout, TextView textView) {

        int allPadding = 10;

        RelativeLayout.LayoutParams textViewLayout = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textViewLayout.addRule(RelativeLayout.BELOW, R.id.courseTitleIDGA);
        textView.setPadding(dpToPx(allPadding), dpToPx(allPadding), dpToPx(allPadding), dpToPx(allPadding));
        textView.setLayoutParams(textViewLayout);
        // The following adds the textView to the Layout
        relativeLayout.addView(textView);
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

