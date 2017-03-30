import processing.core.PApplet;

public class Bueno extends Automata {

	private Mundo m;
	private boolean vivo;
	private int mover;
	private int huir;

	public Bueno(PApplet app, int posX, int posY, Mundo m) {
		super(app, posX, posY);
		this.m = m;
		vivo = true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (vivo) {
				Malo refMalo = m.getMalo();
				mover = (int) app.random(0, 3);
				//mover();
				if ((app.dist(posX, posY, refMalo.getPosX(), refMalo.getPosY()) < 20)) {
					huir();
				}
				Thread.sleep(33);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pintar() {
		app.fill(113, 255, 254);
		app.noStroke();
		app.ellipse(posX, posY, 50, 50);
	}

	public void mover() {
		// TODO Auto-generated method stub
		switch (mover) {
		case 0:
			posX += 5;
			posY = posY;
			break;
		case 1:
			posX -= 2;
			posY = posY;
			break;
		case 2:
			posY += 5;
			posX = posX;
			break;
		case 3:
			posY -= 2;
			posX = posX;
			break;
		}
	}

	public void huir() {
		switch (huir) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		}
	}

}
