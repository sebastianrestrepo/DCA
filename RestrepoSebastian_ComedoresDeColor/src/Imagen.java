import processing.core.PApplet;
import processing.core.PImage;

public class Imagen implements Runnable {

	private Logica log;
	private PImage foto;
	private PApplet app;
	private boolean vivo;

	public Imagen(PApplet app, Logica log, PImage foto) {
		this.log = log;
		this.foto = foto;
		this.app = app;
		vivo = true;
	}

	@Override
	public void run() {
		while (vivo) {
			ponerGris();
			try {
				Thread.sleep(33);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void ponerGris() {
		foto.loadPixels();

		for (int y = 0; y < foto.height; y++) {
			for (int x = 0; x < foto.width; x++) {
				int index = x + y * foto.width;

				for (int i = 0; i < log.getC().size(); i++) {

					Comedor c = log.getC().get(i);

					float r = app.red(foto.pixels[index]);
					float g = app.green(foto.pixels[index]);
					float b = app.green(foto.pixels[index]);
					int gris = (int) (r + g + b) / 3;
					if (app.dist(c.getPosX(), c.getPosY(), x, y) < 30) {
						foto.pixels[index] = app.color(gris);
					}
				}
			}
		}
		foto.updatePixels();
		// Final del método gris
	}

	public void pintar() {
		app.image(foto, 0, -100);
	}

	// ------------------FIN DE LA CLASE IMAGEN------------------//
}
