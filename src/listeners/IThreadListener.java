package listeners;

import event.PanelEvent;

public interface IThreadListener {

	// Peut etre aussi un String en Parametre
	public void ilYAUnMessage(PanelEvent e);
	
	public void afficherCoord(PanelEvent e);
}
