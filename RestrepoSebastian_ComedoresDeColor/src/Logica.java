import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Logica {

	private PApplet app;
	private PImage foto;
	private Imagen imagen;
	private ArrayList<Comedor> c;
	private Thread capImagen;
	private ArrayList <Thread> capComedor;

	public Logica(PApplet app) {
		this.app = app;
		cargarFoto();
		iniciar();
	}

	public void cargarFoto() {
		foto = app.loadImage("jap.jpg");
	}

	public void iniciar() {
		imagen = new Imagen(app, this, foto);
		c = new ArrayList<Comedor>();
		capComedor = new ArrayList<Thread>();
		capImagen = new Thread(imagen);
		capImagen.start();
	}

	public void agregarComedores() {
		c.add(new Comedor(app.mouseX, app.mouseY, 30));
		 Thread temp = new Thread(c.get(c.size() - 1));
			if (temp.getState() == Thread.State.NEW) {
				temp.start();
				System.out.println(temp.getState());
				capComedor.add(temp);
		}
	}

	public void pintar() {
		pintarImagen();
		pintarComedor();
	}

	public void pintarImagen() {
		imagen.pintar();
	}

	public void pintarComedor() {
		for (int i = 0; i < c.size(); i++) {
			c.get(i).pintar(app);
			c.get(i).cambioEstado(app);
		}
	}

	public void click() {
		agregarComedores();
	}
	
	//GETTERS Y SETTERS


	public ArrayList<Comedor> getC() {
		return c;
	}

	public void setCapComedor(ArrayList<Thread> capComedor) {
		this.capComedor = capComedor;
	}

	// -----------------FINAL DE LA CLASE LÓGICA---------------//
}
