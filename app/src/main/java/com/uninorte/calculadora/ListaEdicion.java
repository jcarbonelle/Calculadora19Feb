package com.uninorte.calculadora;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ListaEdicion extends AppCompatActivity {


    ScrollView main;
    String[] operadores;
    int[] operaciones;
    int cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_edicion);
        main=findViewById(R.id.mainScroll);
        generateLayout();
    }

    private void generateLayout() {
        Intent i= getIntent();
        operadores=i.getStringArrayExtra("operadores");
        operaciones=i.getIntArrayExtra("operaciones");
        cont=i.getIntExtra("cont",0);
        LinearLayout Vertical = new LinearLayout(this);
        Vertical.setOrientation(LinearLayout.VERTICAL);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText editText= new EditText(ListaEdicion.this);
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaEdicion.this);
                builder.setTitle("Editar");
                builder.setMessage("¿Por cual numero desea cambiar?");
                builder.setView(editText);
                builder.setPositiveButton("OK",null);
                builder.setNegativeButton("Cancel",null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        };
        int j=0;
        while(j<cont){
            Button bt = new Button(this);
            TextView tv = new TextView(this);
            tv.setTag(j);
            bt.setText("Edit");
            bt.setTag(j);
            bt.setOnClickListener(onClickListener);
            tv.setText(operadores[j]+"");
            LinearLayout Horizontal = new LinearLayout(this);
            Horizontal.setOrientation(LinearLayout.HORIZONTAL);
            Horizontal.addView(tv);
            Horizontal.addView(bt);
            Vertical.addView(Horizontal);
            bt = new Button(this);
            tv = new TextView(this);
            tv.setId(j);
            tv.setTag(j);
            bt.setText("Edit");
            bt.setTag(j);
            bt.setOnClickListener(onClickListener);
            if (operaciones[j]==1){
                tv.setText("+");
            }else{
                if (operaciones[j]==2){
                    tv.setText("-");
                }else{
                    if (operaciones[j]==3){
                        tv.setText("x");
                    }else{
                        if (operaciones[j]==4) {
                            tv.setText("÷");
                        }
                    }
                }
            }
            Horizontal = new LinearLayout(this);
            Horizontal.setOrientation(LinearLayout.HORIZONTAL);
            Horizontal.addView(tv);
            Horizontal.addView(bt);
            Vertical.addView(Horizontal);
            j++;
        }
        Button bt = new Button(this);
        TextView tv = new TextView(this);
        tv.setId(j);
        tv.setTag(j);
        bt.setText("Edit");
        bt.setTag(j);
        bt.setOnClickListener(onClickListener);
        tv.setText(operadores[j]+"");
        LinearLayout Horizontal = new LinearLayout(this);
        Horizontal.setOrientation(LinearLayout.HORIZONTAL);
        Horizontal.addView(tv);
        Horizontal.addView(bt);
        Vertical.addView(Horizontal);
        main.addView(Vertical);
    }
}
