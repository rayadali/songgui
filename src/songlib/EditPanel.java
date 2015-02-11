/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songlib;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Rayad
 */
public class EditPanel extends JPanel{
    DefaultListModel library;
    SongLib songlib;
    JPanel optionsPanel;// = new JPanel();
    JPanel editDetailsPanel;
    JPanel confirmationPanel;
    JButton edit;
    JButton add;
    JButton remove;
    
    
    JLabel editingLabel;
    JLabel nameLabel;
    JLabel artistLabel;
    JLabel albumLabel;
    JLabel yearLabel;
    JTextField nameArea;
    JTextField artistArea;
    JTextField albumArea;
    JTextField yearArea;
    
    JButton cancel;
    JButton confirm;
    JTextArea output;
    
    //String action = "";
    
    public EditPanel(SongLib songlib){
        this.songlib = songlib;
        this.library = songlib.songlist;
        
        //setLayout(new BorderLayout());
        setLayout(new GridLayout(1,3,10,10));
        optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel,BoxLayout.PAGE_AXIS));
        editDetailsPanel = new JPanel(new BorderLayout());
        confirmationPanel = new JPanel();
        
        edit = new JButton("Edit");
        add = new JButton("Add");
        remove = new JButton("Remove");
        ActionListener editL = new editListener(this.songlib);
        ActionListener addL = new addListener(this.songlib);
        ActionListener removeL = new removeListener(this.songlib);
        add.addActionListener(addL);
        edit.addActionListener(editL);
        remove.addActionListener(removeL);
        add.setEnabled(true);
        edit.setEnabled(false);
        remove.setEnabled(false);
        
        JPanel labelsPanel = new JPanel();
        labelsPanel.setLayout(new GridLayout(4,1,10, 10));
        JPanel areaPanel = new JPanel();
        areaPanel.setLayout(new GridLayout(4,1, 10, 10)); 
        
        nameLabel = new JLabel("Title: ");
        artistLabel = new JLabel("Artist: ");
        albumLabel = new JLabel("Album: ");
        yearLabel = new JLabel("Year: ");
        nameArea = new JTextField(20);
        //nameArea.setPreferredSize(new Dimension(1,20));
        nameArea.setEditable(false);
        nameArea.setBackground(labelsPanel.getBackground());
        nameArea.setBorder(BorderFactory.createLineBorder(Color.black));
        artistArea = new JTextField(20);
        artistArea.setEditable(false);
        artistArea.setBackground(labelsPanel.getBackground());
        artistArea.setBorder(BorderFactory.createLineBorder(Color.black));
        albumArea = new JTextField(20);
        albumArea.setEditable(false);
        albumArea.setBackground(labelsPanel.getBackground());
        albumArea.setBorder(BorderFactory.createLineBorder(Color.black));
        yearArea = new JTextField(20);
        yearArea.setEditable(false);
        yearArea.setBackground(labelsPanel.getBackground());
        yearArea.setBorder(BorderFactory.createLineBorder(Color.black));
        
        cancel = new JButton("Cancel");
        cancel.setEnabled(false);
        confirm = new JButton("Confirm");
        confirm.setEnabled(false);
        ActionListener cancelL = new cancelListener(this.songlib);
        ActionListener confirmL = new confirmListener(this.songlib);    
        cancel.addActionListener(cancelL);
        confirm.addActionListener(confirmL);
        output = new JTextArea(3,20);
        output.setLineWrap(true);
        
        optionsPanel.add(add);
        optionsPanel.add(remove);
        optionsPanel.add(edit);
        
        labelsPanel.add(nameLabel);
        labelsPanel.add(artistLabel);
        labelsPanel.add(albumLabel);
        labelsPanel.add(yearLabel);
        
        areaPanel.add(nameArea);
        areaPanel.add(artistArea);
        areaPanel.add(albumArea);
        areaPanel.add(yearArea);
        
        editDetailsPanel.add(labelsPanel, BorderLayout.WEST);
        editDetailsPanel.add(areaPanel, BorderLayout.CENTER);
        //default set invisible
        editDetailsPanel.setVisible(false);
        
        confirmationPanel.add(cancel);
        confirmationPanel.add(confirm);
        confirmationPanel.add(output);
        
        add(optionsPanel);
        add(editDetailsPanel);
        add(confirmationPanel);
    }
    
}


