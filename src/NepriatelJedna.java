import java.awt.Color;
import net.useobjects.draw.drawable.GroupView;
import net.useobjects.frame.MainWindow;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Macka
 */
public class NepriatelJedna extends Nepriatelia{
    
    public NepriatelJedna(GroupView skupina, double x, double y, MainWindow okno){
        super(skupina,x,y,Color.black,okno);
        
    }

    @Override
    public void posun() {
        if(super.getTvar().getPositionX()< super.getOkno().getInternalWidth())
            super.getTvar().move(5, 0);
        else
            super.getTvar().setPosition(0, super.getTvar().getPositionY());
            
            
            
            
            
            
            
            
    }
    
}
