
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.useobjects.draw.drawable.CircleView;
import net.useobjects.draw.drawable.GroupView;
import javax.swing.Timer;
import net.useobjects.frame.MainWindow;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Macka
 */
public abstract class Nepriatelia implements ActionListener{
    private CircleView tvar;
    private double x;
    private double y;
    public Color farba;
    private GroupView skupina;
    private MainWindow okno;
    
    public Nepriatelia(GroupView skupina, double x, double y, Color farba, MainWindow okno){
        this.skupina = skupina;
        this.x = x;
        this.y = y;
        this.farba = farba;
        tvar = new CircleView(this.skupina,x,y,10); 
        tvar.setColor(farba);
        this.okno = okno;
        Timer timer = new Timer(30, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.posun();
    }
    
    abstract public void posun();

    public CircleView getTvar() {
        return tvar;
    }

    public double getPositionX() {
        return this.tvar.getPositionX();
    }

    public double getPositionY() {
        return this.tvar.getPositionY();
    }
    
    public void zmaz(){
        this.skupina.remove(tvar);
    }

    public MainWindow getOkno() {
        return okno;
    }
    
    
}
