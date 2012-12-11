
import java.awt.Color;
import java.awt.event.KeyListener;
import net.useobjects.draw.drawable.CircleView;
import java.awt.event.KeyEvent;
import net.useobjects.draw.drawable.GroupView;
import net.useobjects.draw.drawable.PolygonView;
import net.useobjects.draw.drawable.RectangleView;
import net.useobjects.keyboard.MultiKeyEvent;
import net.useobjects.keyboard.MultiKeyListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Macka
 */
public class Hrac implements MultiKeyListener{
    private GroupView skupina_hrac;
    private RectangleView telo;
    private GroupView nadskupina;
    //private double x;;
    //private double y;

    public Hrac(GroupView skupina, double x, double y){
        nadskupina=skupina;
        this.skupina_hrac = new GroupView(skupina,x,y);
        
        CircleView hlava = new CircleView(skupina_hrac, 0, 0, 8);
        telo = new RectangleView(skupina_hrac, 0, 15, 8, 15);
        PolygonView nohy = new PolygonView(skupina_hrac, -4, 22, 0, 0, 8, 0, 4, 8);
        
        hlava.setColor(Color.red);
        telo.setColor(Color.red);
        nohy.setColor(Color.red);
    };
    
    public void zmaz(){
        this.nadskupina.remove(skupina_hrac);
    }
    
    @Override
    public void onKeyPressed(MultiKeyEvent event) {
         final int krok =5; 
                
         if(event.contains(KeyEvent.VK_RIGHT)){
             this.skupina_hrac.move(krok, 0);
             //System.out.println(this.skupina_hrac.getPositionX());
         }
         if(event.contains(KeyEvent.VK_LEFT)){
             this.skupina_hrac.move(-krok, 0);
             //System.out.println(this.skupina_hrac.getPositionX());
         }
         if(event.contains(KeyEvent.VK_UP))
             this.skupina_hrac.move(0, -krok);
         if(event.contains(KeyEvent.VK_DOWN))
            this.skupina_hrac.move(0, krok); 
    }

    @Override
    public void onKeyReleased(MultiKeyEvent mke) {
    }
    
    public double getPositionX() {
        return this.skupina_hrac.getPositionX();
    }

    public double getPositionY() {
        return this.skupina_hrac.getPositionY();
    }
    
    
}
