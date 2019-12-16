package Proyecto;

import javax.microedition.lcdui.*;

public class Movimientos{
    private int posx, posy;
    private boolean active;
    private int frame, nframes;
    private Image[] Sprite;
    
    public Movimientos(int nframes) { 
        // El Sprite no está activo por defecto. 
        active=false; 
        frame=1; 
        this.nframes=nframes; 
        Sprite=new Image[nframes+1]; 
    }
    
    public void setX(int x) { 
        posx=x; 
    } 
    
    public void setY(int y) { 
        posy=y; 
    }
    
    int getX() { 
        return posx; 
    } 
    
    int getY() { 
        return posy; 
    }
    
     int getW() { 
        return Sprite[nframes].getWidth(); 
    } 
     
    int getH() { 
        return Sprite[nframes].getHeight(); 
    }
    
    public void on() { 
        active=true; 
    } 
    
     public void off() { 
        active=false; 
    } 
     
    public boolean isActive() { 
        return active; 
    }
    
     public void selFrame(int frameno) { 
        frame=frameno; 
    }
     
    public int frames() { 
        return nframes; 
    } 
    
    public void addFrame(int frameno, String path) { 
        try { 
            Sprite[frameno]=Image.createImage(path); 
        } catch (Exception e) {} 
    }
    
     boolean collide(Movimientos sp) { 
        int w1,h1,w2,h2,x1,y1,x2,y2; 
        w1=getW();   // ancho del sprite1 
        h1=getH();   // altura del sprite1 
        w2=sp.getW();  // ancho del sprite2 
        h2=sp.getH();  // alto del sprite2 
        x1=getX();   // pos. X del sprite1 
        y1=getY();   // pos. Y del sprite1 
        x2=sp.getX();  // pos. X del sprite2 
        y2=sp.getY();  // pos. Y del sprite2 
        if (((x1+w1)>x2)&&((y1+h1)>y2)&&((x2+w2)>x1)&&((y2+h2)>y1)) { 
            return true; 
        } else { 
            return false; 
        } 
    }
     
    public void draws(Graphics g) { 
        g.drawImage(Sprite[frame],posx,posy,Graphics.HCENTER|Graphics.VCENTER); 
    } 
}
