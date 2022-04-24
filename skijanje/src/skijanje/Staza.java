package skijanje;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Staza {
	
	private List<Deonica> staza = new LinkedList<>();
	private String naziv;
	
	public Staza(String naziv) {
		this.naziv = naziv;
	}
	
	public Staza dodaj(Deonica d) {
		staza.add(d);
		return this;
	}
	
	public int broj() {
		return staza.size();
	}
	
	public double duzina() {
		double suma = 0;
		for(Deonica d : staza)
			suma+=d.duzina;
		return suma;
	}
	
	public double nagib() {
		double max = this.staza.get(0).nagib();
		for(Deonica v : this.staza) {
			if(v.nagib() > max)
				max = v.nagib();
		}
		return max;
	}
	
	public char oznaka() throws GOznaka {
		if(duzina() == 0) throw new GOznaka();
		Map<Character, Integer> mapa = new HashMap<>();
		for(Deonica d : staza) {
			mapa.put(d.oznaka(), 0);
		}
		for(Deonica d : staza) {
			mapa.put(d.oznaka(), mapa.get(d.oznaka())+1);
		}
		
		int max = 0;
		char maxChar = ' ';
		for(Entry<Character, Integer> m : mapa.entrySet()) { 
			if(m.getValue() > max) {
				max = m.getValue(); maxChar = m.getKey(); 
			} 
		}
		 
		return maxChar;
	}
	
	public double brzina(double pocetna) {
		double brzina = pocetna;
		for(Deonica d : staza) {
			brzina = d.brzina(brzina);
		}
		return brzina;
	}
	
	public double vreme(double pocetna) {
		double brzina = pocetna;
		double vreme = 0;
		for(Deonica d : staza) {
			vreme += d.vreme(brzina);
			brzina = d.brzina(brzina);
		}
		return vreme;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv);
		sb.append('|');
		sb.append(broj());
		sb.append('|');
		sb.append(duzina());
		sb.append('|');
		sb.append(nagib());
		sb.append("\n[");
		int i = 0;
		for(Deonica d : staza) {
			sb.append(d);
			if(i != broj()-1)
				sb.append(',');
		}
		sb.append(']');
		return sb.toString();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
