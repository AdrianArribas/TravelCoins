package adrianarribas.travelcoin;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by shish on 17/10/2017.
 */

public class GestionGastos {
    private Helper helper;
    private SQLiteDatabase BD;
    public GestionGastos (Context ctx){
        helper=new Helper(ctx,"Gastos");
        BD=helper.getWritableDatabase();
    }
    public void NuevoGasto(Gasto G){
        String sql= "insert into gastos (fecha,compra,fotourl,extrastring,precioyen,precioeuro,lat,lng,extradouble)";
        sql+="values('"+G.getFecha()+"','"+G.getCompra()+"','nulo','nulo','"+G.getPrecioyen()+"','"+G.getPrecioeuro()+"','0.0','0.0','0.0')";
        BD.execSQL(sql);
    }
    public ArrayList<Gasto> obtenerGastos() {
        String sql = "select * from gastos";
        Cursor c = BD.rawQuery(sql, null);
        Gasto G = null;
        ArrayList<Gasto> AR = new ArrayList<>();
        //si se ha encontrado el libro, habrá una fila y creamos
        //un objeto Libro con los datos de esa fila
        while (c.moveToNext()) {
            G = new Gasto(c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getDouble(5), c.getDouble(6), c.getDouble(7), c.getDouble(8), c.getDouble(9));
            AR.add(G);
        }

        return AR;
    }

    public ArrayList<Gasto> calGasto(){
        ArrayList<Gasto> AR = new ArrayList<>();
        String sql = "select * from gastos";
        Cursor c = BD.rawQuery(sql, null);
        Gasto G = null;
        while (c.moveToNext()) {
            G = new Gasto(c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getDouble(5), c.getDouble(6), c.getDouble(7), c.getDouble(8), c.getDouble(9));
            AR.add(G);
        }
        return AR;
    }
    public double gastoTotalEur() {
        ArrayList<Gasto> AR;
        AR=this.calGasto();
        double TotalEur=0.0;
        for (int i=0;i<AR.size();i++){
            TotalEur=TotalEur+AR.get(i).getPrecioeuro();
        }
        return TotalEur;
    }
    public double gastoTotalYen() {
        ArrayList<Gasto> AR;
        AR=this.calGasto();
        double TotalYen=0.0;
        for (int i=0;i<AR.size();i++){
            TotalYen=TotalYen+AR.get(i).getPrecioyen();
        }
        return TotalYen;
    }


    public void borrarGasto(String compra, double precioyen){
        String sql="delete from gastos where compra='"+compra+"' and precioyen='"+precioyen+"'";
    }
    public String gastoEmail(){
        double eurostotal=0.0;
        String mail="";
        ArrayList<Gasto> AR;
        AR=this.obtenerGastos();
        for (int i=0;i<AR.size();i++){
            eurostotal+=AR.get(i).getPrecioeuro();
            mail+="Compra N:"+i+" / Fecha: "+AR.get(i).getFecha()+" | Detalles: "+ AR.get(i).getCompra()+" | Total Yens: "+AR.get(i).getPrecioyen()+"Y | Total Euros:"+AR.get(i).getPrecioeuro()+"€ | Total viaje"+eurostotal+"\n";
        }
        return mail;
    }

    /*String creaTablaSql="create table gastos (";
        creaTablaSql+="_id integer primary key autoincrement,";
        creaTablaSql+="compra text,";
        creaTablaSql+="fotourl text";
        creaTablaSql+="extraString text";
        creaTablaSql+="precioyen double";
        creaTablaSql+="precioeuro double";
        creaTablaSql+="lat double";
        creaTablaSql+="lng double";
        creaTablaSql+="extradouble double";*/
}