class cancelListener implements ActionListener {
	
	SongLib slwin;
	
	public cancelListener(SongLib slwin) {
		this.slwin = slwin;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == slwin.editPanel.cancel) {
                    //able to get fields
                    //todo get info from array, set it to the textfield if not done alread
                    //probably should set before --> load
                    //set text area editable
                    //update buttons
                    //set action button for the confirm button
                    slwin.editPanel.editDetailsPanel.setVisible(true);
                    slwin.editPanel.add.setEnabled(true);
                    slwin.editPanel.remove.setEnabled(false);
                    slwin.editPanel.edit.setEnabled(false);
                    slwin.editPanel.editDetailsPanel.setVisible(false);
                    slwin.editPanel.confirm.setEnabled(false);
                    slwin.editPanel.cancel.setEnabled(false);
                    //slwin.action = "cancel";
                    slwin.editPanel.nameArea.setText("");
                    slwin.editPanel.albumArea.setText("");
                    slwin.editPanel.artistArea.setText("");
                    slwin.editPanel.yearArea.setText("");
                    
                    slwin.editPanel.nameArea.setEditable(false);
                    slwin.editPanel.albumArea.setEditable(false);
                    slwin.editPanel.artistArea.setEditable(false);
                    slwin.editPanel.yearArea.setEditable(false);
                    slwin.editPanel.output.setText("You have now cancelled your operation.\nSelect an option to continue.");
		}
	}
}
class confirmListener implements ActionListener {
	
	SongLib slwin;
	
	public confirmListener(SongLib slwin) {
		this.slwin = slwin;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == slwin.editPanel.confirm) {
                    //able to get fields
                    //todo get info from array, set it to the textfield if not done alread
                    //probably should set before --> load
                    //set text area editable
                    //update buttons
                    //set action button for the confirm button
                    slwin.editPanel.editDetailsPanel.setVisible(true);
                    slwin.editPanel.add.setEnabled(true);
                    slwin.editPanel.remove.setEnabled(false);
                    slwin.editPanel.edit.setEnabled(false);
                    slwin.editPanel.editDetailsPanel.setVisible(false);
                    slwin.editPanel.confirm.setEnabled(false);
                    slwin.editPanel.cancel.setEnabled(false);
                    //slwin.action = "confirm";
                    
                    
                    slwin.editPanel.nameArea.setEditable(false);
                    slwin.editPanel.albumArea.setEditable(false);
                    slwin.editPanel.artistArea.setEditable(false);
                    slwin.editPanel.yearArea.setEditable(false);
                    slwin.editPanel.output.setText("You have now updated your library!");
                    
                    String name = slwin.editPanel.nameArea.getText().trim();
                    String artist = slwin.editPanel.artistArea.getText().trim();
                    String album = slwin.editPanel.albumArea.getText().trim();
                    String yeartemp  = slwin.editPanel.yearArea.getText().trim();
                    int year;
                    if(yeartemp.equals("")){
                        year = 0;
                    }
                    else{
                        year = Integer.parseInt(yeartemp);
                    }
                    int index = slwin.getIndex();
                    
                    //do ops to update the data structures
                    if(slwin.action.equalsIgnoreCase("add")){
                        if(!name.equals("") && !artist.equals("")){
                            Song song = new Song(name, artist, year, album);
                            slwin.add(song);
                        }
                    }
                    if(slwin.action.equalsIgnoreCase("edit")){
                        Song song = slwin.getSelection();
                        //check if empty
                        if(!name.equals("")) song.setName(name);
                        if(!artist.equals("")) song.setArtist(artist);
                        song.setAlbum(album);
                        song.setYear(year);
                        
                    }
                    if(slwin.action.equalsIgnoreCase("remove")){
                        Song song = slwin.getSelection();
                        slwin.delete(song);
                        if(slwin.songlist.isEmpty()){
                            slwin.editPanel.edit.setEnabled(false);
                            slwin.editPanel.remove.setEnabled(false);
                        }
                    }
                    slwin.editPanel.nameArea.setText("");
                    slwin.editPanel.albumArea.setText("");
                    slwin.editPanel.artistArea.setText("");
                    slwin.editPanel.yearArea.setText("");
                    slwin.setSong(index);
                    try {
                        slwin.save();
                    } catch (IOException ex) {
                        Logger.getLogger(confirmListener.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
                
	}
}


class editListener implements ActionListener {
	
    SongLib slwin;
	
	public editListener(SongLib slwin) {
		this.slwin = slwin;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == slwin.editPanel.edit) {
                    //able to get fields
                    //todo get info from array, set it to the textfield if not done alread
                    //probably should set before --> load
                    //set text area editable
                    //update buttons
                    //set action button for the confirm button
                    slwin.editPanel.editDetailsPanel.setVisible(true);
                    slwin.editPanel.cancel.setEnabled(true);
                    slwin.action = "edit";
                    slwin.editPanel.confirm.setEnabled(true);
                    
                    slwin.editPanel.add.setEnabled(false);
                    slwin.editPanel.remove.setEnabled(false);
                    
                    slwin.editPanel.nameArea.setEditable(true);
                    slwin.editPanel.albumArea.setEditable(true);
                    slwin.editPanel.artistArea.setEditable(true);
                    slwin.editPanel.yearArea.setEditable(true);
                    Song song = slwin.getSelection();
                    slwin.editPanel.nameArea.setText(song.getName());
                    slwin.editPanel.artistArea.setText(song.getArtist());
                    slwin.editPanel.albumArea.setText(song.getAlbum());
                    slwin.editPanel.yearArea.setText(String.valueOf(song.getYear()));
                    
                    slwin.editPanel.output.setText("You are now editing.\nClick cancel to abort or confirm to submit your changes.");
		}
        }
}

class addListener implements ActionListener {
	
