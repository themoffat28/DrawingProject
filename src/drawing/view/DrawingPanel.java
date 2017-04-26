package drawing.view;

import javax.swing.*;
import drawing.controller.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingPanel extends JPanel
{
	private ShapePanel shapePanel;
	private JButton rectangleButton;
	private JButton triangleButton;
	private JButton circleButton;
	private JButton ellipseButton;
	private JButton polygonButton;
	private JButton resetButton;
	private SpringLayout baseLayout;
	private DrawingController baseController;
	
	public DrawingPanel(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		
		shapePanel = new ShapePanel(baseController);
		rectangleButton = new JButton("Draw rectangels");
		triangleButton = new JButton("Draw triangles");
		circleButton = new JButton("Draw circles");
		ellipseButton = new JButton("Draw ellipse");
		polygonButton = new JButton("Draw polygon");
		resetButton = new JButton("Reset");
		baseLayout = new SpringLayout();

		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GRAY);
		this.setMinimumSize(new Dimension(600, 600));
		
		this.add(rectangleButton);
		this.add(triangleButton);
		this.add(circleButton);
		this.add(ellipseButton);
		this.add(polygonButton);
		this.add(resetButton);
		this.add(shapePanel);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 221, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, polygonButton, 35, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, ellipseButton, 35, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, circleButton, 35, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, triangleButton, 35, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, rectangleButton, 0, SpringLayout.WEST, triangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, rectangleButton, -6, SpringLayout.NORTH, triangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, triangleButton, -6, SpringLayout.NORTH, circleButton);
		baseLayout.putConstraint(SpringLayout.WEST, resetButton, 55, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, circleButton, -6, SpringLayout.NORTH, ellipseButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, ellipseButton, -6, SpringLayout.NORTH, polygonButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, polygonButton, -17, SpringLayout.NORTH, resetButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, resetButton, -10, SpringLayout.SOUTH, this);
	
		
	}
	
	private void setupListeners()
	{
		rectangleButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangles();
			}
				});
		
		triangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangles();
			}
				});
		
		circleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircles();
			}
				});
		
		ellipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipse();
			}
				});
		
		polygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygons();
			}
				});
		
		resetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.reset();
			}
				});
		
		
	}
}
