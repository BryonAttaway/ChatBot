package chatBot.Model;

import java.util.ArrayList;

/**
 * 
 * @author Bryon A.
 * @version 1.2
 */
public class ChatBot
{
	private String name;
	private int numberOfChats;
	private ArrayList<String> memeList;
	private ArrayList<String> userInputList;
	private String content;
	private user myUser;
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
		myUser = new user();
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
	 * Increments the chat count for the Chatbot. Used for tracking the activity
	 * of the Chatbot.
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
		memeList.add("I dont know who you are...");
		memeList.add("I dont always...");
	}

	/**
	 * Processed the supplied text from the user to provide a message from the
	 * Chatbot. Chatbot.
	 * 
	 * @param userText
	 *            The user supplied text.
	 * @return What the Chatbot says because of the supplied input.
	 */
	public String processText(String userText)
	{
		String processedText = "";

		if (userText != null)
		{
			if (numberOfChats < 4)
			{
				processedText = introChat(userText);
			}
			else
			{
				processedText = randomChat(userText);
			}
			
		}

		incrementChats();
		
		return processedText;
	}
	
	private String introChat(String userText)
	{
		String processedText = "";
		
		
			
			//you will need to use some if's or a switch
			//Save userText to the shatUser's appropriate field.
			//For items that are not strings you will the wrapper
			//like Integer.parseInt(userText) to save as an int
			//or Boolean.parseBoolean(userTExt) to save as a boolean
			
			if(numberOfChats == 0)
			{
				myUser.setUser(userText);
				processedText = "Hello " + myUser.getUser() + " how old are you ?";
			}
			else if (numberOfChats == 1)
			{
				int age = Integer.parseInt(userText);
				myUser.setAge(age);
				processedText = myUser.getUser() + ", you are really " + myUser.getAge() + " years old, thats awesome";
				processedText += "\nWhat is your favorite movie?";
			}
			else if (numberOfChats == 2)
			{
				processedText = "That is a great movie\n";
				processedText += "What was your favorite part?\n";
			}
			
		
		return processedText;
	}
	
	private String randomChat(String userText)
	{
		String processedText = "";
		
		int randomChoice = (int) (Math.random() * 6);
		
		if (randomChoice == 0)
		{
			if(stringLengthChecker(userText))
			{
				processedText = "Hey, you should type smaller messages\n";
			}
			else
			{
				processedText = "tiny message\n";
			}
		
			// use stringLengthChecker here
		}
		else if (randomChoice == 1)
		{
			if(contentChecker(userText))
			{
				processedText = "You know exactly what i want to learn about :) games, will you tell me about your favorite game?\n";
			}
			else
			{
				processedText = "Wanna talk about something else?\n";
			}
			// use contentChecker here
		}
		else
		{
			if (memeChecker(userText))
			{
				processedText = "hey, you found a meme: " + userText;
				processedText += " I love that one!!\n";
			}
			else
			{
				processedText = "Boring that wan't a meme.\n";
			}
		}
		
		if (quitChecker(userText))
		{
			processedText = "bye";
		}
		
		return processedText;
	}
	
	private boolean userInputChecker(String input)
	{
		boolean matchesInput = false;
		
		if(userInputList.size() > 0){
			for(int loopCount = 0; loopCount < userInputList.size(); loopCount++)
			{
				if(input.equalsIgnoreCase(userInputList.get(loopCount)))
				{
					matchesInput = true;
					userInputList.remove(loopCount);
					loopCount--;
				}
			}
		}
		return matchesInput;
	}

	private boolean stringLengthChecker(String input)
	{
		boolean isTooLong = false;
		
		if(input.length() >=15)
		{
			isTooLong = true;
		}
		
		return isTooLong;
	}

	private boolean contentChecker(String input)
	{
		content = "games";
		
		boolean hasMyContent = false;

		if (input.equalsIgnoreCase(content))
		{
			hasMyContent = true;
		}

		return hasMyContent;
	}

	/**
	 * This will check if the input matches any of the memes.
	 * 
	 * @param currentText the text that the user supplies
	 * @returnWhether the String matched any of the built in memes
	 */
	private boolean memeChecker(String currentText)
	{
		boolean isAMeme = false;

		for (String currentMeme : memeList)
		{
			if (currentMeme.contains(currentText))
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

	
	/**
	 * Checks to see if the name of the chatbot is contained within the String supplied by the user.
	 * @param currentInput The user supplied String.
	 * @return Whether the name is inside or not.
	 */
	private boolean chatBotNameChecker (String currentInput)
	{
		boolean hasNameInString = false;
		
		if (currentInput.indexOf(this.getName()) > -1)
		{
			hasNameInString = true;
		}
		
		return hasNameInString;
	}
	
	private String chatbotNameConversation(String currentInput)
	{
		String nameConversation = "This is what you typed after my name: ";
		
		nameConversation += currentInput.substring(currentInput.indexOf(this.getName()) + this.getName().length() - 1);
				
		return nameConversation;
	}
	
	private String noNameConversation(String currentInput)
	{
		String notNamed = "";
		
		int smallRandom = (int) (Math.random() * currentInput.length() / 2);
		int largerRandom = (int) (smallRandom + (Math.random() * (currentInput.length() / 2)) + 1);	
		
		notNamed = "You didn't say my name so here is a special phrase: "+ currentInput.substring(smallRandom, largerRandom);
		
		return notNamed;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