	SongLib slwin;
	
	public addListener(SongLib slwin) {
		this.slwin = slwin;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == slwin.editPanel.add) {
                    //able to get fields
                    //todo get info from array, set it to the textfield if not done alread
                    //probably should set before --> load
                    //set text area editable
                    //update buttons
                    //set action button for the confirm button
                    slwin.editPanel.editDetailsPanel.setVisible(true);
                    slwin.editPanel.cancel.setEnabled(true);
                    slwin.action = "add";
                    slwin.editPanel.confirm.setEnabled(true);
                    
                    slwin.editPanel.edit.setEnabled(false);
                    slwin.editPanel.remove.setEnabled(false);
                    
                    slwin.editPanel.nameArea.setEditable(true);
                    slwin.editPanel.albumArea.setEditable(true);
                    slwin.editPanel.artistArea.setEditable(true);
                    slwin.editPanel.yearArea.setEditable(true);
                    slwin.editPanel.output.setText("You are now adding a song.\nClick cancel to abort or confirm to submit your changes.");
                }
        }
}

class removeListener implements ActionListener {
	
	SongLib slwin;
	
	public removeListener(SongLib slwin) {
		this.slwin = slwin;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == slwin.editPanel.remove) {
                    //able to get fields
                    //todo get info from array, set it to the textfield if not done alread
                    //probably should set before --> load
                    //set text area editable
                    //update buttons
                    //set action button for the confirm button
                    //slwin.editPanel.editDetailsPanel.setVisible(true);
                    slwin.editPanel.cancel.setEnabled(true);
                    slwin.action = "remove";
                    slwin.editPanel.confirm.setEnabled(true);
                    
                    slwin.editPanel.add.setEnabled(false);
                    slwin.editPanel.remove.setEnabled(false);
                    /*
                    slwin.editPanel.nameArea.setEditable(true);
                    slwin.editPanel.albumArea.setEditable(true);
                    slwin.editPanel.artistArea.setEditable(true);
                    */
                    slwin.editPanel.output.setText("You are now removing this song, please review.\nClick cancel to abort or confirm to submit your changes.");
		}
        }
}
