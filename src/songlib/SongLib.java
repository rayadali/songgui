/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songlib;

import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author Rayad
 */
public class SongLib extends JFrame{
    
    Song[] songlist;
    DetailsPanel detPanel;
    
    
    public SongLib(String title){
        super(title);
        
        detPanel = new DetailsPanel(this);
        setLayout(new FlowLayout());
        add(detPanel);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final SongLib win = new SongLib("Song Library Simulator");
        win.setDefaultCloseOperation(EXIT_ON_CLOSE);
        win.setSize(965,596);
        win.setLocationRelativeTo(null);
        win.setVisible(true);	
    }
    
}
