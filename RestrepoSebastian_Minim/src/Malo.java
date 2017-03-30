import processing.core.PApplet;

public class Malo extends Automata {

	private Mundo m;
	private boolean vivo;

	public Malo(PApplet app, int posX, int posY, Mundo m){
		super(app, posX, posY);
		this.m = m;
		vivo = true;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (vivo) {
				Thread.sleep(5);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean validar(int cx, int cy){
		return PApplet.dist(cx, cy, posX, posY) < 30;
	}
	
    public void mover(int posX, int posY){
    this.posX = posX;
    this.posY = posY;
    }
	
	public void pintar(){
		app.fill(255, 95, 94);
		app.noStroke();
		app.ellipse(posX, posY, 50, 50);
	}
	
	
	
}
