/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songlib;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Rayad
 */
public class DetailsPanel extends JPanel{
    
    Song[] library;
    JPanel songListAndLabel;// = new JPanel();
    JPanel songDetailsPanel;
    //not the best deisng idea but just for the gridlayout
    JPanel empty;
    //JList songList;
    JComboBox songList;
    JLabel editingLabel;
    JLabel nameLabel;
    JLabel artistLabel;
    JLabel albumLabel;
    JLabel yearLabel;
    JTextArea nameArea;
    JTextArea artistArea;
    JTextArea albumArea;
    JTextArea yearArea;
    
    public DetailsPanel(SongLib songlib){
        this.library = songlib.songlist;
        
        //setLayout(new BorderLayout());
        setLayout(new GridLayout(1,2,10,10));
        songListAndLabel = new JPanel(new BorderLayout());
        songDetailsPanel = new JPanel(new BorderLayout());
        empty = new JPanel(new BorderLayout());
        
        JPanel labelsPanel = new JPanel();
        labelsPanel.setLayout(new GridLayout(4,1,10, 10));
        JPanel areaPanel = new JPanel();
        areaPanel.setLayout(new GridLayout(4,1, 10, 10)); 
        
        songList = new JComboBox();
        //songList = new JList(library);
        //songList = new JComboBox(library);
        editingLabel = new JLabel("Edit/Add/Remove");
        editingLabel.setAlignmentX(LEFT_ALIGNMENT);
        nameLabel = new JLabel("Title: ");
        artistLabel = new JLabel("Artist: ");
        albumLabel = new JLabel("Album: ");
        yearLabel = new JLabel("Year: ");
        nameArea = new JTextArea(1,20);
        nameArea.setEditable(false);
        nameArea.setBackground(labelsPanel.getBackground());
        nameArea.setBorder(BorderFactory.createLineBorder(Color.black));
        artistArea = new JTextArea(1,20);
        artistArea.setEditable(false);
        artistArea.setBackground(labelsPanel.getBackground());
        artistArea.setBorder(BorderFactory.createLineBorder(Color.black));
        albumArea = new JTextArea(1,20);
        albumArea.setEditable(false);
        albumArea.setBackground(labelsPanel.getBackground());
        albumArea.setBorder(BorderFactory.createLineBorder(Color.black));
        yearArea = new JTextArea(1,20);
        yearArea.setEditable(false);
        yearArea.setBackground(labelsPanel.getBackground());
        yearArea.setBorder(BorderFactory.createLineBorder(Color.black));
        
        songListAndLabel.add(songList, BorderLayout.NORTH);
        songListAndLabel.add(editingLabel, BorderLayout.SOUTH);      
        
        labelsPanel.add(nameLabel);
        labelsPanel.add(artistLabel);
        labelsPanel.add(albumLabel);
        labelsPanel.add(yearLabel);
        
        areaPanel.add(nameArea);
        areaPanel.add(artistArea);
        areaPanel.add(albumArea);
        areaPanel.add(yearArea);
        
        songDetailsPanel.add(labelsPanel, BorderLayout.WEST);
        songDetailsPanel.add(areaPanel, BorderLayout.CENTER);
        
        add(songListAndLabel,BorderLayout.WEST);
        add(songDetailsPanel,BorderLayout.CENTER);
        add(empty,BorderLayout.EAST);
    }
}
