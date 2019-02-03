import java.util.Scanner;


public class prompter extends game {
	private game zgame;
	public prompter(game Game){
	zgame = Game;
	}
	public void play(){
		while(zgame.remainlives()>0&&!zgame.isSolved()){
			displayProgress();
			promptGuess();
			
		}if(zgame.isSolved()){
			System.out.println("Congragulation you won with "+zgame.remainlives()+" lives remaining");
		}else{
			System.out.println("LOOSER FEEL THE BAD SMELL OF LOOSING :(..."+"the answer is: "+ zgame.Getanswer());
		}
	}
	
	public boolean promptGuess(){
		Scanner scanner = new Scanner(System.in);
		boolean isHit = false;
		boolean isAValidHit = false;
		while(! isAValidHit){
			System.out.print("Enter a letter : ");
			String guesser = scanner.nextLine();
			
			if(guesser=="hint"){
				zgame.gethint();
			}
			char guess = guesser.charAt(0);
			try {
				isHit=zgame.ApplyGuess(guess);
				isAValidHit=true;
			} catch (IllegalArgumentException e) {
				System.out.println("Please try again!!!");
			}
		}
			return isHit;
		}
	
	
	public void displayProgress(){
		System.out.printf("You have %d lives to solve: %s\n" ,zgame.remainlives(), zgame.currentProgress());
	}

}
