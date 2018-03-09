package com.example.meomeo.tuan2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindColor;

public class SettingActivity extends AppCompatActivity {

    EditText edtText;
    View viewDisplayColor;
    ImageView iv1, iv2, iv3, iv4, iv5, iv6;
    Button btnSave;
    String color ="pink";
    String text = "";

    private int colorId;

    @BindColor(R.color.blue)
    int colorBlue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setInitialize();
        btnSave.setOnClickListener(onClickListener);
        iv1.setOnClickListener(onClickListener);
        iv2.setOnClickListener(onClickListener);
        iv3.setOnClickListener(onClickListener);
        iv4.setOnClickListener(onClickListener);
        iv5.setOnClickListener(onClickListener);
        iv6.setOnClickListener(onClickListener);
    }
    private void setInitialize() {
        edtText = (EditText) findViewById(R.id.edt);
        viewDisplayColor = (View) findViewById(R.id.viewSample);
        iv1= (ImageView) findViewById(R.id.iv1);
        iv2= (ImageView) findViewById(R.id.iv2);
        iv3= (ImageView) findViewById(R.id.iv3);
        iv4= (ImageView) findViewById(R.id.iv4);
        iv5= (ImageView) findViewById(R.id.iv5);
        iv6= (ImageView) findViewById(R.id.iv6);
        btnSave = (Button) findViewById(R.id.btnSave);
    }
    private void transferDataToMainActivity(String text, String color) {
        Intent intent = new Intent();
        intent.putExtra("Key_color",color);
        intent.putExtra("Key_title", text);
        setResult(RESULT_OK, intent);
        finish();
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.iv1:
                    color = "pink";
                    viewDisplayColor.setBackgroundColor(getResources().getColor(R.color.pink));
                    edtText.setTextColor(getResources().getColor(R.color.pink));
                    break;
                case R.id.iv2:
                    color = "purple";
                    viewDisplayColor.setBackgroundColor(getResources().getColor(R.color.purple));
                    edtText.setTextColor(getResources().getColor(R.color.purple));
                    break;
                case R.id.iv3:
                    color = "indigo";
                    viewDisplayColor.setBackgroundColor(getResources().getColor(R.color.indigo));
                    edtText.setTextColor(getResources().getColor(R.color.indigo));
                    break;
                case R.id.iv4:
                    color = "blue";
                    colorId = colorBlue;
                    viewDisplayColor.setBackgroundColor(getResources().getColor(R.color.blue));
                    edtText.setTextColor(getResources().getColor(R.color.blue));
                    break;
                case R.id.iv5:
                    color = "teal";
                    viewDisplayColor.setBackgroundColor(getResources().getColor(R.color.teal));
                    edtText.setTextColor(getResources().getColor(R.color.teal));
                    break;
                case R.id.iv6:
                    color = "green";
                    viewDisplayColor.setBackgroundColor(getResources().getColor(R.color.green));
                    edtText.setTextColor(getResources().getColor(R.color.green));
                    break;
                case R.id.btnSave:
                    text = edtText.getText().toString();
                    transferDataToMainActivity(text,color);
                    break;
            }
        }
    };
}
