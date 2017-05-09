import processing.core.PApplet;

public class MainAppComedores extends PApplet {

	private Logica log;
	
	public static void main(String[] args) {
		PApplet.main("MainAppComedores");
	}
	
	public void settings(){
		size(564, 700);
	}
	
	public void setup(){
		log = new Logica(this);
	}
	
	public void draw(){
		log.pintar();
	}
	
	public void mouseReleased(){
		log.click();
	}
	
}
