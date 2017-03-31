import java.util.ArrayList;
import processing.core.PApplet;

public class Pista {

	private PApplet app;
	private ArrayList<Obstaculo> o;
	private int posX, posY;
	private int h, s, b;
	private ArrayList<Automata> c;
	private Automata caballo;
	private ArrayList<Thread> capsulas;

	public Pista(PApplet app) {
		this.app = app;
		s = 100;
		b = 100;
		inicializar();
		agregar();
	}

	public void inicializar() {
		c = new ArrayList<Automata>();
		capsulas = new ArrayList<Thread>();
		o = new ArrayList<Obstaculo>();
		posX = 175; 
		posY = 175;
	}

	public void agregar() {
		//Caballo
		for (int i = 0; i < 4; i++) {
			h = (int) app.random(0, 365);
			caballo = new Automata(posX, 60 + posY * i, h, 5, this);
			c.add(caballo);
		}
		
		for(int i = 0 ; i < c.size() ; i++){
			capsulas.add(new Thread(c.get(i)));
		}
		
		//obstaculos
		for (int i = 0; i < 4; i++) {
			o.add(new Obstaculo(posX + 500, 60 + posY * i));
		}
		//Final del metodo agregar
	}

	public void pintar() {
		pintarCaballos();
		pintarObstaculos();
	}

	public void clicked(){
		for (int i = 0 ; i < capsulas.size() ; i++) {
			if(capsulas.get(i).getState()==Thread.State.NEW){
				capsulas.get(i).start();
			}
		}
	}
	
	public void pintarCaballos() {
		for (int i = 0; i < c.size(); i++) {
			c.get(i).pintar(app, s, b);
		}
	}

	public void pintarObstaculos() {
		for (int i = 0; i < o.size(); i++) {
			o.get(i).pintar(app);
		}
	}
	
	//GETTERS Y SETTERS
	public ArrayList<Obstaculo> getO() {
		return o;
	}

	public void setO(ArrayList<Obstaculo> o) {
		this.o = o;
	}

	public ArrayList<Automata> getC() {
		return c;
	}

	public void setC(ArrayList<Automata> c) {
		this.c = c;
	}
	
	
	// FINAL DE LA CLASE LÓGICA
}
