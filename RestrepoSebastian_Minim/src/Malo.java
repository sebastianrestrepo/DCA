import processing.core.PApplet;

public class Malo extends Automata {

	private Bueno b;
	private boolean vivo;

	public Malo(PApplet app, int posX, int posY){
		super(app, posX, posY);
		vivo = true;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (vivo) {
				mover();
				Thread.sleep(5);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pintar(){
		app.fill(255, 95, 94);
		app.noStroke();
		app.ellipse(posX, posY, 50, 50);
	}
	
	public void mover() {
		// TODO Auto-generated method stub
		posX += 2;
	}
	
	
}
