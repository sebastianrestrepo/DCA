import java.util.ArrayList;
import processing.core.PApplet;

public class Mundo {

	private PApplet app;
	private int xBueno, xMalo, yBueno, yMalo;
	private Bueno bueno;
	private Malo malo;
	private Thread hiloBueno, hiloMalo;
	private Malo selector;
	

	public Mundo(PApplet app) {
		this.app = app;
		selector = null;
		xBueno = app.width/2;
		yBueno = app.height/2;
		xMalo = 100;
		yMalo = app.height/2;
		malo = new Malo(app, xMalo, yMalo, this);
		bueno = new Bueno(app, xBueno, yMalo, this);
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
	
	public void mousePressed(){
		if(malo.validar(app.mouseX, app.mouseY)){
			selector = malo;
		}
	}
	
	public void mouseDragged(){
		selector.mover(app.mouseX, app.mouseY);
	}
	
	public void mouseReleased(){
		if(selector!=null){
			selector = null;
		}
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
