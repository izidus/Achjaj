
import java.awt.Color;
import net.useobjects.draw.drawable.GroupView;
import net.useobjects.draw.drawable.TextView;
import net.useobjects.eventloop.MainActivity;
import net.useobjects.frame.MainWindow;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Macka
 */
public class HlavnaAkcia implements MainActivity{
    private MainWindow okno;
    private int skore_PC;
    private int skore_hrac;
    private TextView score;
    private Nepriatelia[] pole_nepriatelov;
    private Poklad[] pole_pokladov;
    private GroupView skupina;
    private Hrac hrac;
    private Skore skore;
    
    @Override
    public void onInit(){
        okno = new MainWindow("Hra", 1300, 650);
        okno.setVisible(true);
        okno.setBackground(Color.LIGHT_GRAY);
        skupina = new GroupView(okno.getRootGroup(),0,0);
        
        skore_PC=0;
        skore_hrac=0;
        this.score = new TextView(skupina,"Skore PC-"+skore_PC +"  Score hrac-"+skore_hrac, 580, 10);
        inicializacia();
        
    }
    
    public void pridajHracovi(){
        this.skore_hrac++;
        score.setText("Skore PC-"+skore_PC +"  Score hrac-"+skore_hrac);
    }
    
    public void pridajPC(){
        this.skore_PC++;
        score.setText("Skore PC-"+this.skore_PC +"  Score hrac-"+this.skore_hrac);
    }

    public MainWindow getOkno() {
        return okno;
    }

    public void inicializacia() {
        hrac = new Hrac(skupina,100,100);

        okno.addMultiKeyListener(hrac);
        pole_nepriatelov = new Nepriatelia[8];
        pole_pokladov = new Poklad[4];
        
        pridajNepriatelov();
        pridajPoklady();

        skore = new Skore(pole_nepriatelov,pole_pokladov,hrac, this);
    }
    
    public void deinicializacia(){
        this.hrac.zmaz();
        this.skore=null;
        for(int i=0;i<8;i++){
            this.pole_nepriatelov[i].zmaz();
            if(i<4)
                this.pole_pokladov[i].zmaz();
        }
        
    }
    
    public void pridajNepriatelov(){
        
        for(int i =0;i<8;i++){
            if(i%4==1)
                pole_nepriatelov[i]=new NepriatelJedna(skupina, i*150*Math.random(),i*100*Math.random(), okno);
            if(i%4==2)
                pole_nepriatelov[i]=new NepriatelDva(skupina, i*160*Math.random(),i*100*Math.random(), okno);
            if(i%4==3)
                pole_nepriatelov[i]=new NepriatelTri(skupina, i*160*Math.random(),i*100*Math.random(), okno);
            if(i%4==0)
                pole_nepriatelov[i]=new NepriatelStyri(skupina, i*180*Math.random(),i*100*Math.random()+100, okno);
        }
    }
    
    public void pridajPoklady(){
        for(int i =0;i<4;i++){
            pole_pokladov[i]=new Poklad(skupina, (Math.random()*15)*i*10+208,(Math.random()*15)*i*10+208);
        }
    }   
}
