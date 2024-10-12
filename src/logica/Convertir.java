package logica;

public class Convertir {

    public double conversion(double cantidad_monedas, double valor_destino, double valor_origen){
        return cantidad_monedas * (valor_destino / valor_origen);
    }
}
