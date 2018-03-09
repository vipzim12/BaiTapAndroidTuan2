package com.example.meomeo.tuan2;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {
    Button btnChoose;
    ImageView imViewDetail;

    int temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        btnChoose = (Button) findViewById(R.id.btnChoose);
        imViewDetail = (ImageView) findViewById(R.id.detailView);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            temp = data.getInt("Key_Image");
            imViewDetail.setBackgroundResource(temp);

            btnChoose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    transferDataToChangeBackground();
                }
            });
        }
    }
    private void transferDataToChangeBackground(){
            Intent i= new Intent(this,ChangeBackgroundActivity.class );
            i.putExtra("Key_ChooseImage", temp);
            setResult(RESULT_OK,i);
            finish();

    }


}
