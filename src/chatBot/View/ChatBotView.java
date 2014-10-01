package chatBot.View;

import javax.swing.JOptionPane;

import chatBot.Controller.ChatBotAppController;

public class ChatBotView
{

	private ChatBotAppController baseController;

	public ChatBotView(ChatBotAppController baseController)
	{
		this.baseController = baseController;
	}
	
	/**
	 * Displays the supplied String parameter to the user via popup and returns the users response to the controller.
	 * @param input The supplied text to be displayed
	 * @return The users input
	 */
	public String displayChatBotConversations(String input)
	{
		String output = "";
		
		output = JOptionPane.showInputDialog(null, input );
		
		
		return output;
	}
	
	/**
	 * Displays the supplied input via a popup window.
	 * @param input The text to be displayed.
	 */
	public void displayInformation(String input)
	{
		JOptionPane.showMessageDialog(null, input);
	}
}
