package com.example.cna2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class fogotpassword extends AppCompatActivity {
    ImageView reset;
    EditText txtemail;
    TextView textiew;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fogotpassword);
        reset = findViewById(R.id.resetpassword);
        txtemail = findViewById(R.id.emailid);
        auth = FirebaseAuth.getInstance();
        textiew = findViewById(R.id.textView);


        reset.setOnClickListener(new View.OnClickListener() {
            //            String emailAddress = String.valueOf(email.getText()).trim();

            String emailAddress = String.valueOf(txtemail.getText()).trim();




            @Override
            public void onClick(View v) {
//                textiew.setText(txtemail.getText());

                if (TextUtils.isEmpty(txtemail.getText())) {
                    Toast.makeText(getApplicationContext(), "Enter email", Toast.LENGTH_SHORT).show();
                } else {
                    auth.sendPasswordResetEmail(txtemail.getText().toString().trim())
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Email send", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), login.class));

                                    }
                                }
                            });
                }


            }
        });
    }
}