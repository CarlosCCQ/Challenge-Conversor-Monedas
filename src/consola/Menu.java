package consola;

import centro.Moneda;
import entidad.Data;
import logica.Convertir;
import validaciones.Validar_cantidad;

import java.util.Map;
import java.util.Scanner;

public class Menu {

    private final Data data;

    public Menu() {
        this.data = new Data("Reemplaza este testo por tu API KEY");
    }

    public void getOptions(){
        System.out.println("***********************************************");
        System.out.println("  Sea bienvenido/a al Conversor de Moneda =]");
        System.out.println("***********************************************");
        System.out.println("1) Dólar       => Peso argentino");
        System.out.println("2) Peso argentino => Dólar");
        System.out.println("3) Dólar       => Real brasileño");
        System.out.println("4) Real brasileño => Dólar");
        System.out.println("5) Dólar       => Peso colombiano");
        System.out.println("6) Peso colombiano => Dólar");
        System.out.println("7) Salir");
        System.out.println("***********************************************");
        System.out.println("Elija una opción válida:");
    }

    public void getMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean bandera = true;

        while (bandera) {
            getOptions();
            System.out.println("Ingrese una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1, 2, 3, 4, 5, 6:
                    option1(opcion);
                    break;
                case 7:
                    bandera = false;
                    System.out.println("Gracias por usar el conversor de monedas");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public void option1(int opcion) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Convertir convertir = new Convertir();
        String moneda_origen = "";
        String moneda_destino = "";

        switch (opcion) {
            case 1:
                moneda_origen = "USD";
                moneda_destino = "ARS";
                break;
            case 2:
                moneda_origen = "ARS";
                moneda_destino = "USD";
                break;
            case 3:
                moneda_origen = "USD";
                moneda_destino = "BRL";
                break;
            case 4:
                moneda_origen = "BRL";
                moneda_destino = "USD";
                break;
            case 5:
                moneda_origen = "USD";
                moneda_destino = "COP";
                break;
            case 6:
                moneda_origen = "COP";
                moneda_destino = "USD";
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        double cantidad = 0;
        do {
            System.out.println("Ingrese la cantidad de " + moneda_origen + " a convertir: ");
            cantidad = scanner.nextDouble();
        } while (!Validar_cantidad.validar_valor(cantidad));

        Map<String, Double> monedas = data.getMonedas(moneda_origen);

        double valor_moneda_origen = monedas.get(moneda_origen);
        double valor_moneda_destino = monedas.get(moneda_destino);

        Moneda moneda1 = new Moneda(moneda_origen, valor_moneda_origen);
        Moneda moneda2 = new Moneda(moneda_destino, valor_moneda_destino);

        double conversion = convertir.conversion(cantidad, moneda2.getValor_moneda(), moneda1.getValor_moneda());

        System.out.println("La conversión de " + cantidad + " " + moneda1.getCodigo_moneda() + " a " + moneda2.getCodigo_moneda() + " es: " + conversion);
    }
}
