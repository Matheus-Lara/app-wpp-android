package com.example.wppapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText enviarNumero;
    private TextInputEditText enviarMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enviarNumero = findViewById(R.id.enviarNumero);
        enviarMensagem = findViewById(R.id.enviarMensagem);

        this.registerEvents(findViewById(R.id.btn));
    }

    private void registerEvents(View btn) {
        btn.setOnClickListener(v -> {
            String num = Objects.requireNonNull(enviarNumero.getText()).toString();
            String msg = Objects.requireNonNull(enviarMensagem.getText()).toString();
            Uri link = Uri.parse("https://wa.me/55" + num + "?text=" + msg);
            Intent callIntent = new Intent(Intent.ACTION_VIEW, link);
            startActivity(callIntent);
        });
    }
}