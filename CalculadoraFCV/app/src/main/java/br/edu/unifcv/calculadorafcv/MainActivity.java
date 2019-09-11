package br.edu.unifcv.calculadorafcv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonSoma, buttonSubt, buttonMult, buttonDiv, buttonlimpar, buttonIgual, buttonPonto;

    TextView resultado;

    float valor1, valor2;

    boolean Divisao, Multiplicacao, Adicao, Subtracao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);
        buttonlimpar = (Button) findViewById(R.id.buttonLimpar);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonIgual = (Button) findViewById(R.id.buttonIgual);
        buttonSoma = (Button) findViewById(R.id.buttonSoma);
        buttonSubt = (Button) findViewById(R.id.buttonSubt);
        buttonMult = (Button) findViewById(R.id.buttonMult);
        buttonPonto = (Button) findViewById(R.id.buttonPonto);
        resultado = (TextView) findViewById(R.id.resultado);

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

                    if (valor2 == 0){
                        Toast.makeText(getApplicationContext(), "NÃO É POSSIVEL DIVISÃO POR ZERO.", Toast.LENGTH_SHORT).show();
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

//    int i = 0;
//    int count = 0;
//    int[] Result;
//    float Total = 0;
//
//    float valor, valor1, valor2;
//
//    String operator;
//    TextView resultado;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Result = new int[2];
//        resultado = (TextView) findViewById(R.id.resultado);
//    }
//    public void adicionarNumero(View view) {
//        String numero = ((TextView) view).getText().toString();
//        TextView resultado = ((TextView) findViewById(R.id.resultado));
//        resultado.setText(resultado.getText() + numero);
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.buttonSoma: operator = "soma";
//                calcular();
//                proximoNumero();
//                break;
//            case R.id.buttonSubt: operator = "sub";
//                calcular();
//                proximoNumero();
//                break;
//            case R.id.buttonMult: operator = "mult";
//                calcular();
//                proximoNumero();
//                break;
//            case R.id.buttonDiv: operator = "div";
//                calcular();
//                proximoNumero();
//                break;
//            case R.id.buttonIgual: Igual();
//                count = 0;
//                break;
//            case R.id.buttonLimpar: limpar(view);
//                break;
//        }
//
//        Total = 0;
//    }
//
//
//    private void proximoNumero() {
//        count = 0;
//        i = 1;
//    }
//
//    private void Igual(){
//        valor = Float.parseFloat(resultado.getText()+"");
//    }
//
//    private void limpar(View view) {
//        resultado.setText("");
//    }
//
//    private void calcular() {
//        switch (operator){
//            case "soma": Total = valor1 + valor2; break;
//            case "sub": Total = valor1 - valor2; break;
//            case "mult": Total = valor1 * valor2; break;
//            case "div": Total = valor1 / valor2; break;
//        }
//
//
//    }
//}