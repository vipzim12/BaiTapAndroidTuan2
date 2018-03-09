package com.example.meomeo.tuan2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "main";
    public final int REQUEST_ACT_SETTINGS = 1000;
    public final int REQUEST_ACT_CHANGE_BACKGROUND = 2000;

    Button btnNavigateSettingActivity, btnChangeBackground;
    TextView textView1;

    @BindView(R.id.image_view)
    ImageView imageView;

    String colorS = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnNavigateSettingActivity = findViewById(R.id.btnNavigateSettingActivity);
        btnChangeBackground = findViewById(R.id.btnSetBackground);
        textView1 = findViewById(R.id.textView1);

        btnNavigateSettingActivity.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
            startActivityForResult(intent, REQUEST_ACT_SETTINGS);
        });

        btnChangeBackground.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, ChangeBackgroundActivity.class);
            startActivityForResult(i, REQUEST_ACT_CHANGE_BACKGROUND);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ACT_CHANGE_BACKGROUND) {
            if (resultCode == RESULT_OK) {

                int imageId = data.getIntExtra("Key_Backgroud", -1);
                if (imageId != -1) {
                    Log.d(TAG, "onActivityResult: " + imageId);
                    Picasso.with(this).load(imageId).fit().centerInside().into(imageView);

                }
            }
        }

        if (requestCode == REQUEST_ACT_SETTINGS) {
            if (resultCode == RESULT_OK) {
                colorS = data.getStringExtra("Key_color");
                Log.d("ColorTest: ", colorS);
                if (colorS.equalsIgnoreCase("pink")) {
                    textView1.setTextColor(getResources().getColor(R.color.pink));
                }
                if (colorS.equalsIgnoreCase("purple")) {
                    Log.d("Test: ", "ok");
                    textView1.setTextColor(getResources().getColor(R.color.purple));
                }
                if (colorS.equalsIgnoreCase("blue")) {
                    textView1.setTextColor(getResources().getColor(R.color.blue));
                }
                if (colorS.equalsIgnoreCase("teal")) {
                    textView1.setTextColor(getResources().getColor(R.color.teal));
                }
                if (colorS.equalsIgnoreCase("green")) {
                    textView1.setTextColor(getResources().getColor(R.color.green));
                }
                if (colorS.equalsIgnoreCase("indigo")) {
                    textView1.setTextColor(getResources().getColor(R.color.indigo));
                }
                textView1.setText(data.getStringExtra("Key_title"));

            }
        }
    }
}
