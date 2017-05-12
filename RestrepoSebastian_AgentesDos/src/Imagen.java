import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Imagen extends Thread {

	private PApplet app;
	private PImage img;
	private PImage imgDos;
	private boolean vivo;
	private Logica log;
	private float r, g, b;

	public Imagen(Logica log, PApplet app) {
		this.app = app;
		this.log = log;
		cargar();
		vivo = true;
	}

	public void cargar() {
		img = app.loadImage("../data/jap.jpg");
		imgDos = app.createImage(894, 700, app.RGB);
	}

	public void run() {
		try {
			while (vivo) {
				Thread.sleep(15);
				procesar();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void procesar() {
		ArrayList<Agente> rf = log.getAgentes();

		img.loadPixels();
		imgDos.loadPixels();
		// Reccorrer la imagen original
		for (int i = 0; i < rf.size(); i++) {
			Agente a = rf.get(i);
			
			for (int x = 0; x < img.width; x++) {
				for (int y = 0; y < img.height; y++) {
					int index = x + y * img.width;

	
					r = app.red(img.pixels[index]);
					g = app.green(img.pixels[index]);
					b = app.blue(img.pixels[index]);

					if (a.validar(x, y)) {
						img.pixels[index] = app.color(255);
					}

				}
			}

			for (int xDos = 0; xDos < imgDos.width; xDos++) {
				for (int yDos = 0; yDos < imgDos.height; yDos++) {
					int indexDos = xDos + yDos * imgDos.width;

					if (a.validarDos(xDos, yDos)) {
						imgDos.pixels[indexDos] = app.color(r, g, b);
					}

				}
			}

		}
		imgDos.updatePixels();
		img.updatePixels();
	}

	public void pintar() {
		app.image(img, 0, 0);
		app.image(imgDos, 447, 0);
	}

	// -----------FIN DE LA CLASE IMAGEN----------//
}
