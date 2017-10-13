package adrianarribas.travelcoin;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Adrian on 20/09/2017.
 */

/**
 * Implementa Parcelable porque es la manera de mandar datos en Android (mucho mas eficiente que
 * Serializable)
 */
public class Gasto implements Parcelable{
    String fecha;
    String compra;
    String fotourl;
    String extraString;
    Double precioyen;
    Double precioeuro;
    Double lat;
    Double lng;
    Double extraDouble;

    public Gasto(String fecha, String compra, String fotourl, String extraString, Double precioyen, Double precioeuro, Double lat, Double lng, Double extraDouble) {
        this.fecha = fecha;
        this.compra = compra;
        this.fotourl = fotourl;
        this.extraString = extraString;
        this.precioyen = precioyen;
        this.precioeuro = precioeuro;
        this.lat = lat;
        this.lng = lng;
        this.extraDouble = extraDouble;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }

    public String getFotourl() {
        return fotourl;
    }

    public void setFotourl(String fotourl) {
        this.fotourl = fotourl;
    }

    public String getExtraString() {
        return extraString;
    }

    public void setExtraString(String extraString) {
        this.extraString = extraString;
    }

    public Double getPrecioyen() {
        return precioyen;
    }

    public void setPrecioyen(Double precioyen) {
        this.precioyen = precioyen;
    }

    public Double getPrecioeuro() {
        return precioeuro;
    }

    public void setPrecioeuro(Double precioeuro) {
        this.precioeuro = precioeuro;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getExtraDouble() {
        return extraDouble;
    }

    public void setExtraDouble(Double extraDouble) {
        this.extraDouble = extraDouble;
    }


    /*
     * Implementación de Parcelable
     */
    protected Gasto(Parcel in) {
        fecha = in.readString();
        compra = in.readString();
        fotourl = in.readString();
        extraString = in.readString();
        precioyen = in.readByte() == 0x00 ? null : in.readDouble();
        precioeuro = in.readByte() == 0x00 ? null : in.readDouble();
        lat = in.readByte() == 0x00 ? null : in.readDouble();
        lng = in.readByte() == 0x00 ? null : in.readDouble();
        extraDouble = in.readByte() == 0x00 ? null : in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fecha);
        dest.writeString(compra);
        dest.writeString(fotourl);
        dest.writeString(extraString);
        if (precioyen == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(precioyen);
        }
        if (precioeuro == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(precioeuro);
        }
        if (lat == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(lat);
        }
        if (lng == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(lng);
        }
        if (extraDouble == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(extraDouble);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Gasto> CREATOR = new Parcelable.Creator<Gasto>() {
        @Override
        public Gasto createFromParcel(Parcel in) {
            return new Gasto(in);
        }

        @Override
        public Gasto[] newArray(int size) {
            return new Gasto[size];
        }
    };
}
