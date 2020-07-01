package Clases;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JProgressBar;

/**
 *
 * @author IsraelCM
 */
public class cargarR extends Thread {

    JProgressBar progreso;
    public static boolean detener = false;

    public cargarR(JProgressBar progreso) {
        super();
        this.progreso = progreso;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void run()  {
//        System.out.println("1"+detener);
        for (int i = 1; i <= 30; i++) {
            if(detener){
//                System.out.println("2"+detener);
                detener = false;
                
               //stop();               
            }
//            System.out.println("3"+detener);
            //System.out.println(i);
            progreso.setValue(i);
            pausa(80);
        }
    }

    public void pausa(int mlSeg) {
        try {
            Thread.sleep(mlSeg);
        } catch (InterruptedException e) {
        }
    }
}
