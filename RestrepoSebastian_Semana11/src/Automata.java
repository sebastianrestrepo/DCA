import processing.core.PApplet;

public class Automata implements Runnable {

	private int posX, posY, h, vel;
	private boolean vivo;
	private Pista p;

	public Automata(int posX, int posY, int h, int vel, Pista p) {
		this.posX = posX;
		this.posY = posY;
		this.h = h;
		this.vel = vel;
		this.p = p;
		vivo = true;
	}

	public void pintar(PApplet app, int s, int b) {
		app.fill(h, s, b);
		app.ellipse(posX, posY, 30, 30);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(vivo){
				mover();
				Thread.sleep(33);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mover(){
		posX+=5;
	}

	//GETTERS Y SETTERS
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

	// GETTERS Y SETTERS

}
