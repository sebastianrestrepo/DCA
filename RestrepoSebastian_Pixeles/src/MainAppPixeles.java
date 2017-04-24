import processing.core.*;

public class MainAppPixeles extends PApplet {

	private int cambioPantalla;
	private int filtros;
	private PGraphics fUno;
	private PGraphics fDos;
	private PGraphics fTres;
	private PImage bandera;
	private PImage circulo;
	private PImage oso, pajaro, destination;
	private PImage japon;
	private PImage olympics;
	private int oxMin, oyMin, oxMax, oyMax;
	private int oxMinr, oyMinr, oxMaxr, oyMaxr;
	private int oxMing, oyMing, oxMaxg, oyMaxg;
	private int oxMinb, oyMinb, oxMaxb, oyMaxb;
	private int oxMiny, oyMiny, oxMaxy, oyMaxy;
	private PImage chromaUno, chromaDos;
	private float sumX, sumY, cant, xMin, yMin, xMax, yMax;

	public static void main(String[] args) {
		PApplet.main("MainAppPixeles");
	}

	public void settings() {
		size(600, 600);
	}

	public void setup() {
		fUno = createGraphics(600, 600);
		fDos = createGraphics(600, 600);
		fTres = createGraphics(600, 600);
		bandera = createImage(200, 200, RGB);
		circulo = createImage(width, height, RGB);
		japon = loadImage("japan.jpg");
		olympics = loadImage("olympics.png");
		chromaUno = loadImage("chromaUno.jpg");
		chromaDos = loadImage("chroma2.jpg");
		oso = loadImage("oso.jpg");
		pajaro = loadImage("pajaro.jpg");
		destination = createImage(pajaro.width, pajaro.height, RGB);
		bandera();
		calcularCirculo();
		calcularImagen();
		calcularCentroides();
		calculoChroma();
	}

	public void draw() {
		pantallas();
	}

	public void keyReleased() {
		tecla();
	}

	public void mouseReleased() {
		cambioFiltro();
	}

	// CAMBIO DE PANTALLAS
	public void pantallas() {
		switch (cambioPantalla) {
		// EJERCICIO UNO
		case 0:
			background(255);
			dibujarElipse();
			botones();
			break;
		case 1:
			background(0);
			pintarBandera();
			break;
		case 2:
			background(255);
			pintarCirculo();
			break;
		case 3:
			calcularThreshold();
			break;
		case 4:
			calcularGris();
			break;
		case 5:
			calcularMatriz();
			break;
		case 6:
			pintarJapon();
			break;
		case 7:
			pintarCentroides();
			break;
		case 8:
			pintarChroma();
			break;
		}
	}

	public void tecla() {
		// Ir a la derecha
		if (keyCode == RIGHT) {
			cambioPantalla++;
		}
		// Ir a la izquierda
		if (keyCode == LEFT) {
			cambioPantalla--;
		}
	}

	// EJERCICIO UNO

	public void botones() {
		ellipse((width / 2) / 2, 500, 30, 30);
		ellipse(width / 2, 500, 30, 30);
		ellipse(width / 2 + (width / 2) / 2, 500, 30, 30);
	}

	public void dibujarElipse() {
		fUno.beginDraw();
		fUno.noStroke();
		fUno.fill(255, 187, 90);
		fUno.ellipse(width / 2, height / 2, 300, 300);
		fUno.endDraw();
		filtros();
		image(fUno, 0, 0);
	}

	public void filtros() {
		switch (filtros) {
		case 1:
			fUno.filter(BLUR, 3);
			break;
		case 2:
			fUno.filter(GRAY);
			break;
		case 3:
			fUno.filter(INVERT);
			break;
		}
	}

	public void cambioFiltro() {
		// Filtro Uno
		if (dist(mouseX, mouseY, (width / 2) / 2, 500) < 15) {
			filtros = 1;
		}
		// Filtro Dos
		if (dist(mouseX, mouseY, (width / 2), 500) < 15) {
			filtros = 2;
		}
		// Filtro Tres
		if (dist(mouseX, mouseY, width / 2 + (width / 2) / 2, 500) < 15) {
			filtros = 3;
		}
	}

