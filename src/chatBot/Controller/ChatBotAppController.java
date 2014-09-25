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
		Billy = new ChatBot("Mr. not so clever");
	}
	
	/**
	 * Starts the ChatBot Application.
	 */
	
	public void start()
	{
		String message = JOptionPane.showInputDialog(null, "Would you like to continue");
		if(Billy.quitChecker(message))
		{
			quit();
		}
			
		JOptionPane.showMessageDialog(null, "We are not done yet...");
	}

	private void quit()
	{
		JOptionPane.showMessageDialog(null, "bye");
		System.exit(0);
	}
}
