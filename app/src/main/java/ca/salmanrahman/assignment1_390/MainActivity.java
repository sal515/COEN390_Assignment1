package ca.salmanrahman.assignment1_390;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // ============================================================================================
    //                      Declaration of Member variables / Attributes
    // ============================================================================================

    // attribute for a button is created
    private Button switch2gradeActivityButton;
    private TextView descriptionTextmainActivity;

    // ============================================================================================
    //                      Definition of Methods
    // ============================================================================================


    // onCreate method for the activity (falls within the life cycle of an activity)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // chaining upwards to superclass, so that Android Activity Initialization can be done
        super.onCreate(savedInstanceState);
        // Letting android know what will be the layout of the interface for this activity
        setContentView(R.layout.activity_main);

        // attributes are initialized with the id of respective buttons or textview from layout
       // NOTE: Android Studio < V3 requires the findViewByID to be casted accordingly
        switch2gradeActivityButton = findViewById(R.id.switch2gradeActivity_button);
        descriptionTextmainActivity = findViewById(R.id.descriptionText_mainActivity);


        // Generic code to implement a button
        switch2gradeActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Button logic written here
                 descriptionTextmainActivity.setText(R.string.view_grades);
                go_to_gradeActivity();

            }
        });

    }


    private void go_to_gradeActivity() {
        // This intent object allows to link activity1 to activity2
        // Intent intent = new Intent(MainActivity.this, second_activity.class);
        Intent intent = new Intent(this, gradeActivity.class);

        // The Following sends a string from this activity to another as mentioned above
//        intent.putExtra(secret_message, "This is from MainActivity");

        startActivity(intent);
    }


}
