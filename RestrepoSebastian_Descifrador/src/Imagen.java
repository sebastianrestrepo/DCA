import processing.core.PApplet;
import processing.core.PImage;

public class Imagen implements Runnable {

	private PApplet app;
	private PImage imagen;
	private int fA, fB, fC, fD;
	private int mA, mB, mC, mD;
	private int sumAncho;

	public Imagen(PApplet app, PImage imagen) {
		this.app = app;
		this.imagen = imagen;
		fA = app.color(255, 180, 0);
		fB = app.color(180, 100, 0);
		fC = app.color(200, 20, 0);
		fD = app.color(100, 120, 0);
		//
		mA = app.color(255, 30, 0);
		mB = app.color(180, 30, 0);
		mC = app.color(200, 180, 0);
		mD = app.color(200, 80, 0);
		sumAncho = 0;
	}

	@Override
	public void run() {
		try {
			procesar();
			Thread.sleep(15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void sumarAncho() {
		if (sumAncho <= imagen.width) {
			sumAncho += 102;
		}
		System.out.println(sumAncho);
	}

	public void procesar() {
		imagen.loadPixels();
		for (int x = 0; x < sumAncho; x++) {
			for (int y = 0; y < imagen.height; y++) {
				int index = x + y * imagen.width;
				int r = (int) app.red(imagen.pixels[index]);
				int g = (int) app.green(imagen.pixels[index]);
				int b = (int) app.blue(imagen.pixels[index]);
				if ((r + g + b) == fA) {
					fA = fA / 3;
					imagen.pixels[index] = app.color(fA);
					System.out.println(fA);
				}
			}
		}
		imagen.updatePixels();
	}

	public void pintar() {
		app.image(imagen, 0, 0);
	}

	// ----------FINAL DE LA CLASE IMAGEN-----------//
}
