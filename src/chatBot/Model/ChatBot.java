package chatBot.Model;

public class ChatBot
{
	private String name;
	private int numberOfChats;

	/**
	 * Create a ChatBot object with a specified name. Initializes the total chats to 0.
	 * @param name The name of the ChatBot.
	 */
	public ChatBot(String name)
	{
		this.name = name;
		numberOfChats = 0;
		// this. means talk to the current class.
	}
	
	public String getName()
	{
		return name;
	}
	
	/**
	 * counts up by one for every chat from user or ChatBot.
	 * @return The current number of chats.
	 */
	public int getNumberOfChats()
	{
		return numberOfChats;
	}
	
	/**
	 * Sets the name of the ChatBot.
	 * @param name The new name for the ChatBot.
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	public void incrementChats()
	{
		numberOfChats++;
	}
	
	/**
	 * This will check to see if you type the work to quit the ChatBot.
	 * @param input This is the word to type to exit ChatBot.
	 * @return If it checks and finds the correct word to exit, this will exit ChatBot.
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input != null && input.equals("bye"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}

}
