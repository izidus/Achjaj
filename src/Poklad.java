
import java.awt.Color;
import net.useobjects.draw.drawable.GroupView;
import net.useobjects.draw.drawable.RectangleView;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Macka
 */
public class Poklad {
    private RectangleView poklad;
    private double x;
    private double y;
    private boolean objaveny;
    private GroupView skupina;
    
    public Poklad(GroupView skupina, double x, double y){
        this.skupina = skupina;
        this.x = x;
        this.y = y;
        poklad = new RectangleView(this.skupina, x, y, 50, 20);   
        poklad.setColor(Color.yellow);
        this.objaveny = false;
    }

    public double getPositionX() {
        return x;
    }

    public double getPositionY() {
        return y;
    }
    
    public void odober_poklad(){
        this.skupina.remove(poklad);
        this.objaveny = true;
    }

    public boolean isObjaveny() {
        return objaveny;
    }
    
    public void zmaz(){
        this.skupina.remove(poklad);
    }
    
}
