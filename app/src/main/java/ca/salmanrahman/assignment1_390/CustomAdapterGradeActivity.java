package ca.salmanrahman.assignment1_390;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;


// This is the customized ArrayAdapter class for the ListView found in the GradeActivity
public class CustomAdapterGradeActivity extends ArrayAdapter<Course> {

    boolean letterGrade;

    public CustomAdapterGradeActivity(Context context, ArrayList<Course> courses, boolean letterGradeParam) {
        super(context, 0, courses);
        letterGrade = letterGradeParam;
    }

    // Reference : Creating custom array adapter -->  https://bit.ly/2qtVNYW
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

        DecimalFormat df = new DecimalFormat("###.##");
        // Populate the data into the template view using the data object
        courseTitle.setText(course.getCourseTitle());
        if (Double.isNaN(Double.parseDouble(df.format(averageGrade(course))))) {
            courseAverage.setText("--");

        } else {
            if (!letterGrade) {
                courseAverage.setText("Average: " + Double.toString(Double.parseDouble(df.format(averageGrade(course)))));
            } else {
                int averageGradeInt= (int) averageGrade(course);
                courseAverage.setText("Average: " + conversionRangesForLetterGrades(averageGradeInt));
            }
        }

        // Getting reference to the Relative Layout
        RelativeLayout relativeLayout = convertView.findViewById(R.id.customRowsGA);

        int numberOfAssignments = course.getAssignments().size();
        // Generates the dyanmic TextVeiw for the Assignments
        addAssignmentTextViewsToLayout(course, relativeLayout, position,numberOfAssignments);


        // TEST Code :: DYNAMIC SINGLE TEXTVIEW :
        //        TextView textView = new TextView(getContext());
        //        generateSingleTextView(relativeLayout, textView);
        //        textView.setText(Integer.toString(position));

        // return the completed view to render on screen
        return convertView;
    }

    // Calculates the average of the assignments
    public double averageGrade(Course course) {
        double average = 0;
        double numberOfAssignments = course.getAssignments().size();
        for (int i = 0; i < course.getAssignments().size(); i++) {
            average = (average + course.getAssignments().get(i).getAssignmentGrade());
        }
        return (average/numberOfAssignments);
    }


    // --------------------------------------------------------------------------------------------
                // These Following functions together generate the Dynamic TextView Objects
                // in the GradeActivity page ListView object
    // --------------------------------------------------------------------------------------------
    public void addAssignmentTextViewsToLayout(Course course, RelativeLayout relativeLayout, int position, int numberOfAssignments){
        // there is a bug with the layout
        int i = 0;
        //        if(position == 0) numberOfAssignments = 1;
        for ( ; i < numberOfAssignments; i++) {
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
            firstTextViewInRow(textViewLayout, textView);
        } else {
            otherTextViewInRow(textViewLayout, id);
        }

        //textViewLayout.addRule(RelativeLayout.BELOW, R.id.courseTitleIDGA);

        int allPadding = 2;
        textView.setPadding(dpToPx(allPadding), dpToPx(allPadding), dpToPx(allPadding), dpToPx(allPadding));
        textView.setLayoutParams(textViewLayout);

        String text;
        if (!letterGrade) {
            // setting textView text
            text = course.getAssignments().get(index).getAssignmentTitle() + "                         " +
                    Integer.toString(course.getAssignments().get(index).getAssignmentGrade());
        } else {

            // setting textView text
            text = course.getAssignments().get(index).getAssignmentTitle() + "                         " +
                    conversionRangesForLetterGrades(course.getAssignments().get(index).getAssignmentGrade());

        }
//        // setting textView text
//        String text = course.getAssignments().get(index).getAssignmentTitle() + "        " +
//                Integer.toString(course.getAssignments().get(index).getAssignmentGrade());

        textView.setText(text);
        return textView;
    }

    public void firstTextViewInRow(RelativeLayout.LayoutParams textViewLayout, TextView textView) {
        textViewLayout.addRule(RelativeLayout.BELOW, R.id.courseTitleIDGA);
//        textView.setTranslationY(dpToPx(10));

    }
    public void otherTextViewInRow(RelativeLayout.LayoutParams textViewLayout, int id) {
        int prevID = (id - 1);
        textViewLayout.addRule(RelativeLayout.BELOW, prevID);
    }

    public static String generateID(int position, int index) {
        String newID = Integer.toString(position) + Integer.toString(index);
        return newID;
    }


    // --------------------------------------------------------------------------------------------
    // These functions above together generate the Dynamic TextView Objects
    // in the GradeActivity page ListView object
    // --------------------------------------------------------------------------------------------

    // Test Purpose Function
    public void generateSingleTextView(RelativeLayout relativeLayout, TextView textView) {

        int allPadding = 10;

        RelativeLayout.LayoutParams textViewLayout = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textViewLayout.addRule(RelativeLayout.BELOW, R.id.courseTitleIDGA);
        textView.setPadding(dpToPx(allPadding), dpToPx(allPadding), dpToPx(allPadding), dpToPx(allPadding));
        textView.setLayoutParams(textViewLayout);
        // The following adds the textView to the Layout
        relativeLayout.addView(textView);
    }


    // The following are the helper functions

    // https://bit.ly/2DsU7q3
    public int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    // https://bit.ly/2DsU7q3
    public int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    // Converts an integer grade from 1 to 100 into a letter grade
    public String conversionRangesForLetterGrades(int grade)
    {
        if(90 <= grade && grade <= 100) {
            return "A+";
        }
        else if (85 <= grade && grade <= 89) {
            return "A";
        }
        else if (80 <= grade && grade <= 84) {
            return "A-";
        }
        else if(77 <= grade && grade <= 79) {
            return "B+";
        }
        else if(73 <= grade && grade <= 76) {
            return "B";
        }
        else if(70 <= grade && grade <= 72) {
            return "B-";
        }
        else if(67 <= grade && grade <= 69) {
            return "C+";
        }
        else if(63 <= grade && grade <= 66) {
            return "C";
        }
        else if(60 <= grade && grade <= 62) {
            return "C-";
        }
        else if(57 <= grade && grade <= 59) {
            return "D+";
        }
        else if(53 <= grade && grade <= 56) {
            return "D";
        }
        else if(50 <= grade && grade <= 52) {
            return "D-";
        }
        else{ return "F";}
    }



}

