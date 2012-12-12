

Andrej izold


import net.useobjects.eventloop.EventLoop;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Macka
 */
public class Main {
    public static void main(String[] args){
        
        EventLoop eventloop = EventLoop.getInstance();
        eventloop.start(new HlavnaAkcia());
    }
}