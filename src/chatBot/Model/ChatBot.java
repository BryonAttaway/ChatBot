package chatBot.Model;

import java.util.ArrayList;

public class ChatBot
{
	private String name;
	private int numberOfChats;
	private ArrayList<String> memeList;

	/**
	 * Create a ChatBot object with a specified name. Initializes the total
	 * chats to 0.
	 * 
	 * @param name
	 *            The name of the ChatBot.
	 */
	public ChatBot(String name)
	{
		this.name = name;
		numberOfChats = 0;

		memeList = new ArrayList<String>();
		fillTheMemeList();
		// this. means talk to the current class.
	}

	public String getName()
	{
		return name;
	}

	/**
	 * counts up by one for every chat from user or ChatBot.
	 * 
	 * @return The current number of chats.
	 */
	public int getNumberOfChats()
	{
		return numberOfChats;
	}

	/**
	 * Sets the name of the ChatBot.
	 * 
	 * @param name
	 *            The new name for the ChatBot.
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
	 * Fills the contents of the memeList with internet memes.
	 */
	private void fillTheMemeList()
	{
		memeList.add("y u mad bro");
		memeList.add("doh!");
		memeList.add("One does not simply");
		memeList.add("ALIENS!");
		memeList.add("I don't know who you are...");
		memeList.add("I dont always...");
	}

	/**
	 * Processed the supplied text from the user to provide a message from the Chatbot.
	 * Chatbot.
	 * 
	 * @param userText
	 *            The user supplied text.
	 * @return What the Chatbot says because of the supplied input.
	 */
	public String processText(String userText)
	{
		String processedText = "";
		incrementChats();

		if (memeChecker(userText))
		{
			processedText = "hey, you found a meme: " + userText;
			processedText += " int't that cool.";
		}
		else
		{
			processedText = "Boring that wan't a meme.";
		}

		return processedText;
	}

	private boolean memeChecker(String currentText)
	{
		boolean isAMeme = false;

		for (String currentMeme : memeList)
		{
			if (currentMeme.equalsIgnoreCase(currentText))
			{
				isAMeme = true;
			}
		}

		for (int loopCount = 0; loopCount < memeList.size(); loopCount++)
		{
			if (memeList.get(loopCount).equalsIgnoreCase(currentText))
			{
				isAMeme = true;
			}
		}

		return isAMeme;
	}

	/**
	 * This will check to see if you type the work to quit the ChatBot.
	 * 
	 * @param input
	 *            This is the word to type to exit ChatBot.
	 * @return If it checks and finds the correct word to exit, this will exit
	 *         ChatBot.
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;

		if (input != null && input.equals("bye"))
		{
			okToQuit = true;
		}

		return okToQuit;
	}

}
