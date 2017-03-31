import processing.core.PApplet;

public class MainAppSemana11 extends PApplet {

	private Pista p;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("MainAppSemana11");
	}

	public void settings() {
		size(1200, 700);
	}

	public void setup() {
		p = new Pista(this);
		colorMode(HSB, 360, 100, 100);
		noStroke();
	}

	public void draw() {
		background(59, 7, 100);
		p.pintar();
	}

	public void mousePressed() {
		p.clicked();
	}

}
