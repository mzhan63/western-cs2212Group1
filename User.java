import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
/**
 * This class is to maintain, get, and first time set a users profile
 * @author Meng Zhang
 *
 */

public class User{
	/**
	 * a user has his/her login name, ID, collections of chanllenges received or sent out and games with 
	 * friends, as well as the setting of User Interface skin.
	 * A user is only allowed to view his/her collections and history, change skin settings, but can't change
	 * username and ID.
	 */
	private String userName,playerID;
	private LinkedList<Challenge> challengeCollection;
	private LinkedList<Game> gameHistory;
	private String selectedSkin;
	
	/**
	 * a constructor to set a new profile for users who play the game for the first time.
	 * @param uName
	 * @param pID
	 */
	public User(String uName, String pID){
		userName=uName;
		playerID=generateID();
		challengeCollection=new LinkedList<Challenge>();
		gameHistory=new LinkedList<Game>;		
	}
	
	public String getName(){
		return userName;
	}
	
	public String getID(){
		return playerID;
	}
	
	public LinkedList<Challenge> getCollection(){
		return challengeCollection;
	}
	
	public LinkedList<Game> getHistory(){
		return gameHistory;
	}
	
	public boolean addChallenge(Challenge c){
			
			ListIterator<Challenge> iter=challengeCollection.listIterator();
			while(iter.hasNext()){
				if(iter.next().getGameID().equals(c.getGameID())){
					return false;
				}
			}
			challengeCollection.add(c);
			Collections.sort(challengeCollection);
			return true;
	}
	
	public boolean deleteChallenge(Challenge c){
		ListIterator<Challenge> iter=challengeCollection.listIterator();
		while(iter.hasNext()){
			if(iter.next().getGameID().equals(c.getGameID())){
				iter.remove();
				Collections.sort(challengeCollection);
				return true;
			}
		}
		return false;
		

	}
	
	public LinkedList<Challenge> getSuspended(){
		ListIterator<Challenge> iter=challengeCollection.listIterator();
		LinkedList<Challenge> suspended=new LinkedList<Challenge>();
		while(iter.hasNext()){
			Challenge toAdd=iter.next();	
			if(toAdd.getStatus().equals("Unfinished")){
				suspended.add(toAdd);
				Collections.sort(suspended);
			}
		}
		return suspended;
	}
	
	
	/**
	 * This is a inside method to automatically generate an ID for a new user from DataBase maintained
	 * every player will have a unique ID.
	 * @return a string of an ID up to 8 digits.
	 */
	private String generateID(){
		return "This is your ID";
	}

}
