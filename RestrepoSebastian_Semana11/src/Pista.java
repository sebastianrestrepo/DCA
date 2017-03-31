import java.util.ArrayList;
import processing.core.PApplet;

public class Pista {

	private PApplet app;
	private ArrayList<Automata> c;
	private int posX, posY;
	private int h, s, b;

	public Pista(PApplet app) {
		this.app = app;
		s = 100;
		b = 100;
		inicializar();
		agregar();
	}

	public void inicializar() {
		c = new ArrayList<Automata>();
		posX = 175;
		posY = 175;
	}

	public void agregar() {
		for (int i = 0; i < 4; i++) {
			h = (int) app.random(0, 365);
			Automata caballo = new Automata(posX, 60 + posY * i, h, 5, this);
			Thread hilo = new Thread(caballo);
			hilo.start();
			c.add(caballo);
		}
	}

	public void pintar() {
		pintarCaballos();
		pintarObstaculos();
	}

	public void pintarCaballos() {
		for (int i = 0; i < c.size(); i++) {
			c.get(i).pintar(app, s, b);
		}
	}

	public void pintarObstaculos() {

	}

	// FINAL DE LA CLASE LÓGICA
}
