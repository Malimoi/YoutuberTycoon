package Main;


import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class NativeKeyboard implements NativeKeyListener {
	
	public void nativeKeyPressed(NativeKeyEvent e) {
		try {
			String string = NativeKeyEvent.getKeyText(e.getKeyCode());
			if (string=="Gauche"){
				Fenetre.change=1;
			}else if (string=="Haut"){
				Fenetre.change=2;
			}else if (string=="Droite"){
				Fenetre.change=3;
			}else if (string=="Bas"){
				Fenetre.change=4;
			}
			
		}  catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void nativeKeyReleased(NativeKeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
