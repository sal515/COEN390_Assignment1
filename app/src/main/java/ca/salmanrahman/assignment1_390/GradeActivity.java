package ca.salmanrahman.assignment1_390;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class GradeActivity extends AppCompatActivity {


    ArrayList<Course> courses;
    CustomAdapterGradeActivity adapterGradeActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        // ArrayList of Course objects
        courses = generateCourses(5);
        adapterGradeActivity = new CustomAdapterGradeActivity(
                this, courses, false);

        linkAdapterToListView(courses, adapterGradeActivity);


    }

    // This function links the customized Array adapter to the ListView on the GradeActivity Page
    private void linkAdapterToListView(ArrayList<Course> courses, CustomAdapterGradeActivity adapterGradeActivity) {
        // New object of Custom Array Adapter is created, it converts the array to views
//        CustomAdapterGradeActivity adapterGradeActivity = new CustomAdapterGradeActivity(
//                this, courses );
        // Connect the adapter to the ListView

        ListView listView = findViewById(R.id.listViewIDGA);
        listView.setAdapter(adapterGradeActivity);
    }

    // To generate courseObjects with the assignment objects in them
    private ArrayList<Course> generateCourses(int numberCourses) {
        ArrayList<Course> courses = new ArrayList<Course>(5);
        for (int i = 1; i < numberCourses; i++) {
            courses.add(Course.generateRandomCourse());
        }
        return courses;

    }

    // Unused Helper functions
    public static int charToAsciiNum(char ch) {
        int asciiNum = (int) ch;
        return asciiNum;
    }
    public static char asciiNumToChar(int ascii){
        char ch = (char) ascii;
        return ch;
    }


    // methods for action bar to detect selections or clicks
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.gradesacvitity_menu, menu);
        return(super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);

//                    Toast.makeText(this, "Going Back?", Toast.LENGTH_LONG).show();

                // Testing to Destroy Grade Activity on press of back button
//                    finish();
                return true;

            case R.id.letterGradeCheckbox:

                if (item.isChecked()) {
                    item.setChecked(false);
                    adapterGradeActivity = new CustomAdapterGradeActivity(
                            this, courses, false);
                    linkAdapterToListView(courses, adapterGradeActivity);

                    // just to text how chkbx is working
                    Toast.makeText(this, "Unchecked", Toast.LENGTH_SHORT).show();

                } else {
                    item.setChecked(true);

                    adapterGradeActivity = new CustomAdapterGradeActivity(
                            this, courses, true);

                    linkAdapterToListView(courses, adapterGradeActivity);

                    // just to text how chkbx is working
                    Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show();
                }

                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}