package chatBot.Controller;

import javax.swing.JOptionPane;
import chatBot.Model.ChatBot;
import chatBot.View.ChatBotView;
/**
 * Application Controller for the ChatBot String manipulation project. Responsible for controlling the View and Model packages.
 * @author batt7497
 * @version 1.3 10/1/14
 */

public class ChatBotAppController
{
	/**
	 * The GUI view for the application
	 */
	private ChatBotView appView;
	/**
	 * The ChatBot Model instance	
	 */
	private ChatBot Billy;
	/**
	 * The start up message for our chatbot application
	 */
	private String startMessage;
	
	/**
	 * Creates a ChatBotAppControllwe and initializes the associated View and Model objects.
	 */
	public ChatBotAppController()
	{
		appView = new ChatBotView(this);
		Billy = new ChatBot("Billy");
		startMessage = "Welcome to the " +Billy.getName() +" ChatBot, type in your name.";
		
		
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
		String message = appView.displayChatBotConversations(startMessage);

		while(!Billy.quitChecker(message))
		{
			message = Billy.processText(message);
			message = appView.displayChatBotConversations(message);
		}
		
		quit();
		
	}
	
	/**
	 * Quits the Chatbot application with a message to the user that the application is closing.
	 */
	private void quit()
	{
		appView.displayInformation(" Goodbye :(");
		System.exit(0);
	}
}
