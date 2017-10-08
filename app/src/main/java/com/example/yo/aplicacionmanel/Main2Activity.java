package com.example.yo.aplicacionmanel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView tv1;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1 = (TextView)findViewById(R.id.textView);
        editText2 = (EditText)findViewById(R.id.editText2);

        Bundle b = getIntent().getExtras();
        tv1.setText("Hola "+b.getString("nombre")+", Bienvenido al ultimo dia de tu vida");

    }

    public void enviaEdad(View v) {
        if(editText2.getText().toString().length()>0) {
            getIntent().putExtra("edad", editText2.getText().toString());
            setResult(RESULT_OK,getIntent());
            this.finish();
        } else {
            Toast.makeText(getApplicationContext(),"Introduce una edad",Toast.LENGTH_LONG).show();
        }

    }


}
