package br.edu.unifcv.calculadorafcv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.net.wifi.WpsInfo.INVALID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int i = 0;
    int count = 0;
    int[] Result;
    int Total = 0;
    String operator;
    TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Result = new int[2];
        resultado = (TextView) findViewById(R.id.resultado);
    }
    public void adicionarNumero(View view) {
        String numero = ((TextView) view).getText().toString();
        TextView resultado = ((TextView) findViewById(R.id.resultado));
        resultado.setText(resultado.getText() + numero);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSoma: operator = "soma";
                proximoNumero();
                break;
            case R.id.buttonSubt: operator = "sub";
                proximoNumero();
                break;
            case R.id.buttonMult: operator = "mult";
                proximoNumero();
                break;
            case R.id.buttonDiv: operator = "div";
                proximoNumero();
                break;
            case R.id.buttonIgual: calcular();
                calcular();
                count = 0;
                break;
            case R.id.buttonLimpar: limpar();
                limpar();
                break;
        }
        changesResult();
        Total = 0;
    }

    private void changesResult() {
        if (Total != 0 && Total<INVALID){
            String tela = String.valueOf(Total);
            resultado.setText(tela);
        }else if (Total>INVALID){
            String tela = "ERROR";
            resultado.setText(tela);
        } else {
            String tela = String.valueOf(Result[i]);
            resultado.setText(tela);
        }
    }

    private void proximoNumero() {
        count = 0;
        i = 1;
    }

    private void limpar() {
        i = 0;
        Result[0] = 0;
        Result[1] = 0;
        Total = 0;
        count = 0;
    }

    private void calcular() {
        double value;
        switch (operator){
            case "soma": Total = (Result[0] + Result[1]); break;
            case "sub": Total = Result[0] - Result[1]; break;
            case "mult": Total = Result[0] * Result[1]; break;
            case "div": Total = Result[0] / Result[1]; break;
        }


    }
}