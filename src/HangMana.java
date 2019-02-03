
public class HangMana {

	public static void main(String[] args) {
		game mGame = new game();
		prompter prom = new prompter(mGame);
		mGame.answer("tawanda");
		prom.play();
		boolean ishit= prom.promptGuess();
		if(ishit){
			System.out.println("Tapinda");
		}else{
			System.out.println("tafa");
		}
		
		
		
	}

}
