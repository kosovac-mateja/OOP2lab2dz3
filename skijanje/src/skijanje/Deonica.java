package skijanje;

public abstract class Deonica {
	
	protected double duzina;
	protected double nagib;
	
	public Deonica(double duzina, double nagib) {
		super();
		this.duzina = duzina;
		this.nagib = nagib;
	}

	public double duzina() {
		return duzina;
	}

	public double nagib() {
		return nagib;
	}
	
	public abstract char oznaka();
	
	public abstract double ubrzanje();
	
	public double brzina(double pocetna) {
		return Math.sqrt(2*ubrzanje()*duzina+pocetna*pocetna);
	}
	
	public double vreme(double pocetna) {
		return(brzina(pocetna)-pocetna)/ubrzanje();
	}

	@Override
	public String toString() {
		return oznaka()+"("+duzina+","+nagib+")";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
