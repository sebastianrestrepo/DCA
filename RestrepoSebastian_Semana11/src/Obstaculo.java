import processing.core.PApplet;

public class Obstaculo {

	private int posX, posY, tamX, tamY;
	
	public Obstaculo(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}
	
	public void pintar(PApplet app) {
		// TODO Auto-generated method stub
		app.rectMode(app.CENTER);
		app.fill(25, 84, 20);
		app.rect(posX, posY, 20, 40);
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

	public int getTamX() {
		return tamX;
	}

	public void setTamX(int tamX) {
		this.tamX = tamX;
	}

	public int getTamY() {
		return tamY;
	}

	public void setTamY(int tamY) {
		this.tamY = tamY;
	}

	//FINAL DE LA CLASE OBSTACULO
}
