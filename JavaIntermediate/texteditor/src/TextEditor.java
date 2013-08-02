/**
 Provided in 2013 TechLab Education

 The MIT License (MIT)

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

@SuppressWarnings("serial")
/**
 * A simple text editor view.
 * @author (your name) 
 */
public class TextEditor extends JApplet 
implements ActionListener {
	private TextEditorModel model;

	// add components here
	private JTextField field;
	private JTextArea area;

	// Remember whether or not we have saved our work.
	private boolean saved = false;
	private String saveFile;

	/**
	 * Called by the browser or applet viewer to inform this JApplet that it has
	 * been loaded into the system. It is always called before the first time
	 * that the start method is called.
	 */
	public void init() {
		// Create a model and view object.
		model = new TextEditorModel();
		// Set the size of this applet to the size that the view wants.
		this.setSize(new Dimension(500, 500));
		// Make a new content pane to organize what we put into the applet - since we only have
		// a JTextArea, we make a 1 x 1 grid to ensure the text area resizes to the entire window.
		this.setLayout(new GridLayout(1, 1));

		initializeComponents();
	}

	/**
	 * Initializes the components of this applet.
	 */
	public void initializeComponents() {
		// Initialize the buttons.
		JMenuBar bar = new JMenuBar();
		JMenu replaceMenu = new JMenu("replace");
		replaceMenu.add(createItem("remove profanity"));
		replaceMenu.add(createItem("shakespearean"));
		replaceMenu.add(createItem("funny names"));
		replaceMenu.add(createItem("foo"));
		replaceMenu.add(createItem("remove insults"));
		replaceMenu.add(createItem("Apple rocks"));
		bar.add(replaceMenu);
		setJMenuBar(bar);
		// Initializing a text area.
		area = new JTextArea(30, 30);
		add(area);
	}
	public JMenuItem createItem(String name) {
		JMenuItem item = new JMenuItem(name);
		item.setActionCommand(name);
		item.addActionListener(this);
		return item;
	}

	/**
	 * This method is called whenever a component with an action value is
	 * activated.
	 */
	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == field) {
			// Then our text field is sending us data.
		}
		else {
			// Otherwise, some other component is sending us data.
			String action = a.getActionCommand();
			if (action.equals("new")) {

			}
			// Get the file name to open, then set the text area to the contents.
			if (action.equals("open")) {
				String fileName = JOptionPane.showInputDialog("What should I open?");
				// Your code here.
			}
			// Save the contents of the text area to a file, making a new file if necessary.
			if (action.equals("save")) {
				// Your code here.
			}
			// Saves the contents of the text area to a new file, even if it has already been saved.
			if (action.equals("save as")) {
				// Your code here.
			}
			// Clears the text editor.
			if (action.equals("clear")) {
				// Your code here.
			}
			if (action.equals("remove profanity")) {
				String text = area.getText();

				text = text.replaceAll("\\bheck\\b", "hoo ha");
				text = text.replaceAll("\\bdarn\\b", "dagnabbit");
				area.setText(text);
			}
			if (action.equals("filter")) {
				String text = area.getText();
				text = text.replaceAll("a+h+", "ah");
				text = text.replaceAll("tr(ol)+", "troll");
				area.setText(text);

			}
			if (action.equals("shakesperean")) {
				String text = area.getText();

				text = text.replaceAll("\\b(\\w+)\\b", "$1eth");
				text = text.replaceAll("\\bareeth\\b", "art");
				text = text.replaceAll("\\byoueth\\b", "thou");
				text = text.replaceAll("\\byoureth\\b", "thine");
				area.setText(text);
			}
			if (action.equals("remove insults")) {
				String text = area.getText();

				text = text.replaceAll("(?i)you are (stupid | dumb | stupid and dumb)", "you are quite intelligent and no $1");
				text = text.replaceAll("(?i)you are (bad|terrible|sucky) at (\\w+)", "you are not $1 at $2");
				text = text.replaceAll("\\bareeth\\b", "art");
				text = text.replaceAll("\\byoueth\\b", "thou");
				text = text.replaceAll("\\byoureth\\b", "thine");
				area.setText(text);
			}
			if (action.equals("Apple rocks")) {
				String text = area.getText();

				text = text.replaceAll("(?i)samsung rocks", "Apple rocks and samsung sucks");
				text = text.replaceAll("(?i)microsoft rocks", "Apple rocks and microsoft sucks");
			}
		}
	}
}
