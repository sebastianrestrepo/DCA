import processing.core.PApplet;
import processing.core.PImage;

public class Logica {
	
	private PApplet app;
	private PImage img;
	private Imagen imagen;
	private Thread cap;
	
	public Logica(PApplet app){
		this.app = app;
		cargar();
		iniciar();
	}

	public void cargar(){
		img = app.loadImage("../data/imagen.png");
	}
	
	public void iniciar(){
		imagen = new Imagen(app, img);
		cap = new Thread(imagen);
		cap.start();
	}
	
	public void pintar() {
		imagen.pintar();
	}
	
	public void mouseReleased(){
		imagen.sumarAncho();
	}
	
	
	//---------------FINAL DE LA CLASE LÓGICA--------------//
}