	// EJERCICIO DOS
	public void bandera() {
		bandera.loadPixels();
		// Color Amarillo
		int mitadImagen = bandera.width * bandera.height / 2;
		for (int i = 0; i < mitadImagen; i++) {
			bandera.pixels[i] = color(255, 211, 66);
		}
		// Color Azul
		for (int i = mitadImagen; i < mitadImagen + mitadImagen / 2; i++) {
			bandera.pixels[i] = color(23, 117, 255);
		}
		// Color Rojo
		for (int i = mitadImagen + mitadImagen / 2; i < bandera.pixels.length; i++) {
			bandera.pixels[i] = color(255, 38, 30);
		}
		bandera.updatePixels();
	}

	public void pintarBandera() {
		imageMode(CENTER);
		image(bandera, width / 2, height / 2);
	}

	// EJERCICIO TRES
	public void calcularCirculo() {
		circulo.loadPixels();
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				float d = dist(x, y, width / 2, height / 2);
				circulo.pixels[x + y * width] = color(d);
			}
		}
		circulo.updatePixels();
	}

	public void pintarCirculo() {
		image(circulo, width / 2, height / 2);
	}

	// EJERCICIO CUATRO
	public void calcularThreshold() {
		float threshold = 167;

		pajaro.loadPixels();
		destination.loadPixels();

		for (int x = 0; x < pajaro.width; x++) {
			for (int y = 0; y < pajaro.height; y++) {

				int loc = x + y * pajaro.width;

				if (brightness(pajaro.pixels[loc]) > threshold) {
					destination.pixels[loc] = color(255);
				} else {
					destination.pixels[loc] = color(0);
				}
			}
		}

		destination.updatePixels();
		image(destination, width/2, height/2);

	}
	
	//EJERCICIO CINCO
	public void calcularGris(){
		oso.loadPixels();
		for (int x = 0; x < oso.width; x++) {
			for (int y = 0; y < oso.height; y++) {

				int i = x + y * oso.width;
				float r = red(oso.pixels[i]);
				float g = green(oso.pixels[i]);
				float b = blue(oso.pixels[i]);
				int gris = (int) ((r + g + b) / 3);

				oso.pixels[i] = color(gris, gris, gris);
			}

			oso.updatePixels();
			image(oso, width/2, height/2);
		}
	}

	// EJERCICIO SEIS
	public void calcularMatriz() {
		for (int i = 0; i < 1000; i++) {
			int x = (int) random(width);
			int y = (int) random(height);
			noStroke();
			fill(pajaro.get(x, y));
			ellipse(x, y, 5, 5);
		}
	}

	// EJERCICIO SIETE
	public void calcularImagen() {
		cant = 1;
		japon.loadPixels();
		xMin = japon.width;
		yMin = japon.height;
		xMax = 0;
		yMax = 0;
		for (int y = 0; y < japon.height; y++) {
			for (int x = 0; x < japon.width; x++) {
				int i = x + (y * japon.width);
				float r = red(japon.pixels[i]);
				float g = green(japon.pixels[i]);
				float b = blue(japon.pixels[i]);
				if (r == 255 && g == 0 && b == 0) {
					if (x < xMin) {
						xMin = x;
					}
					if (y < yMin) {
						yMin = y;
					}
					if (x > xMax) {
						xMax = x;
					}
					if (y > yMax) {
						yMax = y;
					}
				}
				//
			}
		}
		japon.updatePixels();
	}

	public void pintarJapon() {
		image(japon, width / 2, height / 2, japon.width, japon.height);
		noStroke();
		fill(0, 255, 0);
		ellipse(xMin + (xMax - xMin) / 2, yMin + (yMax - yMin) / 2, 30, 30);
	}

	// EJERCICIO OCHO
	public void calcularCentroides() {
		olympics.loadPixels();
		oxMin = 600;
		oyMin = 600;
		oxMax = 0;
		oyMax = 0;

		oxMinr = 600;
		oyMinr = 600;
		oxMaxr = 0;
		oyMaxr = 0;

		oxMing = 600;
		oyMing = 600;
		oxMaxg = 0;
		oyMaxg = 0;

		oxMinb = 600;
		oyMinb = 600;
		oxMaxb = 0;
		oyMaxb = 0;

		oxMiny = 600;
		oyMiny = 600;
		oxMaxy = 0;
		oyMaxy = 0;

		for (int y = 0; y < olympics.height; y++) {
			for (int x = 0; x < olympics.width; x++) {

				int i = x + (y * olympics.width);

				float r = red(olympics.pixels[i]);
				float g = green(olympics.pixels[i]);
				float b = blue(olympics.pixels[i]);

				if (r == 0 && g == 0 && b == 0) {

					if (x < oxMin) {
						oxMin = x;
					}
					if (y < oyMin) {
						oyMin = y;
					}
					if (x > oxMax) {
						oxMax = x;
					}
					if (y > oyMax) {
						oyMax = y;
					}

				}

				if (r == 255 && g == 0 && b == 0) {

					if (x < oxMinr) {
						oxMinr = x;
					}
					if (y < oyMinr) {
						oyMinr = y;
					}
					if (x > oxMaxr) {
						oxMaxr = x;
					}
					if (y > oyMaxr) {
						oyMaxr = y;
					}

				}

				if (r == 0 && g == 255 && b == 0) {

					if (x < oxMing) {
						oxMing = x;
					}
					if (y < oyMing) {
						oyMing = y;
					}
					if (x > oxMaxg) {
						oxMaxg = x;
					}
					if (y > oyMaxg) {
						oyMaxg = y;
					}

				}
				if (r == 0 && g == 0 && b == 255) {

					if (x < oxMinb) {
						oxMinb = x;
					}
					if (y < oyMinb) {
						oyMinb = y;
					}
					if (x > oxMaxb) {
						oxMaxb = x;
					}
					if (y > oyMaxb) {
						oyMaxb = y;
					}

				}

				if (r == 255 && g == 255 && b == 0) {

					if (x < oxMiny) {
						oxMiny = x;
					}
					if (y < oyMiny) {
						oyMiny = y;
					}
					if (x > oxMaxy) {
						oxMaxy = x;
					}
					if (y > oyMaxy) {
						oyMaxy = y;
					}

				}
			}

		}
		olympics.updatePixels();
	}

	public void pintarCentroides() {
		image(olympics, width / 2, height / 2);

		fill(0, 0, 0);
		ellipse(xMin + (xMax - xMin) / 2, yMin + (yMax - yMin) / 2, 10, 10);

		fill(255, 0, 0);
		ellipse(oxMinr + (oxMaxr - oxMinr) / 2, oyMinr + (oyMaxr - oyMinr) / 2, 10, 10);

		fill(0, 255, 0);
		ellipse(oxMing + (oxMaxg - oxMing) / 2, oyMing + (oyMaxg - oyMing) / 2, 10, 10);

		fill(0, 0, 255);
		ellipse(oxMinb + (oxMaxb - oxMinb) / 2, oyMinb + (oyMaxb - oyMinb) / 2, 10, 10);

		fill(255, 255, 0);
		ellipse(oxMiny + (oxMaxy - oxMiny) / 2, oyMiny + (oyMaxy - oyMiny) / 2, 10, 10);
	}

	// EJERCICIO NUEVE
	public void calculoChroma() {
		chromaDos.loadPixels();
		for (int y = 0; y < chromaDos.height; y++) {
			for (int x = 0; x < chromaDos.width; x++) {
				int i = x + (y * chromaDos.width);

				float r = red(chromaDos.pixels[i]);
				float g = green(chromaDos.pixels[i]);
				float b = blue(chromaDos.pixels[i]);

				if (r < 150 && g > 150 && b < 150) {
					chromaDos.pixels[i] = color(0, 0, 255, 1);
				}

			}
		}
		chromaDos.updatePixels();
	}

	public void pintarChroma() {
		image(chromaUno, width / 2, height / 2);
		image(chromaDos, width / 2, height / 2);
	}

	// FINAL DE LA CLASE EJECUTABLE
}
