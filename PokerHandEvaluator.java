package poker;
public class PokerHandEvaluator {



	public static boolean hasPair(Card[] cards) {

		for (int i = 0; i < cards.length; i++) {
			for (int j = i + 1; j < cards.length; j++ ) {
				if (cards[i].getValue() == cards[j].getValue()) {
					return true;
				}
			}
		}
		return false;
	}


	public static boolean hasTwoPair(Card[] cards)  {
		boolean hasPair = false;
		int pairValue = -1;

		for (int i = 0; i < cards.length; i++) {
			for (int j = i + 1; j < cards.length; j++ ) {

				if (cards[i].getValue() == cards[j].getValue()) {

					hasPair = true;

					pairValue = cards[i].getValue();

				}
			}
		}

		if (hasPair == true) {

			for (int i = 0; i < cards.length; i++) {

				for (int j = i + 1; j < cards.length; j++ ) {

					if (cards[i].getValue() == cards[j].getValue() && cards[i].getValue() != pairValue) {
						return true;

					}
				}
			}
		}

		return false;
	}

	public static boolean hasThreeOfAKind(Card[] cards) {

		int count = 1;

		for (int i = 0; i < cards.length; i++) {

			for (int j = i + 1; j < cards.length; j++ ) {
				if (cards[i].getValue() == cards[j].getValue()) {
					count++;
					if (count == 3) {
						return true;
					}
				}
			}
			count = 1;
		}
		return false;
	}

	public static boolean hasStraight(Card [] cards) {
		int smallest = cards[0].getValue();
		int count = 0;
		boolean kingPresent = false;
		int [] flushValues;

		for(int i = 1; i < cards.length; i++){
			if (cards[i].getValue() < smallest){
				smallest = cards[i].getValue();

			}

			if (cards[i].getValue() == 13){
				kingPresent = true;
			}
		}

		if(kingPresent == true && smallest == 1){
			flushValues = new int[]{10, 11, 12, 13, smallest};
		}

		else {
			flushValues = new int[]{smallest, smallest + 1, smallest + 2, smallest + 3, smallest + 4};
		}

		for(int j = 0; j < flushValues.length; j++){
			for(int k = 0; k < flushValues.length; k++){
				if(flushValues[j] == cards[k].getValue()){
					count++;
					break;
				}
			}
		}

		if(count == 5){
			return true;
		}

		return false;
	}

	public static boolean hasFlush(Card[] cards) {
		int count = 1;


		for (int i = 1; i < cards.length; i++ ) {
			if (cards[0].getSuit() == cards[i].getSuit()) {
				count++;
				if (count == 5) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean hasFullHouse(Card[] cards) {

		boolean hasThreeOfAKind = false;
		int tripleValue = -1;

		//hasThreeOfAKind

		int count = 1;

		for (int i = 0; i < cards.length; i++) {

			for (int j = i + 1; j < cards.length; j++ ) {

				if (cards[i].getValue() == cards[j].getValue()) {

					count++;

					if (count == 3) {

						hasThreeOfAKind = true;

						tripleValue = cards[i].getValue();

					}
				}
			}

			count = 1;
		}

		if (hasThreeOfAKind == true) {

			//hasPair

			for (int i = 0; i < cards.length; i++) {

				for (int j = i + 1; j < cards.length; j++ ) {

					if (cards[i].getValue() == cards[j].getValue() && cards[i].getValue() != tripleValue) {
						return true;

					}
				}
			}
		}

		return false;
	}


	public static boolean hasFourOfAKind(Card[] cards) {
		int count = 1;

		for (int i = 0; i < cards.length; i++) {

			for (int j = i + 1; j < cards.length; j++ ) {
				if (cards[i].getValue() == cards[j].getValue()) {
					count++;
					if (count == 4) {
						return true;
					}
				}
			}
			count = 1;
		}
		return false;
	}

	public static boolean hasStraightFlush(Card[] cards) {
		if (hasStraight(cards) && hasFlush(cards)) {
			return true;
		}
		return false;
	}
}

