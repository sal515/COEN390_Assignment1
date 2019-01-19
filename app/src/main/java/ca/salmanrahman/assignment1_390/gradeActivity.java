package ca.salmanrahman.assignment1_390;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

public class gradeActivity extends AppCompatActivity {

    private TextView testActionBackChbx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        testActionBackChbx = findViewById(R.id.testShowLetterGrade);

//        getActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("Fuck this");

    }

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
                    testActionBackChbx.setText("Unchecked");

                } else {
                    item.setChecked(true);
                    // just to text how chkbx is working
                    testActionBackChbx.setText("Checked");
                }

                return true;
        }
        return super.onOptionsItemSelected(item);
    }



//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch(item.getItemId()) {
//            case R.id.add:
//                addWord();
//
//                return(true);
//
//            case R.id.reset:
//                initAdapter();
//
//                return(true);
//
//            case R.id.about:
//                Toast.makeText(this, R.string.about_toast, Toast.LENGTH_LONG)
//                        .show();
//
//                return(true);
//        }
//
//        return(super.onOptionsItemSelected(item));
//    }


}