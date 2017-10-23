package adrianarribas.travelcoin;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Adrian on 20/09/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.visTargeta> {

    private ArrayList<Gasto> Gastos=new ArrayList<>();

    public RVAdapter(ArrayList<Gasto> Gastos){
        this.Gastos=Gastos;
    }

    @Override
    public void onBindViewHolder(visTargeta vvisTargeta, int i) {

        vvisTargeta.foto.setImageDrawable(null);
        vvisTargeta.fecha.setText("Fecha y hora: "+Gastos.get(i).getFecha());
        vvisTargeta.compra.setText("Artículo: "+Gastos.get(i).getCompra());
        vvisTargeta.cantidad.setText("Precio total: "+Gastos.get(i).getPrecioyen()+"Y / "+Gastos.get(i).getPrecioeuro()+"€");

    }

    @Override
    public int getItemCount() {
        return Gastos.size();
    }
    @Override
    public visTargeta onCreateViewHolder(ViewGroup viewgroup, int position) {
        View v= LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.cardview, viewgroup, false);
        visTargeta targ = new visTargeta(v);
        return targ;
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



    public static class visTargeta extends RecyclerView.ViewHolder{
        CardView cv;
        TextView fecha;
        TextView compra;
        TextView cantidad;
        ImageView foto;

        public visTargeta(View itemView) {
            super(itemView);
            cv=(CardView)itemView.findViewById(R.id.cv);
            fecha=(TextView)itemView.findViewById(R.id.textCardView);
            compra=(TextView)itemView.findViewById(R.id.textCardView2);
            cantidad=(TextView)itemView.findViewById(R.id.textCardView3);
            foto=(ImageView)itemView.findViewById(R.id.imageCardView);
        }
    }
}
