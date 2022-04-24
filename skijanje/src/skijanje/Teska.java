package skijanje;

public class Teska extends Deonica {

	public Teska(double duzina, double nagib) {
		super(duzina, nagib);
	}

	private static final double gravUbrz = 9.81;
	
	@Override
	public char oznaka() {
		return 'T';
	}

	@Override
	public double ubrzanje() {
		return gravUbrz * Math.sin(Math.toRadians(nagib));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
