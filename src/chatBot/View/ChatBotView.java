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
	
	public String displayChatBotConversations(String input)
	{
		String output = "";
		
		output = JOptionPane.showInputDialog(null, baseController.getBilly().getName() + " says hello, " + input+ " do you wish to continue");
		
		
		return output;
	}
}
