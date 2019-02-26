package com.example.robel.foodchain;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import mehdi.sakout.fancybuttons.FancyButton;

public class MainActivity extends AppCompatActivity {


    private FancyButton scan_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scan_button = (FancyButton)findViewById(R.id.scan);

        final Activity activity = this;

        scan_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setOrientationLocked(false);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult res = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if(res!=null){
            if(res.getContents()==null){

                //Toast.makeText(this,"you canceled the scan",Toast.LENGTH_LONG).show();
            }else{
                //Toast.makeText(this,res.getContents(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,result.class);
                intent.putExtra("id",res.getContents());
                MainActivity.this.startActivity(intent);
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
