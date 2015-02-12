/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songlib;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Rayad
 */
public class DetailsPanel extends JPanel implements ListSelectionListener{
    
    SongLib songlib;
    DefaultListModel library;
    JPanel songListAndLabel;// = new JPanel();
    JPanel songDetailsPanel;
    //not the best design idea but just for the gridlayout
    JPanel empty;
    JList songList;
    //JComboBox songList;
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
        this.songlib = songlib;
        
        //setLayout(new BorderLayout());
        setLayout(new GridLayout(1,2,10,10));
        songListAndLabel = new JPanel(new BorderLayout());
        songDetailsPanel = new JPanel(new BorderLayout());
        empty = new JPanel(new BorderLayout());
        
        JPanel labelsPanel = new JPanel();
        labelsPanel.setLayout(new GridLayout(4,1,10, 10));
        JPanel areaPanel = new JPanel();
        areaPanel.setLayout(new GridLayout(4,1, 10, 10)); 
        
        //songList = new JComboBox();
        songList = new JList(library);
        //songList = new JComboBox(library);
        songList.setLayoutOrientation(JList.VERTICAL);
        songList.setFixedCellWidth(100);
        songList.setVisibleRowCount(3);
        songList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 1 list index at a time
        songList.addListSelectionListener(this);
        
        JScrollPane scroll = new JScrollPane(songList);
        
        
        
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
        
        //songList.setSelectedIndex(0);
        //songListAndLabel.add(songList, BorderLayout.NORTH);
        songListAndLabel.add(scroll, BorderLayout.NORTH);
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

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Song song = songlib.getSelection();
        update(song);
        songlib.editPanel.edit.setEnabled(true);
        songlib.editPanel.remove.setEnabled(true);
    }
    
    public void setSelected(int i){
        if(i < library.getSize() && library.getSize() > 0){
            songList.setSelectedIndex(i);
            Song song = (Song)songList.getSelectedValue();
            songlib.detPanel.update(song);
            songlib.editPanel.edit.setEnabled(true);
            songlib.editPanel.remove.setEnabled(true);
        }
    }
    
    public void update(Song song){
        if(song != null){
            nameArea.setText(song.getName());
            artistArea.setText(song.getArtist());
            albumArea.setText(song.getAlbum());
            String check = String.valueOf(song.getYear());
            if (check.equals("0")) check = "";
            yearArea.setText(check);
        }
        else{
            clean();
        }
    }
    public void clean(){
        nameArea.setText("");
        artistArea.setText("");
        albumArea.setText("");
        yearArea.setText("");
    }
    
    public void sortSongs(DefaultListModel songs) {
     int numItems = songs.getSize();
     Song[] a = new Song[numItems];
     for (int i=0;i<numItems;i++){
       a[i] = (Song)songs.getElementAt(i);
       }
     sortArray(a);
     // Locale loc = Locale.FRENCH;
     // sortArray(Collator.getInstance(loc), (String[])a);
     for (int i=0;i<numItems;i++) {
       songs.setElementAt(a[i], i);
}
}
    private static void sortArray(Song[] array) {
       Song temp;
       if (array.length == 1) return;
       for (int i = 0; i < array.length; i++) {
        for (int j = i + 1; j < array.length; j++) {
          if(array[i].compareTo(array[j])  > 0 ) {
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        }
      }
    } 
   }
}
