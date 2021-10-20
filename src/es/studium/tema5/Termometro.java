package es.studium.tema5;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Termometro extends Frame implements WindowListener, ActionListener {
	private static final long serialVersionUID = 1L;
	Label etiqueta = new Label("Celsius");
	TextField Celsius = new TextField(5);
	Label etiqueta2 = new Label("Fahrenheit");
	TextField Fahrenheit = new TextField(5);
	Button btnCelFah = new Button(" Celsius a Fahrenheit ");
	Button btnFahCel = new Button(" Fahrenheit a Celsius ");

	public Termometro() {
		setLayout(new GridLayout(3, 2));
		setTitle("Conversión de temperaturas");
		add(etiqueta);
		add(Celsius);
		add(etiqueta2);
		add(Fahrenheit);
		add(btnCelFah);
		add(btnFahCel);

		// Añadir Listener a los botones
		btnCelFah.addActionListener(this);
		btnFahCel.addActionListener(this);

		// Añadir el Listener a la ventana
		addWindowListener(this);
		setSize(450, 150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Termometro();
	}
	public void actionPerformed(ActionEvent evento) {
		// Primero averiguar qué botón generó este evento
		Object boton = evento.getSource();
		float resultado;
		if (boton == btnCelFah) {
			resultado = (float) ((Float.parseFloat(Celsius.getText()) * 9.0 / 5.0) + 32.0);
			Fahrenheit.setText(Float.toString(resultado));
		} else {
			resultado = (float) (Float.parseFloat(Fahrenheit.getText()) - 32.0) * (float) (5.0 / 9.0);
			Celsius.setText(Float.toString(resultado));
		}
	}
	public void windowActivated(WindowEvent we) {
	}
	public void windowClosed(WindowEvent we) {
	}
	public void windowClosing(WindowEvent we) {
		// Llamamos al método exit de la clase System,
		// devolviendo como código de salida un 0   
		System.exit(0);
		//this.dispose();
		//this.setVisible(false);
	}
	public void windowDeactivated(WindowEvent we) {
	}
	public void windowDeiconified(WindowEvent we) {
	}
	public void windowIconified(WindowEvent we) {
	}
	public void windowOpened(WindowEvent we) {
	}
}
