package com.cderian.petagram.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cderian.petagram.R;
import com.cderian.petagram.util.SessionMail;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class ContactoActivity extends AppCompatActivity {

    Button btnEnviar;
    TextInputLayout inputTxtNombre, inputTxtEmail, inputTxtMensaje;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        toolbar = findViewById(R.id.actionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Inicializando los InputText
        inputTxtNombre = findViewById(R.id.inputTxtNombre);
        inputTxtEmail = findViewById(R.id.inputTxtEmail);
        inputTxtMensaje = findViewById(R.id.inputTxtMensaje);

        //Inicializando el botón de Enviar
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Datos de ingreso de datos
                String inputNombre, inputEmail, inputMensaje;

                //Capturando los datos ingresados por el usuario
                inputNombre = inputTxtNombre.getEditText().getText().toString();
                inputEmail = inputTxtEmail.getEditText().getText().toString();
                inputMensaje = inputTxtMensaje.getEditText().getText().toString();

                //Validando datos
                if (inputNombre.isEmpty() || inputNombre=="") {
                    Snackbar snackbar = Snackbar.make(v, getResources().getString(R.string.nombre_nulo), Snackbar.LENGTH_LONG);
                    snackbar.show();
                    inputTxtNombre.setBoxStrokeColor(Color.RED);
                } else if (!validarEmail(inputEmail)) {
                    Snackbar snackbar = Snackbar.make(v, getResources().getString(R.string.email_invalido), Snackbar.LENGTH_LONG);
                    snackbar.show();
                    inputTxtEmail.setBoxStrokeColor(Color.RED);
                } else {
                    SessionMail sessionMail = new SessionMail(ContactoActivity.this, inputEmail, inputMensaje);
                    sessionMail.execute();
                }
            }
        });
    }

    private final static boolean validarEmail(CharSequence email) {
        if (email == null)
            return false;

        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}