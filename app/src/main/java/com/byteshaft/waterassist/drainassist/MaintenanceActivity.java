package com.byteshaft.waterassist.drainassist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.byteshaft.waterassist.Helpers;
import com.byteshaft.waterassist.R;

public class MaintenanceActivity extends Activity {

    private Button submit_button;
    private EditText scale_removal_details;
    private String mEmailSubject = "Scale Removal";
    private String mReceiverEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maintenance_activity);
        overridePendingTransition(R.anim.anim_left_in, R.anim.anim_left_out);
        mReceiverEmail = getString(R.string.email_string);
        submit_button = (Button) findViewById(R.id.submit);
        scale_removal_details = (EditText) findViewById(R.id.maintenance_et);
        scale_removal_details.setSelected(false);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String detail_values_scale_removal = scale_removal_details.getText().toString();
                System.out.println(detail_values_scale_removal);
                String finalMessage = Helpers.getStringFromSharedPreferences("basic") +
                        scale_removal_details.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {mReceiverEmail});
                intent.putExtra(Intent.EXTRA_SUBJECT, mEmailSubject);
                intent.putExtra(Intent.EXTRA_TEXT, finalMessage);
                startActivity(Intent.createChooser(intent, "Send Email"));

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_right_in, R.anim.anim_right_out);
    }
}
