package chatBot.Controller;

import javax.swing.JOptionPane;

import chatBot.Model.ChatBot;
import chatBot.View.ChatBotView;
import chatBot.View.ChatbotFrame;
import chatBot.View.ChatbotPanel;
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
	
	
	private ChatbotFrame baseFrame;
	
	/**
	 * Creates a ChatBotAppControllwe and initializes the associated View and Model objects.
	 */
	public ChatBotAppController()
	{
		appView = new ChatBotView(this);
		baseFrame = new ChatbotFrame(this);
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

		ChatbotPanel myAppPanel = (ChatbotPanel) baseFrame.getContentPane();
		myAppPanel.displayTextToUser(startMessage);
		
		
	}
	
	public String sendTextToChatbot(String userInput)
	{
		String respondText = "";
		
		
		respondText = Billy.processText(userInput);
		
		return respondText;
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
