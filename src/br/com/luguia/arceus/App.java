package br.com.luguia.arceus;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.luguia.arceus.control.ControllerGui;
import br.com.luguia.arceus.control.InterfaceController;

public class App {

	public static void main(String[] args) {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e) {
		    // handle exception
		} catch (ClassNotFoundException e) {
		    // handle exception
		} catch (InstantiationException e) {
		    // handle exception
		} catch (IllegalAccessException e) {
		    // handle exception
		}
		// Utiliza esta classe para testar a aplicação a medida que formos construíndo.
		
		InterfaceController control = new ControllerGui();
		control.inicializar();
		
		
	}

}
