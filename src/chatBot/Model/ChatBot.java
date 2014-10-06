package chatBot.Model;

import java.util.ArrayList;

public class ChatBot
{
	private String name;
	private int numberOfChats;
	private ArrayList<String> memeList;
	private String content;

	/**
	 * Create a ChatBot object with a specified name. Initializes the total
	 * chats to 0.
	 * 
	 * @param name The name of the ChatBot.
	 */
	public ChatBot(String name)
	{
		this.name = name;
		numberOfChats = 0;
		
		content = "Games";
		
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
	
	/**
	 * Increments the chat count for the Chatbot. Used for tracking the activity of the Chatbot.
	 */
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
		
		int randomChoice = (int) (Math.random() * 3);
		
		if(randomChoice == 0)
		{
			//use stringLengthChecker here
		}
		else if (randomChoice == 1)
		{
			//use contentChecker here
		}
		else
		{
			if (memeChecker(userText))
			{
				processedText = "hey, you found a meme: " + userText;
				processedText += " int't that cool.";
			}
			else
			{
				processedText = "Boring that wan't a meme.";
			}
		}
		
		
		return processedText;
	}

	private boolean stringLengthChecker(String input)
	{
		boolean isTooLong = false;
		
		if(input.length() >=15)
		{
			isTooLong;
		}
		
		return isTooLong;
	}
	
	private boolean contentChecker(String input)
	{
		boolean hasMyContent = false;
		
		if(input.contains(content))
		{
			hasMyContent = true;
		}
		
		return hasMyContent;
	}
	
	/**
	 * This will check if the input matches any of the memes.
	 * @param currentText the text that the user supplies
	 * @returnWhether the String matched any of the built in memes
	 */
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
