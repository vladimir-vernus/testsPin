package com.testing.task.atm;

public class AtmMashine {
	
	private boolean insertedCard = false;
	private boolean eatCard = false;
	private boolean accessToAccount = false;
	private int enterPinCounter = 0;
	private int correctPin;
	
	public void insertCard () {
        insertedCard = true;
    }
	
	public void enterPIN (int pin) {
		if(insertedCard){
			if(correctPin == pin){
				setAccessToAccount(true);
			}else{
				++enterPinCounter;
				if(enterPinCounter>=3){
					setEatCard(true);
				}
			}
		}
    }

	public boolean getEatCard() {
		return eatCard;
	}

	public void setEatCard(boolean eatCard) {
		this.eatCard = eatCard;
	}

	public boolean getAccessToAccount() {
		return accessToAccount;
	}

	public void setAccessToAccount(boolean accessToAccount) {
		this.accessToAccount = accessToAccount;
	}
	
	public int getCorrectPin() {
		return correctPin;
	}

	public void setCorrectPin(int correctPin) {
		this.correctPin = correctPin;
	}
	
	public int getEnterPinCounter() {
		return enterPinCounter;
	}

	public void setEnterPinCounter(int enterPinCounter) {
		this.enterPinCounter = enterPinCounter;
	}
	
	public Boolean getInsertedCard() {
		return insertedCard;
	}

	public void setInsertedCard(Boolean insertedCard) {
		this.insertedCard = insertedCard;
	}

}
