import java.util.ArrayList;

import processing.core.PApplet;

public class Automata implements Runnable {

	private int posX, posY, h, s, vel;
	private int tamX, tamY;
	private boolean vivo;
	private Pista p;

	public Automata(int posX, int posY, int h, int vel, Pista p) {
		this.posX = posX;
		this.posY = posY;
		this.h = h;
		this.vel = vel;
		this.p = p;
		tamX = 30;
		tamY = 30;
		vivo = true;
	}

	public void pintar(PApplet app, int s, int b) {
		this.s = s;
		app.fill(h, s, b);
		app.ellipse(posX, posY, tamX, tamY);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (vivo) {
				mover();
				ArrayList<Obstaculo> refObs = p.getO();
				for (int i = 0; i < refObs.size(); i++) {
					Obstaculo obs = refObs.get(i);
					if (PApplet.dist(obs.getPosX(), obs.getPosY(), posX, posY) < 10) {
						restar();
					}
				}
				Thread.sleep(33);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mover() {
		posX += vel;
		if (posX > 1100) {
			if (vel > 0) {
				vel--;
			}
		}
	}

	public void restar() {
		int restar = 1 + ((int) (Math.random() * 3));
		switch (restar) {
		case 1:
			tamX = 10 + ((int) (Math.random() * 25));
			tamY = tamX;
			break;
		case 2:
			vel = 2 + ((int) (Math.random() * 3));
			break;
		case 3:
			s = 80 + ((int) (Math.random() * 100));
			break;
		}

	}

	// GETTERS Y SETTERS
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}

	// FINAL DE LA CLASE AUTOMATA
}
