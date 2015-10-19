package Main;


import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class NativeKeyboard implements NativeKeyListener {
	
	public void nativeKeyPressed(NativeKeyEvent e) {
		try {
			String string = NativeKeyEvent.getKeyText(e.getKeyCode());
			System.out.println(string);
			if (string=="Haut"){
				Fenetre.change=1;
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
