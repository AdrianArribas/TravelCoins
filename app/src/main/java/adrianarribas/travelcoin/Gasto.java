package adrianarribas.travelcoin;

/**
 * Created by Adrian on 20/09/2017.
 */

public class Gasto {
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
}
