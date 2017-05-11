import processing.core.PApplet;

public class MainAppDescifrador extends PApplet {

	private Logica log;

	public static void main(String[] args) {
		PApplet.main("MainAppDescifrador");
	}
	
	public void settings() {
		size(1020, 180);
	}

	public void setup() {
		log = new Logica(this);
	}

	public void draw() {
		log.pintar();
	}
	
	public void mouseReleased(){
		//println(mouseX, mouseY);
		log.mouseReleased();
	}

}
