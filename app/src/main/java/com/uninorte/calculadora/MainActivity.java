package com.uninorte.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.security.PrivilegedExceptionAction;

public class MainActivity extends AppCompatActivity {

    TextView textoCalculo;
    TextView textoResultado;
    String Texto;
    int cont;
    int contop;
    float acumulado=0;
    String[] operadores= new String[100];
    int[] operaciones= new int[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoCalculo=findViewById(R.id.textoCalc);
        textoResultado=findViewById(R.id.textoResul);
        cont=0;
        contop=0;
    }

    public void escribirSiete(View view) {
        if(operadores[cont]==null){
            operadores[cont]="";
        }
        Texto=textoCalculo.getText().toString();
        Texto=Texto+"7";
        operadores[cont]=operadores[cont]+"7";
        textoCalculo.setText(Texto);

    }

    public void escribirOcho(View view) {
        if(operadores[cont]==null){
            operadores[cont]="";
        }
        Texto=textoCalculo.getText().toString();
        Texto=Texto+"8";
        operadores[cont]=operadores[cont]+"8";
        textoCalculo.setText(Texto);
    }

    public void escribirNueve(View view) {
        if(operadores[cont]==null){
            operadores[cont]="";
        }
        Texto=textoCalculo.getText().toString();
        Texto=Texto+"9";
        operadores[cont]=operadores[cont]+"9";
        textoCalculo.setText(Texto);
    }
    public void escribirCuatro(View view) {
        if(operadores[cont]==null){
            operadores[cont]="";
        }
        Texto=textoCalculo.getText().toString();
        Texto=Texto+"4";
        operadores[cont]=operadores[cont]+"4";
        textoCalculo.setText(Texto);
    }
    public void escribirCinco(View view) {
        if(operadores[cont]==null){
            operadores[cont]="";
        }
        Texto=textoCalculo.getText().toString();
        Texto=Texto+"5";
        operadores[cont]=operadores[cont]+"5";
        textoCalculo.setText(Texto);
    }
    public void escribirSeis(View view) {
        if(operadores[cont]==null){
            operadores[cont]="";
        }
        Texto=textoCalculo.getText().toString();
        Texto=Texto+"6";
        operadores[cont]=operadores[cont]+"6";
        textoCalculo.setText(Texto);
    }
    public void escribirUno(View view) {
        if(operadores[cont]==null){
            operadores[cont]="";
        }
        Texto=textoCalculo.getText().toString();
        Texto=Texto+"1";
        operadores[cont]=operadores[cont]+"1";
        textoCalculo.setText(Texto);
    }
    public void escribirDos(View view) {
        if(operadores[cont]==null){
            operadores[cont]="";
        }
        Texto=textoCalculo.getText().toString();
        Texto=Texto+"2";
        operadores[cont]=operadores[cont]+"2";
        textoCalculo.setText(Texto);
    }
    public void escribirTres(View view) {
        if(operadores[cont]==null){
            operadores[cont]="";
        }
        Texto=textoCalculo.getText().toString();
        Texto=Texto+"3";
        operadores[cont]=operadores[cont]+"3";
        textoCalculo.setText(Texto);
    }
    public void escribirCero(View view) {
        if(operadores[cont]==null){
            operadores[0]="";
        }
        Texto=textoCalculo.getText().toString();
        Texto=Texto+"0";
        operadores[cont]=operadores[cont]+"0";
        textoCalculo.setText(Texto);
    }
    public void escribirPunto(View view) {
        if(operadores[cont]==null){
            operadores[cont]="";
        }
        Texto=textoCalculo.getText().toString();
        Texto=Texto+".";
        if (operadores[cont]==""){
            operadores[cont]="0.";
        }
        else{
            operadores[cont]=operadores[cont]+".";
        }
        textoCalculo.setText(Texto);
    }
    public void escribirEntre(View view) {
        if (cont==0){
            acumulado=Float.parseFloat(operadores[0]);
        }else{
            float resultado=RealizarOperacion(acumulado,Float.parseFloat(operadores[cont]),operaciones[contop-1]);
            acumulado=resultado;
        }
        textoResultado.setText(acumulado+"");
        Texto=textoCalculo.getText().toString();
        Texto=Texto+"÷";
        textoCalculo.setText(Texto);
        cont++;
        operaciones[contop]=4;
        contop++;
    }
    public void escribirPor(View view) {
        if (cont==0){
            acumulado=Float.parseFloat(operadores[cont]);
        }else{
            float resultado=RealizarOperacion(acumulado,Float.parseFloat(operadores[cont]),operaciones[contop-1]);
            acumulado=resultado;
        }
        textoResultado.setText(acumulado+"");
        Texto=textoCalculo.getText().toString();
        Texto=Texto+"x";
        textoCalculo.setText(Texto);
        cont++;
        operaciones[contop]=3;
        contop++;
    }
    public void escribirMenos(View view) {
        if (cont==0){
            acumulado=Float.parseFloat(operadores[0]);
        }else{
            float resultado=RealizarOperacion(acumulado,Float.parseFloat(operadores[cont]),operaciones[contop-1]);
            acumulado=resultado;
        }
        textoResultado.setText(acumulado+"");
        Texto=textoCalculo.getText().toString();
        Texto=Texto+"-";
        textoCalculo.setText(Texto);
        cont++;
        operaciones[contop]=2;
        contop++;
    }
    public void escribirMas(View view) {
        if (cont==0){
            acumulado=Float.parseFloat(operadores[0]);
        }else{
            float resultado=RealizarOperacion(acumulado,Float.parseFloat(operadores[cont]),operaciones[contop-1]);
            acumulado=resultado;
        }
        textoResultado.setText(acumulado+"");
        Texto=textoCalculo.getText().toString();
        Texto=Texto+"+";
        textoCalculo.setText(Texto);
        cont++;
        operaciones[contop]=1;
        contop++;
    }

    public void darResultado(View view) {
        if (cont==0){
            acumulado=Float.parseFloat(operadores[0]);
        }else{
            float resultado=RealizarOperacion(acumulado,Float.parseFloat(operadores[cont]),operaciones[contop-1]);
            acumulado=resultado;
        }
        operadores[0]=acumulado+"";
        textoCalculo.setText(acumulado+"");
        textoResultado.setText("");
        cont=0;
        contop=0;
    }

    public void Borrar(View view) {
        operadores = new String[100];
        operaciones = new int[100];
        cont=0;
        contop=0;
        textoCalculo.setText("");
        textoResultado.setText("");
    }

    public float RealizarOperacion(float operador1,float operador2, int operacion){
        if (operacion==1){
            return operador1 + operador2;
        }
        else {
            if (operacion == 2) {
                return operador1 - operador2;
            } else {
                if (operacion == 3) {
                    return operador1 * operador2;
                } else {
                    if (operacion == 4) {
                        return operador1 / operador2;
                    }
                }
            }
        }
        return 0;
    }
    public float DesarrollarVectorOperaciones (String[] operadores,int[] operaciones,int contop){
        int i=0;
        float acumulado=0;
        if (i < contop){
            acumulado=RealizarOperacion(Float.parseFloat(operadores[i]),Float.parseFloat(operadores[i+1]),operaciones[i]);
            i++;
        }
        return acumulado;
    }

    public void AbrirActividad(View view) {
        Intent i=new Intent(this,ListaEdicion.class);
        i.putExtra("operadores",operadores);
        i.putExtra("operaciones",operaciones);
        i.putExtra("cont",contop);
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
