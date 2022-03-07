package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {

	private List<Voto> voti;
	
	public Libretto() {
		
		voti = new ArrayList<Voto>();
	}
	
	public void add(Voto v) {
		voti.add(v);
	}
	
	public Libretto filtraPunti(int punti) {
		Libretto result = new Libretto();
		
		for(Voto v : voti)
			if(v.getPunti()==punti)
				result.add(v);
		
		return result;
	}
	
	/**
	 * Restituisce il punteggio ottenuto all'esame di cui specifico il nome
	 * @param nome Nome dell'esame
	 * @return punteggio numerico, oppure {@code null} se l'esame non esiste
	 */
	public Integer puntiEsame(String nome) {
		
		for(Voto v : voti)
			if(v.getNome().equals(nome))
				return v.getPunti();
		
		return null;
//		throw new IllegalArgumentException("Corso non trovato");
	}
	
	public boolean isDuplicato(Voto v) {
	
		for(Voto v1 : voti)
			if(v1.equals(v))
				return true;
		
		return false;
	}
	
	public boolean isConflitto(Voto v) {
		Integer punti = puntiEsame(v.getNome());
		
		if(punti != null && v.getPunti()!=punti)
			return true;
		else
			return false;
		
	}
	
	public String toString() {
		return voti.toString();
	}
	
	
}
