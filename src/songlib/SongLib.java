/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songlib;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;

/**
 *
 * @author Rayad
 */
public class SongLib extends JFrame{
    
    DefaultListModel songlist = new DefaultListModel();
    private File songlibrary;
    DetailsPanel detPanel;
    EditPanel editPanel;
    String action = "";
    
    
    public SongLib(String title) throws FileNotFoundException{
        super(title);
        
        init();
        
        detPanel = new DetailsPanel(this);
        editPanel = new EditPanel(this);
        setLayout(new GridLayout(2,3,10,10));
        add(detPanel);
        add(editPanel);
        detPanel.sortSongs(detPanel.library);
        detPanel.songList.setSelectedIndex(0);
    }
    //load the songs
    private void init() throws FileNotFoundException{
        this.songlibrary = new File("songlib.txt");
        Scanner scanner = new Scanner(songlibrary);
        
        while(scanner.hasNextLine()){
            //1song artist,2 song artist year
            //3song artist album,4 song artist album year
            String[] details = scanner.nextLine().split("\\|");
            String name = details[0];
            String artist = details[1];
            Song song = new Song(name, artist);
            if(details.length == 3){
                if(details[2].matches("[0-9]")){
                    String year = details[3];
                    song.setYear(Integer.parseInt(year));
                }
                else{
                    String album = details[2];
                    song.setAlbum(album);
                }
            }
            if(details.length == 4){
                String album = details[2];
                String year = details[3];
                song.setAlbum(album);
                song.setYear(Integer.parseInt(year));
            }
            add(song);
            
        }
        
    }
    //save the library
    public void save() throws IOException{
        //as outlined in rec 1 use string builder
        StringBuilder songs = new StringBuilder();
        int i=0;
        for(i=0;i <songlist.getSize();i++){
            Song song = (Song)songlist.getElementAt(i);
            String name = song.getName();
            String artist = song.getArtist();
            String album = song.getAlbum();
            int year = song.getYear();
            //note the syntax
            songs.append(name + "|" + artist + "|" + album + "|" + String.valueOf(year) + "\n");
        }
        
        FileWriter writer = new FileWriter(this.songlibrary);
        writer.write(songs.toString());
        writer.close();
    }
    
    //gui ops
    
    public void add(Song song){
        if(!songlist.contains(song)){
            songlist.addElement(song);
        }
    }
    
    public void delete(Song song){
        if(songlist.contains(song)){
            songlist.removeElement(song);
        }
        if(songlist.getSize() == 0){
            detPanel.songList.setSelectedIndex(0);
        }
    }
    
    public Song getSelection(){
        return (Song)detPanel.songList.getSelectedValue();
    }
    
    public int getIndex(){
        return detPanel.songList.getSelectedIndex();
    }
    
    public void setSong(int i){
        if (i < songlist.getSize() && songlist.getSize() > 0){
            detPanel.songList.setSelectedIndex(i);
            Song song = getSelection();
            detPanel.update(song);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        final SongLib win = new SongLib("Song Library Simulator");
        win.setDefaultCloseOperation(EXIT_ON_CLOSE);
        win.setSize(965,596);
        win.setLocationRelativeTo(null);
        win.setVisible(true);	
        // save on exit
        /*win.addWindowListener(new WindowAdapter() {
        public void close(WindowEvent w){
            try{
                win.save();
            }
            catch(Exception e){
            }
            }
        
    });*/
    }
    
}
