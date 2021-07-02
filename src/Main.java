import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Main implements NativeKeyListener{
	
	public static void main(String[] args)
	{
		
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GlobalScreen.addNativeKeyListener(new Main());
		
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.WARNING);

		// Don't forget to disable the parent handlers.
		logger.setUseParentHandlers(false);
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Pressed: " + NativeKeyEvent.getKeyText(arg0.getKeyCode()));
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("Released: " + NativeKeyEvent.getKeyText(arg0.getKeyCode()));
		
		if(NativeKeyEvent.getKeyText(arg0.getKeyCode()) == "Shift")
		{
			System.out.println("Shift released");
		}
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
