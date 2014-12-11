package chatBot.View;

import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import chatBot.Controller.ChatBotAppController;

public class ChatbotPanel extends JPanel
{	
	private ChatBotAppController baseController;
	private JButton sampleButton;	
	private JTextField sampleField;	
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private SpringLayout baseLayout;	
	
	public ChatbotPanel(ChatBotAppController baseController) 
	{
		this.baseController = baseController;
		
		sampleButton = new JButton("Submit");
		sampleField = new JTextField(25);
		chatArea = new JTextArea(5, 25);
		chatArea.setTabSize(5);
		chatPane = new JScrollPane(chatArea);
		
		baseLayout = new SpringLayout();

		
		setupScrollPane();				
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupScrollPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setLayout(baseLayout);
		
		this.add(sampleButton);
		this.add(sampleField);
		this.add(chatPane);
	}
		
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 106, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 10, SpringLayout.WEST, this);		
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, 225, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, sampleField, 3, SpringLayout.NORTH, chatPane);
		baseLayout.putConstraint(SpringLayout.WEST, sampleField, 6, SpringLayout.EAST, chatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, sampleButton, 15, SpringLayout.SOUTH, sampleField);
		baseLayout.putConstraint(SpringLayout.EAST, sampleButton, -69, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, -10, SpringLayout.SOUTH, this);

	}
	
	private void gatherInfo()
	{
		String userTypedText = sampleField.getText();
		String chatbotResponse = baseController.sendTextToChatbot(userTypedText);
		displayTextToUser(userTypedText + "\n");
		displayTextToUser(chatbotResponse);
		sampleField.setText("");
	}
		
	private void setupListeners()
	{
		sampleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				gatherInfo();
			}
		});
		
		sampleField.addKeyListener(new KeyListener()
		{

			@Override
			public void keyPressed(KeyEvent typedKey)
			{
				// TODO Auto-generated method stub
				if(typedKey.getID() == KeyEvent.VK_ENTER)
				{
					gatherInfo();
				}
				
			}

			@Override
			public void keyReleased(KeyEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent typedKey)
			{
				
				
			}
			
		});
	}
	

	public void displayTextToUser(String input)
	{
		chatArea.append(input);
	}

}
