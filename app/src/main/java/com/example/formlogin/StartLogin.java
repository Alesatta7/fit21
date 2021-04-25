package com.example.formlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.io.Serializable;

public class StartLogin extends AppCompatActivity {
    EditText pass, mail;
    CheckBox showP;
    Persona persona;
    Button login;

    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_login);

        mail = findViewById(R.id.idEmail);
        pass = findViewById(R.id.idPass);
        showP = findViewById(R.id.checkbox);
        login = findViewById(R.id.idLog);

        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(MainActivity.PERSONA_PATH);

        if(object instanceof Persona){
            this.persona = (Persona) object;
        }
        else {
            this.persona = new Persona();
        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int err = 0;
                if(mail.getText().toString().length() ==0){
                    mail.setError("Inserire il nome");
                    err=1;
                } else mail.setError(null);

                if(!mail.getText().toString().equals(persona.getEmail())){
                    mail.setError("Inserire il nome");
                    err=1;
                } else mail.setError(null);

                if(pass.getText().toString().length() ==0 ){
                    pass.setError("Inserire il nome");
                    err=1;
                } else pass.setError(null);

                if(!pass.getText().toString().equals(persona.getPassword())){
                    pass.setError("Inserire il nome");
                    err=1;
                } else pass.setError(null);
                if(err==0){
                    Intent es = new Intent(StartLogin.this, ListaEsercizi.class);
                    startActivity(es);
                }

            }

        });


        showP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }
}