
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import net.useobjects.draw.drawable.TextView;
import net.useobjects.timer.SimpleTimer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Macka
 */
public class Skore implements ActionListener{
    private Nepriatelia[] pole_nepriatelov;
    private Hrac hrac;
    private Poklad[] pole_pokladov;
   // private TextView score;
    private int pocet_objavenych;
    //private int skore_hrac;
    private HlavnaAkcia akcia;
    private Timer timer;
    
    public Skore(Nepriatelia[] pole_n, Poklad[] pole_p, Hrac hrac_n, HlavnaAkcia akcia){
       // skore_PC=0;
       // skore_hrac=0;
        this.akcia = akcia;
        pocet_objavenych = 0;
        pole_nepriatelov = pole_n;
        pole_pokladov = pole_p;
        this.hrac = hrac_n;
        System.out.println("objavene:"+pocet_objavenych+"\n+lenght:"+pole_pokladov.length+"\n");
        
        timer = new Timer(30, this);
        timer.start();
        //score = new TextView("Skore PC-"+skore_PC +"  Score hrac"+skore_hrac, 170, 10);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kontrolaNepriatelov();
        kontrolaPokladov();
    }

    private void kontrolaNepriatelov() {
        for(int i=0; i<8;i++){
            //System.out.println("Hrac:"+hrac.getPositionX()+"\nnepriatel"+i+":"+pole_nepriatelov[i].getPositionX()+"\n");
            if((hrac.getPositionX() >= pole_nepriatelov[i].getPositionX()-12 && hrac.getPositionX() <= pole_nepriatelov[i].getPositionX()+12) &&
                       (hrac.getPositionY() >= pole_nepriatelov[i].getPositionY()-12 && hrac.getPositionY() <= pole_nepriatelov[i].getPositionY()+12)){
                timer.stop();
                akcia.pridajPC();
                akcia.deinicializacia();
                SimpleTimer.sleep(1000);
                akcia.inicializacia();
            }    
        }
    }

    private void kontrolaPokladov() {
            for(int i=0; i<4;i++){
            //System.out.println("Hrac:"+hrac.getPositionX()+"\nnepriatel"+i+":"+pole_nepriatelov[i].getPositionX()+"\n");
                if(!pole_pokladov[i].isObjaveny()){
                    if((hrac.getPositionX() >= pole_pokladov[i].getPositionX()-20 && hrac.getPositionX() <= pole_pokladov[i].getPositionX()+20) &&
                        (hrac.getPositionY() >= pole_pokladov[i].getPositionY()-12 && hrac.getPositionY() <= pole_pokladov[i].getPositionY()+12)){
                        pole_pokladov[i].odober_poklad();
                        pocet_objavenych++;
                    }
                }
            }
            
            if(pocet_objavenych == pole_pokladov.length){
                //System.out.println("objavene:"+pocet_objavenych+"\n+lenght:"+pole_pokladov.length+"\n");
                timer.stop();
                akcia.pridajHracovi();
                pocet_objavenych=0;
                akcia.deinicializacia();
                SimpleTimer.sleep(1000);
                akcia.inicializacia();
            }
    }
}
