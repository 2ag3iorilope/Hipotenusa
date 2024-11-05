package com.ikaslea.hipotenusa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText Edittextb;
    EditText Edittextc;
    Button btnkalkulatu;
    Button btnGarbitu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Edittextb = findViewById(R.id.editTextText2);
        Edittextc = findViewById(R.id.editTextText);
        btnkalkulatu = findViewById(R.id.button2);
        btnGarbitu = findViewById(R.id.button);

        btnkalkulatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KalkulatuHipotenusa();
            }
        });
        btnGarbitu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Eremuak_Garbitu();
            }
        });


    }

    private void KalkulatuHipotenusa() {
        String textoB = Edittextb.getText().toString();
        String textoC = Edittextc.getText().toString();

        // Konrpobatu Hutsik dagoen
        if (textoB.isEmpty()) {
            Edittextb.requestFocus();
            Toast.makeText(this, "Mesdez, sartu kateto B-ren balioa", Toast.LENGTH_SHORT).show();
            return;
        }

        if (textoC.isEmpty()) {
            Edittextc.requestFocus();
            Toast.makeText(this, "Mesdez, sartu Kateto C-ren balioa", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double b = Double.parseDouble(textoB);
            double c = Double.parseDouble(textoC);
            double emaitza = hipotenusaKalkulua(b, c);

            Toast.makeText(this, "Hipotenusa da: " + emaitza, Toast.LENGTH_LONG).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Mesedez sartu zenbaki numerikoak", Toast.LENGTH_SHORT).show();
        }
    }

    private double hipotenusaKalkulua(double b, double c) {
        double hipotenusa = 0.0;
        try {
            hipotenusa = Math.sqrt(Math.pow(b, 2) + Math.pow(c, 2));
        } catch (Exception e) {
            Toast.makeText(this, "Errorea Hipotenusa kalkulatzerakoan: " + e.getMessage() + "", Toast.LENGTH_SHORT).show();
        }
        return hipotenusa;
    }

    private void Eremuak_Garbitu() {
        Edittextb.setText("");
        Edittextc.setText("");
        Edittextb.requestFocus();
    }
}