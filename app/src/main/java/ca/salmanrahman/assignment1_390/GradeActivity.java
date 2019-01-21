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

    private GradeActivityCustomAdapter coursesAdapter;
    private ListView coursesListView;

    ArrayList<Course> courses;

//    private TextView testActionBackChbx;
//
//    ArrayList<String> coursesTitles = new ArrayList<String>(5);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);




//        testActionBackChbx = findViewById(R.id.testShowLetterGrade);




//        generateCourses(courses);
//        testerFunc(courses);
//        prepareListView();

    }

    private void prepareListView(){
        coursesAdapter = new GradeActivityCustomAdapter(this, courses, 5);
        coursesListView.setAdapter(coursesAdapter);








        //        ArrayAdapter coursesAdapter = new ArrayAdapter<>(this,
//                R.layout.custom_row_grade_activity_list_view, courses);
//
//        ListView listView = findViewById(R.id.gradeActivityListView);
//        listView.setAdapter(coursesAdapter);
//
//
//        // setting the onClick listener for the listview
//        listView.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        String mobilearray = String.valueOf(parent.getItemAtPosition(position));
//                        Toast.makeText(GradeActivity.this, mobilearray, Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );

    }


//    private void testerFunc(ArrayList<Course> courses){
//        for(int i =0; i < courses.size(); i++){
//            Toast.makeText(GradeActivity.this, courses.get(i).getCourseTitle(), Toast.LENGTH_SHORT).show();
//        }

//    }

    // Extract Course Names
//    private void extractCourseNames(ArrayList courses,ArrayList coursesTitles) {
//        while
//        for(int i = 0; i < ; i++){
//            ;
//        }
//    }
//
//    // To generate courseTitle
//    private void generateCourses(ArrayList courses) {
//        for (int i = 0; i < 5; i++) {
//            courses.add(Course.generateRandomCourse());
//        }
//    }
//
//
//



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