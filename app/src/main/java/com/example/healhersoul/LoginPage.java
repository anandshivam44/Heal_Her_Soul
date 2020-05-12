package com.example.healhersoul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginPage extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{
    private static final String TAG = "MyTag";
    String countryCode[] = {"+91","+234"};
    String country;
    Spinner spinner;
    String phoneNumber;

    private EditText et_phoneNumber,et_otp;
    private Button SignInButton;
    private Button sendOTPButton;
    private String mVerificationId;
    TextView skip_button;


    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getUid()!=null){
//            Intent intent = new Intent(otp.this, DrawerActivity.class);
//            Log.d(TAG, "Inside OTP\n\n"+"UID " + mAuth.getUid() + " \nCurrent User " + mAuth.getCurrentUser() + " \nPhone Number " + mAuth.getCurrentUser().getPhoneNumber());
//            startActivity(intent);
//            finish();
            Toast.makeText(this, "USER already Registered", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        et_phoneNumber=findViewById(R.id.edit_text_phone);
        et_otp=findViewById(R.id.edit_text_otp);
        spinner=findViewById(R.id.spinner_country_code);
        SignInButton=findViewById(R.id.sign_in);
        sendOTPButton=findViewById(R.id.bt_send_otp);
        skip_button=findViewById(R.id.skip_login);


        spinner.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,countryCode);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
        spinner.setSelection(0);

        sendOTPButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumber=et_phoneNumber.getText().toString();
                initiateLoginProcess();
            }
        });

        skip_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, MainActivity.class);
//            Log.d(TAG, "Inside OTP\n\n"+"UID " + mAuth.getUid() + " \nCurrent User " + mAuth.getCurrentUser() + " \nPhone Number " + mAuth.getCurrentUser().getPhoneNumber());
            startActivity(intent);
            }
        });
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyVerificationCode(et_otp.getText().toString());
            }
        });

    }

    private void initiateLoginProcess() {
        Log.d(TAG, "lower button clicked");
        if (!et_phoneNumber.getText().toString().equals("")){
            et_otp.setHint("Otp Sent");
            sendVerificationCode(phoneNumber);
        }
    }
    private void sendVerificationCode(String phone) {   // method for getting sms.........
        Log.d(TAG, "Just entered send verification code");
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                country + phone,
                60,
                TimeUnit.SECONDS,
                this,
                mCallbacks);
        Log.d(TAG, "Completed send verification code");

    }

    //the callback to detect the verification status
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {         //this object is for tracking sms sent or not.
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            Log.d(TAG, "Just entered onVerificationCompleted");//Log.d(TAG, "Just entered ");

            //Getting the code sent by SMS
            String code = phoneAuthCredential.getSmsCode();                                          //code for auto detection .....
            Toast.makeText(getApplicationContext(), "SMS Reading Done", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Code Received by app code: "+code);

            //sometime the code is not detected automatically
            //in this case the code will be null
            //so user has to manually enter the code
            if (code != null) {
                Log.d(TAG, "Code Received by app and code is not empty set text in pinVier");
                et_otp.setText(code);
                //verifying the code
                verifyVerificationCode(code);                                               //function call for verifying code using autodetected code
            }
            else{
                signInWithPhoneAuthCredential(phoneAuthCredential);

            }
            Log.d(TAG, "Completed onVerificationCompleted");
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Log.d(TAG, "Verification Failed "+e.getMessage());
            Toast.makeText(LoginPage.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            Log.d(TAG, "Entered Code sent");
            super.onCodeSent(s, forceResendingToken);
            Toast.makeText(getApplicationContext(), "CODE SENT s="+s, Toast.LENGTH_SHORT).show();

            //storing the verification id that is sent to the user
            mVerificationId = s;
            Log.d(TAG, "Exit Code sent");
        }
    };


    private void verifyVerificationCode(String code) {  // method for verification called by submit otp button....
        //creating the credential
        Log.d(TAG, "entered verifyVerificationCode ");
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);

        //signing the user
        signInWithPhoneAuthCredential(credential);
        Log.d(TAG, "Exit verifyVerificationCode ");
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        Log.d(TAG, "entered signInWithPhoneAuthCredential ");
        // code for user signin......
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signIn Complete ");

                            //verification successful we will start the profile activity
                            Intent intent = new Intent(LoginPage.this, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();

                        } else {
                            Log.d(TAG, "sign in failed ");

                            //verification unsuccessful.. display an error message

                            String message = "Somthing is wrong, we will fix it soon...";

                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                message = "Invalid code entered...";
                            }

//                            Snackbar snackbar = Snackbar.make(findViewById(R.id.parent), message, Snackbar.LENGTH_SHORT);
//                            snackbar.setAction("Dismiss", new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//
//                                }
//                            });
//                            snackbar.show();
                        }
                    }
                });
        Log.d(TAG, "Exit signInWithPhoneAuthCredential ");
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        country=countryCode[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        country=countryCode[0];

    }
}
