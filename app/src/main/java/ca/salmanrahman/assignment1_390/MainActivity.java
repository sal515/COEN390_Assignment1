package ca.salmanrahman.assignment1_390;

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // attributes of the mainActivity class is initialized with the id of respective buttons or
        // textview from layout

        switch2gradeActivityButton = findViewById(R.id.switch2gradeActivity_button);
        descriptionTextmainActivity = findViewById(R.id.descriptionText_mainActivity);



        // Generic code to implement a button
        switch2gradeActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Button logic written here
                descriptionTextmainActivity.setText(R.string.descriptionText_mainActivity);

            }
        });

    }


}
