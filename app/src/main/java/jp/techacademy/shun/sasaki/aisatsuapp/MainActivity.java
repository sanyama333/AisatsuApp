package jp.techacademy.shun.sasaki.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);


    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.button1){
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourODay, int minute) {
                        Log.d("UI_PARTS", String.valueOf(hourODay) + ":" + String.valueOf(minute));
                        if(hourODay > 17 || hourODay == 1 || hourODay == 0){
                            mTextView.setText("こんばんは");
                        }else if(hourODay > 9){
                            mTextView.setText("こんにちは");
                        }else{
                            mTextView.setText("おはよう");
                        }
                    }
                },
                13,
                0,
                true);
        timePickerDialog.show();

    }
}
