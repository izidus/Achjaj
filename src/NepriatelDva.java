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
public class NepriatelDva extends Nepriatelia{
    
    public NepriatelDva(GroupView skupina, double x, double y, MainWindow okno){
        super(skupina,x,y,Color.blue, okno);
        dorobene
    }

    @Override
    public void posun() {
        //super.getTvar().move(0, 2);
        if(super.getTvar().getPositionY()< super.getOkno().getInternalHeight())
            super.getTvar().move(0,4);
        else
            super.getTvar().setPosition(super.getTvar().getPositionX(), 0);


    }
    
}
