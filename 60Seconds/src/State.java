
public class State {

	String state;
	int earthquake;
	int volcano;
	int bomb;
	
	public State() {
		state = "temp";
		earthquake =0;
		volcano =0;
		bomb=0;
	}
	
	public State(String s, int e, int v, int b) {
		state = s;
		earthquake = e;
		volcano = v;
		bomb = b;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getEarthquake() {
		return earthquake;
	}

	public void setEarthquake(int earthquake) {
		this.earthquake = earthquake;
	}

	public int getVolcano() {
		return volcano;
	}

	public void setVolcano(int volcano) {
		this.volcano = volcano;
	}

	public int getBomb() {
		return bomb;
	}

	public void setBomb(int bomb) {
		this.bomb = bomb;
	}
	
	
}
