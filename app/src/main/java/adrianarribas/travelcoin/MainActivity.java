package adrianarribas.travelcoin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static android.R.attr.duration;

public class MainActivity extends AppCompatActivity {
    CheckBox ChBebida,ChComida,ChTransporte,ChSouvenir,ChEntrada;
    SeekBar SeekBebida,SeekComida,SeekTransporte,SeekSouvenir,SeekEntrada;
    TextView TvBebida,TvComida,TvTransporte,TvSouvenir,TvEntrada,TvEuros,TvTotales;
    EditText edtDetalle,edtPrecio;
    String detalles="nul";
    int precioBebida,precionComida,precioTransporte,precioSouvenir,precioEntrada;
    Double precioTotal,Euros,Yens;
    Context ctx;
    GestionGastos GC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx=this;
        GC=new GestionGastos(ctx);

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
        TvTotales=(TextView) this.findViewById(R.id.tvTotales);

        edtDetalle=(EditText) this.findViewById(R.id.editTextDetalles);
        edtPrecio=(EditText) this.findViewById(R.id.editTextPrecio);

        precioBebida=0;
        precionComida=0;
        precioTransporte=0;
        precioSouvenir=0;
        precioEntrada=0;
        precioTotal=0.0;

        totales();

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
        detalles="";
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
        edtPrecio.setText(String.format("%.0f",precioTotal*10));
        Yens=precioTotal*10;
        Euros=Yens*0.00750;
        TvEuros.setText("Total de éste gasto en Euros: "+Euros+" € en: "+ detalles  );
        edtDetalle.setText(detalles);

    }
    public void verGastos(View v){
        borrar();
        Intent intent = new Intent (this, ListaActivity.class);
        startActivity(intent);
    }

    public void añadir(View v){

        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Importante");
        dialogo1.setMessage("¿ Seguro que quieres añadir el gasto ?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                if(precioTotal>0&&!detalles.equals("nul")){
                    Yens=Double.parseDouble(edtPrecio.getText().toString());
                    Euros=Yens*0.00750;
                    detalles=edtDetalle.getText().toString();
                    Calendar calendar = Calendar.getInstance();
                    DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault());
                    String fecha = formatter.format(calendar.getTime());
                    Gasto g = new Gasto (fecha,detalles,"fotoURL","vacio",Yens,Euros,0.0,0.0,0.0);
                    GestionGastos GC=new GestionGastos(ctx);
                    GC.NuevoGasto(g);
                    borrar();
                    fecha="";
                    Intent intent = new Intent (ctx, ListaActivity.class);
                    startActivity(intent);
                }else{
                    Toast toast = Toast.makeText(ctx, "no hay ningun texto, pulsa el circulo para añadir texto o hazlo a mano :D", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });
        dialogo1.show();
    }

    public void borrar(){
        //---------------------PONEMOS TOD A CERO-------------

        ChBebida.setActivated(false);
        ChComida.setActivated(false);
        ChTransporte.setActivated(false);
        ChSouvenir.setActivated(false);
        ChEntrada.setActivated(false);

        SeekBebida.setProgress(0);
        SeekComida.setProgress(0);
        SeekTransporte.setProgress(0);
        SeekSouvenir.setProgress(0);
        SeekEntrada.setProgress(0);

        TvBebida.setText("");
        TvComida.setText("");
        TvTransporte.setText("");
        TvSouvenir.setText("");
        TvEntrada.setText("");
        TvEuros.setText("");

        edtDetalle.setText("");
        edtPrecio.setText("");
        detalles="nul";
        totales();
    }
    public void borrar2(View v){
        borrar();

    }
    public void totales(){
        double Eur=GC.gastoTotalEur();
        TvTotales.setText("GASTO TOTAL: "+ String.format("%.2f",Eur)+" Eur / "+GC.gastoTotalYen()+" Yen");
    }

    public void enviarEmail(View v){
        Calendar calendar = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault());
        String fecha = formatter.format(calendar.getTime());
        //Instanciamos un Intent del tipo ACTION_SEND
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        //Definimos la tipologia de datos del contenido dle Email en este caso text/html
        emailIntent.setType("message/rfc822");
        // Indicamos con un Array de tipo String las direcciones de correo a las cuales
        //queremos enviar el texto
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"Susana_R_F@hotmail.com"});
        // Definimos un titulo para el Email
        emailIntent.putExtra(android.content.Intent.EXTRA_TITLE, "Gastos viaje a Japon");
        // Definimos un Asunto para el Email
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Gastos a fecha: "+fecha);
        // Obtenemos la referencia al texto y lo pasamos al Email Intent
        String mail=GC.gastoEmail();
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, mail);
        try {
            //Enviamos el Correo iniciando una nueva Activity con el emailIntent.
            startActivity(Intent.createChooser(emailIntent, "Enviar E-mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "No hay ningun cliente de correo instalado.", Toast.LENGTH_SHORT).show();
        }
    }


}


