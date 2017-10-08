package com.example.yo.aplicacionmanel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText et1;
    TextView textView2;
    RadioButton radioButton;
    RadioButton radioButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText)findViewById(R.id.editText);
        textView2 = (TextView)findViewById(R.id.textView2);
        radioButton = (RadioButton)findViewById(R.id.radioButton);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
    }



    public void nextPage(View v) {
        Intent i = new Intent(getApplicationContext(), Main2Activity.class);
        if(et1.getText().toString().length()>0){
            i.putExtra("nombre", et1.getText().toString());
            startActivityForResult(i,1);
            et1.setEnabled(false);
            radioButton.setEnabled(false);
            radioButton2.setEnabled(false);
        } else {
            Toast.makeText(getApplicationContext(),"Introduce un nombre",Toast.LENGTH_LONG).show();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int i = Integer.parseInt(data.getExtras().getString("edad"));
        System.out.println(data.getExtras().getString("edad"));
        if(i>=18&&i<25){
            textView2.setText("Eres mayor de edad");
        } else if(i>=25&&i<35){
            textView2.setText("Cuidado con la flor, que tiene vida");
        } else if(i>=35) {
            textView2.setText("Eres viejoven");
        } else{
            textView2.setText("Eres muy joven");
        }
    }
}
