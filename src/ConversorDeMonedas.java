import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

public class ConversorDeMonedas {
    private static final double DOLAR_A_EURO = 0.84;
    private static final double DOLAR_A_LIBRA = 0.73;
    private static final double EURO_A_DOLAR = 1.19;
    private static final double EURO_A_LIBRA = 0.86;
    private static final double LIBRA_A_DOLAR = 1.38;
    private static final double LIBRA_A_EURO = 1.16;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Conversor de Monedas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel etiquetaCantidad = new JLabel("Cantidad:");
        JTextField campoCantidad = new JTextField(10);

        String[] opcionesMoneda = {"Seleccione una moneda", "Dólares", "Euros", "Libras"};
        JComboBox<String> listaMonedaOrigen = new JComboBox<>(opcionesMoneda);
        JComboBox<String> listaMonedaDestino = new JComboBox<>(opcionesMoneda);
        JLabel etiquetaResultado = new JLabel("");

        JButton botonConvertir = new JButton("Convertir");
        botonConvertir.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
                double cantidad = Double.parseDouble(campoCantidad.getText());
                String monedaOrigen = (String) listaMonedaOrigen.getSelectedItem();
                String monedaDestino = (String) listaMonedaDestino.getSelectedItem();

                double tasaDeCambio = 0.0;
                switch(monedaOrigen) {
                    case "Dólares":
                        switch(monedaDestino) {
                            case "Euros":
                                tasaDeCambio = DOLAR_A_EURO;
                                break;
                            case "Libras":
                                tasaDeCambio = DOLAR_A_LIBRA;
                                break;
                        }
                        break;
                    case "Euros":
                        switch(monedaDestino) {
                            case "Dólares":
                                tasaDeCambio = EURO_A_DOLAR;
                                break;
                            case "Libras":
                                tasaDeCambio = EURO_A_LIBRA;
                                break;
                        }
                        break;
                    case "Libras":
                        switch(monedaDestino) {
                            case "Dólares":
                                tasaDeCambio = LIBRA_A_DOLAR;
                                break;
                            case "Euros":
                                tasaDeCambio = LIBRA_A_EURO;
                                break;
                        }
                        break;
                }

                double resultado = cantidad * tasaDeCambio;
                DecimalFormat formato = new DecimalFormat("#.##");
                etiquetaResultado.setText(formato.format(cantidad) + " " + monedaOrigen + " = " + formato.format(resultado) + " " + monedaDestino);
            }
        });

        panel.add(etiquetaCantidad);
        panel.add(campoCantidad);
        panel.add(listaMonedaOrigen);
        panel.add(listaMonedaDestino);
        panel.add(botonConvertir);
        panel.add(etiquetaResultado);
        frame.add(panel);
        frame.setVisible(true);
    }
}

