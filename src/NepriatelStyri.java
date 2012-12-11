
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
public class NepriatelStyri extends Nepriatelia{

    public NepriatelStyri(GroupView skupina, double x, double y, MainWindow okno) {
        super(skupina, x, y, Color.MAGENTA, okno);
    }

    @Override
    public void posun() {
        if(super.getTvar().getPositionX()> 0)
            super.getTvar().move(-4, 0);
        else
            super.getTvar().setPosition(super.getOkno().getInternalWidth(), super.getTvar().getPositionY());
    }
    
}
