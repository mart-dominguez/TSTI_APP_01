package isi.dam.tsti_app_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button botonAceptar, botonReiniciar;
    TextView textoIndicador;
    CheckBox checkBoxAceptar;
    EditText razonSocial,nomApe;
    Switch swTipoPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonAceptar = findViewById(R.id.btnAceptar);
        botonReiniciar = findViewById(R.id.btnReiniciar);
        textoIndicador = findViewById(R.id.textoIndicador);
        checkBoxAceptar = findViewById(R.id.cbCondiciones);
        nomApe = findViewById(R.id.edNombre);
        razonSocial = findViewById(R.id.editRazonSocial);
        swTipoPersona = findViewById(R.id.swTipoPersona);

        verificarNombreMostrar();

        swTipoPersona.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                verificarNombreMostrar();
            }
        });
        botonAceptar.setEnabled(checkBoxAceptar.isChecked());

        checkBoxAceptar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                botonAceptar.setEnabled(isChecked);

            }
        });

        ManejadorEventoBoton listener = new ManejadorEventoBoton(this);
//        botonAceptar.setOnClickListener(new  View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textoIndicador.setText("COMIENZA DESDE CLASE ANONIMA");
//            }
//        });
//        botonReiniciar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textoIndicador.setText("REINICIA DESDE CLASE ANONIMA");
//
//            }
//        });
        // botonAceptar.setOnClickListener(this);
        botonReiniciar.setOnClickListener(this);
        botonReiniciar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                textoIndicador.setText("Click largo");
                Log.d("ManejadorEventoBoton", "CLICK LARGO EN REINICIAR");
                return true;
            }
        });
        // listener es una instancia de una clase que implementa la interface View.OnClickListener
        // dicha interface, posee un único "onClick" el cual es invocado por android
        // cada vez que se hace click en el widget
        // boton.getOnClickListener().onClick(boton)
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        switch (v.getId()){
            case R.id.btnAceptar:
                Log.d("ManejadorEventoBoton", "onClick: en el BOTON ACEPTAR "+v.getId()+ " --> "+ b.getText());
                textoIndicador.setText("COMENZO implementando IF en misma activ");
                break;
            case R.id.btnReiniciar:
                Log.d("ManejadorEventoBoton", "onClick: en el BOTON REINICIAR "+v.getId()+ " --> "+ b.getText());
                textoIndicador.setText("REINICIO implementando IF en misma activ");
                checkBoxAceptar.setChecked(false);
                break;
        }
    }

    public void botonAceptar(View view){
        Log.d("ManejadorEventoBoton", "onClick: en el BOTON ACEPTAR "+view.getId()+ " --> "+ ((Button) view).getText());
        textoIndicador.setText("COMENZO implementando EN METODO botonAceptar");
    }

    private void verificarNombreMostrar(){
        if(swTipoPersona.isChecked()){
            // es juridico
            nomApe.setVisibility(View.GONE);
            razonSocial.setVisibility(View.VISIBLE);
        } else {
            nomApe.setVisibility(View.VISIBLE);
            razonSocial.setVisibility(View.GONE);
        }
    }
}