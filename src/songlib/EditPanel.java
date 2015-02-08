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
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Rayad
 */
public class EditPanel extends JPanel{
    Song[] library;
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
    JTextArea nameArea;
    JTextArea artistArea;
    JTextArea albumArea;
    JTextArea yearArea;
    
    JButton cancel;
    JButton confirm;
    JTextArea output;
    
    public EditPanel(SongLib songlib){
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
        
        cancel = new JButton("Cancel");
        cancel.setEnabled(false);
        confirm = new JButton("Confirm");
        confirm.setEnabled(false);
        output = new JTextArea(3,20);
        
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
