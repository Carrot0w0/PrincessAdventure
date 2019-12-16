package Proyecto;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Proyecto extends MIDlet implements CommandListener{

    private Display Pantalla;
    private Command Salir, Play, Fin;
    private Animacion Ani;
    
    public Proyecto(){
        Pantalla=Display.getDisplay(this);
        Salir=new Command("Salir", Command.SCREEN, 2);
        Ani= new Animacion();
        Ani.addCommand(Salir);
        Ani.setCommandListener(this);
    }
    
    public void startApp() {
        Pantalla.setCurrent(Ani);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if(c==Salir){
            destroyApp(true);
            notifyDestroyed();
        }
    }
}
