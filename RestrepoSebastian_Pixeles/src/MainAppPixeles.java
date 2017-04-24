import processing.core.*;

public class MainAppPixeles extends PApplet {

	private int cambioPantalla;
	private int filtros;
	private PGraphics fUno;
	private PGraphics fDos;
	private PGraphics fTres;
	private PImage bandera;
	private PImage circulo;
	private PImage japon;
	private float sumX, sumY, cant;

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
		japon = loadImage("japan.png");
		bandera();
		calcularCirculo();
		calcularImagen();
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
			background(0);
			break;
		case 4:
			background(150);
			break;
		case 5:
			background(255);
			break;
		case 6:
			background(0);
			break;
		case 7:
			pintarJapon();
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
	
	public void filtros(){
		switch(filtros){
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

	// EJERCICIO SIETE
	public void calcularImagen() {
		cant = 1;
		japon.loadPixels();
		for (int y = 0; y < japon.height; y++) {
			for (int x = 0; x < japon.width; x++) {
				int i = x + (y * japon.width);
				float r = red(japon.pixels[i]);
				float g = green(japon.pixels[i]);
				float b = blue(japon.pixels[i]);
				if (r > 210 && g < 100 && b < 100) {
					sumX += x;
					sumY += y;
					cant++;
				}
			}
		}
		japon.updatePixels();
	}

	public void pintarJapon() {
		image(japon, width / 2, height / 2, japon.width, japon.height);
		noStroke();
		fill(0, 255, 0);
		ellipse(sumX / cant, sumY / cant, 30, 30);
	}

	// FINAL DE LA CLASE EJECUTABLE
}
