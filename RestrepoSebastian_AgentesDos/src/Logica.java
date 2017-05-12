import java.util.ArrayList;
import processing.core.PApplet;

public class Logica {

	private PApplet app;
	private Imagen img;
	private ArrayList<Agente> agentes;

	public Logica(PApplet app) {
		this.app = app;
		iniciar();
	}

	public void iniciar() {
		img = new Imagen(this, app);
		agentes = new ArrayList<Agente>();
		img.start();
	}

	public void pintar() {
		img.pintar();
		for (int i = 0; i < agentes.size(); i++) {
			Agente a = agentes.get(i);
			a.pintar();
		}
	}

	public void click() {
		agentes.add(new Agente(app.mouseX, app.mouseY, this, app));
		for (int i = 0; i < agentes.size(); i++) {
			Agente a = agentes.get(i);
			if (a.getState() == Thread.State.NEW) {
				a.start();
			}
		}
	}

	// --------------GETTERS Y SETTERS------------//

	public Imagen getImg() {
		return img;
	}

	public void setImg(Imagen img) {
		this.img = img;
	}

	public ArrayList<Agente> getAgentes() {
		return agentes;
	}

	public void setAgentes(ArrayList<Agente> agentes) {
		this.agentes = agentes;
	}

	// -----------FINAL DE LA CLASE LÓGICA----------//
}
