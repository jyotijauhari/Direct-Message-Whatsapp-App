package com.pabbas.quickwhatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rilixtech.widget.countrycodepicker.CountryCodePicker;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "WhatsApp_file" ;
    private static final String NAME_KEY = "UserName_key";
    private static final String FIRST_TIME_SHOW_KEY = "FirstTimeShow_key";
    String yourName;

    final Context context = this;
    CountryCodePicker ccp;
    EditText userPhoneNumber;
    EditText message;
    Button fastReplayOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ccp =findViewById(R.id.ccp);
        userPhoneNumber = findViewById(R.id.phone_number_edt);
        message = findViewById(R.id.message);
    }

    public void sendbtn(View view) {

        if(TextUtils.isEmpty(userPhoneNumber.getText().toString())){
            Toast.makeText(context, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }else {
            ccp.registerPhoneNumberTextView(userPhoneNumber);
            userPhoneNumber.setHint("Enter Number");

            String messageText = message.getText().toString();

            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(
                            "https://api.whatsapp.com/send?phone=" + ccp.getFullNumberWithPlus() + "&text=" + messageText
                    )));
        }
    }
}