package kr.ac.konkuk.activityforresult_201713076;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class SubActivity extends AppCompatActivity {

    static final int GET_STRING = 1;

    TextView sub_tv;
    Button toSub2_btn, sub_okbtn, sub_cancelbtn;
    EditText sub_et;

   public void onCreate(Bundle icicle){
       super.onCreate(icicle);
       setContentView(R.layout.sub);

       sub_tv = (TextView)findViewById(R.id.sub_tv);
       toSub2_btn =(Button)findViewById(R.id.toSub2_btn);
       sub_okbtn=(Button)findViewById(R.id.sub_okbtn);
       sub_cancelbtn=(Button)findViewById(R.id.sub_cancelbtn);
       sub_et = (EditText)findViewById(R.id.sub_et);


       //sub2가는 버튼을 클릭하면 sub2로 이동한다.activity 실행
       toSub2_btn.setOnClickListener(new View.OnClickListener() {
           // @Override
           public void onClick(View arg0) {
               Intent in = new Intent(SubActivity.this, SubActivity2.class);
               startActivityForResult(in, GET_STRING);
           }
       });

       //OK버튼을 클릭했을때 --> mainActivity에 sub1의 결과(INPUT_TEXT1)와 이미 받아온 sub2결과(INPUT_TEXT2)를 전달
       sub_okbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent();
               intent.putExtra("INPUT_TEXT1", sub_et.getText().toString());
               intent.putExtra("INPUT_TEXT2",sub_tv.getText().toString());
               setResult(RESULT_OK,intent);
               finish();
           }
       });
       //취소버튼을 클릭했을때 --> 코드가 RESULT_CANCELED이다.
       sub_cancelbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               setResult(RESULT_CANCELED);
               finish();
           }
       });

   }
/*
       toSub2_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(SubActivity.this, SubActivity2.class);
               startActivityForResult(intent, GET_STRING);

           }
       });

       */


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_STRING) {
            if (resultCode == RESULT_OK) { //RESULT_OK일때 == OK버튼이 클릭되었을떄
                sub_tv.setText(data.getStringExtra("INPUT_TEXT2")); //sub2액티비티로부터 결과를 받아서 textview에다 표시
            }
        }
    }
/*
   //Sub2 액티비티를 실행
    public void toSub2(View view){
       Intent intent = new Intent(SubActivity.this, SubActivity2.class);
       startActivityForResult(intent,GET_STRING);
    }

   //액티비티2로부터 결과를 받는다.
   protected void onAcitivityResult(int requestCode, int resultCode, Intent data){
       if (requestCode ==GET_STRING){
           if (resultCode==RESULT_OK){
               sub_tv.setText(data.getStringExtra("INPUT_TEXT"));
           }
       }

   }

*/
}
