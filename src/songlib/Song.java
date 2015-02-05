/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songlib;

/**
 *
 * @author Rayad
 */
public class Song {
    private String name = "";
    private String artist = "";
    private String album = "";
    private int year = 0;
    
    /*different constructors because the user can enter in these ways:
    name + artist
    name + artist + year
    name + artist + album
    name + artist + year + album
    */
    
    public Song (String name, String artist){
        this.name = name;
        this.artist = artist;
    }
    //note using int for the year as i am using a 3 string constructor already for just name, artist, year
    public Song (String name, String artist, int year){
        this.name = name;
        this.artist = artist;
        this.year = year;
    }
    public Song (String name, String artist, String album){
        this.name = name;
        this.artist = artist;
        this.album = album;
    }
    public Song (String name, String artist, int year, String album){
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.year = year;
    }
    
    //methods to return the data
    public String getName(){
        return name;
    }
    public String getArtist(){
        return artist;
    }
    public int getYear(){
        return year;
    }
    public String getAlbum(){
        return album;
    }
    
    //methods to set the data
    
    public void setName(String name){
        this.name = name;
    }
    public void setArtist(String artist){
        this.artist= artist;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setAlbum(String album){
        this.album = album;
    }
    
    //check if it exists
    
    public boolean equals(Song song){
        if(song == null){
            return false;
        }
        /*name and artist the same
        case insenstive so ignore case
        */
        return name.equalsIgnoreCase(song.getName()) && artist.equalsIgnoreCase(song.getArtist());
    }
    
    //std toString method
    
    public String toString(){
        //Using this sytnax for now
        return name + " - " + artist;
    }
}
