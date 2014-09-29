package chatBot.Controller;

import javax.swing.JOptionPane;
import chatBot.Model.ChatBot;
import chatBot.View.ChatBotView;


public class ChatBotAppController
{
	private ChatBotView appView;
	private ChatBot Billy;
	
	/**
	 * Creates a ChatBotAppControllwe and initializes the associated View and Model objects.
	 */
	public ChatBotAppController()
	{
		appView = new ChatBotView(this);
		Billy = new ChatBot("Billy");
		
	}
	
	
	/**
	 * Allows other objects access to the Billy
	 * @return The ChatBot for this app.
	 */
	public ChatBot getBilly()
	{
		return Billy;
	}
	
	/**
	 * Starts the ChatBot Application.
	 */
	public void start()
	{
		String message = JOptionPane.showInputDialog(null, "Welcome to ChatBot, type in your name.");

		while(!Billy.quitChecker(message))
		{
			message = appView.displayChatBotConversations(message);
		}
		
	}
	
	/**
	 * If i were to say quit to ChatBot, This will end ChatBot.
	 */
	private void quit()
	{
		JOptionPane.showMessageDialog(null, "bye");
		System.exit(0);
	}
}
