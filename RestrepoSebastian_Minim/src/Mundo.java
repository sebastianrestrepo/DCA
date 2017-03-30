import java.util.ArrayList;
import processing.core.PApplet;

public class Mundo {

	private PApplet app;
	Bueno bueno;
	Malo malo;
	Thread hilo;

	public Mundo(PApplet app) {
		this.app = app;
		malo = new Malo(app, 20, 100);
		bueno = new Bueno(app, 20, 100, malo);
		//bueno.start();
	}

	public void pintar() {
		app.background(30, 38, 41);
		bueno.pintar();
		malo.pintar();
	}

}
