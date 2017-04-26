package drawing.view;

import javax.swing.*;
import drawing.controller.*;

public class DrawingFrame extends JFrame
{
	private DrawingController baseController;
	private DrawingPanel appPanel;
	
	public DrawingFrame(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		appPanel = new DrawingPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("Wow");
		this.setResizable(true);
		this.setSize(1920, 1080);
		this.setVisible(true);
	}
}
