package chatBot.View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import chatBot.Controller.ChatBotAppController;

public class ChatbotPanel extends JPanel
{	
	private ChatBotAppController baseController;
	private JButton sampleButton;	
	private JButton nextButton;
	private JTextField sampleField;	
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private SpringLayout baseLayout;	
	
	public ChatbotPanel(ChatBotAppController baseController) 
	{
		this.baseController = baseController;
		
		sampleButton = new JButton("click on me, or DIE >:)");
		nextButton = new JButton("Or click on me :D");
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
		add(nextButton);
	}
		
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 106, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, sampleButton, 42, SpringLayout.EAST, chatPane);
		baseLayout.putConstraint(SpringLayout.SOUTH, sampleButton, 0, SpringLayout.SOUTH, chatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 100, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 10, SpringLayout.WEST, this);		
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, 200, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, 225, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, sampleField, 3, SpringLayout.NORTH, chatPane);
		baseLayout.putConstraint(SpringLayout.WEST, sampleField, 6, SpringLayout.EAST, chatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, nextButton, 22, SpringLayout.SOUTH, sampleButton);
		baseLayout.putConstraint(SpringLayout.WEST, nextButton, 0, SpringLayout.WEST, sampleButton);
	}
		
	private void setupListeners()
	{
		sampleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userTypedText = sampleField.getText();
				String chatbotResponse = baseController.sendTextToChatbot(userTypedText);
				displayTextToUser(userTypedText);
				displayTextToUser(chatbotResponse);
				sampleField.setText("");
			}
		});
		
		nextButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				sampleField.setText(sampleField.getText() + " you clicked on me!!!! ");
			}
		});
	}

	public void displayTextToUser(String input)
	{
		chatArea.append("\n" + input);
	}

}
