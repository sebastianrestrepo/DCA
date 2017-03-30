import processing.core.PApplet;

public class Bueno extends Automata {

	private Mundo m;
	private boolean vivo;

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
				if (!(app.dist(posX, posY, refMalo.getPosX(), refMalo.getPosY()) < 20)) {
					mover();	
				}else{
					vivo = false;
				}
				Thread.sleep(10);
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
		posX += 2;
	}

}
