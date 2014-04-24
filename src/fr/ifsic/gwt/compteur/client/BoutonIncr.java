package fr.ifsic.gwt.compteur.client;

import com.google.gwt.user.client.ui.Button;

public class BoutonIncr extends Button {
	
	private int incr;

	public BoutonIncr(String name, int incr) {
		// TODO Auto-generated constructor stub
		super();
		setText(name);
		this.setIncr(incr);
	}

	public int getIncr() {
		return incr;
	}

	public void setIncr(int incr) {
		this.incr = incr;
	}	

}
