package com.pasistence.mantrafingerprint.Main;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.provider.FontsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.pasistence.mantrafingerprint.FingerPrintMatching.MFS100Mantra;
import com.pasistence.mantrafingerprint.Models.WorkerModel;
import com.pasistence.mantrafingerprint.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class MatchingActivity extends AppCompatActivity {

    private static final String TAG = "atten :" ;
    Context mContext;
    TextView txtProjectName,txtEmployeeId,txtDate,txtTime,txtWorkerName,txtWorkerId,lblMessage;
    ImageView imgfinger;
    CircleImageView CircularImage;
    Button statrMatchingbtn;
    RadioGroup radioGroup;
    RadioButton RInTime,ROutTime,RHalfDay;
    MFS100Mantra mfs100Mantra;
    WorkerModel workerModel;
    ScrollView linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);
        mInit();



        mfs100Mantra = new MFS100Mantra(MatchingActivity.this,imgfinger,CircularImage,txtWorkerName,txtWorkerId,lblMessage);
        mfs100Mantra.onStart();
        mfs100Mantra.setRadioCheck("checkIn");

        statrMatchingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    mfs100Mantra.startMatching();

            }
        });
    }

    private void mInit() {
        mContext = MatchingActivity.this;
        txtProjectName              = (TextView) findViewById(R.id.txt_ProjectName);
        txtEmployeeId               = (TextView)findViewById(R.id.txt_matching_EmpId);
        txtDate                     = (TextView)findViewById(R.id.txt_Date);
        txtTime                     = (TextView)findViewById(R.id.txt_time);
        txtWorkerName               = (TextView)findViewById(R.id.txt_matchingWorkerName);
        txtWorkerId                 = (TextView)findViewById(R.id.txt_matchingWorkerId);

        imgfinger                   = (ImageView)findViewById(R.id.matching_fingerPrint);
        CircularImage               = (CircleImageView) findViewById(R.id.matching_ProfileImg);

        statrMatchingbtn            = (Button) findViewById(R.id.matchingBtn);
        linearLayout                = (ScrollView) findViewById(R.id.Matching_Layout);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.smb_coin);


        radioGroup                  = (RadioGroup) findViewById(R.id.radio_group);
        RInTime                     = (RadioButton) findViewById(R.id.radio_In_Time);
        ROutTime                    = (RadioButton) findViewById(R.id.radio_Out_Time);
        RHalfDay                    = (RadioButton) findViewById(R.id.radio_Half_Day);

        lblMessage                  = (TextView) findViewById(R.id.lbl_message);

        mCurrentate();
        radioGroup.check(R.id.radio_In_Time);
        linearLayout.setBackgroundResource(R.drawable.gradient_rintime_worker);



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup radioGroup, int i) {
               if(RInTime.isChecked())
               {
                 //linearLayout.setBackgroundColor(Color.GREEN);
                   linearLayout.setBackgroundResource(R.drawable.gradient_rintime_worker);
                   mfs100Mantra.setRadioCheck("checkIn");

               }
               if(ROutTime.isChecked())
               {
                //linearLayout.setBackground(getDrawable(R.drawable.gradient_routtime_worker));
                   linearLayout.setBackgroundResource(R.drawable.gradient_routtime_worker);
                   mfs100Mantra.setRadioCheck("checkOut");


               }
               if(RHalfDay.isChecked())
               {
                      // linearLayout.setBackground(getDrawable(R.drawable.gradient_rhalfday_worker));
                   linearLayout.setBackgroundResource(R.drawable.gradient_rhalfday_worker);
                   mfs100Mantra.setRadioCheck("halfDay");

               }
           }
       });
      //  mfs100Mantra.setRadioCheck("checkIn");
    }

    private void mCurrentate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat(" dd/ MM / yyyy ");
        String strDate = "" + mdformat.format(calendar.getTime());
        display(strDate);
    }

    private void display(String strDate) {
        txtDate.setText(strDate);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mfs100Mantra.onDestroy();
    }
}
