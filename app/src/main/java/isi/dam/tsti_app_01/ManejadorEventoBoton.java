package isi.dam.tsti_app_01;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ManejadorEventoBoton implements View.OnClickListener {

    Activity act;

    public ManejadorEventoBoton(Activity act){
        this.act = act;
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        TextView tv = act.findViewById(R.id.textoIndicador);
        switch (v.getId()){
            case R.id.btnAceptar:
                Log.d("ManejadorEventoBoton", "onClick: en el BOTON ACEPTAR "+v.getId()+ " --> "+ b.getText());
                tv.setText("COMENZO");
                break;
            case R.id.btnReiniciar:
                Log.d("ManejadorEventoBoton", "onClick: en el BOTON REINICIAR "+v.getId()+ " --> "+ b.getText());
                tv.setText("REINICIO");
                break;
        }
    }
}
