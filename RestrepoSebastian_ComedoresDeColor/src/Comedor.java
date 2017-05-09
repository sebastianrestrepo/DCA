import processing.core.PApplet;

public class Comedor implements Runnable {

	private PApplet app;
	private float posX, posY, tam;
	private int estado;
	private boolean vivo;

	public Comedor(float posX, float posY, float tam) {
		this.posX = posX;
		this.posY = posY;
		this.tam = tam;
		vivo = true;
		estado = (int) Math.random() * 3;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (vivo) {
			estado();
			devuelvis();
			try {
				Thread.sleep(33);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void pintar(PApplet app) {
		this.app = app;
		app.noStroke();
		app.fill(255, 70);
		app.ellipse(posX, posY, tam + 30, tam + 30);
		app.fill(255);
		app.ellipse(posX, posY, tam, tam);
	}

	public void cambioEstado(PApplet app) {
		this.app = app;
		if (app.frameCount % 150 == 0) {
			estado = (int) (0+Math.random() * 3);
			System.out.println(estado);
		}
	}

	public void estado() {
		switch (estado) {
		// Arriba
		case 0:
			posY-=5;
			break;
		// Abajo
		case 1:
			posY+=5;
			break;
		// Derecha
		case 2:
			posX+=5;
			break;
		// Izquierda
		case 3:
			posX-=5;
			break;
		}
	}

	public void devuelvis() {
		switch (estado) {
		// Arriba
		case 0:
			if (posY < 10)
				estado = 1;
			break;
		// Abajo
		case 1:
			if (posY > 100)
				estado = 0;
			break;
		// Derecha
		case 2:
			if (posX > 570)
				estado = 3;
			break;
		// Izquierda
		case 3:
			if (posX < 10)
				estado = 2;
			break;
		}
	}

	//GETTERS Y SETTERS
	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public float getTam() {
		return tam;
	}

	public void setTam(float tam) {
		this.tam = tam;
	}
	
	// ---------FINAL DE LA CLASE COMEDOR---------//
}
