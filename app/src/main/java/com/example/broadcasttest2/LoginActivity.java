package com.example.broadcasttest2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox remenberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        accountEdit=findViewById(R.id.account);
        passwordEdit=findViewById(R.id.password);
        login=findViewById(R.id.login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        remenberPass = findViewById(R.id.remember_pass);
        boolean isRemenber = pref.getBoolean("remember_password",false);
        if(isRemenber){
            String account = pref.getString("account","");
            String password = pref.getString("password","");
            accountEdit.setText(password);
            passwordEdit.setText(account);
            remenberPass.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(remenberPass.isChecked()){
                    String account = accountEdit.getText().toString();
                    String password= passwordEdit.getText().toString();
                    if((account.equals("admin"))&&(password.equals("123456"))){
                        editor = pref.edit();
                        if(remenberPass.isChecked()){
                            editor.putBoolean("remember_password",true);
                            editor.putString("account",account);
                            editor.putString("password",password);
                        }else{
                            editor.clear();
                        }
                        editor.apply();
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "account or password is invalid", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
