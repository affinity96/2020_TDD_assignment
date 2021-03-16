
public class Game {

	
	private int score = 0;
	private int currentRoll = 0;
	private int[] rolls = new int[21];
	

	public void roll(int pins) {
		// TODO Auto-generated method stub
		score +=pins;
		rolls [currentRoll ++] = pins;
	}

	public int score() {
		// TODO Auto-generated method stub
		int score = 0;
		int frameIndex=0;
		for(int frame = 0; frame <10; frame++) {
			if(isStrike(frameIndex)) {
				score+= 10+strikeBonus(frameIndex);
				frameIndex++;
			}
			else if(isSpare(frameIndex)) // spare
			{
				score+= 10 + rolls[frameIndex+2];
				frameIndex+=2;
			}else {
				score += rolls[frameIndex] + rolls[frameIndex+1];
				frameIndex+=2;
			}
			
		}
		return score;
	}

	private boolean isStrike(int frameIndex) {
		// TODO Auto-generated method stub
		return rolls[frameIndex] == 10;
	}

	private int strikeBonus(int frameIndex) {
		// TODO Auto-generated method stub
		
		return rolls[frameIndex+1] + rolls[frameIndex+2];
	}

	private boolean isSpare(int frameIndex) {
		// TODO Auto-generated method stub
		return rolls[frameIndex] + rolls[frameIndex+1] == 10;
	}

}
