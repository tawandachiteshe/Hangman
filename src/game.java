import java.util.Random;


public class game {
	public static final int MAX_LIVES=7;
	private String mAnswer;
	private String mHits;
	private String mMisses;
public String answer(String answer){
	mAnswer=answer;
	mHits="";
	mMisses="";
	return mAnswer;
}
	public boolean ApplyGuess(char letter) {
		letter = validatoe(letter);
		boolean isHit = mAnswer.indexOf(letter)>=0;
		if(isHit){
			mHits+=letter;
		}else{
			mMisses+=letter;
		}
		return isHit;
		
	}
	public String Getanswer(){
		return mAnswer;
	}
	private char validatoe(char letter){
		if(! Character.isLetter(letter)||Character.isWhitespace(letter)){
			IllegalArgumentException is=new IllegalArgumentException("A letter is required");
			System.out.println(is.getMessage());
		}
		letter = Character.toLowerCase(letter);
		if(mHits.indexOf(letter)>=0||mMisses.indexOf(letter)>=0){
			IllegalArgumentException is=new IllegalArgumentException("hey you have already solved that");
			System.out.println(is.getMessage());
			
		}
		return letter;
	}
	public String currentProgress(){
		String prog ="";
		for(char a:mAnswer.toCharArray()){
			char dis='-';
			if(mHits.indexOf(a)>=0){
				dis=a;
			}
			prog+=dis;
			
		}
		return prog;
	}
	public char gethint(){
		Random rand = new Random();
		char ra = (char)mAnswer.indexOf(rand.nextInt(mAnswer.length()));
		ApplyGuess(ra);
		return ra;
	}
	
	public boolean isSolved(){
		return currentProgress().indexOf('-')==-1;
	}
	public int remainlives(){
		return MAX_LIVES - mMisses.length();
	}
}
