package floricultura.app.app;

import javax.swing.SwingUtilities;

import floricultura.app.gui.TelaCadastro;
import floricultura.app.gui.TelaFloricultura;
import floricultura.app.gui.TelaHome;
import floricultura.app.gui.TelaInicio;

public class App {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				TelaInicio tInit = new TelaInicio();
				tInit.setVisible(true);
				//TelaHome tHome = new TelaHome();
				//tHome.setVisible(true);
				//TelaFloricultura t = new TelaFloricultura();
				
				//t.setVisible(true);
			}
		});
	}
}
