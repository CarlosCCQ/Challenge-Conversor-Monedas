package centro;

public class Moneda {

    private String codigo_moneda;
    private double valor_moneda;

    public Moneda(String codigo_moneda, double valor_moneda) {
        this.codigo_moneda = codigo_moneda;
        this.valor_moneda = valor_moneda;
    }

    public String getCodigo_moneda() {
        return codigo_moneda;
    }
    public double getValor_moneda() {
        return valor_moneda;
    }
}
