package chatBot.View;

import javax.swing.JFrame;

import chatBot.Controller.ChatBotAppController;

public class ChatbotFrame extends JFrame
{
	private ChatbotPanel basePanel;
	
	/**
	 * creates a chatbot panel called baseController
	 * @param baseController is the way you get from the user to do stuff
	 */
	public ChatbotFrame(ChatBotAppController baseController) 
	{
		basePanel = new ChatbotPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		/**
		 * this is what makes up the window
		 */
		this.setContentPane(basePanel);
		/**
		 * sets where on your screen it will pop-up
		 */
		this.setLocation(10,10);
		/**
		 * sets the size (X,Y)
		 */
		this.setSize(500, 400);
		/**
		 * The user can't change the size of the window
		 */
		this.setResizable(false);
		/**
		 * This makes it so you can see it
		 */
		this.setVisible(true);
	}

}
