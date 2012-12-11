
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
public class NepriatelTri extends Nepriatelia{

    public NepriatelTri(GroupView skupina, double x, double y, MainWindow okno) {
        super(skupina, x, y, Color.GREEN, okno);
    }
    
    @Override
    public void posun() {
        //super.getTvar().move(0, -3);
        if(super.getTvar().getPositionY()> 0)
            super.getTvar().move(0, -6);
        else
            super.getTvar().setPosition(super.getTvar().getPositionX(), super.getOkno().getInternalHeight());

    }
    
}
