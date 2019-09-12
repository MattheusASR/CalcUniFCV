package br.edu.unifcv.calculadorafcv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonSoma, buttonSubt, buttonMult, buttonDiv, buttonlimpar, buttonIgual, buttonPonto;


    float valor1, valor2;

    boolean Divisao,
            Multiplicacao,
            Adicao,
            Subtracao;

    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);
        buttonlimpar = findViewById(R.id.buttonLimpar);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonIgual = findViewById(R.id.buttonIgual);
        buttonSoma = findViewById(R.id.buttonSoma);
        buttonSubt = findViewById(R.id.buttonSubt);
        buttonMult = findViewById(R.id.buttonMult);
        buttonPonto = findViewById(R.id.buttonPonto);
        resultado = findViewById(R.id.resultado);

       resultado.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                if(s.length() > 0
                        && s.subSequence(0, s.length()-1).toString().contains(".")
                        && s.toString().charAt(s.length() - 1) == '.')
                {
                    CharSequence text = s.subSequence(0, s.length()-1);
                    resultado.setText(text);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resultado.setText(resultado.getText()+"" +"1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText(resultado.getText()+"2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText(resultado.getText()+"3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText(resultado.getText()+"4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText(resultado.getText()+"5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText(resultado.getText()+"6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText(resultado.getText()+"7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText(resultado.getText()+"8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText(resultado.getText()+"9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText(resultado.getText()+"0");
            }
        });

        buttonPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText(resultado.getText()+".");
            }
        });

        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor1 = Float.parseFloat(resultado.getText()+"");
                Multiplicacao = true;

                resultado.setText(null);
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor1 = Float.parseFloat(resultado.getText()+"");
                Divisao = true;

                resultado.setText(null);
            }
        });

        buttonSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resultado == null){
                    resultado.setText("");
                }
                else{
                    valor1 = Float.parseFloat(resultado.getText()+"");
                    Adicao = true;

                    resultado.setText(null);

                }
            }
        });

        buttonSubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor1 = Float.parseFloat(resultado.getText()+"");
                Subtracao = true;

                resultado.setText(null);

            }
        });

        buttonlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText("");
            }
        });

        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor2 = Float.parseFloat(resultado.getText() + "");


                if (Multiplicacao == true){

                    resultado.setText(valor1 * valor2 + "");
                    Multiplicacao = false;

                }

                if (Divisao == true){

                    if (valor1 == 0 && valor2 == 0){
                        Toast.makeText(getApplicationContext(), "RESULTADO INDEFINIDO", Toast.LENGTH_SHORT).show();
                    } else if (valor2 == 0) {
                        Toast.makeText(getApplicationContext(), "NÃO É POSSIVEL DIVIDIR POR ZERO.", Toast.LENGTH_SHORT).show();
                    } else {
                        resultado.setText(valor1 / valor2 + "");
                        Divisao = false;
                    }
                }

                if (Subtracao == true){

                    resultado.setText(valor1 - valor2 + "");
                    Subtracao =  false;

                }

                if (Adicao == true){

                    resultado.setText(valor1 + valor2 + "");
                    Adicao = false;
                }
            }
        });
    }
}