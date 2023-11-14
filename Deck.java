package poker;

public class Deck {

	public Card [] cards = new Card [52];

	public Deck() {
		int idx = 0;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14; j++) {
				this.cards[idx] = new Card(j,i);

				idx++;
			}
		}
	}

	public Deck(Deck other) {
		this.cards = other.cards;
	}

	public Card getCardAt(int position) {

		Card newCards = new Card (this.cards[position].getValue(), this.cards[position].getSuit());
		return newCards;

	}

	public int getNumCards() {
		int count = 0;
		for (int i = 0; i < this.cards.length; i++) {
			count++;
		}
		return count;
	}


	public void shuffle() {

		int len = this.cards.length;
		Card [] tempCards = new Card[len];

		int state = 1;


		int topIndex = 0;
		int bottomIndex;

		//account for odd sized list
		if (len%2 == 0){
			bottomIndex = len/2;
		}
		else{
			bottomIndex = len/2 + 1;
		}


		for(int i = 0; i < len; i++){
			if(state == 1){
				tempCards[i] = this.cards[topIndex];
				topIndex++;
				state++;
			}

			else{
				tempCards[i] = this.cards[bottomIndex];
				bottomIndex++;
				state--;
			}
		}
		this.cards = tempCards;
	}


	public void cut(int position) {
		Card [] firstHalf = new Card [position];
		for (int i = 0; i < firstHalf.length; i++) {
			firstHalf[i] = this.cards[i];

		}

		Card [] secondHalf = new Card [this.cards.length - firstHalf.length];
		int cutIdx = position;
		for (int i = 0; i < secondHalf.length; i++) {
			secondHalf[i] = this.cards[cutIdx];
			cutIdx++;
		}

		int j = 0;
		for (int i = 0; i < this.cards.length; i++) {
			if (i < secondHalf.length) {
				this.cards[i] = secondHalf[i];
			} else {
				this.cards[i] = firstHalf[j];
				j++;
			}
		}
	}

	public Card[] deal(int numCards) {

		Card [] dealedOut = new Card[numCards];
		for (int i = 0; i < dealedOut.length; i++) {
			dealedOut[i] = this.cards[i];

		}

		Card [] smaller = new Card[this.cards.length - numCards];
		for (int i = 0; i < smaller.length; i++) {
			smaller[i] = this.cards[numCards];
			numCards++;
		}

		this.cards = new Card[smaller.length];
		for (int i = 0; i < this.cards.length; i++) {
			cards[i] = smaller[i];

		}
		return dealedOut;
	}

}
