package adrianarribas.travelcoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox ChBebida,ChComida,ChTransporte,ChSouvenir,ChEntrada;
    SeekBar SeekBebida,SeekComida,SeekTransporte,SeekSouvenir,SeekEntrada;
    TextView TvBebida,TvComida,TvTransporte,TvSouvenir,TvEntrada,TvEuros;
    EditText edtDetalle,edtPrecio;
    String detalles="";
    int precioBebida,precionComida,precioTransporte,precioSouvenir,precioEntrada;
    Double precioTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-----------------------INICIALIZAMOS LOS COMPONENTES---------------------
        ChBebida=(CheckBox)this.findViewById(R.id.checkBebida);
        ChComida=(CheckBox)this.findViewById(R.id.checkComida);
        ChTransporte=(CheckBox)this.findViewById(R.id.checkTransporte);
        ChSouvenir=(CheckBox)this.findViewById(R.id.checkSouvenir);
        ChEntrada=(CheckBox)this.findViewById(R.id.checkEntrada);

        SeekBebida=(SeekBar)this.findViewById(R.id.seekBebida);
        SeekComida=(SeekBar)this.findViewById(R.id.seekComida);
        SeekTransporte=(SeekBar)this.findViewById(R.id.seekTransporte);
        SeekSouvenir=(SeekBar)this.findViewById(R.id.seekSouvenir);
        SeekEntrada=(SeekBar)this.findViewById(R.id.seekEntrada);

        TvBebida=(TextView) this.findViewById(R.id.textVBebida);
        TvComida=(TextView) this.findViewById(R.id.textVComida);
        TvTransporte=(TextView) this.findViewById(R.id.textVTransporte);
        TvSouvenir=(TextView) this.findViewById(R.id.textVSouvenir);
        TvEntrada=(TextView) this.findViewById(R.id.textVEntrada);
        TvEuros=(TextView) this.findViewById(R.id.textVEuros);

        edtDetalle=(EditText) this.findViewById(R.id.editTextDetalles);
        edtPrecio=(EditText) this.findViewById(R.id.editTextPrecio);

        precioBebida=0;
        precionComida=0;
        precioTransporte=0;
        precioSouvenir=0;
        precioEntrada=0;
        precioTotal=0;

        SeekBebida.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                //la Seekbar siempre empieza en cero, si queremos que el valor mínimo sea otro podemos modificarlo
                TvBebida.setText(progress+"00Y");
                if(progress>0){
                    ChBebida.setChecked(true);
                }else{
                    ChBebida.setChecked(false);
                }
                precioBebida=progress*10;
            }
            @Override
            public void onStartTrackingTouch(SeekBar arg0){}

            @Override
            public void onStopTrackingTouch(SeekBar arg0){}
        });

        SeekComida.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                //la Seekbar siempre empieza en cero, si queremos que el valor mínimo sea otro podemos modificarlo
                TvComida.setText(progress+"00Y");
                if(progress>0){
                    ChComida.setChecked(true);
                }else{
                    ChComida.setChecked(false);
                }
                precionComida=progress*10;
            }
            @Override
            public void onStartTrackingTouch(SeekBar arg0){}

            @Override
            public void onStopTrackingTouch(SeekBar arg0){}
        });

        SeekTransporte.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                //la Seekbar siempre empieza en cero, si queremos que el valor mínimo sea otro podemos modificarlo
                TvTransporte.setText(progress+"00Y");
                if(progress>0){
                    ChTransporte.setChecked(true);
                }else{
                    ChTransporte.setChecked(false);
                }
                precioTransporte=progress*10;
            }
            @Override
            public void onStartTrackingTouch(SeekBar arg0){}

            @Override
            public void onStopTrackingTouch(SeekBar arg0){}
        });

        SeekSouvenir.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                //la Seekbar siempre empieza en cero, si queremos que el valor mínimo sea otro podemos modificarlo
                TvSouvenir.setText(progress+"00Y");
                if(progress>0){
                    ChSouvenir.setChecked(true);
                }else{
                    ChSouvenir.setChecked(false);
                }
                precioSouvenir=progress*10;
            }
            @Override
            public void onStartTrackingTouch(SeekBar arg0){}

            @Override
            public void onStopTrackingTouch(SeekBar arg0){}
        });

        SeekEntrada.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                //la Seekbar siempre empieza en cero, si queremos que el valor mínimo sea otro podemos modificarlo
                TvEntrada.setText(progress+"00Y");
                if(progress>0){
                    ChEntrada.setChecked(true);
                }else{
                    ChEntrada.setChecked(false);
                }
                precioEntrada=progress*10;
            }
            @Override
            public void onStartTrackingTouch(SeekBar arg0){}

            @Override
            public void onStopTrackingTouch(SeekBar arg0){
                if(ChBebida.isChecked()){

                }
            }
        });

    }

    public void operaciones(View v) {
        precioTotal = 0.0;
        if (ChBebida.isChecked()) {
            precioTotal += precioBebida;
            detalles+=" Bebida/";
        }
        if (ChComida.isChecked()) {
            precioTotal += precionComida;
            detalles+=" Comida/";
        }
        if (ChTransporte.isChecked()) {
            precioTotal += precioTransporte;
            detalles+=" Transporte/";
        }
        if (ChSouvenir.isChecked()) {
            precioTotal += precioSouvenir;
            detalles+=" Souvenir/";
        }
        if (ChEntrada.isChecked()) {
            precioTotal += precioEntrada;
            detalles+=" Entradas/";
        }
        edtPrecio.setText(precioTotal*10+"");
        double Euros;
        Euros=precioTotal*10*0.00760;
        TvEuros.setText("Total de éste gasto en Euros: "+Euros+" € en: "+ detalles  );
        edtDetalle.setText(detalles);

    }

    public void añadir(View v){
        if(precioTotal>0){
            new Gasto ("X/X/X",detalles,"fotoURL","vacio",precioTotal,precioTotal*10*0.00760,0.0,0.0,0.0);
        }
    }

}


