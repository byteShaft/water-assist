package com.byteshaft.waterassist.drainassist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.byteshaft.waterassist.R;

/**
 * Created by husnain on 5/7/16.
 */
public class MaintenanceActivity extends Activity {

    private Button submit_button;
    private EditText scale_removal_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maintenance_activity);

        submit_button = (Button) findViewById(R.id.submit);
        scale_removal_details = (EditText) findViewById(R.id.scale_removal_et);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String detail_values_scale_removal = scale_removal_details.getText().toString();
                System.out.println(detail_values_scale_removal);

            }
        });
    }
}
