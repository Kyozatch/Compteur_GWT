package fr.ifsic.gwt.compteur.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Compteur implements EntryPoint {
	
	private int cpt = 0;
	private int incr = 0;
	
	  private VerticalPanel mainPanel = new VerticalPanel();
	  private HorizontalPanel visuPanel = new HorizontalPanel();
	  private HorizontalPanel buttonPanel = new HorizontalPanel();
	  private TextBox visuCompteurTextBox = new TextBox();
	  private Button addButton = new Button("+");
	  private Button zeroButton = new Button("0");
	  private Button subButton = new Button("-");
	  private Label label = new Label("Compteur");
	  
	  // button Incrs
	  private HorizontalPanel buttonIncrPanel = new HorizontalPanel();
	  private TextBox visuIncrTextBox = new TextBox();
	  private BoutonIncr incr2Button = new BoutonIncr("Incr 2", 2);
	  private BoutonIncr incr5Button = new BoutonIncr("Incr 5", 5);
	  private BoutonIncr incr7Button = new BoutonIncr("Incr 7", 7);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		visuPanel.add(label);
		
		
		visuPanel.add(visuCompteurTextBox);
		
		buttonPanel.setSpacing(20);
		buttonPanel.add(addButton);
		buttonPanel.add(zeroButton);
		buttonPanel.add(subButton);
		
		 // button Incrs
		buttonIncrPanel.add(visuIncrTextBox);
		buttonIncrPanel.setSpacing(20);
		buttonIncrPanel.add(incr2Button);
		buttonIncrPanel.add(incr5Button);
		buttonIncrPanel.add(incr7Button);
		
		mainPanel.add(buttonIncrPanel);
		mainPanel.add(visuPanel);
		mainPanel.add(buttonPanel);
		
		
		RootPanel.get("mainCompteur").add(mainPanel);

		incr2Button.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		        incr += incr2Button.getIncr();
		        refresh();
		      }
		    });
		
		incr5Button.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  incr += incr5Button.getIncr();
		        refresh();
		      }
		    });
		
		incr7Button.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  incr += incr7Button.getIncr();
		        refresh();
		      }
		    });
		
		visuIncrTextBox.addKeyPressHandler(new KeyPressHandler() {
		      public void onKeyPress(KeyPressEvent event) {
		        if (event.getCharCode() == KeyCodes.KEY_ENTER) {
		          String newVal = visuIncrTextBox.getText();
		          incr=Integer.parseInt(newVal);
		        }
		      }
		    });
		
	    // Listen for mouse events on the Add button.
	    addButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        cpt += incr;
	        incr = 0;
	        refresh();
	      }
	    });

	    // Listen for mouse events on the Add button.
	    zeroButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        cpt = 0;
	        refresh();
	      }
	    });
	    // Listen for mouse events on the Add button.
	    subButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	    	cpt -= incr;
		    incr = 0;
		    refresh();
	      }
	    });
	    
	    // Listen for keyboard events in the input box.
	    visuCompteurTextBox.addKeyPressHandler(new KeyPressHandler() {
	      public void onKeyPress(KeyPressEvent event) {
	        if (event.getCharCode() == KeyCodes.KEY_ENTER) {
	          String newVal = visuCompteurTextBox.getText();
	          cpt=Integer.parseInt(newVal);
	        }
	      }
	    });
	    refresh();
	}
		private void refresh() {
			visuCompteurTextBox.setText(""+cpt);
			visuIncrTextBox.setText(""+incr);
		}
		
}
