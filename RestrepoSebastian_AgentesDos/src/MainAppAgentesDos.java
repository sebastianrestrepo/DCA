import processing.core.PApplet;

public class MainAppAgentesDos extends PApplet {

	private Logica log;

	public static void main(String[] args) {
		PApplet.main("MainAppAgentesDos");
	}

	public void settings() {
		size(894, 690);
	}

	public void setup() {
		log = new Logica(this);
	}

	public void draw() {
		log.pintar();
	}

	public void mouseReleased(){
		log.click();
	}
	
}