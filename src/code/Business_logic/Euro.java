package code.Business_logic;
public class Euro {


	private long valore;

	public Euro(long euro, long cent) {
		if (euro >= 0) {
			valore = euro*100 + cent;
		} else {
			valore = euro*100 - cent;
		}
	}

	public Euro(Euro d) {
		valore = (d.getValore()*100);
	}

	public long getValore() {
		return valore;
	}

	public Euro somma(Euro e) {
		this.valore = this.valore + e.getValore();
		return this;
	}

	public Euro sottrai(Euro e) {
		this.valore = this.valore - e.getValore();
		return this;
	}

	public boolean ugualeA(Euro e){
		if (valore == e.getValore())
			return true;
		else return false;
	}
	
	public boolean minoreDi(Euro e){
		if (valore <= e.getValore())
			return true;
		else return false;
	}

	public String stampa(){
		return getValore()/100 +" euro";
	}
}