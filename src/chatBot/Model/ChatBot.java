package chatBot.Model;

public class ChatBot
{
	private String name;
	private int numberOfChats;

	/**
	 * Create a ChatBot object with a specified name. Initializes the total chats to 0.
	 * @param name The name of the ChatBot
	 */
	public ChatBot(String name)
	{
		this.name = name;
		numberOfChats = 0;
		// this. means talk to the current class
	}

	public String getName()
	{
		return name;
	}

	public int getNumberOfChats()
	{
		return numberOfChats;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void incrementChats()
	{
		numberOfChats++;
	}
	
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input.equals("bye"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}

}
