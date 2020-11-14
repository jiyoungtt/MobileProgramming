package kr.ac.konkuk.activityforresult_201713076;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity2 extends AppCompatActivity {

    EditText sub2_et;
    Button ok, cancel;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.sub2);

        sub2_et = (EditText)findViewById(R.id.sub2_et);
        ok = (Button)findViewById(R.id.sub2_okbtn);
        cancel = (Button)findViewById(R.id.sub2_cancelbtn);


        // ok버튼을 클릭하면 입력받은 데이터를 sub1에 전달 --> sub2에서 받은 결과값의 이름:INPUT_TEXT2
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("INPUT_TEXT2", sub2_et.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }

    /*

    public void sub2_ok(View target){
        Intent intent = new Intent();
        intent.putExtra("INPUT_TEXT", sub2_et.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }

    public void sub2_cancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }

     */
}
