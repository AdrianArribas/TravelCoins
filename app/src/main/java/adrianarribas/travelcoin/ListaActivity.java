package adrianarribas.travelcoin;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        ArrayList<Gasto>Gastos= new ArrayList<>();

        Gastos.add((Gasto) this.getIntent().getParcelableExtra("Gasto"));

        RecyclerView rv = (RecyclerView)findViewById(R.id.RecView);
        LinearLayoutManager llm= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RVAdapter adapter = new RVAdapter(Gastos);

        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
    }

}
