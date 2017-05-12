import processing.core.PApplet;
import processing.core.PVector;

public class Agente extends Thread {

	private PApplet app;
	private Logica log;
	// private PVector pos, vel, acc;
	private int x, y, tam, estado;
	private int xDos, yDos;
	private boolean vivo;

	public Agente(int x, int y, Logica log, PApplet app) {
		this.app = app;
		this.log = log;
		this.x = x;
		this.y = y;
		// pos = new PVector(0, 0);
		tam = 10;
		vivo = true;
		estado = (int) (1 + Math.random() * 4);
	}

	@Override
	public void run() {

		try {
			while (vivo) {
				mover();
				devuelvis();
				cambioEstado();
				sleep(2);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void mover() {
		switch (estado) {
		case 1:
			x ++;
			break;
		case 2:
			x --;
			break;
		case 3:
			y ++;
			break;
		case 4:
			y --;
			break;
		}
	}

	public void cambioEstado() {
		if (app.frameCount % 15 == 0) {
			estado = (int) (1 + Math.random() * 4.9);
		}
	}

	public void devuelvis() {
		switch (estado) {
		case 1:
			if (x > 447) {
				estado = 2;
			}
			break;
		case 2:
			if (x < 5) {
				estado = 1;
			}
			break;
		case 3:
			if (y > app.height) {
				estado = 4;
			}
			break;
		case 4:
			if (y < 0) {
				estado = 3;
			}
			break;
		}
	}

	public void pintar() {
		app.noStroke();
		app.fill(255);
		app.ellipse(x, y, tam, tam);
	}

	public boolean validar(int cx, int cy) {
		return PApplet.dist(x, y, cx, cy) < tam/2;
	}

	// ------------GETTERS Y SETTERS----------//
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public int getxDos() {
		return xDos;
	}

	public void setxDos(int xDos) {
		this.xDos = xDos;
	}

	public int getyDos() {
		return yDos;
	}

	public void setyDos(int yDos) {
		this.yDos = yDos;
	}

	// -------------FINAL DE LA CLASE AGENTE-------------//
}
