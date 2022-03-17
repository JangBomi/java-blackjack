package blackjack.domain;

import static blackjack.domain.BlackjackGame.BLACKJACK_NUMBER;

public enum PlayerOutcome {
    BLACKJACK_WIN("블랙잭"),
    WIN("승"),
    LOSE("패"),
    DRAW("무");

    private String value;

    PlayerOutcome(String value) {
        this.value = value;
    }

    public static PlayerOutcome match(int dealerTotal, int playerTotal) {
        if (dealerTotal > BLACKJACK_NUMBER && playerTotal > BLACKJACK_NUMBER) {
            return LOSE;
        }
        if (dealerTotal > BLACKJACK_NUMBER) {
            return WIN;
        }
        if (playerTotal > BLACKJACK_NUMBER) {
            return LOSE;
        }
        return matchCards(dealerTotal, playerTotal);
    }

    private static PlayerOutcome matchCards(int dealerTotal, int playerTotal) {
        if (dealerTotal < playerTotal) {
            return WIN;
        }
        if (dealerTotal > playerTotal) {
            return LOSE;
        }
        return DRAW;
    }

    public String getValue() {
        return this.value;
    }
}
