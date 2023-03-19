
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;  

public class Conversor {
	private static final double soles_a_dolares =0.26;
	private static final double soles_a_euros=0.25;
	private static final double soles_a_pesoColombiano=1249.68;	
	private static final double dolar_a_soles=3.79;
	private static final double dolar_a_euros=0.94;
	private static final double dolar_a_pesoColombiano=4809.75;
	private static final double euros_a_soles=4.05;
	private static final double euros_a_dolares=1.06;
	private static final double euros_a_pesoColombiano=5090.35;
	private static final double pesoColombiano_a_soles=0.00080;
	private static final double pesoColombiano_a_dolares=0.00021;
	private static final double pesoColombiano_a_euros=0.00020;

	public static void main(String[] args) {
		JFrame frame = new JFrame("CONVERSOR DE MONEDAS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        
        JPanel panel= new JPanel();
        JLabel etiquetaCantidad = new JLabel("cantidad");
        JTextField campoCantidad= new JTextField(10);
        
        
        String[] opcionesMoneda={"Selecione Moneda","Soles","Dólares","Euros","Peso colombiano"};
        JComboBox <String> lmonedaOrigen= new JComboBox<>(opcionesMoneda);
        JComboBox<String> lmonedaDestino= new JComboBox<>(opcionesMoneda);
        JLabel etiquetaResultado= new JLabel("");
        
        JButton btnConvertir= new JButton("Convertir");
        btnConvertir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				double cantidad= Double.parseDouble(campoCantidad.getText());
				String monedaOrigen= (String)lmonedaOrigen.getSelectedItem();
				String monedaDestino= (String) lmonedaDestino.getSelectedItem();
				
				double tasaDeCambio=0.0;
				switch (monedaOrigen) {
					case "Soles":
						switch (monedaDestino) {
							case "Dólares":
								tasaDeCambio=soles_a_dolares;				
								
								break;
							case "Euros":
								tasaDeCambio=soles_a_euros;
								break;
							
							case "Peso colombiano":
								tasaDeCambio=soles_a_pesoColombiano;
								break;
		
						
						}									
						break;
						
						
					case "Dólares":
						switch (monedaDestino) {
							case "Soles":
								tasaDeCambio=dolar_a_soles;
								break;
							case "Euros":
								tasaDeCambio=dolar_a_euros;
								break;
							case "Peso colombiano":
								tasaDeCambio=dolar_a_pesoColombiano;
								break;
						}
						break;
					case "Euros":
						switch (monedaDestino) {
							case "Soles":
								tasaDeCambio=euros_a_soles;
								break;
							case "Dólares":
								tasaDeCambio=euros_a_dolares;
								break;
							case "Peso colombiano":
								tasaDeCambio=euros_a_pesoColombiano;
								break;
						}
						break;
					case "Peso colombiano":
						switch (monedaDestino) {
							case "Soles":
								tasaDeCambio=pesoColombiano_a_soles;;
								break;
							case "Euros":
								tasaDeCambio=pesoColombiano_a_euros;
								break;
							case "Dólares":
								tasaDeCambio=pesoColombiano_a_dolares;
								break;
						}
						break;

				
				}
				
				
				double resultado=cantidad*tasaDeCambio;
				
				DecimalFormat formato= new DecimalFormat("#.##");
				etiquetaResultado.setText(formato.format(cantidad)+ " "+ monedaOrigen+ " = "+ formato.format(resultado)+" "+ monedaDestino);
				
			}
		});
        

        
        
        
        panel.add(etiquetaCantidad);
        panel.add(campoCantidad);
        panel.add(lmonedaOrigen);
        panel.add(lmonedaDestino);
        panel.add(etiquetaResultado);
        panel.add(btnConvertir);
        frame.add(panel);
        frame.setVisible(true);
	}
	
	
	
	
	
	
	

}
