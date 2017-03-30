import processing.core.PApplet;

public class Bueno extends Automata {

	private Malo m;
	private boolean vivo;

	public Bueno(PApplet app, int posX, int posY, Malo m) {
		super(app, posX, posY);
		this.m = m;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (vivo) {
				mover();
				Thread.sleep(15);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pintar(){
		app.fill(113, 255, 254);
		app.noStroke();
		app.ellipse(posX, posY, 50, 50);
	}
	
	public void mover() {
		// TODO Auto-generated method stub
		posX += 2;
	}

}
