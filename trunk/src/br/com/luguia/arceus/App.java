package br.com.luguia.arceus;

import br.com.luguia.arceus.control.ControllerGui;
import br.com.luguia.arceus.control.InterfaceController;

public class App {

	public static void main(String[] args) {
		// Utiliza esta classe para testar a aplicação a medida que formos construíndo.
		
		InterfaceController control = new ControllerGui();
		control.inicializar();
		
		
	}

}
