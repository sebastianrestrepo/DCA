import ddf.minim.AudioPlayer;
import ddf.minim.AudioSample;
import ddf.minim.Minim;
import processing.core.PApplet;

public class MainApp extends PApplet {

	Mundo mundo;
	Minim minim;
	AudioSample sample, sampleA;
	AudioPlayer cancion;

	public static void main(String[] args) {
		PApplet.main("MainApp");
	}

	@Override
	public void settings() {
		size(1400, 700);
	}

	@Override
	public void setup() {
		mundo = new Mundo(this);
		minim = new Minim(this);
		sample = minim.loadSample("../data/BD.mp3", 512);
		cancion = minim.loadFile("../data/marcus_kellis_theme.mp3");
		// cancion.play();
	}

	@Override
	public void draw() {
		mundo.pintar();
	}

	@Override
	public void keyPressed() {
		sample.trigger();
	}

	public void mousePressed() {
		mundo.mousePressed();
	}

	public void mouseDragged() {
		mundo.mouseDragged();
	}

	public void mouseReleased() {
		mundo.mouseReleased();
	}
}
