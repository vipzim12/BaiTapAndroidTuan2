package com.example.meomeo.tuan2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeBackgroundActivity extends AppCompatActivity {
    public final int REQUEST_ACT_DETAILACTIVITY = 3000;

//    @BindView(R.id.btnSave)
//    Button btnSave;

    private int imageId = -1;
    private String TAG = "bg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_backgroud);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.im1, R.id.im2, R.id.im3, R.id.im4, R.id.im5, R.id.im6})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im1:
                imageId = R.drawable.im1;
                transferDataToDetailActivity();
                break;
            case R.id.im2:
                imageId = R.drawable.im2;
                transferDataToDetailActivity();
                break;
            case R.id.im3:
                imageId = R.drawable.im3;
                transferDataToDetailActivity();
                break;
            case R.id.im4:
                imageId = R.drawable.im4;
                transferDataToDetailActivity();
                break;
            case R.id.im5:
                imageId = R.drawable.im5;
                transferDataToDetailActivity();
                break;
            case R.id.im6:
                imageId = R.drawable.im6;
                transferDataToDetailActivity();
                break;
        }
        Log.d(TAG, "onClick: " + imageId);
    }


//    @OnClick(R.id.btnSave)
//    public void btnSave() {
//        transferDataToMainActivity();
//    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_ACT_DETAILACTIVITY){
            if(resultCode==RESULT_OK){
                int imId= data.getIntExtra("Key_ChooseImage",-1);
                imageId=imId;
                transferDataToMainActivity();
            }
        }
        }
    private void transferDataToDetailActivity(){
        Intent i= new Intent(this, DetailActivity.class);
        i.putExtra("Key_Image",imageId);
        setResult(RESULT_OK,i);
        startActivityForResult(i,REQUEST_ACT_DETAILACTIVITY);
    }

    private void transferDataToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Key_Backgroud", imageId);
        setResult(RESULT_OK, intent);
        finish();
    }
}
