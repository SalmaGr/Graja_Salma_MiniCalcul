package com.example.graja_salma_lsi3_somme;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText a;
    private EditText op;
    private EditText b;
    private TextView r;
    private Button btnCalculer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer(v);
            }
        });
    }

    private void init() {
        a = findViewById(R.id.a);
        op = findViewById(R.id.op);
        b = findViewById(R.id.b);
        r = findViewById(R.id.r);
        btnCalculer = findViewById(R.id.btnCalculer);
    }

    //...

    public void calculer(View view) {
        int resultat = 0;
        boolean verifa = false, verifb = false, verifOp = false;

        if (!a.getText().toString().isEmpty()) {
            verifa = true;
        } else {
            Toast.makeText(MainActivity.this, "Veuillez saisir a !", Toast.LENGTH_SHORT).show();
        }

        if (!op.getText().toString().isEmpty()) {
            String operateur = op.getText().toString().trim();

            // Vérifier que l'opérateur est l'un des opérateurs autorisés
            if (operateur.equals("+") || operateur.equals("-") || operateur.equals("*")
                    || operateur.equals("/") || operateur.equals("%")) {
                verifOp = true;
            } else {
                Toast.makeText(MainActivity.this, "Opérateur non valide !", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Veuillez saisir l'opérateur !", Toast.LENGTH_LONG).show();
        }

        if (!b.getText().toString().isEmpty()) {
            verifb = true;
        } else {
            Toast.makeText(MainActivity.this, "Veuillez saisir b !", Toast.LENGTH_LONG).show();
        }

        if (verifa && verifOp && verifb) {
            int valeurA = Integer.parseInt(a.getText().toString());
            int valeurB = Integer.parseInt(b.getText().toString());

            char operation = op.getText().toString().charAt(0);

            switch (operation) {
                case '+':
                    resultat = valeurA + valeurB;
                    break;
                case '-':
                    resultat = valeurA - valeurB;
                    break;
                case '*':
                    resultat = valeurA * valeurB;
                    break;
                case '/':
                    if (valeurB != 0) {
                        resultat = valeurA / valeurB;
                    } else {
                        Toast.makeText(MainActivity.this, "Division par zéro !", Toast.LENGTH_LONG).show();
                        return; // Arrêter le calcul si division par zéro
                    }
                    break;
                case '%':
                    if (valeurB != 0) {
                        resultat = valeurA % valeurB;
                    } else {
                        Toast.makeText(MainActivity.this, "Division par zéro !", Toast.LENGTH_LONG).show();
                        return; // Arrêter le calcul si division par zéro
                    }
                    break;
            }

            r.setText(String.valueOf(resultat));
        }
    }
}
