package kr.ac.konkuk.activityforresult_201713076;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final static int GET_STRING = 1;

    Button toSub_btn;
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//레이아웃을 activity_main으로 하겠다.

        //XML파일에서 정의한 버튼, 텍스트뷰를 가지고 온다
        toSub_btn = (Button) findViewById(R.id.toSub_btn);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);


        //서브커튼으로 가는 버튼클릭 리스너 등록 --> sub.java를 실행
        toSub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(in, GET_STRING);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == GET_STRING){
            if (resultCode==RESULT_OK){
                text1.setText(data.getStringExtra("INPUT_TEXT1"));//textview1에는 INPUT_TEXT1이름의 String을 가지고온다.
                text2.setText(data.getStringExtra("INPUT_TEXT2"));//textview1에는 INPUT_TEXT1이름의 String을 가지고온다.

            }
        }
    }

    /*
    public void toSub(View view){
       Intent in = new Intent(MainActivity.this, SubActivity.class);
        startActivityForResult(in, GET_STRING);
    }
    */



}//MainActivity