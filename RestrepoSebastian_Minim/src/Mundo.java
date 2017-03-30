import java.util.ArrayList;
import processing.core.PApplet;

public class Mundo {

	private PApplet app;
	Bueno bueno;
	Malo malo;
	Thread hiloBueno, hiloMalo;

	public Mundo(PApplet app) {
		this.app = app;
		malo = new Malo(app, 10, app.height/2);
		bueno = new Bueno(app, app.width/2, app.height/2, this);
		hiloBueno = new Thread(bueno);
		hiloMalo = new Thread(malo);
		hiloBueno.start();
		hiloMalo.start();
	}

	public void pintar() {
		app.background(30, 38, 41);
		bueno.pintar();
		malo.pintar();
	}

	//GETTERS Y SETTERS
	public Bueno getBueno() {
		return bueno;
	}

	public void setBueno(Bueno bueno) {
		this.bueno = bueno;
	}

	public Malo getMalo() {
		return malo;
	}

	public void setMalo(Malo malo) {
		this.malo = malo;
	}
	
}
