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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        // ArrayList of Course objects
        courses = generateCourses(5);

        linkAdapterToListView(courses);

    }

    private void linkAdapterToListView(ArrayList<Course> courses) {

        // New object of Custom Array Adapter is created, it converts the array to views
        CustomAdapterGradeActivity adapterGradeActivity = new CustomAdapterGradeActivity(
                this, courses );
        // Connect the adapter to the ListView
        ListView listView = findViewById(R.id.listViewIDGA);
        listView.setAdapter(adapterGradeActivity);


    }

    // To generate courseTitle
    private ArrayList<Course> generateCourses(int numberCourses) {
        ArrayList<Course> courses = new ArrayList<Course>(5);
        for (int i = 1; i < numberCourses; i++) {
            courses.add(Course.generateRandomCourse());
        }
        return courses;
    }








//    private void testerFunc(ArrayList<Course> courses){
//        for(int i =0; i < courses.size(); i++){
//            Toast.makeText(GradeActivity.this, courses.get(i).getCourseTitle(), Toast.LENGTH_SHORT).show();
//        }
//    }


//
//    // To generate courseTitle
//    private void generateCourses(ArrayList courses) {
//        for (int i = 0; i < 5; i++) {
//            courses.add(Course.generateRandomCourse());
//        }
//    }



        // methods for action bar
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
                    return true;

                case R.id.letterGradeCheckbox:

                    if (item.isChecked()) {
                        item.setChecked(false);
                        // just to text how chkbx is working
                        Toast.makeText(this, "Unchecked", Toast.LENGTH_LONG).show();

                    } else {
                        item.setChecked(true);
                        // just to text how chkbx is working
                        Toast.makeText(this, "Checked", Toast.LENGTH_LONG).show();
                    }

                    return true;
            }
            return super.onOptionsItemSelected(item);
        }


    }