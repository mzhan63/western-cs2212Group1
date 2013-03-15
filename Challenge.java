
public class Challenge implements Comparable<Challenge> {
/**
 * a challenge maintain the data of two players ID, and the Game ID created by one of the player
 * the score each player got. 
 * Even for same scores, In means the game is still in progress, hasn't finished yet.
 */
	private String challengerID,challengedID,gameID,status;
	private int challengerScore, challengedScore;
	private final String EVEN="Even";
	private final String UNFINISHED="Unfinished";
	private final String COMPLETED="Completed";
	
	/**
	 * constructor
	 * @param CerID challenger's ID
	 * @param CedID challenged's ID
	 * @param GameID the game's ID this challenge belongs to 
	 * scores are set to be negative initially, for convenience to compare who wins
	 */
	public Challenge(String CerID,String CedID,String GameID){
		challengerID=CerID;
		challengedID=CedID;
		gameID=GameID;
		challengerScore=-1;
		challengedScore=-1;
		status=UNFINISHED;
	}
/**
 * 
 * @return the gameID this challenge belongs to 
 */
	public String getGameID(){
		return gameID;
	}
	
	public String getChallengerID(){
		return challengerID;
	}
	
	public String getChallengedID(){
		return challengedID;
	}
	
	public int getChallengerScore(){
		return challengerScore;
	}
	
	public int getChallengedScore(){
		return challengedScore;
	}
	
	public void setChallengerScore(int s){
		challengerScore=s;
	}
	
	public void setChallengedScore(int s){
		challengedScore=s;
	}
	
	public void setCompleted(){
		status=COMPLETED;
	}
	
	public String getStatus(){
		return status;
	}
	
	/**
	 * 
	 * @return the userID of winner of even for same scores, or In for in progress game
	 */
	public String whoWon(){
		if((challengerScore>=0)&&(challengedScore>=0)){
			if(challengerScore>challengedScore){
				status=COMPLETED;
				return challengerID;
			}
			else if(challengerScore==challengedScore){
				status=COMPLETED;
				return EVEN;
			}
			else{
				status=COMPLETED;
				return challengedID;
			}
		}
		else{
			return UNFINISHED;
		}
	}
	
	/**
	 * compare if two challenges are the same. Since each Game only have one challenge, so by comparing
	 * gameID, we can know if the two challenges are the same thing.
	 */
	public int compareTo(Challenge c){
		if(this.gameID.compareTo(c.getGameID())<0){
			return -1;//return -1 if the first one is less than the second
		}
		else if(this.gameID.compareTo(c.getGameID())>0){
			return 1;//the first is greater than the second
		}
		else{
			return 0;//they are equal
		}
	}
	
	public String toString()
	{
	    return this.getGameID();
	}
	

}
